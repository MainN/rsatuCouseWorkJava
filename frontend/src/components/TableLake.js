import React from 'react';

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
                    <td>{item.name}</td>
                    <td>{item.kind}</td>
                    <td>{item.depth}</td>
                    <td>{item.weight}</td>
                </tr>
            ))}
        </tbody>
    </table>
    <button type="button" className="btn btn-outline-primary" > Добавить </button>
    <span> </span>
    <button type="button" className="btn btn-outline-primary" > Удалить </button>
    </div>
)