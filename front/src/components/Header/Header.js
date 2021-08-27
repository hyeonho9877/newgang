import React from 'react';
import './Header.css';
import Menu from '../Menu/Menu';
import '../../shared/App.css';
import user from '../../img/user.png';
import logo from '../../img/logo-header.png';

function Header({ name }) {
    return (
        <div className="mainContainer">
            <div className="headerFront">
                <img src={logo} alt="KGU" className="headerLogo" />
                <div className="limitTime">
                    Time out : <strong>10:00</strong>
                    <button type="button" className="resetTimeButton">
                        연장하기
                    </button>
                </div>
                <Menu></Menu>
            </div>
            <div className="headerBack">
                <div className="userInfo">
                    <img src={user} className="userIcon"></img>
                    <span>{name}님</span>
                </div>
                <button type="button" className="loginAndOutButton">로그아웃</button>
            </div>
        </div>
    );
}


export default Header;
