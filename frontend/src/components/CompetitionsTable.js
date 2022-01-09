import React, { useEffect, useState } from 'react';
import BootstrapTable from 'react-bootstrap-table-next';

export default function CompetitionsTable(props) {

    const selectRow = {
        mode: 'radio',
        clickToSelect: true,
        style: { backgroundColor: 'LightGrey' }
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
        formatter:(value, row) =>{return `${value}/${row.maxMembers}`}
    }, {
        dataField: 'prize',
        text: 'Приз'
    }, {
        dataField: 'type',
        text: 'Вид соревнования',
        formatter:(cell)=>{return getFormatedCompType(cell)}
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


    return <div>
        <BootstrapTable keyField='id' data={ data } columns={ columns } selectRow = {selectRow}/>
    </div>
}
