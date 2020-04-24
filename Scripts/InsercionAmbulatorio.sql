--ENFERMEDAD
insert into enfermedad (nombre, descripcion)	
	values 
	('Mascaria', 'Malditos mosquitos.'),
	('Gripe Clase A', 'Lo habitual.'),
	('Minero', 'No hay una descripción disponible. Habrá que seguir investigando.'),
	('CoD-02', 'Los videojuegos son el problema de la sociedad.');

--PACIENTE
insert into paciente (cip, dni, numSeguridadSocial, nombre, fechaNacimiento, sexo, grupoSanguineo, nacionalidad, direccion, telefono)
	values 
	('cip123', '56655665S', 5648, 'Martin Suarez', '2000-12-11', 'Masculino', '0+', 'Española', 'Pontevedra, Vigo', '655214698'),
	('cip124', '56562262F', 5649, 'Ainhoa Vivel', '2000-03-07', 'Femenino', '0+', 'Española', 'Ciudad Falsa, Calle Falsa', '986252525'),
	('cip125', '35383321F', 5650, 'Pablo Tarrio', '2000-12-27', 'Masculino', 'AB+', 'Española', 'Lugo, Lugo', '665541416');

--TENER ENFERMEDAD
insert into tenerEnfermedad (enfermedad, paciente)
	values 
	('Minero', 'cip124'),
	('Gripe Clase A', 'cip123'),
	('CoD-02', 'cip125');

--ESPECIALIDAD
insert into especialidad (nombre, descripcion) 
	values
	('General', 'Soy multivaluado!'),
	('Cirujia', 'Dedicado a abrir gente.'), 
	('Oftalmologia', 'Dedicado a la mirar los ojos.'),
	('Odontologia', '¿Tienes caries?');

--TIPO CITA
insert into tipoCita (nombre, especialidad, descripcion)
	values
	('Urgencia', 'General', 'No te mueras aún!'),
	('Consulta', 'Cirujia', 'Cita diaria.'),
	('Consulta', 'Oftalmologia', 'No ve nada.');
	
--MEDICAMENTO
insert into medicamento (nombre, prospecto)
	values
	('Acetaminofeno', 'Esta indicado para el alivio o tratamiento del dolor ocasional leve o moderado, como dolor de cabeza, dental, muscular (contracturas) o de espalda (lumbago) y en estados febriles.'),
	('Antiagregante', 'Este medicamento esta indicado en el alivio sintomatico de los dolores ocasionales leves o moderados, como dolores de cabeza, dentales, menstruales, musculares (contracturas) o de espalda (lumbalgia) y en estados febriles.');

--HOSPITALES
insert into hospital (nombre, direccion, telefono, provincia)
	values
	('Hospital Universitario de Lucus Augusti', 'Rua Dr. Ulises Romero, 1, 27003 Lugo', '982296000', 'Lugo'),
	('Polusa', 'Rua Iglesias Otero, s/n, 27004 Lugo', '982222854', 'Lugo'),
	('Juan Carlos I', 'Valle de los Caidos', '193200000', 'Comunidad de Madrid');
	
--AMBULATORIO 1 e INSERCIONES ASOCIADAS
insert into ambulatorio (nombre, direccionPostal, anoConstruccion, provincia, telefono)
	values ('Fingoi', 'Rua Armorica, s/n, 27002 Lugo', '1950', 'Lugo', '989796951');
	
insert into subvencion (fecha, cantidad, motivo)
	values
	('2019-12-23', 2000.05, 'Porque se lo merecen.'),
	('2019-05-31', 5015.55, 'Porque no se lo merecen.');
	
insert into donativo (fecha, cantidad, donante)
	values ('2020-02-03', 100000, 'Rafael Nadal');
	
insert into material (tipo, descripcion, coste, fechaCompra)
	values
	('bisturi', 'Elemento quirurgico.', 12.05, '2020-03-12'),
	('ordenador', 'Ordenador empleado por el usuario administrador.', 1299.99, '2012-09-25');

insert into asociado (hospital, distancia)
	values
	((select codigoHospital from hospital where nombre like 'Polusa' and provincia like 'Lugo'), 3.6),
	((select codigoHospital from hospital where nombre like 'Hospital Universitario de Lucus Augusti' and provincia like 'Lugo'), 15.3); 

insert into personalNoSanitario (dni, nombre, fechaIncorporacion, telefono, sueldo, clase)
	values ('52134865S', 'Clara Suarez', '2020-01-15', '687452133', 1674.23, 'Secretario');
insert into personalAdministrador (personal, contrasena)
	values ('52134865S', 'sualci');
	
insert into personalNoSanitario (dni, nombre, fechaIncorporacion, telefono, sueldo, clase)
	values ('00000000A', 'a', '2000-01-01', '999999999', 0.01, 'Administrador');
insert into personalAdministrador (personal, contrasena)
	values ('00000000A', 'a');

insert into personalSanitario (dni, nombre, fechaIncorporacion, telefono, sueldo)
	values ('84125961A', 'Adrian Vispalia', '2005-11-03', '981250503', 2000.01);
insert into especializacionPersonal (especialidad, personal)
	values
	('Cirujia', '84125961A'),
	('Oftalmologia', '84125961A');
	
insert into personalSanitario (dni, nombre, fechaIncorporacion, telefono, sueldo)
	values ('52145961A', 'Miguel Torres', '2010-11-03', '985202020', 600.01);
insert into especializacionPersonal (especialidad, personal)
	values ('General', '52145961A');

insert into consulta (identificador, especialidad)
	values
	(101, 'Cirujia'),
	(203, 'Oftalmologia'),
	(005, 'General');

insert into pertenecer (personal, consulta) 
	values
	('84125961A', 101),
	('84125961A', 203),
	('52145961A', 005);
	
insert into cita (fechaHoraInicio, fechaHoraFin, paciente, consulta, tipo, especialidad)
	values ('2019-10-12 12:22:23', '2019-10-12 13:05:00', 'cip124', 005, 'Urgencia', 'General');
insert into cita (fechaHoraInicio, paciente, consulta, tipo, especialidad)
	values ('2019-01-22 16:52:32', 'cip124', 005, 'Urgencia', 'General');
insert into urgencia (cita, paciente, consulta, soborno, gravedad)
	values ('2019-01-22 16:52:32', 'cip124', 005, 0.01, 2);
insert into cita (fechaHoraInicio, paciente, consulta, tipo, especialidad)
	values ('2019-04-07 09:42:21', 'cip123', 005, 'Urgencia', 'General');
insert into urgencia (cita, paciente, consulta, soborno, gravedad)
	values ('2019-04-07 09:42:21', 'cip123', 005, 150.00, 3);

insert into receta (cita, paciente, consulta, medicamento, cantidad, descripcion, fechaInicio, fechaFin)
	values ('2019-10-12 12:22:23', 'cip124', 005, 'Acetaminofeno', 3, 'Drogarse cada 6 horas.', '2003-06-24', '2009-01-02');
insert into derivarHospital (cita, paciente, consulta)
	values ('2019-10-12 12:22:23', 'cip124', 005);


--AMBULATORIO 2 e INSERCIONES ASOCIADAS
insert into ambulatorio (nombre, direccionPostal, anoConstruccion, provincia, telefono)
	values('Galeras', 'Rua de Entrerrios, 3, 15705 Santiago de Compostela', '1920', 'A Coruña', '987654311');

insert into subvencion (fecha, cantidad, motivo)
	values ('2010-06-28', 3000, 'Porque se lo merecen');
	
insert into donativo (fecha, cantidad, donante)
	values
	('2019-05-31', 100000, 'Amancio Ortega'),
	(CURRENT_DATE, 100000, 'Pau Gasol');

insert into material (tipo, descripcion, coste, fechaCompra)
	values
	('bisturi', 'Elemento quirurgico.', 12.3, '2019-10-01'),
	('ordenador', 'Ordenador empleado por el usuario administrador.',900.99 ,'2012-09-25'),
	('camilla', 'Elemento de las consultas.', 400.0 ,'2018-03-09');

insert into asociado (hospital, distancia)
	values ((select codigoHospital from hospital where nombre like 'Polusa' and provincia like 'Lugo'), 5.2);

insert into personalNoSanitario (dni, nombre, fechaIncorporacion, telefono, sueldo, clase)
	values ('76589765T', 'Pablo Augusto', '2019-05-30', '678543226', 1674.23, 'Secretario');

insert into personalAdministrador (personal,contrasena)
	values ('76589765T','char');

insert into personalNoSanitario (dni, nombre, fechaIncorporacion, telefono, sueldo, clase)
	values ('10000000A', 'p', '2000-01-01', '999999999', 0.01, 'Administrador');
insert into personalAdministrador (personal, contrasena)
	values ('10000000A', 'p');

insert into personalSanitario (dni, nombre, fechaIncorporacion, telefono, sueldo)
	values ('83325741B', 'Marcos Henandez', '2001-12-23', '611280593', 20100.31);
	
insert into especializacionPersonal (especialidad, personal)
	values
	('Cirujia', '83325741B'),
	('Oftalmologia', '83325741B');
	
insert into personalSanitario (dni, nombre, fechaIncorporacion, telefono, sueldo)
	values ('83325331B', 'Humberto Gutierrez', '2012-10-12', '789649382', 430.00);
insert into especializacionPersonal (especialidad, personal)
	values ('General', '83325331B');

insert into consulta (identificador, especialidad)
	values
	(203, 'Cirujia'),
	(102, 'Oftalmologia'),
	(305, 'General');

insert into pertenecer (personal, consulta) 
	values
	('83325331B', 102),
	('83325331B', 305);

insert into cita (fechaHoraInicio, fechaHoraFin, paciente, consulta, tipo, especialidad)
	values ('2019-10-12 12:21:23', '2019-10-12 13:05:00', 'cip123', 305, 'Urgencia', 'General');
insert into urgencia (cita, paciente, consulta, soborno, gravedad)
	values ('2019-10-12 12:21:23', 'cip123', 305, 0.01, 1);
insert into receta (cita, paciente, consulta, medicamento, cantidad, descripcion, fechaInicio, fechaFin)
	values ('2019-10-12 12:21:23', 'cip123', 305, 'Acetaminofeno', 3, 'Drogarse cada 6 horas.', '2003-06-24', '2009-01-02');
insert into derivarHospital (cita, paciente, consulta)
	values ('2019-10-12 12:21:23', 'cip123', 305);
