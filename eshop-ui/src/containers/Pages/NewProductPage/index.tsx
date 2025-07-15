import { useState } from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';

interface Product {
    name: string;
    price: number;
    amount: number;
    description: string;
}

const NewProductPage = () => {
    const [product, setProduct] = useState<Product>({
        name: '',
        price: 0,
        amount: 0,
        description: '',
    });

    const onSubmit = (e: any) => {
        e.preventDefault();

        console.log('Product created');
        console.log(product);
    };

    const handleChange = (e: any) => {
        // console.log("onChange", e.target.name, e.target.value);
        setProduct({
            ...product,
            [e.target.name]: e.target.value,
        });
    };

    return (
        <Container>
            <Form onSubmit={onSubmit}>
                <Form.Group className="mb-3" controlId="name">
                    <Form.Label>Product name</Form.Label>
                    <Form.Control
                        placeholder="Enter name"
                        name="name"
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group className="mb-3" controlId="price">
                    <Form.Label>Product price</Form.Label>
                    <Form.Control
                        placeholder="Enter price"
                        name="price"
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group className="mb-3" controlId="amount">
                    <Form.Label>Product amount</Form.Label>
                    <Form.Control
                        placeholder="Enter amount"
                        name="amount"
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group className="mb-3" controlId="description">
                    <Form.Label>Product description</Form.Label>
                    <Form.Control
                        placeholder="Enter description"
                        name="description"
                        as="textarea"
                        onChange={handleChange}
                    />
                </Form.Group>

                <Form.Group className="mb-3" controlId="categoryId">
                    <Form.Label>Product category</Form.Label>
                    <Form.Select aria-label="Default select example">
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </Form.Select>
                </Form.Group>

                <Button variant="primary" type="submit">
                    Create new
                </Button>
            </Form>
        </Container>
    );
};

export default NewProductPage;
