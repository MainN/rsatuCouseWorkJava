import React, { useEffect, useState } from 'react';
import { Button } from 'react-bootstrap';
import BootstrapTable from 'react-bootstrap-table-next';
import { Alert } from 'react-bootstrap';

export default function CompetitionsTable(props) {

    const selectRow = {
        mode: 'radio',
        clickToSelect: true,
        style: { backgroundColor: 'LightGrey' },
        onSelect: (row, isSelect, rowIndex, e) => {
            console.log(row);
            setCompetition(row);
            setShowAddMember(true);
            setShowDownload(true);
            setShowUpload(true);
        }
    };

    const columns = [{
        dataField: 'id',
        text: 'ID'
    }, {
        dataField: 'startDate',
        text: 'Дата начала'
    }, {
        dataField: 'members.length',
        text: 'Тек./Макс. кол-во участников',
        formatter: (value, row) => { return `${value}/${row.maxMembers}` }
    }, {
        dataField: 'prize',
        text: 'Приз'
    }, {
        dataField: 'type',
        text: 'Вид соревнования',
        formatter: (cell) => { return getFormatedCompType(cell) }
    }, {
        dataField: 'lake.name',
        text: 'Озеро'
    }, {
        dataField: 'lure.name',
        text: 'Наживка'
    }, {
        dataField: 'endDate',
        text: 'Дата окончания'
    }
    ];


    const [data, setData] = useState([]);
    const [competition, setCompetition] = useState([]);
    const [showAddMember, setShowAddMember] = useState(false);
    const [showUpload, setShowUpload] = useState(false);
    const [showDownload, setShowDownload] = useState(false);
    const [showAlert, setShowAlert] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            const res = await fetch(
                'api/competition/get',
                {
                    headers: { "Authorization": "Bearer " + props.token }
                }
            );
            const json = await res.json();
            console.log(json);
            setData(json);
        };
        fetchData();
    }, []);

    function getFormatedCompType(type) {
        switch (type) {
            case 'WITH_BOAT':
                return 'На лодке'
            case 'FROM_SHORE':
                return 'С берега'
            case 'ON_ICE':
                return 'На льду'
        }
    }

    function GetAlert() {
        return (
            <Alert show={showAlert} variant="success">
                <Alert.Heading>Сообщение</Alert.Heading>
                <p>
                    Вы зарегистрированы на соревнование!
                </p>
                <hr />
                <div className="d-flex justify-content-end">
                    <Button onClick={() => window.location.reload(false)} variant="outline-success">
                        Закрыть
                    </Button>
                </div>
            </Alert>
        );
    }

    const handleAddMe = () => {
        let competitionId = competition.id;
        let userId = props.user.id;
        console.log(JSON.stringify(userId));

        fetch(`api/competition/${competitionId}/members/${userId}`, {
            method: 'POST',
            headers: { 'Content-type': 'application/json', "Authorization": "Bearer " + props.token },
            body: JSON.stringify({
                idCompetition: competitionId,
                idMember: userId
            })
        }).then((result) => {
            console.log(result);
            setShowAlert(true);
        });
    }

    const handleDownloadFile = () => {

    }

    const handleUploadFile = () => {

    }

    const rowStyle = (row, rowIndex) => {
        var ids = row.members.map(function (member) {
            return member.id;
        });
        if (ids.includes(props.user.id)) {
            return {
                //backgroundColor: "lightgreen",
                border: "3px solid lightgreen"
            };
        }
        return null;
    };

    return <div>
        <BootstrapTable keyField='id' data={data} columns={columns} selectRow={selectRow} rowStyle={rowStyle} />
        {showAddMember && (<Button onClick={handleAddMe}>Записаться на соревнование</Button>)}
        {showUpload && (<Button onClick={handleUploadFile}>Загрузить отчёт о соревновании на сервер</Button>)}
        {showDownload && (<Button onClick={handleDownloadFile}>Скачать отчёт о соревновании</Button>)}
        {GetAlert()}
    </div>
}
