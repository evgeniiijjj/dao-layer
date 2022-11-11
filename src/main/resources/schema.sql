
CREATE TABLE CUSTOMERS
(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    surname VARCHAR(30) NOT NULL,
    age INTEGER CHECK(Age > 0 AND Age < 100),
    phone_number VARCHAR(15) UNIQUE
);

CREATE TABLE ORDERS
(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    date DATE NOT NULL,
    customer_id INTEGER NOT NULL,
    product_name VARCHAR (100) NOT NULL,
    amount INTEGER,
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);

INSERT INTO CUSTOMERS (name, surname, age, phone_number)
VALUES ('Alexey', 'Alexiev', 20, 89283654596),
       ('Ivan', 'Vasiliev', 31, 89283694536),
       ('ivan', 'Yegorovich', 35, 89283656786),
       ('ivan', 'Dmitrievich', 37, 89383654596),
       ('alexey', 'Mikhailovich', 35, 89283651236);

INSERT INTO ORDERS (date, customer_id, product_name, amount)
VALUES ('01.10.2022', 1, 'headphones', 1),
       ('02.10.2022', 2, 'laptop', 1),
       ('02.11.2022', 3, 'camera', 2),
       ('03.11.2022', 4, 'battery', 3),
       ('03.11.2022', 5, 'flashcard', 5)
