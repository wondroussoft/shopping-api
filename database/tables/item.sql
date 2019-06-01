CREATE TABLE item
(
    id                  BIGSERIAL,
    name                VARCHAR(256),
    price		INTEGER NOT NULL,
    size		VARCHAR(6),
    color		VARCHAR(20),
    category_id		BIGINT NOT NULL,
    created_on          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by          BIGINT,
    updated_on          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by          BIGINT,
    x                   BOOLEAN DEFAULT FALSE,

    CONSTRAINT pk_item PRIMARY KEY (id)
);
