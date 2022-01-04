import React, { useState } from 'react';
import { Modal, Form, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

export default function ModalWindow() {
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);


    const handleAddCompetition = () => {
        let compInfo = {
            startDate: document.getElementById("compDateBegin").value,
            type: document.getElementById("exampleFormControlSelect1").value,
            maxMembers: parseFloat(document.getElementById("compMaxSize").value),
            prize: parseFloat(document.getElementById("compPrize").value),
            endDate: parseFloat(document.getElementById("compDateEnd").value),
        };
        console.log(JSON.stringify(compInfo));
        fetch('http://localhost:8080/api/competition/insert', {
            method: 'POST',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(compInfo)
        });
        setShow(false);
    }



    return (
        <div>
            <button type="button" className="btn btn-outline-primary" onClick={handleShow}> <img src="https://pic.onlinewebfonts.com/svg/img_360305.png" alt="" width="40" height="40"></img> </button>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Создание соревнования</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group controlId="compDateBegin">
                            <Form.Label>Дата начала соревнования</Form.Label>
                            <Form.Control type="date" />
                        </Form.Group>
                        <Form.Group controlId="compType">
                            <Form.Label>Вид соревнования </Form.Label>
                            <select className="form-control" id="exampleFormControlSelect1">
                                <option>WITH_BOAT</option>
                                <option>FROM_SHORE</option>
                                <option>ON_ICE</option>
                            </select>
                        </Form.Group>
                        <Form.Group controlId="compMaxSize">
                            <Form.Label>Максимальное число участников</Form.Label>
                            <Form.Control type="number" />
                        </Form.Group>
                        <Form.Group controlId="compPrize">
                            <Form.Label>Денежный приз</Form.Label>
                            <Form.Control type="number" />
                        </Form.Group>
                        <Form.Group controlId="compDateEnd">
                            <Form.Label>Дата конца соревнования</Form.Label>
                            <Form.Control type="date" />
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="primary" onClick={handleAddCompetition}>Создать</Button>
                </Modal.Footer>
            </Modal>
        </div>
    )
}
