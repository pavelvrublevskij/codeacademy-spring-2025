import { Route, Routes } from 'react-router-dom';
import HomePage from './HomePage/HomePage';
import ProductsPage from './ProductsPage';
import NewProductPage from './NewProductPage';
import ExchangeRatesPage from './ExchangeRatesPage';
import LoginPage from "./LoginPage/LoginPage";

const Pages = () => (
    <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/products" element={<ProductsPage />} />
        <Route path="/products/create" element={<NewProductPage />} />
        <Route path="/products/:productId" element={<ProductsPage />} />
        <Route path="/exchange-ratest" element={<ExchangeRatesPage />} />
        <Route path="/login" element={<LoginPage />} />
    </Routes>
);

export default Pages;
