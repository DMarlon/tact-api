CREATE TABLE IF NOT EXISTS contacts
(
    con_id serial NOT NULL,
    con_name character varying (150) NOT NULL,
    con_image_path character varying (255),
    PRIMARY KEY (con_id)
);

CREATE INDEX IF NOT EXISTS idx_con_name ON contacts(con_name);