DROP TABLE IF EXISTS request;

CREATE TABLE request (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  origin_ip VARCHAR(50) NOT NULL,
  request_method VARCHAR(100) NOT NULL,
  request_date TIMESTAMP NOT NULL
);