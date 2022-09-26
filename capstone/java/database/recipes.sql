--don't use this directly... sequence is off.


BEGIN TRANSACTION;

INSERT INTO unit (unit_name)
    VALUES ('whole'), ('cup'), ('pinch');

INSERT INTO ingredient (ingredient_name)
    VALUES ('plantain'), ('vegetable oil'), ('salt');

INSERT INTO recipe (recipe_name)
    VALUES ('Crispy Salted Tostones');

INSERT INTO ingredient_recipe (ingredient_id, recipe_id, quantity, unit_id)
    VALUES (4, 2, 3, 7), (5, 2, 2, 8), (6, 2, 1, 9);

INSERT INTO instructions (recipe_id, sequence, instruction_text)
    VALUES (2, 1, 'Peel the plantains by making a vertical cut through the skin and peeling it back with your hands or the edge of a spoon.'),
    (2, 2, 'Cut the plantains into 1-inch thick pieces. Heat a layer of oil in a heavy bottomed pan.'),
    (2, 3, 'Fry the plantains in batches. When the plantains are starting to turn light golden brown, remove from the oil and transfer to a plate lined with paper towels. Smash each piece with the back of a wooden spoon – this gives you a flatter shape with rougher edges. Return to the frying pan and fry for an additional 4-5 minutes or until golden brown and crispy. Transfer back to a paper towel lined plate to drain excess oil.'),
    (2, 4, 'Sprinkle with sea salt and serve immediately, dipped in some kind of yummy sauce.');

COMMIT TRANSACTION;