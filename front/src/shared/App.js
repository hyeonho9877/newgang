import React from 'react';
import { Route, Switch } from 'react-router-dom';
import { Main, Enroll} from '../Pages';

function App() {
    return(
        <div>
            <Route exact path="/" component={Main}></Route>
            <Switch>
                <Route path="/Enroll/:name" component={Enroll}></Route>
                <Route path="/Enroll" component={Enroll}></Route>
            </Switch>
        </div>
    )
}

export default App;