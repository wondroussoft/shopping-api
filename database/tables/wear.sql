CREATE TABLE wear
(
    id                  BIGSERIAL,
    name                VARCHAR(256),
    season_id		BIGINT NOT NULL,
    created_on          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by          BIGINT,
    updated_on          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by          BIGINT,
    x                   BOOLEAN DEFAULT FALSE,

    CONSTRAINT pk_wear PRIMARY KEY (id)
);
