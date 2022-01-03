import React, { useState } from 'react';
import { Modal, Form, Button, Dropdown,Figure} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import ModalCompetitionCreate from './ModalCompetitionCreate'
import ProfileModal from './ProfileModal'
import ModularHandBook from './ModularHandBook'
export default function MyNavBar() {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  return <nav class="navbar navbar-light bg-white">
  <div class="container-fluid">
    <a class="navbar-brand" href="/"><img src="https://www.pinclipart.com/picdir/big/44-448226_file-home-icon-svg-wikimedia-commons-free-train.png" alt="" width="40" height="40" class="d-inline-block align-text-top"></img></a>
    <ModularHandBook/>
    <a class="search-brand" href="#">
    <form class="d-flex">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"></input>
      <input type="image" src="https://www.freeiconspng.com/uploads/search-icon-png-21.png" alt="" width="40" height="40" />
    </form>

    </a>



     { setShow ? <ModalCompetitionCreate/> : null }
    Вася Пупкин



    <ProfileModal/>




    </div>

    </nav>
};
