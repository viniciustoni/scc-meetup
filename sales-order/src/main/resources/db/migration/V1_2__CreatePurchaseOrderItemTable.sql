create sequence if not exists sales_order.purchase_order_item_seq
    increment 1
    start 1
    minvalue 1
    maxvalue 9223372036854775807
    cache 1;

create table if not exists sales_order.purchase_order_item
(
	id bigint not null,
    purchase_order_id bigint not null,
    product_id bigint not null,
    quantity decimal(10,3) not null,
    price_item decimal(10,3) not null,
    total_price decimal(10,3) not null,
	constraint purchase_order_item_pk PRIMARY KEY (id)
);

alter table sales_order.purchase_order_item ADD CONSTRAINT IF NOT EXISTS FK_ORDER_ITEM_ORDER FOREIGN KEY (purchase_order_id) REFERENCES sales_order.purchase_order (ID) ON DELETE CASCADE;