import React from 'react';

export default props => (
    <table className="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Дата начала</th>
                <th>Участники</th>
                <th>Приз</th>
                <th>Дата окончания</th>
            </tr>
        </thead>
        <tbody>
            { props.data.map(item =>(
                <tr key={item.id}>
                    <td>{item.name}</td>
                    <td>{item.kind}</td>
                    <td>{item.depth}</td>
                    <td>{item.weight}</td>
                </tr>
            ))}
        </tbody>
    </table>
)
