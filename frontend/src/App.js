
import React, { Component } from 'react';
import Table from './components/Table';
import HelpButton from './components/HelpButton'
import ModalWindow from './components/ModalWindow';
import Search from './components/Search'
import { Modal, Form, Button, Dropdown } from 'react-bootstrap';
import CompetitionsTable from './components/CompetitionsTable'
import MyNavBar from './components/MyNavBar'
class App extends Component {

  render() {
    return (
      <div className="container">
        <MyNavBar/>
        <CompetitionsTable />      
      </div>
    );
  }
}

export default App;
