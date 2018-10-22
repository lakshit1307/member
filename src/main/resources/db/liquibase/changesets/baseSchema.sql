CREATE TABLE M_MEMBER (
	MEMBER_ID serial NOT NULL,
	MEMBER_NAME varchar NOT NULL,
	MEMBER_EMAIL varchar NOT NULL,
	MEMBER_PASSWORD varchar NOT NULL,
	MEMBER_DESCRIPTION varchar NOT NULL,
	CONSTRAINT M_MEMBER_PK PRIMARY KEY (MEMBER_ID),
	CONSTRAINT M_MEMBER_UK_NAME UNIQUE (MEMBER_NAME),
	CONSTRAINT M_MEMBER_UK_EMAIL UNIQUE (MEMBER_EMAIL)

);