
-- create table recipes
-- (
--   recipe_id serial,
--   recipe_name varchar(50),
--   recipe_description text,
--   recipe_ingredients text,
--   recipe_image bytea
-- );

create table users
(
  id serial,
  username varchar(50),
  password text,
  email varchar(50)
);


-- DROP SCHEMA PUBLIC CASCADE;
--
--CREATE TABLE RECIPES (
                       --   recipe_id serial,
                       --  recipe_name VARCHAR(255),
                       --  recipe_description VARCHAR(255),
                       --   recipe_ingredients VARCHAR(255)
-- );

--CREATE TABLE USERS (
                     --  id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
                     --  username VARCHAR(255),
                     --  password VARCHAR(255),
                     --   email VARCHAR(255)
-- );
