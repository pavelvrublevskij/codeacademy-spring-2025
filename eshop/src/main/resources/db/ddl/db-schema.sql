CREATE TABLE product
(
    id INT PRIMARY KEY auto_increment,
    product_id UUID NOT NULL,
    name VARCHAR(40) NOT NULL,
    quantity_in_stock INT DEFAULT 0 NOT NULL,
    price DECIMAL(20, 2) NOT NULL,
    description VARCHAR(500) DEFAULT NULL
);

CREATE TABLE product_category
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE product_product_categories
(
    product_id          BIGINT NOT NULL,
    product_category_id INT    NOT NULL
);

ALTER TABLE product_product_categories
    ADD CONSTRAINT product_product_categories_category_id
        FOREIGN KEY (product_category_id) REFERENCES product_category (id);

ALTER TABLE product_product_categories
    ADD CONSTRAINT product_product_categories_product_id
        FOREIGN KEY (product_id) REFERENCES product (id);


CREATE TABLE users (
                       username VARCHAR(50) NOT NULL PRIMARY KEY,
                       password VARCHAR(100) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);
