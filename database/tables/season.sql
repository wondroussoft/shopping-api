CREATE TABLE season
(
    id                  BIGSERIAL,
    name                VARCHAR(256),
    created_on          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by          BIGINT,
    updated_on          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by          BIGINT,
    x                   BOOLEAN DEFAULT FALSE,

    CONSTRAINT pk_season PRIMARY KEY (id)
);
