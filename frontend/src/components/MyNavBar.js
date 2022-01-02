import React from 'react';
import { Modal, Form, Button, Dropdown,Figure} from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

export default function MyNavBar() {

  return <nav class="navbar navbar-dark bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><img src="https://www.pinclipart.com/picdir/big/44-448226_file-home-icon-svg-wikimedia-commons-free-train.png" alt="" width="120" height="120" class="d-inline-block align-text-top"></img></a>
    <a class="search-brand" href="#">
    <form class="d-flex">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"></input>
      <input type="image" src="https://www.freeiconspng.com/uploads/search-icon-png-21.png" alt="" width="84" height="86" />
    </form>

    </a>
    <a class="search-brand" href="#"><img src="https://pic.onlinewebfonts.com/svg/img_360305.png" alt="" width="84" height="86" class="d-inline-block align-text-top"></img></a>

    Вася Пупкин
    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">

    <img src="http://cdn.onlinewebfonts.com/svg/download_415638.png" alt="" width="84" height="86" class="d-inline-block align-text-top">
    </img>
    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
           <li><a class="dropdown-item" href="#">Профиль</a></li>
           <li><a class="dropdown-item" href="#">Выход</a></li>

         </ul>
    </a>




    </div>

    </nav>
};
