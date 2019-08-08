CREATE TABLE app_user (
	user_id SERIAL PRIMARY KEY,
	username TEXT UNIQUE NOT NULL,
	pass TEXT NOT NULL,
	first_name TEXT NOT NULL,
	last_name TEXT NOT NULL,
	phone TEXT,
	email TEXT UNIQUE NOT NULL,
	role TEXT NOT NULL
);

CREATE TABLE flavor (
	flavor_id SERIAL PRIMARY KEY,
	name TEXT UNIQUE NOT NULL
);

CREATE TABLE topping (
	topping_id SERIAL PRIMARY KEY,
	name TEXT UNIQUE NOT NULL
);


CREATE TABLE brand (
	brand_id SERIAL PRIMARY KEY,
	name TEXT UNIQUE NOT NULL
);

CREATE TABLE ice_cream (
	ice_cream_id SERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	brand_id INTEGER REFERENCES brand(brand_id)
);

CREATE TABLE ice_cream_flavor (
    ice_cream_id INT NOT NULL REFERENCES ice_cream(ice_cream_id),
    flavor_id INT NOT NULL REFERENCES flavor(flavor_id),
    CONSTRAINT pk_ice_cream_flavor PRIMARY KEY  (ice_cream_id, flavor_id)
);

CREATE TABLE ice_cream_topping (
    ice_cream_id INT NOT NULL REFERENCES ice_cream(ice_cream_id),
    topping_id INT NOT NULL REFERENCES topping(topping_id),
    CONSTRAINT pk_ice_cream_topping PRIMARY KEY  (ice_cream_id, topping_id)
);