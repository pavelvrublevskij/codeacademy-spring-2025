DROP TABLE IF EXISTS product;

CREATE TABLE product
(
    id                SERIAL PRIMARY KEY,
    product_id        UUID           NOT NULL,
    name              VARCHAR(40)    NOT NULL,
    quantity_in_stock INT DEFAULT 0  NOT NULL,
    price             NUMERIC(20, 2) NOT NULL,
    description       VARCHAR(500)
);
