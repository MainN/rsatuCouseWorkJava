import React, { useRef, useState } from "react";
import { Button } from 'react-bootstrap';

export default function UploadButton(props) {

    const inputRef = useRef(null);
    const [uploadedStatus, setUploadedStatus] = useState(null);

    const handleInputFile = () => {
        inputRef.current?.click();
    };

    function uploadFile() {
        const data = new FormData();
        data.append('file', inputRef.current.files[0]);
        data.append('idCompetition', props.competitionId);
        data.append('originalName', inputRef.current.files[0].name);
        fetch('/api/file/upload', {
            method: 'post',
            headers: { "Authorization": "Bearer " + props.token },
            body: data
        }).then(
            setUploadedStatus("Загружено")
        );
    }

    const handleUploadFile = () => {
        inputRef.current?.files && uploadFile();
    };


    return (
        <div className='m-2'>
            <input ref={inputRef} className="d-none" type="file" onChange={handleUploadFile} />
            <Button className={`btn btn-${uploadedStatus ? "success" : "primary"
                }`} onClick={handleInputFile}>{uploadedStatus ? uploadedStatus : "Загрузить отчёт о соревновании"}</Button>
        </div>
    );
}