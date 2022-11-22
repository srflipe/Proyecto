INSERT INTO roles(nombre) VALUES('ROLE_USER');
INSERT INTO roles(nombre) VALUES('ROLE_ADMIN');

INSERT INTO usuarios(cedula, correo, enabled, nombres, password, telefono, username)VALUES ('1001001001','admin@tienda.com',TRUE,'Luis Beltran','$2a$10$NQMGuHQzBdKszpHqK/Zm/OxLTeJnKYR8Gk/LW.Ur2nFeCV6s.kDU.','2334455','administrador');

INSERT INTO usuario_roles(usuario_id, role_id)VALUES (1, 2);

INSERT INTO public.productos(cantidad, descripcion, fecha, marca, serial, valor)VALUES ('100', 'Arroz Blanco (1 KG)', '2022-11-22', 'Diana', 'arz-01-001', '3560');
INSERT INTO public.productos(cantidad, descripcion, fecha, marca, serial, valor)VALUES ('50', 'Aceite de Girasol (1 Litro)', '2022-11-22', 'Gourmet', 'ace-01-001', '5000');
INSERT INTO public.productos(cantidad, descripcion, fecha, marca, serial, valor)VALUES ('1000', 'Condimentos', '2022-11-22', 'El Rey', con-01-001, 1500);
INSERT INTO public.productos(cantidad, descripcion, fecha, marca, serial, valor)VALUES ('30', 'Gaseosa de Manzana (1.5 Lt)', '2022-11-22', 'Postobon', 'gas-01-001', '2300');
INSERT INTO public.productos(cantidad, descripcion, fecha, marca, serial, valor)VALUES ('128', 'Tostadas', '2022-11-22', 'Bimbo', 'tos-01-001', '2600');
INSERT INTO public.productos(cantidad, descripcion, fecha, marca, serial, valor)VALUES ('5',' 'Panela (Caja)', '2022-11-22', 'Panela', 'pan-01-001', '2000');
INSERT INTO public.productos(cantidad, descripcion, fecha, marca, serial, valor)VALUES ('43, 'Huevos AAA (Cubeta)', '2022-11-22', 'Kikes', 'huv-01-001', 2'0000');
INSERT INTO public.productos(cantidad, descripcion, fecha, marca, serial, valor)VALUES ('88', 'Detergente Liquido (1 Lt)', '2022-11-22', 'Axion', 'jab-01-001', '5900');
INSERT INTO public.productos(cantidad, descripcion, fecha, marca, serial, valor)VALUES ('300', 'Jabon en Barra', '2022-11-22', 'Rey', 'jab-01-002', '2200');
INSERT INTO public.productos(cantidad, descripcion, fecha, marca, serial, valor)VALUES ('70', 'Vino de Manzana', '2022-11-22', 'Cariñoso', 'vin-01-001', '10500');