import React from 'react';
import './App.css';
import { FirstComponent } from './components/first/first.component';

const App: React.FC = () => {
  return (
    <div className="App">
      App.tsx is the entry point to the application
      <FirstComponent/>
      <FirstComponent/>
      <p>
        We can import componenets wherever and as many times as we want
      </p>
      <FirstComponent/>
    </div>
  );
}

export default App;
