import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './components/Header/Header';
import Board from './components/Board/Board';

const App = () => {
  const [type, setType] = useState('now');

  useEffect(() => {
    const query = new URLSearchParams(window.location.search);
    setType(query.get('type'));
  }, [window.location.search]);

  return (
    <>
      <Header />
      <div className="container mt-5">
        <Board type={type} />
      </div>
    </>
  );
};

export default App;