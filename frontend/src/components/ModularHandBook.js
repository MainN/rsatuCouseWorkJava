import React, { useState } from 'react';
import { Modal, Form, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

export default function ModalWindow() {
    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

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
                        <p>
                            <Form.Group controlId="fishName">
                                <Button variant="primary" onClick={handleClose}>Рыбы</Button>
                            </Form.Group>
                        </p>
                        <p>
                            <Form.Group controlId="fishType">
                                <Button variant="primary" onClick={handleClose}>Озёра</Button>
                            </Form.Group>
                        </p>
                        <Form.Group controlId="fishDepth">
                            <Button variant="primary" onClick={handleClose}>Наживки</Button>
                        </Form.Group>

                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="primary" onClick={handleAddFish}>Назад</Button>
                </Modal.Footer>
            </Modal>
        </div>
    )
}
