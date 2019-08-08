INSERT INTO app_user (username, pass, first_name, last_name, phone, email, role)
	VALUES 	('btkruppa', 'pass', 'blake', 'kruppa', '09803924', 'blake.kruppa@revature.com', 'admin'),
			('edward', 'pass', 'edward', 'mcintire', '09803924', 'edward.mcintire@revature.com', 'employee'),
			('abdulla', 'pass', 'abdulla', 'aqrabawi', '09803924', 'abdula.aqrabawi@revature.com', 'admin'),
			('shay', 'pass', 'shay', 'gilchrist', '09803924', 'shay.gilchrist@revature.com', 'manager'),
			('stefan', 'pass', 'stefan', 'todorov', '09803924', 'stefan.todorov@revature.com', 'employee'),
			('larry', 'pass', 'larry', 'the cable man', '09803924', 'larry.the cable man@revature.com', 'manager');
			
INSERT INTO brand (name)
    VALUES ('PET'), (E'Ben & Jerry\'s'), ('Cold Stone'), ('Haagen Dazs');

INSERT INTO flavor (name)
    VALUES ('Vanilla'), ('Chocolate'), ('Mint'), ('Cookies And Cream'), ('Strawberry');

INSERT INTO ice_cream (name, brand_id)
    VALUES ('1906', (SELECT brand_id FROM brand WHERE brand.name = 'PET')),
           ('Strawberry Gas', (SELECT brand_id FROM brand WHERE brand.name = E'Ben & Jerry\'s')),
           ('Larry Special', (SELECT brand_id FROM brand WHERE brand.name = 'Cold Stone')),
           ('Flavor Not Found', (SELECT brand_id FROM brand WHERE brand.name = 'Haagen Dazs')),
           ('Island', (SELECT brand_id FROM brand WHERE brand.name = 'Cold Stone'));

INSERT INTO ice_cream_flavor (ice_cream_id, flavor_id)
    VALUES  ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = '1906'), 
                (SELECT flavor_id FROM flavor f WHERE f.name = 'Vanilla')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = '1906'), 
                (SELECT flavor_id FROM flavor f WHERE f.name = 'Cookies And Cream')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Strawberry Gas'), 
                (SELECT flavor_id FROM flavor f WHERE f.name = 'Mint')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Strawberry Gas'), 
                (SELECT flavor_id FROM flavor f WHERE f.name = 'Strawberry')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Larry Special'), 
                (SELECT flavor_id FROM flavor f WHERE f.name = 'Chocolate')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Flavor Not Found'), 
                (SELECT flavor_id FROM flavor f WHERE f.name = 'Strawberry')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Flavor Not Found'), 
                (SELECT flavor_id FROM flavor f WHERE f.name = 'Vanilla')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Island'), 
                (SELECT flavor_id FROM flavor f WHERE f.name = 'Vanilla')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Island'), 
                (SELECT flavor_id FROM flavor f WHERE f.name = 'Mint'));

INSERT INTO topping (name)
    VALUES ('Chocolate Chips'), ('Peanuts'), ('Chocolate Syrup'), ('Sprinkles'), ('Gummy Worms'),
        ('Gummy Bears'), ('Caramel'), ('Bananas');

INSERT INTO ice_cream_topping (ice_cream_id, topping_id)
    VALUES ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = '1906'), 
                (SELECT topping_id FROM topping t WHERE t.name = 'Peanuts')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = '1906'), 
                (SELECT topping_id FROM topping t WHERE t.name = 'Chocolate Chips')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = '1906'), 
                (SELECT topping_id FROM topping t WHERE t.name = 'Sprinkles')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Strawberry Gas'), 
                (SELECT topping_id FROM topping t WHERE t.name = 'Gummy Bears')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Larry Special'), 
                (SELECT topping_id FROM topping t WHERE t.name = 'Chocolate Syrup')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Flavor Not Found'), 
                (SELECT topping_id FROM topping t WHERE t.name = 'Bananas')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Flavor Not Found'), 
                (SELECT topping_id FROM topping t WHERE t.name = 'Gummy Worms')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Island'), 
                (SELECT topping_id FROM topping t WHERE t.name = 'Sprinkles')),
            ((SELECT ice_cream_id FROM ice_cream ic WHERE ic.name = 'Island'), 
                (SELECT topping_id FROM topping t WHERE t.name = 'Caramel'));