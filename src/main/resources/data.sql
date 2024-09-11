create table "order" (order_id bigint not null, asset_id bigint, price bigint, side varchar(25), size integer, status varchar(25), customer_id bigint, create_date date, primary key (order_id));

create table customer (customer_id bigint not null, currency varchar(25), deposit_amount bigint, primary key (customer_id));

create table asset (asset_id bigint not null, customer_id integer, asset_name varchar(50), size integer, usable_size integer,  primary key (asset_id));

create table "user" (user_id bigint not null, username varchar(50), password varchar(150), role varchar(25),  primary key (user_id));

create sequence customer_seq start with 1 increment by 50;

create sequence order_seq start with 1 increment by 50;

create sequence asset_seq start with 1 increment by 50;

create sequence user_seq start with 1 increment by 50;

insert into customer values(1, 'TL', 1_000_000);

insert into customer values(2, 'TL', 1_000_000);

insert into customer values(3, 'TL', 0);

insert into customer values(4, 'TL', 0);

insert into customer values(5, 'TL', 0);

insert into asset values(1, 1, 'ASSET_1', 1_000, 1_000);

insert into asset values(2, 1, 'ASSET_2', 1_000, 1_000);

insert into asset values(3, 2, 'ASSET_3', 1_000, 1_000);

insert into asset values(4, 2, 'ASSET_4', 1_000, 1_000);
