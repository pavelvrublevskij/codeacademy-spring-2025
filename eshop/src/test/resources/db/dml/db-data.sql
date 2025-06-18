insert into product_category (name)
values ('Phone'),
    ('Other');

insert into users (first_name,
                  last_name,
                  email,
                  password,
                  phone_number,
                  address,
                  city,
                  zip_code)
VALUES ('Admin', 'Admin', 'admin@eshop.lt',
        '$2a$12$scveGQWH2wL6VWjzspc9a.6YK/kZx15X1FwpgPbQTloQlOPd1Jq3W',
        'N/A', 'N/A', 'N/A', 'N/A'),
('User', 'User', 'user@eshop.lt',
    '$2a$12$8hk6Og4DREwZOKyx/XhuMu0GMJ2DOheDf/Z/IaJYoQ7PAU.dwaToW',
    'N/A', 'N/A', 'N/A', 'N/A');

insert into authority (name, description)
VALUES ('ADMIN', 'Administrator role with full access'),
       ('USER', 'User role with limited access');

insert into users_authorities (user_id, authority_id)
VALUES (1, 1), -- Admin user with ADMIN authority
        (1, 2), -- Admin user with USER authority
       (2, 2); -- Regular user with USER authority