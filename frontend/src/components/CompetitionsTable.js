import React, { useEffect, useState } from 'react';

export default function CompetitionsTable(props) {

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
        <table className="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Дата начала</th>
                    <th>Текущее/Макс. кол-во участников</th>
                    <th>Приз</th>
                    <th>Вид соревнования</th>
                    <th>Дата окончания</th>
                    
                </tr>
            </thead>
            <tbody>
                {data.map(item => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.startDate}</td>
                        <td>{item.members.length}\{item.maxMembers}</td>
                        <td>{item.prize}</td>
                        <td>{getFormatedCompType(item.type)}</td>
                        <td>{item.endDate}</td>

                    </tr>
                ))}
            </tbody>
        </table>
    </div>
}
