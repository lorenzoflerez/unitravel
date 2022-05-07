insert into region values(1,'Eje cafetero');
insert into region values(2,'Costa atlantica');
insert into region values(3,'Llanos orientales');

insert into ciudad values(1,'Armenia', 1);
insert into ciudad values(2,'San Andres', 2);
insert into ciudad values(3,'Manizales', 1);
insert into ciudad values(4,'Villavicencio', 3);

insert into administrador(id_persona,apellido,email,fecha_registro,nickname,nombre,password) values(1000, 'Lopez', 'camilopez@email.com',utc_date,'caliche','Camilo', 'calo');
insert into administrador(id_persona,apellido,email,fecha_registro,nickname,nombre,password) values(1001, 'Lopez', 'juanlopez@email.com',utc_date , 'juancho','Juan', 'julo');
insert into administrador(id_persona,apellido,email,fecha_registro,nickname,nombre,password) values(1002, 'Lopez', 'andrelopez@email.com',utc_date , 'andrew','Andres', 'anlo');

insert into gerente(id_persona,apellido,email,fecha_registro,nickname,nombre,password) values(3000, 'Jaramillo', 'laujara@email.com',utc_date,'lau','Laura', 'laja');
insert into gerente(id_persona,apellido,email,fecha_registro,nickname,nombre,password) values(3001, 'Echeverry', 'luchoe@email.com',utc_date , 'lucho','Luis', 'luec');
insert into gerente(id_persona,apellido,email,fecha_registro,nickname,nombre,password) values(3002, 'Ramirez', 'gabramirez@email.com',utc_date , 'gabi','Gabriela', 'gara');

insert into guia_turistico(id_persona,apellido,email,fecha_registro,nickname,nombre,password) values(4000, 'Arana', 'pepearana@email.com',utc_date,'pepe','Pedro', 'ppar');
insert into guia_turistico(id_persona,apellido,email,fecha_registro,nickname,nombre,password) values(4001, 'Sanz', 'helenadetroya@email.com',utc_date , 'troya','Helena', 'hesz');
insert into guia_turistico(id_persona,apellido,email,fecha_registro,nickname,nombre,password) values(4002, 'Ortiz', 'sofiortiz@email.com',utc_date , 'sofi','Sofia', 'sort');

insert into cliente(id_persona, apellido, email, fecha_registro, nickname, nombre, password, ciudad_id) values(2000, 'Vargas', 'sergivar@email.com',utc_date,'checho', 'Sergio', 'sevar',1);
insert into cliente(id_persona, apellido, email, fecha_registro, nickname, nombre, password, ciudad_id) values(2001, 'Restrepo', 'hrestrepo@email.com',utc_date,'hrestrepo' ,'Hugo', 'hugres',1);
insert into cliente(id_persona, apellido, email, fecha_registro, nickname, nombre, password, ciudad_id) values(2002, 'Sanchez', 'aurosan@email.com',utc_date,'aurora boreal' ,'Aurora', 'aurosan',2);

insert into telefono values(2001,'323 714 12 11');
insert into telefono values(2001,'323 714 12 12');
insert into telefono values(2002,'312 966 18 43');

insert into hotel values(1, 'Av. Bolivar Calle 8 Norte - Esquina', 4, 'Hotel Armenia estelar', 1, 3000);
insert into hotel values(2, 'Cra. 14 #9 Norte - 00', 4, 'Hotel Mocawa Plaza', 1, 3000);
insert into hotel values(3, 'Cra. 23 ##35A-31', 5, 'Hotel Carretero', 3, 3001);

insert into habitacion values (1, 3, 35000, 1);
insert into habitacion values (2, 2, 75000, 1);
insert into habitacion values (3, 4, 95000, 2);

insert into foto values(1,'imagenes/Habitacion/Mocawa/101a',2,null);
insert into foto values(2,'imagenes/Habitacion/Mocawa/101b',2,null);
insert into foto values(3,'imagenes/Hoteles/ArmeniaEstelara',null,1);
insert into foto values(4,'imagenes/Hoteles/ArmeniaEstelarb',null,1);

insert into cama values (1, 'DOBLE');
insert into cama values (2, 'DOBLE');
insert into cama values (3, 'QUEEN');
insert into cama values (4, 'KING');

insert into habitacion_camas values(1,1);
insert into habitacion_camas values(1,2);
insert into habitacion_camas values(2,1);
insert into habitacion_camas values(3,2);

insert into caracteristica values (1, 'Piscina');
insert into caracteristica values (2, 'Buffet');
insert into caracteristica values (3, 'Aire acondicionado');
insert into caracteristica values (4, 'DirecTV');

insert into caracteristica_hoteles values (1, 1);
insert into caracteristica_hoteles values (1, 2);
insert into caracteristica_hoteles values (2, 1);
insert into caracteristica_hoteles values (2, 3);

insert into caracteristica_habitaciones values (3, 1);
insert into caracteristica_habitaciones values (4, 2);
insert into caracteristica_habitaciones values (3, 1);
insert into caracteristica_habitaciones values (4, 3);

insert into vuelo values (1,'Avianca','Programado','2022-06-01 10:45:00','2022-06-01 11:45:00',2, 1);
insert into vuelo values (2,'Easyfly','Programado','2022-08-01 8:45:00','2022-08-01 10:00:00',2, 4);
insert into vuelo values (3,'Spirit','Programado','2022-06-02 6:45:00','2022-06-02 7:45:00',2, 3);
insert into vuelo values (4,'Avianca','Programado','2022-06-08 10:45:00','2022-06-08 11:45:00',1, 2);

insert into silla values(1,'23F',98000,1);
insert into silla values(2,'2A',130000,1);
insert into silla values(3,'27G',112000,2);
insert into silla values(4,'22F',98000,3);
insert into silla values(5,'21F',98000,4);
insert into silla values(6,'24F',98000,1);

insert into sitio_de_interes values(1,'Parque del Cafe',75000,1);
insert into sitio_de_interes values(2,'Panaca',125000,1);
insert into sitio_de_interes values(3,'Acuario',80000,2);
insert into sitio_de_interes values(4,'EcoParque Los Yarumos',15000,3);

insert into horario values(1,'xjvsd', '18:00:00', '9:00:00');
insert into horario values(2,'mxjvsd', '17:00:00', '8:30:00');
insert into horario values(3,'lmxjvsd', '12:30:00', '8:30:00');

insert into paquete_turistico values(1, 180000, 4000);
insert into paquete_turistico values(2, 25000, 4001);
insert into paquete_turistico values(3, 70000, 4002);

insert into sitio_de_interes_paquetes values(1,1);
insert into sitio_de_interes_paquetes values(2,1);
insert into sitio_de_interes_paquetes values(4,2);
insert into sitio_de_interes_paquetes values(1,3);

insert into horario_paquetes values(1,1);
insert into horario_paquetes values(1,3);
insert into horario_paquetes values(2,1);
insert into horario_paquetes values(3,2);

insert into reserva values(1,'2022-06-08 10:45:00','2022-06-01 10:45:00',utc_date,2,900000,2000);
insert into reserva values(2,'2022-08-08 08:45:00','2022-08-01 08:45:00',utc_date,2,500000,2001);
insert into reserva values(3,'2022-06-08 10:45:00','2022-06-01 10:45:00',utc_date,2,1000000,2002);

insert into reserva_silla values(1,98000,1,1);
insert into reserva_silla values(2,98000,1,6);
insert into reserva_silla values(3,112000,2,1);
insert into reserva_silla values(4,130000,3,2);

insert into reserva_habitacion values(1,450000,2,1);
insert into reserva_habitacion values(2,190000,3,2);
insert into reserva_habitacion values(3,450000,2,3);

insert into reserva_paquete values(1,180000,1,1);
insert into reserva_paquete values(2,180000,1,3);
insert into reserva_paquete values(3,70000,3,2);