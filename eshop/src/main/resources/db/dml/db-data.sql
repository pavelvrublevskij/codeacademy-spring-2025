INSERT INTO product (product_id, name, quantity_in_stock, price, description)
VALUES
    ('b4e1d83a-7c2d-4e11-8d12-3f65db34c6c0', 'iPhone 14', 50, 999.99, 'Apple iPhone 14 with 128GB storage, Midnight Black'),
('d2a349a3-8a14-4f9e-81e4-61b90b7a28ff', 'Samsung S23', 40, 899.99, 'Samsung Galaxy S23 with 256GB storage, Phantom Black'),
('0fa29a66-6d4c-437d-a7cf-3a51b844110c', 'Google Pixel 7', 30, 799.00, 'Google Pixel 7 with 128GB, Snow White'),
('c1524d18-e26e-4b9a-8a75-4c104b2f887d', 'OnePlus 11', 25, 699.99, 'OnePlus 11 5G with 16GB RAM and 256GB storage'),
('e2bcb15d-3ac0-43e2-9c66-0086de54e00e', 'Xiaomi 13 Pro', 20, 749.50, 'Xiaomi 13 Pro with Leica camera, Ceramic Black'),
('5b71f9e7-14a2-4d5a-bb2d-7c5ad4dfb693', 'Sony Xperia 1 V', 15, 949.99, 'Sony Xperia 1 V with 4K OLED display, 512GB'),
('a9d179fa-e8e2-4b19-b74c-21e3881d14f0', 'Motorola Edge 40', 35, 599.00, 'Motorola Edge 40 with 144Hz OLED display'),
('c1524d18-e26e-4b9a-8a75-4c104b2f8871', 'onePlus 11', 25, 699.99, 'OnePlus 11 5G with 16GB RAM and 256GB storage'),
('e2bcb15d-3ac0-43e2-9c66-0086de54e002', 'xiaomi 13 Pro', 20, 749.50, 'Xiaomi 13 Pro with Leica camera, Ceramic Black'),
('5b71f9e7-14a2-4d5a-bb2d-7c5ad4dfb694', 'sony Xperia 1 V', 15, 949.99, 'Sony Xperia 1 V with 4K OLED display, 512GB'),
('a9d179fa-e8e2-4b19-b74c-21e3881d14f5', 'motorola Edge 40', 35, 599.00, 'Motorola Edge 40 with 144Hz OLED display'),
('4f34830f-dfa5-4566-9f40-279f94cf66f4', 'Nokia XR21', 10, 499.99, 'Rugged Nokia XR21, 128GB, 5G ready'),
('d7f81f80-d11b-4e4e-b5cc-19164031c055', 'Asus ROG Phone 7', 8, 1099.00, 'Gaming phone with 165Hz AMOLED and 6000mAh battery'),
( 'ab65a876-8723-4a5c-865d-6f172ec0ea3c', 'Realme GT Neo 5', 12, 449.49, 'Realme GT Neo 5 with 240W charging, 1TB storage');

insert into product_category (name)
values ('Phone'),
    ('Other');

insert into product_product_categories (product_id, product_category_id)
values (1, 1),
    (2, 1),
    (3, 1),
    (4, 1),
    (5, 1),
    (6, 1),
    (7, 1),
    (8, 1),
    (9, 1),
    (10, 1),
    (11, 1),
    (12, 1),
    (13, 1),
    (14, 1);

insert into users (first_name,
                  last_name,
                  email,
                  password,
                  phone_number,
                  address,
                  city,
                  zip_code)
VALUES ('Admin', 'Admin', 'admin@eshop.lt',
        '{bcrypt}$2a$12$scveGQWH2wL6VWjzspc9a.6YK/kZx15X1FwpgPbQTloQlOPd1Jq3W',
        'N/A', 'N/A', 'N/A', 'N/A'),
('User', 'User', 'user@eshop.lt',
    '{bcrypt}$2a$12$8hk6Og4DREwZOKyx/XhuMu0GMJ2DOheDf/Z/IaJYoQ7PAU.dwaToW',
    'N/A', 'N/A', 'N/A', 'N/A');