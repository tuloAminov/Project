import React from "react";
import '../css/UserRoom.css';
import {Link} from "react-router-dom";



function UserRoom() {
    return (
        <div className="UserRoom">

            <div className="enter">
                <text className="roomNumber">Номер комнаты</text>
                <input className="room"/>
            </div>
            <Link to="/quiz">
                <button className="arrowButton2">
                    <p className="arrow"/>
                </button>
            </Link>

        </div>

    );
}

export default UserRoom;
