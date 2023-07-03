CREATE TABLE IF NOT EXISTS public.product (
	id 					SERIAL ,
	name 				VARCHAR(100) NOT NULL,
	description 		VARCHAR(500) NOT NULL,
	bar_code 			VARCHAR(100) NOT NULL,
	product_type		VARCHAR(100) NOT NULL,
	unit_measurement 	VARCHAR(100) NOT NULL,
	status 				VARCHAR(100) NOT NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id),
	CONSTRAINT bar_code_unique UNIQUE (bar_code)
);

CREATE SEQUENCE IF NOT EXISTS public.sequence_id_product START 1;