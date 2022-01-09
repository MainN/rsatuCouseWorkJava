import React, { useState } from 'react';
import { Modal, Form, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

export default function ModalWindow() {
    console.log("11");
    const [show, setShow] = useState(false);

    const [dataLake, setDataLake] = useState([]);
    const [dataLure, setDataLure] = useState([]);

    const fetchDataLake = async () => {
        const res = await fetch(
            'api/lake/get',
        );
        const json = await res.json();
        setDataLake(json);
    };
    const fetchDataLure = async () => {
        const res = await fetch(
            'api/lure/get',
        );
        const json = await res.json();
        setDataLure(json);
    };

    const handleClose = () => setShow(false);
    const handleShow = () => {
        fetchDataLake();
        fetchDataLure();
        setShow(true);
    }


    const handleAddCompetition = () => {
        let typeComp = document.getElementById("exampleFormControlSelect1").value;
        switch (typeComp) {
            case 'На лодке':
                typeComp = 'WITH_BOAT'
                break;
            case 'С берега':
                typeComp = 'FROM_SHORE'
                break;
            case 'На льду':
                typeComp = 'ON_ICE'
                break;
        }

        const fetchData = async () => {
            const lakeName = document.getElementById("selectCompLake").value;
            const lureName = document.getElementById("selectCompLure").value;

            const lakeData = await fetch(`/api/lake/get/${lakeName}`).then(res => res.json());

            const lureData = await fetch(`/api/lure/get/${lureName}`).then(res => res.json());

            let compInfo = {
                startDate: document.getElementById("compDateBegin").value,
                type: typeComp,
                maxMembers: parseFloat(document.getElementById("compMaxSize").value),
                prize: parseFloat(document.getElementById("compPrize").value),
                endDate: document.getElementById("compDateEnd").value,
                lake: lakeData,
                lure: lureData
            };
            await fetch('/api/competition/insert', {
                method: 'POST',
                headers: { 'Content-type': 'application/json' },
                body: JSON.stringify(compInfo)
            })
            setShow(false);
            window.location.reload(false);
        };
        fetchData();
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
                            <Form.Control required type="date"/>
                        </Form.Group>
                        <Form.Group controlId="compType">
                            <Form.Label>Вид соревнования </Form.Label>
                            <select className="form-control" id="exampleFormControlSelect1">
                                <option>На лодке</option>
                                <option>С берега</option>
                                <option>На льду</option>
                            </select>
                        </Form.Group>
                        <Form.Group controlId="compMaxSize">
                            <Form.Label>Максимальное число участников</Form.Label>
                            <Form.Control required type="number"/>
                        </Form.Group>
                        <Form.Group controlId="compPrize">
                            <Form.Label>Денежный приз</Form.Label>
                            <Form.Control required type="number"/>
                        </Form.Group>
                        <Form.Group controlId="compDateEnd">
                            <Form.Label>Дата конца соревнования</Form.Label>
                            <Form.Control required type="date"/>
                        </Form.Group>
                        <Form.Group controlId="compLake">
                            <Form.Label>Озеро соревнования </Form.Label>
                            <select className="form-control" id="selectCompLake">
                                {dataLake.map(item => (
                                    <option>{item.name}</option>
                                ))}
                            </select>
                        </Form.Group>
                        <Form.Group controlId="compLure">
                            <Form.Label>Применяемая на соревании наживка</Form.Label>
                            <select className="form-control" id="selectCompLure">
                            {dataLure.map(item => (
                                <option>{item.name}</option>
                            ))}
                            </select>
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
