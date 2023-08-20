-- DROP TABLE IF EXISTS POLES;
CREATE SEQUENCE POLES_SEQ;
CREATE TABLE POLES (
    ID bigint CHECK (ID > 0) NOT NULL DEFAULT NEXTVAL ('poles_seq'),
    NAME VARCHAR(50) NOT NULL,
    DESCRIPTION VARCHAR(110) NOT NULL,
    CREATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    UPDATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    PRIMARY KEY (ID)
);
ALTER SEQUENCE POLES_SEQ RESTART WITH 29;
INSERT INTO POLES
VALUES (
        1,
        'SEAD',
        'Superintendência de Educação a Distância',
        NULL,
        NULL
    ),
    (2, 'Vitória', 'Polo de Vitória', NULL, NULL),
    (
        3,
        'Afonso Cláudio',
        'Polo de Afonso Cláudio',
        NULL,
        NULL
    ),
    (4, 'Alegre', 'Polo de Alegre', NULL, NULL),
    (5, 'Aracruz', 'Polo de Aracruz', NULL, NULL),
    (
        6,
        'Baixo Guandu',
        'Polo de Baixo Guandu',
        NULL,
        NULL
    ),
    (
        7,
        'Bom Jesus do Norte',
        'Polo de Bom Jesus do Norte',
        NULL,
        NULL
    ),
    (
        8,
        'Cachoeiro de Itapemirim',
        'Polo de Cachoeiro de Itapemirim',
        NULL,
        NULL
    ),
    (9, 'Castelo', 'Polo de Castelo', NULL, NULL),
    (10, 'Colatina', 'Polo de Colatina', NULL, NULL),
    (
        11,
        'Conceição da Barra',
        'Polo de Conceição da Barra',
        NULL,
        NULL
    ),
    (
        12,
        'Domingos Martins',
        'Polo de Domingos Martins',
        NULL,
        NULL
    ),
    (
        13,
        'Ecoporanga',
        'Polo de Ecoporanga',
        NULL,
        NULL
    ),
    (
        14,
        'Itapemirim',
        'Polo de Itapemirim',
        NULL,
        NULL
    ),
    (15, 'Iúna', 'Polo de Iúna', NULL, NULL),
    (16, 'Linhares', 'Polo de Linhares', NULL, NULL),
    (
        17,
        'Mantenópolis',
        'Polo de Mantenópolis',
        NULL,
        NULL
    ),
    (
        18,
        'Mimoso do Sul',
        'Polo de Mimoso do Sul',
        NULL,
        NULL
    ),
    (19, 'Montanha', 'Polo de Montanha', NULL, NULL),
    (
        20,
        'Nova Venécia',
        'Polo de Nova Venécia',
        NULL,
        NULL
    ),
    (21, 'Pinheiros', 'Polo de Pinheiros', NULL, NULL),
    (22, 'Piúma', 'Polo de Piúma', NULL, NULL),
    (
        23,
        'Santa Leopoldina',
        'Polo de Santa Leopoldina',
        NULL,
        NULL
    ),
    (
        24,
        'Santa Teresa',
        'Polo de Santa Teresa',
        NULL,
        NULL
    ),
    (
        25,
        'São Mateus',
        'Polo de São Mateus',
        NULL,
        NULL
    ),
    (
        26,
        'Vargem Alta',
        'Polo de Vargem Alta',
        NULL,
        NULL
    ),
    (
        27,
        'Venda Nova do Imigrante',
        'Polo de Venda Nova do Imigrante',
        NULL,
        NULL
    ),
    (
        28,
        'Vila Velha',
        'Polo de Vila Velha',
        NULL,
        NULL
    );