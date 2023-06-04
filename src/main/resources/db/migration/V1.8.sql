-- DROP TABLE IF EXISTS USER_TYPES;
CREATE SEQUENCE USER_TYPES_SEQ;
CREATE TABLE USER_TYPES (
    ID bigint CHECK (ID > 0) NOT NULL DEFAULT NEXTVAL ('user_types_seq'),
    NAME VARCHAR(50) NOT NULL,
    ACRONYM VARCHAR(5) NOT NULL,
    DESCRIPTION VARCHAR(110) NOT NULL,
    CREATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    UPDATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT USER_TYPES_ACRONYM_UNIQUE UNIQUE (ACRONYM)
);
ALTER SEQUENCE USER_TYPES_SEQ RESTART WITH 7;
INSERT INTO USER_TYPES
VALUES (
        1,
        'Administrador',
        'adm',
        'Administrador do sistema',
        NULL,
        NULL
    ),
    (
        2,
        'Diretor',
        'dir',
        'Diretor da Sead',
        NULL,
        NULL
    ),
    (
        3,
        'Assitente UAB',
        'ass',
        'Assitente UAB',
        NULL,
        NULL
    ),
    (
        4,
        'Secretário Acadêmico',
        'sec',
        'Colaborador da Secretaria Acadêmica da Sead',
        NULL,
        NULL
    ),
    (
        5,
        'Colaborador LDI',
        'ldi',
        'Colaborador do LDI da Sead',
        NULL,
        NULL
    ),
    (
        6,
        'Coordenador',
        'coord',
        'Coordenador que recebe bolsa',
        NULL,
        NULL
    );