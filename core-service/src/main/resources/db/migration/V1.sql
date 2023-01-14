CREATE SCHEMA `shop` ;
CREATE TABLE categories
(
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL
);
Insert Into categories(category_id, category_name)
VALUES (1, 'tea'), (2, 'coffee');

CREATE TABLE products
(
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(255)  NOT NULL,
    price INT NOT NULL,
    category_id BIGINT UNSIGNED,
    FOREIGN KEY (category_id) REFERENCES categories (category_id)
);
Insert Into products(product_name, price, category_id)
VALUES ('Шен Пуэр', 100, 1), ('Шy Пуэр', 200, 1), ('Габа', 300, 1);

Insert Into products(product_name, price, category_id)
VALUES ('Lavazza', 100, 2), ('Dallmayr', 200, 2), ('Merrild', 300, 2);

CREATE TABLE purchases
(
    purchase_id SERIAL PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL,
    purchase_date DATETIME NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE purchase_items
(
    purchase_items_id SERIAL PRIMARY KEY,
    purchase_id BIGINT UNSIGNED NOT NULL,
    product_id BIGINT UNSIGNED NOT NULL,
    product_count BIGINT UNSIGNED NOT NULL,
    product_price INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products (product_id),
    FOREIGN KEY (purchase_id) REFERENCES purchases (purchase_id)
);
