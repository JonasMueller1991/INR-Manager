CREATE TABLE inr (
    id SERIAL PRIMARY KEY,
    inr_value NUMERIC(2,1),
    date DATE
);

INSERT INTO inr (inr_value, date)
VALUES (2.4, '2023-02-28');
