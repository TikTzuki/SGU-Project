CREATE TABLE publisher 
(
	id int not null auto_increment,
    name varchar(255),
    address varchar(255),
    phone_number varchar(20),
    primary key (id)
);

CREATE TABLE genre
(
	id int not null auto_increment,
    `name` varchar(255),
    primary key (id)
);
create table author
(
	id int not null auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    phone_number varchar(20),
    primary key (id)
);
CREATE TABLE book
(
	id int not null auto_increment,
    author_id int not null,
    publisher_id int not null,
    genre_id int not null,
    title varchar(255) not null,
    isbn varchar(13) not null,
    publication_date date,
    price decimal(12,0) default 0,
    available_quantity int default 0,
    primary key (id),
    index b_author_id_pk (author_id),
    foreign key (author_id) references author(id) on delete cascade,
    index b_publisher_id_pk (publisher_id),
    foreign key (publisher_id) references publisher(id) on delete cascade,
    index b_genre_id_pk (genre_id),
    foreign key (genre_id) references genre(id) on delete cascade
);
create table customer
(
	id int not null auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    phone_number varchar(13),
    address varchar(255),
    primary key (id)
);
create table staff    
(
	id int not null auto_increment,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    `password` varchar(255),
    phone_number varchar(255),
	sex varchar(10),
    primary key (id)
);
create table discount 
(
	id int not null auto_increment,
    discount_name varchar(255),
    discount_type varchar(255),
    start_date date,
    end_date date,
    value decimal,
    minimum_order_value decimal,
    maximum_discount_amount decimal,
    primary key(id)
);
create table `order`
(
	id int not null auto_increment,
    staff_id int not null,
    discount_id int not null,
    customer_id int ,
    order_date date,
    total decimal(12,0),
	primary key (id),
    index od_staff_id_pk (staff_id),
    foreign key (staff_id) references staff(id),
    index od_discount_id_pk (discount_id),
    foreign key (discount_id) references discount(id),
        index od_customer_id_pk (customer_id),
    foreign key (customer_id) references customer(id)
);
create table order_item
(
	order_id int not null,
    book_id int not null,
    quantity int default 0,
    price decimal (12,0),
	primary key (order_id,book_id),
    index oi_order_id_pk (order_id),
    foreign key (order_id) references `order`(id),
    index oi_book_id_pk (book_id),
    foreign key (book_id) references book(id)
);