import logo from './logo.svg';
import './App.css';
import { LikeButton } from './components/LikeButton';
import { List } from './components/List';

const listItems = [
  'Apple',
  'Banana',
  'Tomato',
]

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
      <LikeButton />
      <List items={listItems} />
    </div>
  );
}

export default App;
