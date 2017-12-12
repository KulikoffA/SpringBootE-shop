drop TABLE IF EXISTS cart_items;
drop TABLE IF EXISTS cart;
drop TABLE IF EXISTS products;
drop TABLE IF EXISTS user_roles;
drop TABLE IF EXISTS users;


CREATE TABLE cart
(
  cart_id VARCHAR(50) PRIMARY KEY NOT NULL
);
CREATE TABLE cart_items
(
  cart_id VARCHAR(50) NOT NULL,
  product_id VARCHAR(20) NOT NULL,
  quantity INTEGER
);
CREATE TABLE products
(
  product_id VARCHAR(20) PRIMARY KEY NOT NULL,
  brand VARCHAR(20) NOT NULL,
  name VARCHAR(20) NOT NULL,
  price INTEGER NOT NULL,
  description VARCHAR(1000) NOT NULL,
  in_stock INTEGER NOT NULL,
  in_order INTEGER DEFAULT 0 NOT NULL,
  category VARCHAR(20) NOT NULL
);
CREATE TABLE user_roles
(
  username VARCHAR(20) NOT NULL,
  role VARCHAR(20) NOT NULL
);
CREATE UNIQUE INDEX user_roles_username_role_pk ON user_roles (username, role);
CREATE TABLE users
(
  username VARCHAR(20),
  password VARCHAR(20) NOT NULL,
  enabled BOOLEAN DEFAULT true
);

ALTER TABLE cart_items
  ADD CONSTRAINT cart_items_cart_cart_id_fk
FOREIGN KEY (cart_id) REFERENCES cart (cart_id);
ALTER TABLE cart_items
  ADD CONSTRAINT cart_items_products_product_id_fk
FOREIGN KEY (product_id) REFERENCES products (product_id);

ALTER TABLE public.cart_items ADD CONSTRAINT cart_items_cart_id_product_id_pk PRIMARY KEY (cart_id, product_id);
