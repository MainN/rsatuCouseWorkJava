import React, { useState } from 'react';
import { Modal, Form, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

export default function ModalWindow() {
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);



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
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </Form.Group>
                        <Form.Group controlId="compMaxSize">
                            <Form.Label>Максимальное число участников</Form.Label>
                            <Form.Control type="number" />
                        </Form.Group>
                        <Form.Group controlId="compMaxSize">
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
                    <Button variant="primary" >Создать</Button>
                </Modal.Footer>
            </Modal>
        </div>
    )
}
