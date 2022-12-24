import React from "react";
import '../css/Registration.css';
import {Link, Route, BrowserRouter, Routes} from "react-router-dom";

function Registration() {
  return (
    <div className="Registration">
        <div className="paper">
          <h1 className='enterSystem'>ВОЙТИ В СИСТЕМУ</h1>
        </div>
      <div>
        <text className="textLogin">Логин</text>
        <input className="login"/>
      </div>
      <div>
        <text>Пароль</text>
        <input className="password"/>
      </div>
        <Link to="/main">
            <button className="arrowButton">
                <p className="arrow"/>
            </button>
        </Link>
    </div>
  );
}

export default Registration;
