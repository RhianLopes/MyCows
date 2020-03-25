CREATE TABLE `user` (
    id                  BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    email               VARCHAR(100) NOT NULL,
    name                VARCHAR(200) NOT NULL,
    password            VARCHAR(100) NOT NULL,
    phone               VARCHAR(30) NOT NULL,
    updated_at          DATE NOT NULL,
    PRIMARY KEY ( id ),
    UNIQUE ( email )
);

CREATE TABLE farm (
    id                  BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id             BIGINT UNSIGNED NOT NULL,
    name                VARCHAR(200) NOT NULL,
    address             VARCHAR(500) NOT NULL,
    PRIMARY KEY ( id ),
    CONSTRAINT fk_farm_user FOREIGN KEY ( user_id ) REFERENCES `user` ( id ) ON DELETE CASCADE
);

