import './App.css';
import { LikeList } from './components/LikeList/LikeList';


function App() {
  return (
    <div className="App">
      {/* <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React 1
        </a>
      </header> */}
      {/* <LikeButton />
      <List items={listItems} /> */}



      <LikeList />


    </div>
  );
}

export default App;