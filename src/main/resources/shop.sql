CREATE SCHEMA `shop` ;

CREATE TABLE categories 
 (
    category_id SERIAL PRIMARY KEY, 
    category_name VARCHAR(100) NOT NULL
);


CREATE TABLE products
(
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(255)  NOT NULL,
    price INT NOT NULL,
    category_id BIGINT UNSIGNED,
    FOREIGN KEY (category_id) REFERENCES categories (category_id)
);


CREATE TABLE users
(
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
	user_password VARCHAR(100) NOT NULL,
	user_role VARCHAR(45) NOT NULL,
	user_status VARCHAR(45) NOT NULL
);


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
