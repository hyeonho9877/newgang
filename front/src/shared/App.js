import React from 'react';
import {Route, Switch} from 'react-router-dom';
import {Enroll, Inquire, Main, Notice} from '../Pages';

function App() {
    return(
        <div>
            <Route exact path="/" component={Main}/>
            <Switch>
                <Route path="/Enroll/:name" component={Enroll}/>
                <Route path="/Enroll" component={Enroll}/>
                <Route path="/Notice" component={Notice}/>
                <Route path="/Inquire" component={Inquire}/>
            </Switch>
        </div>
    )
}

export default App;