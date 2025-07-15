import Header from './Header';
import Footer from './Footer';
import './App.css';
import HomePage from './Pages/HomePage/HomePage';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import NewProductPage from './Pages/NewProductPage';
import ProductsPage from './Pages/ProductsPage';

function App() {
    return (
        <BrowserRouter>
            <div className="mainApp">
                <Header />
                <Routes>
                    <Route path="/" element={<HomePage />} />
                    <Route path="/products" element={<ProductsPage />} />
                    <Route
                        path="/products/create"
                        element={<NewProductPage />}
                    />
                </Routes>
                <Footer />
            </div>
        </BrowserRouter>
    );
}

export default App;
