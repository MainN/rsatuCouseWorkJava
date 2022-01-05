import React, { useEffect, useState } from 'react';

export default function CompetitionsTable() {

    const [data, setData] = useState([]);
    useEffect(() => {
        const fetchData = async () => {
            const res = await fetch(
                'api/competition/get',
            );
            const json = await res.json();
            setData(json);
        };
        fetchData();
    });

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
                    <th></th>
                    <th>ID</th>
                    <th>Дата начала</th>
                    <th>Текущее/Макс. кол-во участников</th>
                    <th>Приз</th>
                    <th>Вид соревнования</th>
                    <th>Дата окончания</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {data.map(item => (
                    <tr key={item.id}>
                        <td> <button type="button" className="btn btn-outline-primary"> <img src="https://pixy.org/src/479/4794412.png" alt="" width="40" height="40"></img> </button></td>
                        <td>{item.id}</td>
                        <td>{item.startDate}</td>
                        <td>{item.members.length}\{item.maxMembers}</td>
                        <td>{item.prize}</td>
                        <td>{getFormatedCompType(item.type)}</td>
                        <td>{item.endDate}</td>
                        <td> <button type="button" className="btn btn-outline-primary"> <img src="http://cdn.onlinewebfonts.com/svg/img_384596.png" alt="" width="40" height="40"></img> </button></td>
                    </tr>
                ))}
            </tbody>
        </table>
    </div>
}
