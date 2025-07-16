import { useState } from 'react';

interface Product {
    name: string;
    price: number;
    amount: number;
    description: string;
}

const ProductCreateComponent = () => {
    const [product, setProduct] = useState<Product>({
        name: '',
        price: 0,
        amount: 0,
        description: '',
    });

    const onSubmit = () => {
        console.log('Product created');
    };

    const onChange = (e: any) => {
        // console.log("onChange", e.target.name, e.target.value);
        setProduct({
            ...product,
            [e.target.name]: e.target.value,
        });
    };

    return (
        <>
            <h1>Create a New Product</h1>
            <form onSubmit={onSubmit}>
                <div>
                    <label htmlFor="name">Name:</label>
                    <input
                        type="text"
                        placeholder="product name"
                        id="name"
                        name="name"
                        value={product.name}
                        onChange={onChange}
                    />
                </div>

                <div>
                    <label htmlFor="price">Price:</label>
                    <input
                        type="text"
                        placeholder="product price"
                        id="price"
                        name="price"
                        value={product.price}
                        onChange={onChange}
                    />
                </div>

                <div>
                    <label htmlFor="amount">Amount:</label>
                    <input
                        type="text"
                        placeholder="product amount"
                        id="amount"
                        name="amount"
                        value={product.amount}
                        onChange={onChange}
                    />
                </div>

                <div>
                    <label htmlFor="description">Description:</label>
                    <input
                        type="text"
                        placeholder="product description"
                        id="description"
                        name="description"
                        value={product.description}
                        onChange={onChange}
                    />
                </div>

                <button type="submit">Create new</button>
            </form>
        </>
    );
};

export default ProductCreateComponent;
