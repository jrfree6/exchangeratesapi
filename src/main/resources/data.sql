drop table if exists currency;

create table currency (
	id int auto_increment primary key, 
	origin_currency varchar(255),
	destination_currency varchar(255),
	origin_amount varchar(255),
	destination_amount varchar(255),
	conversion_rate varchar(255),
	date date, 
	user_id varchar(80)
	primary key (id)
);
	
insert  into currency values(1 , 'BRL','USD', '25', '4.94','1.09', '2022-03-10', 'JohnSnow' );

drop table if exists users;
create table users (id integer not null, email varchar(255) not null, password varchar(255) not null, phone varchar(255) not null, token varchar(255), username varchar(255) not null, primary key (id));
