import Header from './Header';
import Footer from './Footer';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import Pages from './Pages/Page';

function App() {
    return (
        <BrowserRouter>
            <div className="mainApp">
                <Header />
                <Pages />
                <Footer />
            </div>
        </BrowserRouter>
    );
}

export default App;
