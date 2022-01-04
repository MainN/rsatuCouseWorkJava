import React, { useState } from 'react';
import { Modal, Form, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

export default function ModalWindow() {
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);



    return (
        <div>
        <button type="button" class="btn btn-outline-primary" onClick={handleShow}> <img src="http://cdn.onlinewebfonts.com/svg/download_415638.png" alt="" width="40" height="40"></img> </button>
        <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Профиль пользователя</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form>
                <Form.Group controlId="compMaxSize">
                    <Form.Label>ФИО пользователя</Form.Label>
                    <Form.Control type="text" />
                </Form.Group>
                    <Form.Group controlId="compDateBegin">
                        <Form.Label>Дата рождения</Form.Label>
                        <Form.Control type="date"/>
                    </Form.Group>


                    <Form.Group controlId="compType">
                        <Form.Label>Пол пользователя </Form.Label>
                        <select class="form-control" id="exampleFormControlSelect1">
                        <option>Мужской</option>
                        <option>Женский</option>
                        <option>Другое</option>
                        </select>
                    </Form.Group>

                </Form>
            </Modal.Body>
            <Modal.Footer>
              <Button variant="primary" >Выход</Button>

                <Button variant="primary" >Изменить</Button>
            </Modal.Footer>
        </Modal>
        </div>
    )
}
