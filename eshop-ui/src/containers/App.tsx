import Header from "./Header";
import Footer from "./Footer";
import Content from "./Content";
import './App.css';
import HomePage from "./Pages/HomePage/HomePage";
import {BrowserRouter, Route, Routes} from "react-router-dom";

function App() {
    return (
        <BrowserRouter>
            <div className='mainApp'>
                <Header />
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route path="/products" element={<Content />} />
                </Routes>
                <Footer />
            </div>
        </BrowserRouter>
    );
}

export default App;
