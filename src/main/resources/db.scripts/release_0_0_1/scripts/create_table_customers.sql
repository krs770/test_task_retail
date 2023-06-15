--liquibase formatted sql

--changeset krasilov-aa:create_table_Customers rollbackSplitStatements:true
--comment: Создание таблицы Customers

CREATE TABLE IF NOT EXISTS Customers
(
    id           SERIAL PRIMARY KEY,
    address      VARCHAR(255),
    network_name VARCHAR(255) UNIQUE
);

--rollback DROP TABLE Customers;