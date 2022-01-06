import React from 'react';
import ModalWindowLake from './ModalWindowLake'
export default props => (
    <div>
    <table className="table">
        <thead>
            <tr>
                <th>Код озера</th>
                <th>Площадь</th>
                <th>Глубина</th>
                <th>Название</th>
            </tr>
        </thead>
        <tbody>
            {props.data.map(item => (
                <tr key={item.id}>
                    <td>{item.area}</td>
                    <td>{item.kind}</td>
                    <td>{item.depth}</td>
                    <td>{item.name}</td>
                </tr>
            ))}
        </tbody>
    </table>
    <ModalWindowLake/>
    </div>
)
