
import React, { Component } from 'react';
import CompetitionsTable from './components/CompetitionsTable'
import MyNavBar from './components/MyNavBar'
class App extends Component {
  constructor(props) {
    // highlight-range{3}
    super(props);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.fileInput = React.createRef();
  }

  handleSubmit(event){
    const formData = new FormData();
    formData.append('file', this.fileInput.current.files[0]);
    formData.append('idCompetition', '5');
    formData.append('originalName', this.fileInput.current.files[0].name);
    console.log(formData.getAll);
    event.preventDefault();
    fetch('http://localhost:8080/api/file/upload', {
       method: 'post',
       body: formData
    });
  };


  render() {
    return (
      <div className="container">
        <MyNavBar />
        <CompetitionsTable />

      </div>
    );
  }
}

export default App;
