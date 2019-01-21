DROP TABLE IF EXISTS sites;

CREATE TABLE sites(

	id SERIAL,
	url varchar(255) not null,
	last_check date,
	status integer,
	PRIMARY KEY(id)	
);

INSERT INTO sites(url) VALUES ('https://www.google.com');
INSERT INTO sites(url, last_check) VALUES ('https://vk.com', '2019-01-15');
INSERT INTO sites(url, last_check, status) VALUES ('https://habr.com', '2019-01-15', 333);
INSERT INTO sites(url, last_check, status) VALUES ('https://www.youtube.com', '2019-01-15', 111);
INSERT INTO sites(url, last_check) VALUES ('https://www.securitylab.ru/das', '2018-01-15');
