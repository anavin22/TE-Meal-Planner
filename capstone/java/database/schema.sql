BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, ingredient, recipe, unit, ingredient_recipe, instructions, tag, recipe_tag CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE ingredient (
  ingredient_id SERIAL,
  ingredient_name varchar(40) NOT NULL,
  ingredient_type varchar(40),
  CONSTRAINT PK_ingredient PRIMARY KEY (ingredient_id)
);

CREATE TABLE recipe (
    recipe_id SERIAL,
    recipe_name varchar(100) NOT NULL,
    CONSTRAINT PK_recipe PRIMARY KEY (recipe_id)
);

CREATE TABLE unit (
    unit_id SERIAL,
    unit_name varchar(50) NOT NULL,
    CONSTRAINT PK_unit PRIMARY KEY (unit_id)
);

CREATE TABLE ingredient_recipe (
    ingredient_id integer,
    recipe_id integer,
    quantity numeric NOT NULL,
    unit_id integer,
    CONSTRAINT PK_ingredient_recipe PRIMARY KEY (ingredient_id, recipe_id),
    CONSTRAINT FK_unit_id FOREIGN KEY (unit_id) REFERENCES unit(unit_id)
);

CREATE TABLE instructions (
    instruction_id SERIAL,
    recipe_id integer,
    sequence integer NOT NULL,
    instruction_text varchar NOT NULL,
    CONSTRAINT PK_instructions PRIMARY KEY (instruction_id)
);

CREATE TABLE tag (
    tag_id SERIAL,
    tag_text varchar(100),
    CONSTRAINT PK_tag PRIMARY KEY (tag_id)
);

CREATE TABLE recipe_tag (
    recipe_id integer,
    tag_id integer,
    CONSTRAINT PK_recipe_tag PRIMARY KEY (recipe_id, tag_id)
);

COMMIT TRANSACTION;
