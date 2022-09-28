

BEGIN TRANSACTION;

INSERT INTO unit (unit_id, unit_name)
    VALUES (1, 'whole'), (2, 'cup'), (3, 'pinch');

INSERT INTO ingredient (ingredient_id, ingredient_name)
    VALUES (1, 'plantain'), (2, 'vegetable oil'), (3, 'salt');

INSERT INTO recipe (recipe_id, created_by, recipe_name, recipe_img)
    VALUES (1, 1, 'Crispy Salted Tostones', 'https://pinchofyum.com/cdn-cgi/image/width=680,height=99999,fit=scale-down/wp-content/uploads/Crispy-Tostones.jpg');

INSERT INTO ingredient_recipe (ingredient_id, recipe_id, quantity, unit_id)
    VALUES (1, 1, 1, 1), (2, 1, 2, 2), (3, 1, 1, 3);

INSERT INTO instructions (recipe_id, sequence, instruction_text)
    VALUES (1, 1, 'Peel the plantains by making a vertical cut through the skin and peeling it back with your hands or the edge of a spoon.'),
    (1, 2, 'Cut the plantains into 1-inch thick pieces. Heat a layer of oil in a heavy bottomed pan.'),
    (1, 3, 'Fry the plantains in batches. When the plantains are starting to turn light golden brown, remove from the oil and transfer to a plate lined with paper towels. Smash each piece with the back of a wooden spoon – this gives you a flatter shape with rougher edges. Return to the frying pan and fry for an additional 4-5 minutes or until golden brown and crispy. Transfer back to a paper towel lined plate to drain excess oil.'),
    (1, 4, 'Sprinkle with sea salt and serve immediately, dipped in some kind of yummy sauce.');

COMMIT TRANSACTION;