import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import App from '../shared/App.css';

function Root() {
    return(
        <BrowserRouter>
            <App/>
        </BrowserRouter>
    )
}

export default Root;