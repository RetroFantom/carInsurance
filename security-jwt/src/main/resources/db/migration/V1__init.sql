create table users
(
  id BIGINT auto_increment primary key,
  username varchar(30) not null unique,
  password varchar(80) not null
);

create table roles
(
  id bigint auto_increment primary key ,
  name varchar(50) not null
);

CREATE TABLE users_roles
(
  user_id bigint not null,
  role_id bigint not null,
  primary key (user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password)
values
('user@gmail.com', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i'),
('admin@gmail.com', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i');

insert into users_roles (user_id, role_id)
values
(1, 1),
(2, 2);

create table insurances
(
    id BIGINT auto_increment primary key,

    user_id BIGiNT not null,
    VIN varchar(50),
    car_Plate varchar(50),
    FIO varchar(50),
    driver_licence BIGINT not null,
    STS varchar(50)
);


insert into insurances (user_id, VIN, car_Plate, FIO, driver_licence, STS)
values
    ('1', 'XТА21124070445066', 'Е577НУ', 'Калачев Сергей Дмитриевич', '424124', 'f2332f'), ( '2', 'XТА211245432545066', 'C486УК', 'Жук Валентин Петрович', '6435434', 'fwef342');
