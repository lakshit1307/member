CREATE TABLE M_MEMBER_ROLE (
	MEMBER_ROLE_ID serial NOT NULL,
	ROLE_ID INTEGER NOT NULL REFERENCES M_ROLE(ROLE_ID),
	MEMBER_ID INTEGER NOT NULL REFERENCES M_MEMBER(MEMBER_ID),
	GLOBAL_ID VARCHAR(200) DEFAULT NULL,
    TENANT_ID INTEGER DEFAULT NULL,
    CREATED_DATE TIMESTAMP DEFAULT NULL,
	CREATED_BY VARCHAR(200) DEFAULT NULL,
    UPDATED_DATE TIMESTAMP DEFAULT NULL,
    UPDATED_BY VARCHAR(200) DEFAULT NULL,
	CONSTRAINT M_MEMBER_ROLE_PK PRIMARY KEY (MEMBER_ROLE_ID),
	CONSTRAINT M_MEMBER_ROLE_UK UNIQUE (ROLE_ID, MEMBER_ID, TENANT_ID)
);