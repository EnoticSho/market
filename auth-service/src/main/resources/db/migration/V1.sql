CREATE TABLE users
(
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    user_password VARCHAR(100) NOT NULL,
    user_role VARCHAR(45) NOT NULL,
    user_status VARCHAR(45) NOT NULL
);

Insert Into users(user_name, user_password, user_role, user_status)
VALUES ('Alisa', '$2a$12$PQkh5S4HTgo.PL.ev0Qu8eBHQZc0LQzExc3XgP5hsvgtgW3KP4yw.', 'ADMIN', 'ACTIVE'),
       ('Sanya', '$2a$12$VjnRB/gZybumbtOpqWjYfOMU4yrFFbQYZPeQO6ZPyHVN4gfH1twta', 'MANAGER', 'ACTIVE'),
       ('Vasya', '$2a$12$CeqYW0Us2TShujTt9Y7dje.Y8oZRwZyOP.gIlRk9eSyNCCLUD8aQW', 'USER', 'ACTIVE'),
       ('Vanya', '$2a$12$cim7Epi9I5HT.qip737OHO8u3sZaGAeH3.uE9ng7HGlZ2ccwOMuJu', 'USER', 'ACTIVE');
