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


CREATE TABLE users
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name   VARCHAR(20)  NOT NULL,
    last_name    VARCHAR(50)  NOT NULL,
    email        VARCHAR(100) NOT NULL UNIQUE,
    password     VARCHAR(100) NOT NULL,
    phone_number VARCHAR(12)  DEFAULT NULL,
    address      VARCHAR(200) DEFAULT NULL,
    city         VARCHAR(50)  DEFAULT NULL,
    zip_code     VARCHAR(20)  DEFAULT NULL
);

CREATE TABLE authority
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(100) NOT NULL,
    description VARCHAR(2000)
);

CREATE TABLE users_authorities
(
    user_id      BIGINT NOT NULL,
    authority_id BIGINT NOT NULL
);

ALTER TABLE users_authorities
    ADD CONSTRAINT users_authorities_user_id
        FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE users_authorities
    ADD CONSTRAINT users_authorities_authority_id
        FOREIGN KEY (authority_id) REFERENCES authority (id);

CREATE UNIQUE INDEX users_authorities_unique ON users_authorities (user_id, authority_id);

CREATE TABLE file
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(255),
    extension    VARCHAR(255),
    content_type VARCHAR(255),
    size         BIGINT,
    created_at   TIMESTAMP
);
