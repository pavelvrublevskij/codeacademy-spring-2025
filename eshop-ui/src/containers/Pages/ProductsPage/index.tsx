import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { getProductsApi } from '../../../config/api/eshopApiEndpoints';
import Container from 'react-bootstrap/Container';
import { Card, Col, Row } from 'react-bootstrap';

interface ProductsData {
    amount: number;
    categoryName: string;
    description: string;
    name: string;
    price: number;
    uuid: string;
}

const ProductsPage = () => {
    const { productId } = useParams<{ productId: string }>();
    const [productsData, setProductsData] = useState<ProductsData[]>([]);

    useEffect(() => {
        getProductsApi()
            // This is where you would handle the API response when successful
            .then((response) => {
                // console.log('response', response);
                setProductsData(response.data);
                // console.log('productsData', productsData);
            })
            // This is where you would handle the API error
            .catch((error) => console.error('Error fetching products:', error));
    });

    return (
        <Container fluid>
            <h1 className={'text-center'}>Product list</h1>
            <Row className="justify-content-md-center g-4">
                {productsData.map((product) => (
                    <Col key={product.uuid}>
                        <Card style={{ width: '18rem' }}>
                            <Card.Header>
                                <div className="d-flex justify-content-between align-items-center">
                                    <div>{product.price} Eur</div>
                                    <div>{product.amount} available</div>
                                </div>
                            </Card.Header>
                            <Card.Body>
                                <Card.Title>{product.name}</Card.Title>
                                <Card.Text>{product.description}</Card.Text>
                            </Card.Body>
                        </Card>
                    </Col>
                ))}
            </Row>
        </Container>
    );
};

export default ProductsPage;
