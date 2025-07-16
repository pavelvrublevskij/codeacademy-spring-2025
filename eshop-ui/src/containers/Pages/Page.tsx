import { Route, Routes } from 'react-router-dom';
import HomePage from './HomePage/HomePage';
import ProductsPage from './ProductsPage';
import NewProductPage from './NewProductPage';

const Pages = () => (
    <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/products" element={<ProductsPage />} />
        <Route path="/products/create" element={<NewProductPage />} />
        <Route path="/products/:productId" element={<ProductsPage />} />
    </Routes>
);

export default Pages;
