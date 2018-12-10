import React, { Component } from 'react';
import {Provider} from "mobx-react";
import StationContainer from "./containers/StationContainer";
import AppStore from "./stores/AppStore";
import ApiClient from "./clients/ApiClient";

const appStore = new AppStore(new ApiClient());
const stores = {
  appStore
};

class App extends Component {
  render() {
    return (
      <Provider { ...stores }>
        <StationContainer />

      </Provider>
    );
  }
}


export default App;
