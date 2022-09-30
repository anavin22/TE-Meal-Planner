BEGIN TRANSACTION;

INSERT INTO unit (unit_id, unit_name)
    VALUES (4, 'slices'), (5, 'tablespoons'), (6, 'teaspoons'), (7, 'cups'), (8, 'pounds'), (9, 'bunch');

INSERT INTO ingredient (ingredient_id, ingredient_name)
    VALUES (4, 'sandwich bread'), (5, 'unsalted butter'), (6, 'hot sauce'), (7, 'grated sharp cheddar cheese'), (8, 'chopped kimchi'),
    (9, 'baby yukon gold or red skin potatoes'), (10, 'fresh herbs'), (11, 'chicken'), (12, 'extra virgin olive oil'), (13, 'black pepper');

INSERT INTO recipe (recipe_id, created_by, recipe_name, recipe_img)
    VALUES (2, 1, 'Inside-Out Kimchi Grilled Cheese', 'https://assets.bonappetit.com/photos/613235964a6a69e9fc1fc229/1:1/w_960,c_limit/Inside%20Out%20Kimchi%20Grilled%20Cheese.jpg'),
    (3, 1, 'French Market Chicken With Herbed Potatoes', 'https://static2.refinery29.com/bin/entry/70d/x/1088781/cut-3-ingredient-chicken-dinner-1.jpg');

INSERT INTO ingredient_recipe (ingredient_id, recipe_id, quantity, unit_id)
    VALUES (4, 2, 4, 4), (5, 2, 3, 5), (6, 2, 4, 6), (7, 2, 1.5, 7), (8, 2, 0.5, 2),
    (9, 3, 1.5, 8), (10, 3, 1, 9), (11, 3, 1, 1), (12, 3, 2, 5), (13, 3, 0.5, 6), (3, 3, 0.5, 6);

INSERT INTO instructions (recipe_id, sequence, instruction_text)
    VALUES (2, 1, 'Place 2 bread slices on a work surface. Evenly spread ½ Tbsp. butter over each slice. Turn 1 slice over and spread 2 tsp. gochujang over, then top with ½ cup cheese and half the kimchi. Close sandwich with buttered sides facing out. Sprinkle 2 Tbsp. cheese over top of sandwich, gently pressing to adhere cheese to butter.'),
    (2, 2, 'Heat ½ Tbsp. butter in a medium nonstick skillet over medium-low until foaming. Cook sandwich, cheese side down (if some cheese falls out, use a heatproof spatula to nudge it back underneath the sandwich), gently pressing occasionally with a heatproof spatula, until underside is golden brown and crisp, about 3 minutes. Sprinkle another 2 Tbsp. cheese over top of sandwich, pressing with spatula to adhere. Turn sandwich over and cook until golden brown on second side and cheese inside is fully melted, about 3 minutes. Transfer sandwich to a plate. Wipe out skillet and repeat process with remaining ingredients to make 1 more sandwich.'),
    (3, 1, 'Preheat the oven to 450˚. Toss the potatoes, two tablespoons olive oil, one tablespoon chopped herbs (your choice), and ½ teaspoon salt in a large cast-iron skillet or shallow baking dish. Spread in an even layer.'),
    (3, 2, 'Remove the giblets from the chicken, if needed. Rinse and dry the chicken very well (inside and out) with paper towels. Put the chicken, breast-side down, on a cutting board. Starting at the bottom, cut along both sides of the backbone using kitchen shears or very sharp scissors; discard the backbone. Flip the chicken over and open it like a book; press down on the breastbone to flatten.'),
    (3, 3, 'Brush chicken with one tablespoon olive oil and generously season all over with about 1½ teaspoons salt and ½ teaspoon pepper.'),
    (3, 4, 'Put the chicken on top of the potatoes in the skillet (tuck some extra herbs under the chicken, if desired) and roast until golden and a thermometer inserted into the thigh registers 180˚, about 45 minutes. Let cool slightly before serving. Garnish with more herbs, if desired.'),
    (3, 5, 'Note: Want to do a little more? Serve with a green salad and some Dijon mustard for dipping. You could also rub the chicken with softened butter instead of brushing with olive oil. Or maybe stick a lemon, cut into wedges, under the chicken before roasting.');

COMMIT TRANSACTION;