import './Main.css';
import '../components/reset.css';
import LoginForm from '../components/LoginForm/LoginForm';
import logo from '../img/logo.png';

function Main() {
    return (
        <div className="Main">
            <div className="white-container">
                <div className="main-container">
                    <div className="kgu-sign1 box1"></div>
                    <div className="kgu-sign4 box2">
                        <LoginForm></LoginForm>
                    </div>
                    <div className="kgu-sign2 box3">
                        <img src={logo} alt="KGU 경기대학교" className="logo"></img>
                    </div>
                    <div className="kgu-sign3 box4">
                        <div className="suwon-campus-info">
                            <p>수원캠퍼스 (16227) </p>
                            <p>경기도 수원시 영통구 광교산로 154-42 전화 031-249-9114</p>
                        </div>
                        <div className="seoul-campus-info">
                            <p>서울캠퍼스 (03746)</p>
                            <p>서울특별시 서대문구 경기대로 9길 24 전화 02-390-5114</p>
                        </div>
                        <p>COPYRIGHT © KYONGGI UNIVERSITY. ALL RIGHT RESERVED.</p>
                    </div>
                    <div className="kgu-sign1 box5"></div>
                </div>
            </div>
        </div>
    );
}

export default Main;