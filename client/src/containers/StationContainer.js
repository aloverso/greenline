import React, { Component } from 'react';
import {inject, observer} from "mobx-react";

class StationContainer extends Component {

  componentDidMount() {
    this.props.appStore.getStations()
  }

  renderView = () => {

    return this.props.appStore.viewData.map(
      station => <div data-station key={station.id}>{station.name}</div>
    )
  };

  render() {
    return (
      <div>
        <button onClick={this.props.appStore.switchView}>Swap view</button>
        {this.renderView()}
      </div>
    );
  }
}


export default inject(['appStore'])(observer(StationContainer));
