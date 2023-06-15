--liquibase formatted sql

--changeset krasilov-aa:create_table_Price rollbackSplitStatements:true
--comment: Создание таблицы Price

CREATE TABLE IF NOT EXISTS  Price
(
    id SERIAL PRIMARY KEY ,
    customer_id INT,
    product_id INT,
    regular_price DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES Customers (id),
    FOREIGN KEY (product_id) REFERENCES Products (id)
);

--rollback DROP TABLE Price;