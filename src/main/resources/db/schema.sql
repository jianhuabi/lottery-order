DROP TABLE IF EXISTS wh_order;

CREATE TABLE wh_order
(
	id int NOT NULL,
    sn VARCHAR(24),
    num int,
    money int,
    PRIMARY KEY (id)
);