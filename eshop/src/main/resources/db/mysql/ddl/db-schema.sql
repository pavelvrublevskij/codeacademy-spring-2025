DROP TABLE IF EXISTS product;

CREATE TABLE product
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    product_id        VARCHAR(36)            NOT NULL,
    name              VARCHAR(40)            NOT NULL,
    quantity_in_stock INT          DEFAULT 0 NOT NULL,
    price             DECIMAL(20, 2)         NOT NULL,
    description       VARCHAR(500) DEFAULT NULL
);
