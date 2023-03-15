DROP TABLE IF EXISTS cities;
 
CREATE TABLE cities (
  name VARCHAR(250) AUTO_INCREMENT  PRIMARY KEY,
  postcode VARCHAR(250),
);
 
INSERT INTO cities (name, postcode) VALUES
  ('Lyon', '69000'),
  ('Marseille', '06260'),
  ('Grenobleeuh', '38000');