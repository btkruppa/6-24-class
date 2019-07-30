import React from 'react';
import './App.css';
import { FirstComponent } from './components/first/first.component';
import Second from './components/second/second.component';
import Third from './components/third/third.component';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import NotFound from './components/not-found/not-found.component';
import { NavComponent } from './components/app-nav/app-nav.component';

const App: React.FC = () => {
  return (
    <BrowserRouter>
      <div className="App">
        <NavComponent />
        {/* The switch will only render the first route to match */}
        <Switch>
          <Route path="/first" component={FirstComponent} />
          <Route path="/second" component={Second} />
          <Route path="/third" component={Third} />
          <Route component={NotFound} />
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
