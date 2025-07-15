import { useParams } from 'react-router-dom';

const ProductsPage = () => {
    const { productId } = useParams<{ productId: string }>();

    return (
        <>
            <h1>This is Product Page</h1>
            <p>Product ID: {productId}</p>
        </>
    );
};

export default ProductsPage;
