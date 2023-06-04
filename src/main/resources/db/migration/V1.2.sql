-- DROP TABLE IF EXISTS COURSES;
CREATE SEQUENCE COURSES_SEQ;
CREATE TABLE COURSES (
    ID bigint CHECK (ID > 0) NOT NULL DEFAULT NEXTVAL ('courses_seq'),
    NAME VARCHAR(50) NOT NULL,
    DESCRIPTION VARCHAR(110) NOT NULL,
    DEGREE VARCHAR(50) NOT NULL,
    LMS_URL VARCHAR(255) NOT NULL,
    CREATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    UPDATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    PRIMARY KEY (ID)
);
ALTER SEQUENCE COURSES_SEQ RESTART WITH 29;
INSERT INTO COURSES
VALUES (
        1,
        'Artes Visuais',
        'Curso de Artes Visuais',
        'L',
        'https://ead.sead.ufes.br/course/1',
        NULL,
        NULL
    ),
    (
        2,
        'Ciências Biológicas',
        'Curso de Ciências Biológicas',
        'L',
        'https://ead.sead.ufes.br/course/2',
        NULL,
        NULL
    ),
    (
        3,
        'Educação Física',
        'Curso de Educação Física',
        'L',
        'https://ead.sead.ufes.br/course/3',
        NULL,
        NULL
    ),
    (
        4,
        'Filosofia',
        'Curso de Filosofia',
        'L',
        'https://ead.sead.ufes.br/course/4',
        NULL,
        NULL
    ),
    (
        5,
        'Física',
        'Curso de Física',
        'L',
        'https://ead.sead.ufes.br/course/5',
        NULL,
        NULL
    ),
    (
        6,
        'História',
        'Curso de História',
        'L',
        'https://ead.sead.ufes.br/course/6',
        NULL,
        NULL
    ),
    (
        7,
        'Letras Italiano',
        'Curso de Letras Italiano',
        'L',
        'https://ead.sead.ufes.br/course/7',
        NULL,
        NULL
    ),
    (
        8,
        'Pedagogia',
        'Curso de Pedagogia',
        'L',
        'https://ead.sead.ufes.br/course/8',
        NULL,
        NULL
    ),
    (
        9,
        'Química',
        'Curso de Química',
        'L',
        'https://ead.sead.ufes.br/course/9',
        NULL,
        NULL
    ),
    (
        10,
        'Administração',
        'Curso de Administração',
        'B',
        'https://ead.sead.ufes.br/course/10',
        NULL,
        NULL
    ),
    (
        11,
        'Biblioteconomia',
        'Curso de Biblioteconomia',
        'B',
        'https://ead.sead.ufes.br/course/11',
        NULL,
        NULL
    ),
    (
        12,
        'Ciências Contábeis',
        'Curso de Ciências Contábeis',
        'B',
        'https://ead.sead.ufes.br/course/12',
        NULL,
        NULL
    ),
    (
        13,
        'Ciência é 10!',
        'Curso Ciência é 10!',
        'E',
        'https://ead.sead.ufes.br/course/13',
        NULL,
        NULL
    ),
    (
        14,
        'Educação em Direitos Humanos',
        'Curso de Educação em Direitos Humanos',
        'E',
        'https://ead.sead.ufes.br/course/14',
        NULL,
        NULL
    ),
    (
        15,
        'Ensino de Matemática para o Ensino Médio',
        'Curso de Ensino de Matemática para o Ensino Médio',
        'E',
        'https://ead.sead.ufes.br/course/15',
        NULL,
        NULL
    ),
    (
        16,
        'Epidemiologia',
        'Curso de Epidemiologia',
        'E',
        'https://ead.sead.ufes.br/course/16',
        NULL,
        NULL
    ),
    (
        17,
        'Filosofia e Psicanálise',
        'Curso de Filosofia e Psicanálise',
        'E',
        'https://ead.sead.ufes.br/course/17',
        NULL,
        NULL
    ),
    (
        18,
        'Gênero e Diversidade na Escola',
        'Curso de Gênero e Diversidade na Escola',
        'E',
        'https://ead.sead.ufes.br/course/18',
        NULL,
        NULL
    ),
    (
        19,
        'Gestão de Agronegócios',
        'Curso de Gestão de Agronegócios',
        'E',
        'https://ead.sead.ufes.br/course/19',
        NULL,
        NULL
    ),
    (
        20,
        'Gestão em Saúde',
        'Curso de Gestão em Saúde',
        'E',
        'https://ead.sead.ufes.br/course/20',
        NULL,
        NULL
    ),
    (
        21,
        'Gestão Pública',
        'Curso de Gestão Pública',
        'E',
        'https://ead.sead.ufes.br/course/21',
        NULL,
        NULL
    ),
    (
        22,
        'Logística',
        'Curso de Logística',
        'E',
        'https://ead.sead.ufes.br/course/22',
        NULL,
        NULL
    ),
    (
        23,
        'Oratória, Transversalidade e Didática da Fala',
        'Curso de Oratória, Transversalidade e Didática da Fala',
        'E',
        'https://ead.sead.ufes.br/course/23',
        NULL,
        NULL
    ),
    (
        24,
        'Educação Ambiental',
        'Curso de Educação Ambiental',
        'A',
        'https://ead.sead.ufes.br/course/24',
        NULL,
        NULL
    ),
    (
        25,
        'Educação do Campo',
        'Curso de Educação do Campo',
        'A',
        'https://ead.sead.ufes.br/course/25',
        NULL,
        NULL
    ),
    (
        26,
        'Educação para a Diversidade e Cidadania',
        'Curso de Educação para a Diversidade e Cidadania',
        'A',
        'https://ead.sead.ufes.br/course/26',
        NULL,
        NULL
    ),
    (
        27,
        'Educação para as Relações Etnicorraciais',
        'Curso de Educação para as Relações Etnicorraciais',
        'A',
        'https://ead.sead.ufes.br/course/27',
        NULL,
        NULL
    ),
    (
        28,
        'Gestão de Políticas Públicas em Gênero e Raça',
        'Curso de Gestão de Políticas Públicas em Gênero e Raça',
        'A',
        'https://ead.sead.ufes.br/course/28',
        NULL,
        NULL
    );