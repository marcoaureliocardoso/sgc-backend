-- DROP TABLE IF EXISTS EMPLOYEES;
CREATE SEQUENCE EMPLOYEES_SEQ;
CREATE TABLE EMPLOYEES (
    ID bigint CHECK (ID > 0) NOT NULL DEFAULT NEXTVAL ('employees_seq'),
    CPF VARCHAR(11) NOT NULL,
    NAME VARCHAR(50) NOT NULL,
    GENDER VARCHAR(10) NOT NULL,
    EMAIL VARCHAR(50) NOT NULL,
    CREATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    UPDATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT EMPLOYEES_CPF_UNIQUE UNIQUE (CPF),
    CONSTRAINT EMPLOYEES_EMAIL_UNIQUE UNIQUE (EMAIL)
);