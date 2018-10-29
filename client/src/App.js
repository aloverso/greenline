import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
        </header>

        <div data-station>Grand Central - 42 St</div>
        <div data-station>Canal St</div>

      </div>
    );
  }
}

export default App;
