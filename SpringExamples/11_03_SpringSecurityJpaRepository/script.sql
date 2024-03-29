CREATE TABLE sec_users (
	id serial primary key,
	login varchar(50) NOT NULL,
	password varchar(100) NOT NULL	
);

INSERT INTO sec_users (login, password)
VALUES
('admin', 'admin'),
('user', 'user');


CREATE TABLE sec_roles (	
	id serial primary key,
	name text not null	
);

INSERT INTO sec_roles (name)
VALUES
('ROLE_ADMIN'),
('ROLE_USER');

create table sec_users_roles (
	user_id integer not null,
	role_id integer not null,
	foreign key (user_id) references sec_users(id),
	foreign key (role_id) references sec_roles(id),
	unique (user_id, role_id)
);

insert into sec_users_roles
values
(1, 1),
(2, 2)

