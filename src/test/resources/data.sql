DROP TABLE IF EXISTS product;



CREATE TABLE product (
  id INT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  Units INT NOT NULL,
  status VARCHAR(250) NOT NULL,
  data VARCHAR(250) NOT NULL,
  price float NOT NULL,
  enable VARCHAR(250) NOT NULL
);
INSERT INTO product (id, name,description, Units, status, data, price, enable) VALUES
  (1,'product 1', 'desc 1', 10, 'new', '20/10/10',1.00, 'true'),
  (2,'product 2', 'desc 2', 10, 'used', '20/10/10',1.00, 'false'),
  (3,'product 3', 'desc 3', 10, 'new', '20/10/10',1.00, 'true')


