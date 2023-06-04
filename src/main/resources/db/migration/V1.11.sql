-- DROP TABLE IF EXISTS APPLICANTS;
CREATE SEQUENCE APPLICANTS_SEQ;
CREATE TABLE APPLICANTS (
    ID bigint CHECK (ID > 0) NOT NULL DEFAULT NEXTVAL ('applicants_seq'),
    NAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(50) NOT NULL,
    AREA_CODE VARCHAR(3) NOT NULL,
    LANDLINE VARCHAR(11) DEFAULT NULL,
    MOBILE VARCHAR(11) NOT NULL,
    HIRING_PROCESS VARCHAR(8) NOT NULL,
    ROLE_ID bigint CHECK (ROLE_ID > 0) NOT NULL,
    POLE_ID bigint CHECK (POLE_ID > 0) DEFAULT NULL,
    COURSE_ID bigint CHECK (COURSE_ID > 0) DEFAULT NULL,
    CALL_STATE VARCHAR(15) NOT NULL,
    CREATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    UPDATED_AT TIMESTAMP(0) NULL DEFAULT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT APPLICANTS_COURSE_ID_FOREIGN FOREIGN KEY (COURSE_ID) REFERENCES COURSES (ID),
    CONSTRAINT APPLICANTS_POLE_ID_FOREIGN FOREIGN KEY (POLE_ID) REFERENCES POLES (ID),
    CONSTRAINT APPLICANTS_ROLE_ID_FOREIGN FOREIGN KEY (ROLE_ID) REFERENCES ROLES (ID)
);
CREATE INDEX APPLICANTS_ROLE_ID_FOREIGN ON APPLICANTS (ROLE_ID);
CREATE INDEX APPLICANTS_POLE_ID_FOREIGN ON APPLICANTS (POLE_ID);
CREATE INDEX APPLICANTS_COURSE_ID_FOREIGN ON APPLICANTS (COURSE_ID);