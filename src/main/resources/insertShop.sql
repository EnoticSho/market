Insert Into categories(category_id, category_name)
VALUES (1, 'tea'), (2, 'coffee')


Insert Into products(product_name, price, category_id)
VALUES ('Шен Пуэр', 100, 1), ('Шy Пуэр', 200, 1), ('Габа', 300, 1)

Insert Into products(product_name, price, category_id)
VALUES ('Lavazza', 100, 2), ('Dallmayr', 200, 2), ('Merrild', 300, 2)


Insert Into users(user_name, user_password, user_role, user_status)
VALUES ('Alisa', '$2a$12$PQkh5S4HTgo.PL.ev0Qu8eBHQZc0LQzExc3XgP5hsvgtgW3KP4yw.', 'ADMIN', 'ACTIVE'),
    ('Sanya', '$2a$12$VjnRB/gZybumbtOpqWjYfOMU4yrFFbQYZPeQO6ZPyHVN4gfH1twta', 'MANAGER', 'ACTIVE'),
    ('Vasya', '$2a$12$CeqYW0Us2TShujTt9Y7dje.Y8oZRwZyOP.gIlRk9eSyNCCLUD8aQW', 'USER', 'ACTIVE'),
    ('Vanya', '$2a$12$cim7Epi9I5HT.qip737OHO8u3sZaGAeH3.uE9ng7HGlZ2ccwOMuJu', 'USER', 'ACTIVE')

