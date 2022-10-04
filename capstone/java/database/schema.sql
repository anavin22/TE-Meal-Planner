BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, ingredient, recipe, ingredient_recipe, instructions, tag, recipe_tag, saved_recipes, meal, meal_plan CASCADE;

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
    meal_type varchar(15),
    day_of_week varchar(10),
    CONSTRAINT PK_meal PRIMARY KEY (meal_id),
    CONSTRAINT FK_meal_plan FOREIGN KEY (meal_plan_id) REFERENCES meal_plan(meal_plan_id),
	CONSTRAINT FK_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(recipe_id)
);

COMMIT TRANSACTION;

CREATE TABLE user_meal_plan(
    user_meal_plan_id SERIAL,
    created_by int,
    monday_breakfast int,
    monday_lunch int,
    monday_dinner int,
    monday_other int,
    tuesday_breakfast int,
    tuesday_lunch int,
    tuesday_dinner int,
    tuesday_other int,
    wednesday_breakfast int,
    wednesday_lunch int,
    wednesday_dinner int,
    wednesday_other int,
    thursday_breakfast int,
    thursday_lunch int,
    thursday_dinner int,
    thursday_other int,
    friday_breakfast int,
    friday_lunch int,
    friday_dinner int,
    friday_other int,
    saturday_breakfast int,
    saturday_lunch int,
    saturday_dinner int,
    saturday_other int,
    sunday_breakfast int,
    sunday_lunch int,
    sunday_dinner int,
    sunday_other int,
    CONSTRAINT PF_user_meal_plan PRIMARY KEY (user_meal_plan_id)
);
