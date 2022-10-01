BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, ingredient, recipe, ingredient_recipe, instructions, tag, recipe_tag, saved_recipes CASCADE;

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
    created_by integer,
    recipe_name varchar(100) NOT NULL,
    recipe_img text NOT NULL,
    CONSTRAINT PK_recipe PRIMARY KEY (recipe_id),
    CONSTRAINT FK_created_by FOREIGN KEY (created_by) REFERENCES users(user_id)
);

CREATE TABLE ingredient_recipe (
    ingredient_id integer,
    recipe_id integer,
    quantity numeric NOT NULL,
    unit varchar(100),
    CONSTRAINT PK_ingredient_recipe PRIMARY KEY (ingredient_id, recipe_id)
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

CREATE TABLE saved_recipes (
    recipe_id integer,
    user_id integer,
    CONSTRAINT PK_saved PRIMARY KEY (recipe_id, user_id)
);
CREATE TABLE meal_plan(
    meal_plan_id SERIAL,
    created_by integer NOT NULL,
    title varchar(100) NOT NULL,
    CONSTRAINT PK_meal_plan PRIMARY KEY (meal_plan_id)
);
CREATE TABLE meal(
    meal_id SERIAL,
    meal_plan_id integer,
    recipe_id integer NOT NULL,
    meal_type varchar (15),
    day_of_week varchar (10)
    CONSTRAINT PK_meal PRIMARY KEY (meal_id),
    CONSTRAINT FK_meal_plan FOREIGN KEY (meal_plan_id) REFERENCES (meal_plan)
);

COMMIT TRANSACTION;
