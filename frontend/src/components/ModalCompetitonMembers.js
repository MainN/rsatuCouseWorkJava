import React, { useState } from 'react';
import { Modal, Form, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

export default function ModalWindow(props) {


    return (
        <div>

            <Modal>
                <Modal.Header closeButton>
                    <Modal.Title>Добавление наживки</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>


                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="primary" >Добавить</Button>
                </Modal.Footer>
            </Modal>
        </div>
    )
}
