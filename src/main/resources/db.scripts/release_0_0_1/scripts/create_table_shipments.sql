--liquibase formatted sql

--changeset krasilov-aa:create_table_Shipments rollbackSplitStatements:true
--comment: Создание таблицы Shipments

CREATE TABLE IF NOT EXISTS Shipments
(
    id              SERIAL PRIMARY KEY,
    customer_id     INT,
    product_id      INT,
    day             DATE,
    shipment_price  DECIMAL(10, 2),
    promo_flag VARCHAR(10),
    FOREIGN KEY (customer_id) REFERENCES Customers(id),
    FOREIGN KEY (product_id) REFERENCES Products (id)
);

--rollback DROP TABLE Shipments;