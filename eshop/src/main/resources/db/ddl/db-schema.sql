CREATE TABLE product
(
    id INT PRIMARY KEY auto_increment,
    product_id UUID NOT NULL,
    name VARCHAR(20) NOT NULL,
    quantity_in_stock INT DEFAULT 0 NOT NULL,
    price DECIMAL(20, 2) NOT NULL,
    description VARCHAR(500) DEFAULT NULL
);