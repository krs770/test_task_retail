--liquibase formatted sql

--changeset krasilov-aa:create_table_Products rollbackSplitStatements:true
--comment: Создание таблицы Products

CREATE TABLE IF NOT EXISTS Products
(
    id           SERIAL PRIMARY KEY,
    product_code VARCHAR(50),
    name         VARCHAR(255),
    category     VARCHAR(255),
    brand        VARCHAR(255)
);

--rollback DROP TABLE Products;