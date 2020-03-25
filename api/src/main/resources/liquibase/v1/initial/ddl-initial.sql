CREATE TABLE `user` (
    id                  BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    email               VARCHAR(100) NOT NULL,
    name                VARCHAR(200) NOT NULL,
    password            VARCHAR(512) NOT NULL,
    phone               VARCHAR(30) NOT NULL,
    updated_at          DATE NOT NULL,
    created_at          DATE NOT NULL,
    PRIMARY KEY ( id ),
    UNIQUE ( email )
);

CREATE TABLE farm (
    id                  BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id             BIGINT UNSIGNED NOT NULL,
    name                VARCHAR(200) NOT NULL,
    address             VARCHAR(500) NOT NULL,
    updated_at          DATE NOT NULL,
    created_at          DATE NOT NULL,
    PRIMARY KEY ( id ),
    CONSTRAINT fk_farm_user FOREIGN KEY ( user_id ) REFERENCES `user` ( id ) ON DELETE CASCADE
);

CREATE TABLE cow (
    id                  BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    farm_id             BIGINT UNSIGNED NOT NULL,
    name                VARCHAR(100),
    code                VARCHAR(100) NOT NULL,
    species             VARCHAR(200) NOT NULL,
    description         VARCHAR(500),
    updated_at          DATE NOT NULL,
    created_at          DATE NOT NULL,
    PRIMARY KEY ( id ),
    CONSTRAINT fk_cow_farm FOREIGN KEY ( farm_id ) REFERENCES farm ( id ) ON DELETE CASCADE
);

CREATE TABLE milk (
    id                  BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    cow_id              BIGINT UNSIGNED NOT NULL,
    liters              DOUBLE NOT NULL,
    description         VARCHAR(200),
    updated_at          DATETIME NOT NULL,
    created_at          DATETIME NOT NULL,
    PRIMARY KEY ( id ),
    CONSTRAINT fk_milk_cow FOREIGN KEY ( cow_id ) REFERENCES cow ( id ) ON DELETE CASCADE
);