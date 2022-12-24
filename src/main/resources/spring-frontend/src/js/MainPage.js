import React from "react";
import '../css/MainPage.css';
import './Registration'
import {Link} from "react-router-dom";

function MainPage() {
    return(
        <div className="MainPage">

            <div className="user">
                <div className="avatar"/>
                <textarea>Hello, Nickname!</textarea>
            </div>
            <div className="picture"/>
            <Link to="/userRoom">
                <div>
                    <button className="mainButtons">войти в комнату</button>
                </div>
            </Link>
            <div>
                <button className="mainButtons">создать комнату</button>
            </div>
            <div>
                <button className="lastGamesButton">Предыдущие игры</button>
                <div className="bookPicture"/>
            </div>

        </div>
    );
}

export default MainPage;