import React, { useState } from 'react';
import { Modal, Form, Button, Dropdown } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import TableFish from './TableFish'
import TableLake from './TableLake'
import TableLure from './TableLure'

export default function ModalWindow() {
  function ShowFish()
{
  handleLureClose();
  handleLakeClose();
  handleFishShow();
}
function ShowLake()
{
handleLureClose();
handleLakeShow();
handleFishClose();
}
function ShowLure()
{
handleFishClose();
handleLakeClose();
handleLureShow();
}
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const [fishShow, setFishShow] = useState(false);

    const handleFishClose = () => setFishShow(false);
    const handleFishShow = () => setFishShow(true);

    const [lakeShow, setLakeShow] = useState(false);

    const handleLakeClose = () => setLakeShow(false);
    const handleLakeShow = () => setLakeShow(true);

    const [lureShow, setLureShow] = useState(false);

    const handleLureClose = () => setLureShow(false);
    const handleLureShow = () => setLureShow(true);

    const handleAddFish = () => {
        let fishInfo = {
            name: document.getElementById("fishName").value,
            kind: document.getElementById("fishType").value,
            depth: parseFloat(document.getElementById("fishDepth").value),
            weight: parseFloat(document.getElementById("fishWeight").value),
        };
        console.log(JSON.stringify(fishInfo));
        fetch('http://localhost:8080/fish/insert', {
            method: 'POST',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(fishInfo)
        });

    }

    return (
        <div>
            <button type="button" className="btn btn-outline-primary" onClick={handleShow}> <img src="https://www.pinclipart.com/picdir/big/558-5584488_literature-icon-free-download-book-icon-png-white.png" alt="" width="40" height="40"></img> </button>



            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Справочник</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                <Form>
                <Dropdown>
                    <Dropdown.Toggle variant="success" id="dropdown-basic">
                        Справочник:
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                    <button class="dropdown-item" type="button" onClick={ShowFish}> Рыбы</button>
<button class="dropdown-item" type="button" onClick={ShowLake}>Озёра</button>
<button class="dropdown-item" type="button" onClick={ShowLure} >Наживки</button>
                    </Dropdown.Menu>
                </Dropdown>
                {fishShow ? <TableFish data={[]} /> : null}
                {lakeShow ? <TableLake data={[]} /> : null}
                {lureShow ? <TableLure data={[]} /> : null}
                </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="primary" onClick={handleClose}>Назад</Button>
                </Modal.Footer>
            </Modal>

        </div>
    )
}
