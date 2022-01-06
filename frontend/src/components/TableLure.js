import React from 'react';
import ModalWindow from './ModalWindow'
export default props => (
  <div>
    <table className="table">
        <thead>
            <tr>
                <th>Код наживки</th>
                <th>Название</th>
                <th>Глубина</th>

            </tr>
        </thead>
        <tbody>
            {props.data.map(item => (
                <tr key={item.id}>
                    <td>{item.name}</td>

                    <td>{item.depth}</td>

                </tr>
            ))}
        </tbody>
    </table>

    <ModalWindow/>
    </div>
)
