import React, {useState} from 'react';
import './Menu.css'
import {Link} from 'react-router-dom';
import {AppBar, Tabs, Tab, styled} from "@material-ui/core";

function Menu() {
    function handleChange() {
        console.log("toggle");
    }
    const StyleAppBar = styled(AppBar) `
        && {
          background-color: #ffffff;
          color:#ffffff;
          font-size: 20px;
        }
    `

    return (
        <div className="menuContainer">
            <AppBar position="static">
                <Tabs onChange={handleChange} aria-label="Main Tabs">
                    <Tab label="공지사항"/>
                    <Tab label="조회"/>
                    <Tab label="수강신청"/>
                </Tabs>
            </AppBar>
        </div>
    )
}

export default Menu;