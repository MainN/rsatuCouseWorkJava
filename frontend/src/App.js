
import React, { Component } from 'react';
import Table from './components/Table';
import HelpButton from './components/HelpButton'
import ModalWindow from './components/ModalWindow';
import Search from './components/Search'
import { Modal, Form, Button, Dropdown } from 'react-bootstrap';
import CompetitionsTable from './components/CompetitionsTable'
import MyNavBar from './components/MyNavBar'
class App extends Component {
  state = {
    data: [],
  }


  async componentDidMount() {
    const response = await fetch('/fish/get')
    const data = await response.json()
    console.log(data)
    this.setState({
      data
    })
  }

  render() {
    return (
      
      <div className="container">
        <MyNavBar/>
        <CompetitionsTable data={this.state.data} />
        <ModalWindow/>
      </div>

    );
  }
}

export default App;
