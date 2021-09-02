import './LoginForm.css';
import '../reset.css';
import user from '../../img/user.png';
import password from '../../img/password.png';
import info from '../../img/info.png'
import {React} from 'react';
import axios from "axios";


function LoginForm() {

    function auth(e) {
        e.preventDefault();

        const id = document.querySelector(".userID").value;
        const pw = document.querySelector(".userPW").value;

        const data = {"userID": id, "password": pw};
        axios.post("http://localhost:8120/auth",data).then((Response)=>{
            console.log(Response.data);
        }).catch((Error)=>{
            console.log(Error);
        })
    }


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

            <form name="login" className="login-form" autoComplete="on" action="/auth" method="post" encType="">
                <input type="text" className="userID" placeholder="아이디" required></input>
                <img src={user} className="userInter" alt="userIcon"></img>
                <p className="after"></p>
                <br />
                <input type="password" className="userPW" placeholder="패스워드" required></input>
                <img src={password} className="passwordInter" alt="passwordIcon"></img>
                <p className="after2"></p>
                <button type="submit" className="submit-button" onClick={auth}>로그인</button>
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
