DROP TABLE IF EXISTS product_product_categories;
DROP TABLE IF EXISTS product_category;
DROP TABLE IF EXISTS product;

CREATE TABLE product
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    product_id        binary(36)            NOT NULL,
    name              VARCHAR(40)            NOT NULL,
    quantity_in_stock INT          DEFAULT 0 NOT NULL,
    price             DECIMAL(20, 2)         NOT NULL,
    description       VARCHAR(500) DEFAULT NULL
);

CREATE TABLE product_category
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE product_product_categories
(
    product_id          INT NOT NULL,
    product_category_id INT NOT NULL
);

ALTER TABLE product_product_categories
    ADD CONSTRAINT product_product_categories_category_id
        FOREIGN KEY (product_category_id) REFERENCES product_category (id);

ALTER TABLE product_product_categories
    ADD CONSTRAINT product_product_categories_product_id
        FOREIGN KEY (product_id) REFERENCES product (id);