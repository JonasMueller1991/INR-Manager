CREATE TABLE inr (
    id bigint NOT NULL ,
    inr_value NUMERIC(2,1),
    date DATE
);
ALTER TABLE inr
    ADD UNIQUE (id);

INSERT INTO inr (id, inr_value, date)
VALUES (1, 2.4, '2023-02-28');
