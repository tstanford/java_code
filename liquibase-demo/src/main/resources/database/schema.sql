CREATE TABLE person (
   id bigserial NOT NULL,
   firstname varchar(255) NULL,
   surname varchar(255) NULL,
   CONSTRAINT person_pkey PRIMARY KEY (id)
);