import React, { useState } from 'react';
import { Modal, Form, Button, Dropdown, Figure } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import ModalCompetitionCreate from './ModalCompetitionCreate'
import ProfileModal from './ProfileModal'
import ModularHandBook from './ModularHandBook'
import DropDownMenu from './DropDownMenu';


export default function MyNavBar() {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  return <nav className="navbar navbar-light bg-white">
    <div className="container-fluid">
      <a className="navbar-brand" href="/"><img src="https://www.pinclipart.com/picdir/big/44-448226_file-home-icon-svg-wikimedia-commons-free-train.png" alt="" width="40" height="40" className="d-inline-block align-text-top"></img></a>
      <ModularHandBook />

      <a className="search-brand" href="#">
        <form className="d-flex">
          <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search"></input>
          <input type="image" src="https://www.freeiconspng.com/uploads/search-icon-png-21.png" alt="" width="40" height="40" />
        </form>
      </a>
      {setShow ? <ModalCompetitionCreate /> : null}
      Вася Пупкин
      <Dropdown>
        <Dropdown.Toggle variant="white" id="dropdown-basic">
          <img src="http://cdn.onlinewebfonts.com/svg/download_415638.png" alt="" width="40" height="40"></img>
        </Dropdown.Toggle>

        <Dropdown.Menu>
          <ProfileModal />
          <p>
          </p>
          <button type="button" className="btn btn-outline-primary" > Выход </button>

        </Dropdown.Menu>
      </Dropdown>
    </div>
  </nav>
};
