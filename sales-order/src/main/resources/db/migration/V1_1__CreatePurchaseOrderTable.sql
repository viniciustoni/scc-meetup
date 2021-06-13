create sequence if not exists sales_order.purchase_order_seq
    increment 1
    start 1
    minvalue 1
    maxvalue 9223372036854775807
    cache 1;

create table if not exists sales_order.purchase_order
(
	id bigint not null,
	client_id bigint not null,
    total_amount decimal(10,3) not null,
    discount decimal(10,3),
	constraint purchase_order_pk PRIMARY KEY (id)
);