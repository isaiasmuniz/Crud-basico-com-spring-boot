CREATE TABLE IF NOT EXISTS basiccrud (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	first_name  varchar(80),
	last_name  varchar(80),
	gender  varchar(80),
	age int(100)
);