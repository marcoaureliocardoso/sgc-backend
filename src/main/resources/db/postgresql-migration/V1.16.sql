-- DROP TABLE IF EXISTS DOCUMENT_TYPES;
CREATE SEQUENCE DOCUMENT_TYPES_SEQ;
CREATE TABLE DOCUMENT_TYPES (
    ID bigint CHECK (ID > 0) NOT NULL DEFAULT NEXTVAL ('document_types_seq'),
    NAME VARCHAR(100) NOT NULL,
    DESCRIPTION VARCHAR(110) NOT NULL,
    CREATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    UPDATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    PRIMARY KEY (ID)
);
ALTER SEQUENCE DOCUMENT_TYPES_SEQ RESTART WITH 21;
INSERT INTO DOCUMENT_TYPES
VALUES (1, 'RG', 'Carteira de Identidade', NULL, NULL),
    (
        2,
        'CPF',
        'Cadastro de Pessoas Físicas',
        NULL,
        NULL
    ),
    (
        3,
        'CNH',
        'Carteira Nacional de Habilitação',
        NULL,
        NULL
    ),
    (
        4,
        'Passaporte',
        'Passaporte brasileiro emitido pela Polícia Federal ou pelo Ministério das Relações Exteriores',
        NULL,
        NULL
    ),
    (
        5,
        'Carteira de Identidade Profissional',
        'Carteira de Identidade Profissional emitida por entidades de classe (OAB, CRM, CRBio, CREA)',
        NULL,
        NULL
    ),
    (
        6,
        'SIAPE',
        'Sistema Integrado de Administração de Pessoal',
        NULL,
        NULL
    ),
    (
        7,
        'Ficha de Inscrição - Formulário',
        '',
        NULL,
        NULL
    ),
    (8, 'Termo de cessão de direitos', '', NULL, NULL),
    (9, 'Comprobatório do currículo', '', NULL, NULL),
    (10, 'Diploma de maior titulação', '', NULL, NULL),
    (11, 'Comprovante de residência', '', NULL, NULL),
    (
        12,
        'Comprovante de experiência no magistério no ensino superior',
        '',
        NULL,
        NULL
    ),
    (
        13,
        'Comprovante de quitação eleitoral',
        '',
        NULL,
        NULL
    ),
    (14, 'Certificado de reservista', '', NULL, NULL),
    (15, 'Certidão de casamento', '', NULL, NULL),
    (16, 'Ficha de qualificação', '', NULL, NULL),
    (
        17,
        'Experiência - Prática em atividades de processos EAD',
        '',
        NULL,
        NULL
    ),
    (
        18,
        'Experiência - Participação  na  produção  de  materiais didáticos',
        '',
        NULL,
        NULL
    ),
    (
        19,
        'Experiência - Atividades de apoio ao ensino: planejamento pedagógico, coordenação',
        '',
        NULL,
        NULL
    ),
    (
        20,
        'Experiência - Experiência  com  formatação  e  uso  de ambientes virtuais de aprendizagem',
        '',
        NULL,
        NULL
    );