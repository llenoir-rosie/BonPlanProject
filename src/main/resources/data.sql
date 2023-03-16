DROP TABLE IF EXISTS cities;
 
CREATE TABLE cities (
  name VARCHAR(250) AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250),
  postcode VARCHAR(250),
);
 
INSERT INTO cities (name, description, postcode) VALUES
  ('Lyon', 'description','69000'),
  ('Marseille', 'description','06260'),
  ('Grenobleeuh', 'description','38000');