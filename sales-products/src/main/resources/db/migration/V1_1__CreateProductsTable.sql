create sequence if not exists product.product_seq
    increment 1
    start 1
    minvalue 1
    maxvalue 9223372036854775807
    cache 1;

create table if not exists product.product
(
	id bigint not null,
	name varchar(255) not null,
    unit_price decimal(10,2) not null,
    unit_of_measure varchar(20) not null,
    quantity_total decimal(10,3) not null,
    quantity_available decimal(10,3) not null,
    quantity_reserved decimal(10,3),
    quantity_sold decimal(10,3),
    created_date timestamp not null,
    updated_date timestamp not null,
	constraint product_pk PRIMARY KEY (id)
);