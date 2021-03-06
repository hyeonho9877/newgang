import './LoginForm.css';
import '../reset.css';
import user from '../../img/user.png';
import password from '../../img/password.png';
import info from '../../img/info.png'
import { Link } from 'react-router-dom';
import { React, useState }from 'react';


function LoginForm() {

    return (
        <div className="LoginPage">
            <h1>수강신청 시스템</h1>
            <div className="radio-form">
                <div class="radio-wrap">
                    <input type="radio" name="a" id="a" defaultChecked />
                    <label for="a">한국어</label>
                </div>
                <div class="radio-wrap">
                    <input type="radio" name="a" id="a" />
                    <label for="a">English</label>
                </div>
            </div>

            <form name="login" className="login-form" autoComplete="on" action="" method="post" encType="">
                <input type="text" className="userID" placeholder="아이디" required></input>
                <img src={user} className="userInter" alt="userIcon"></img>
                <p className="after"></p>
                <br />
                <input type="password" className="userPW" placeholder="패스워드" required></input>
                <img src={password} className="passwordInter" alt="passwordIcon"></img>
                <p className="after2"></p>
                <button type="submit" className="submit-button">로그인</button>
            </form>

            <div className="help">
                <a href="#">
                    <img src={info} className="helpIcon"></img>
                    <p>학번이 기억나지 않으신가요?</p>
                </a>
            </div>
        </div>
    );
}

export default LoginForm;
