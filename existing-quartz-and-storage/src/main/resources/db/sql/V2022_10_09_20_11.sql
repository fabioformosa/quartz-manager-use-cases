--liquibase formatted sql

--changeset Fabio:V2022_10_09_20_11_01 (dbms:postgresql)

CREATE TABLE QUOTES(
    ID serial primary key,
    AUTHOR varchar(255),
    TEXT   varchar(1024)
);
INSERT INTO QUOTES(ID, AUTHOR, TEXT) VALUES (1, 'Albert Einstein', 'Strive not to be a success, but rather to be of value');
INSERT INTO QUOTES(ID, AUTHOR, TEXT) VALUES (2, 'Mahatma Gandhi', 'You must be the change you wish to see in the world');
INSERT INTO QUOTES(ID, AUTHOR, TEXT) VALUES (3, 'Lao Tzu','The journey of a thousand miles begins with one step');