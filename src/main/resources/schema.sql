DROP SCHEMA PUBLIC CASCADE;

CREATE SEQUENCE recipe_sequence AS INTEGER START WITH 1;

CREATE TABLE recipes (
  id BIGINT NOT NULL,
  recipe_name VARCHAR(255),
  recipe_description VARCHAR(255)
);

/*
CREATE TABLE ingredients (
  ingredient_name VARCHAR(255),
  recipe_id BIGINT,
  FOREIGN KEY (recipe_id)
    REFERENCES recipes ON DELETE CASCADE
);
*/
