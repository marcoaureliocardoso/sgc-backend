-- DROP TABLE IF EXISTS ROLES;
CREATE SEQUENCE ROLES_SEQ;
CREATE TABLE ROLES (
    ID bigint CHECK (ID > 0) NOT NULL DEFAULT NEXTVAL ('roles_seq'),
    NAME VARCHAR(50) NOT NULL,
    DESCRIPTION VARCHAR(110) NOT NULL,
    GRANT_VALUE int CHECK (GRANT_VALUE > 0) NOT NULL,
    GRANT_TYPE VARCHAR(20) NOT NULL,
    CREATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    UPDATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    PRIMARY KEY (ID)
);
ALTER SEQUENCE ROLES_SEQ RESTART WITH 13;
INSERT INTO ROLES
VALUES (
        1,
        'Coordenador de curso I',
        'Coordenador de curso, com 3 anos de experiência em docência no ensino superior',
        140000,
        'M',
        NULL,
        NULL
    ),
    (
        2,
        'Coordenador de curso II',
        'Coordenador de curso, com 1 ano de experiência em docência no ensino superior',
        110000,
        'M',
        NULL,
        NULL
    ),
    (
        3,
        'Tutor a Distancia',
        'Tutor a Distancia',
        76500,
        'P',
        NULL,
        NULL
    ),
    (
        4,
        'Tutor Presencial',
        'Tutor Presencial',
        76500,
        'P',
        NULL,
        NULL
    ),
    (
        5,
        'Professor I',
        'Professor, com 3 anos de experiência em docência no ensino superior',
        130000,
        'P',
        NULL,
        NULL
    ),
    (
        6,
        'Professor II',
        'Professor, com 1 ano de experiência em docência no ensino superior',
        110000,
        'P',
        NULL,
        NULL
    ),
    (
        7,
        'Coordenador de Tutoria I',
        'Coordenador de Tutoria, com 3 anos de experiência em docência no ensino superior',
        130000,
        'P',
        NULL,
        NULL
    ),
    (
        8,
        'Coordenador de Tutoria II',
        'Coordenador de Tutoria, com 1 ano de experiência em docência no ensino superior',
        110000,
        'P',
        NULL,
        NULL
    ),
    (
        9,
        'Professor orientador de TCC I',
        'Professor orientador de TCC, com 3 anos de experiência em docência no ensino superior',
        130000,
        'P',
        NULL,
        NULL
    ),
    (
        10,
        'Professor orientador de TCC II',
        'Professor orientador de TCC, com 1 ano de experiência em docência no ensino superior',
        110000,
        'P',
        NULL,
        NULL
    ),
    (
        11,
        'Professor formador de componentes curriculares I',
        'Professor formador de componentes curriculares, com 3 anos de experiência em docência no ensino superior',
        130000,
        'P',
        NULL,
        NULL
    ),
    (
        12,
        'Professor formador de componentes curriculares II',
        'Professor formador de componentes curriculares, com 1 ano de experiência em docência no ensino superior',
        110000,
        'P',
        NULL,
        NULL
    );