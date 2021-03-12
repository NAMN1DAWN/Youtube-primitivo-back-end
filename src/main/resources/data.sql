drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1000 increment by 1;


insert into categoria (id, nombre) values (1, 'Jazz');
insert into categoria (id, nombre) values (2, 'Swing');
insert into categoria (id, nombre) values (3, 'Rock');

insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (1, 'Juice - Orange, Concentrate', 'Son todo papayas', 2, 3, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (2, 'Beef - Ground, Extra Lean, Fresh', 'Son todo papayas', 1, 2, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (3, 'Cheese - Parmesan Grated', 'Son todo papayas', 3, 3, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (4, 'Cups 10oz Trans', 'Son todo papayas', 1, 3, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (5, 'Wine - Beringer Founders Estate', 'Son todo papayas', 2, 2, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (6, 'Bread - Wheat Baguette', 'Son todo papayas', 2, 3,'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (7, 'Quail - Eggs, Fresh', 'Son todo papayas', 2, 3, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (8, 'Cheese - Mascarpone', 'Son todo papayas', 2, 3, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (9, 'Mace', 'Son todo papayas', 2, 3, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (10, 'Oil - Shortening - All - Purpose', 'Son todo papayas', 2, 3, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (11, 'Marjoram - Fresh', 'Son todo papayas', 2, 3, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (12, 'Turnip - White', 'Son todo papayas', 2, 3, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (13, 'Pork Salted Bellies', 'Son todo papayas', 2, 4, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (14, 'Longos - Greek Salad', 'Son todo papayas', 2, 2, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (15, 'Amaretto', 'Son todo papayas', 2, 3, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (16, 'Godiva White Chocolate', 'Son todo papayas', 2, 2, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (17, 'Tomatoes - Roma', 'Son todo papayas', 2, 3, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (18, 'Oven Mitt - 13 Inch', 'Son todo papayas', 3, 3, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (19, 'Vermouth - White, Cinzano', 'Son todo papayas', 2, 2, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (20, 'Club Soda - Schweppes, 355 Ml', 'Son todo papayas', 2, 3, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (21, 'Fenngreek Seed', 'Son todo papayas', 1, 1, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (22, 'Dill Weed - Dry', 'Son todo papayas', 1, 3, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (23, 'Pepper - Green', 'Son todo papayas', 1, 3, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (24, 'Bacardi Breezer - Tropical', 'Son todo papayas', 3, 1, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (25, 'Wine - Merlot Vina Carmen', 'Son todo papayas', 2, 3, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (26, 'Sauce - Black Current, Dry Mix', 'Son todo papayas', 1, 4, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (27, 'Crab - Soft Shell', 'Son todo papayas', 1, 3, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (28, 'Jameson Irish Whiskey', 'Son todo papayas', 2, 3, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (29, 'Muffin Chocolate Individual Wrap', 'Son todo papayas', 1, 1, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into videos (id, Titulo, Descripcion, categoria_id, usuario_id, Imagen) values (30, 'Mussels - Frozen', 'Son todo papayas', 1, 3, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');

-- Contraseña: Admin1
insert into user_entity (id, username, correo, password, avatar, fullName, created_at, last_password_change_at) 
values (1, 'admin', 'admin@openwebinars.net','$2a$10$vPaqZvZkz6jhb7U7k/V/v.5vprfNdOnh4sxi/qpPRkYTzPmFlI9p2','https://api.adorable.io/avatars/285/admin@openwebinars.net.png', 'Admin admin',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_entity_roles (user_entity_id, roles) values (1,'USER');
insert into user_entity_roles (user_entity_id, roles) values (1,'ADMIN');


-- Contraseña: Marialopez1
insert into user_entity (id, username, correo, password, avatar, fullName, created_at, last_password_change_at) 
values (2, 'marialopez', 'maria.lopez@openwebinars.net','$2a$10$3i95KIxdl8igcpDby.URMOgwdDR2q9UaSfor2kJJrhAPfNOC/HMSi','https://api.adorable.io/avatars/285/maria.lopez@openwebinars.net.png', 'María López', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_entity_roles (user_entity_id, roles) values (2,'USER');

-- Contraseña: Angelmartinez1
insert into user_entity (id, username, correo, password, avatar, fullName, created_at, last_password_change_at) 
values (3, 'angelmartinez', 'angel.martinez@openwebinars.net', '$2a$10$37IEM6zzuwXqFrotYDtySOKITKfeNWR3NBRqcM7JYWnBDIaq9ByZm','https://api.adorable.io/avatars/285/angel.martinez@openwebinars.net.png', 'Ángel Martínez',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_entity_roles (user_entity_id, roles) values (3,'USER');

-- Contraseña: Anajimenez1
insert into user_entity (id, username, correo, password, avatar, fullName, created_at, last_password_change_at) 
values (4, 'anajimenez', 'ana.jimenez@openwebinars.net','$2a$10$k0om5gtNBheWX54VzD1E0etCnqC0xChHjfW3lOXaeCpN5ST1vVGYm','https://api.adorable.io/avatars/285/ana.jimenez@openwebinars.net.png', 'Ana Jiménez', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_entity_roles (user_entity_id, roles) values (4,'USER');