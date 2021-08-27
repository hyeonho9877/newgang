import React, { useState } from 'react';
import './Menu.css'
import { Link } from 'react-router-dom';

function Menu() {
    let [ state, setState ] = useState(0);

    function toggle(){
        setState( state => false);
    }
    return(
        <div className="menuContainer">
            <span className="movingLine"></span>
            <ul className="menulist" onMouseOver={toggle}>
                <li>
                    <Link to="#">
                        공지사항
                    </Link>
                </li>
                <li>
                    <Link to="#">
                        조회
                    </Link>
                </li>
                <li>
                    <Link to="#">
                        수강신청
                    </Link>
                </li>
            </ul>
        </div>
    )
}

export default Menu;