import React from 'react';
import { Route, Switch } from 'react-router-dom';
import { Main, Enroll, Notice, Inquire} from '../Pages';

function App() {
    return(
        <div>
            <Route exact path="/" component={Main}></Route>
            <Switch>
                <Route path="/Enroll/:name" component={Enroll}></Route>
                <Route path="/Enroll" component={Enroll}></Route>
                <Route path="/Notice" component={Notice}></Route>
                <Route path="/Inquire" component={Inquire}></Route>
            </Switch>
        </div>
    )
}

export default App;