import { useParams } from 'react-router-dom';
import { useEffect } from 'react';
import { getProductsApi } from '../../../config/api/eshopApiEndpoints';

const ProductsPage = () => {
    const { productId } = useParams<{ productId: string }>();

    useEffect(() => {
        getProductsApi()
            // This is where you would handle the API response when successful
            .then((response) => console.log('response', response))
            // This is where you would handle the API error
            .catch((error) => console.error('Error fetching products:', error));
    });

    return (
        <>
            <h1>This is Product Page</h1>
            <p>Product ID: {productId}</p>
        </>
    );
};

export default ProductsPage;
