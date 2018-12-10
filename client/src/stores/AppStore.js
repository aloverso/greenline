import {action, observable, set, get, extendObservable, decorate, computed} from "mobx";
import ApiClient from "../clients/ApiClient";

class AppStore {

  constructor(apiClient) {
    this.apiClient = apiClient;

  }

  stations = [];
  lines = [{
    name: 'N',
    id: 'N'
  }]
  currentView = 'stations';

  get viewData() {
    return this[this.currentView]
  }

  //
  switchView = action(() => {
    console.log(this.currentView)
    if (this.currentView === 'stations') {
      this.currentView = 'lines'
    } else if (this.currentView === 'lines') {
      this.currentView = 'stations'
    }
    console.log(this.currentView)
  })

  getStations = action(() => {
    this.apiClient.get('http://localhost:8080/api/v1/stations')
      .then((data) => {
        console.log(data)
        this.stations = data;
      })
  })

}
 export default decorate(AppStore, {
   currentView: observable,
   viewData: computed
 })