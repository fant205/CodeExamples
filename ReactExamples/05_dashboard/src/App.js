
import './App.css';
import { Menu } from './components/Menu';
import { Navigation } from './components/Navigation';
import { IndicatorsList } from './components/IndicatorsList';
import { Report } from './components/Report';

function App() {
  return (
    <div className="App">
      <div className="wrapper">
        <div className="block">
          <Navigation />
        </div>
        <div className="block">
          <Menu />
          <IndicatorsList />
          <Report />
        </div>
      </div>
    </div>
  );
}

export default App;
