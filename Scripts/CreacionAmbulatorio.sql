create sequence secIngresos as int start with 1 increment by 1 minvalue 1;

create sequence secAmbulatorios as int start with 1 increment by 1 minvalue 1;

create sequence secHospitales as int start with 1 increment by 1 minvalue 1;

create table ambulatorio (
    codigoAmbulatorio int NOT NULL DEFAULT nextval('secAmbulatorios'),
    nombre varchar(50) NOT NULL,
    direccionPostal varchar(50) NOT NULL,
    anoConstruccion varchar(4) NOT NULL DEFAULT extract(
        year
        from
            CURRENT_DATE
    ),
    provincia varchar(40) NOT NULL,
    telefono char(9) NOT NULL,
    primary key (codigoAmbulatorio),
    unique(nombre, provincia)
);

create table material (
    codigoMaterial int NOT NULL,
    tipo varchar(20) NOT NULL,
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    descripcion varchar(200),
    coste decimal(22, 2) NOT NULL,
    fechaCompra date NOT NULL,
    primary key (codigoMaterial, ambulatorio),
    foreign key (ambulatorio) references ambulatorio(codigoAmbulatorio) on delete cascade on update cascade
);

/* Función para asignar el codigo del material */
create
or replace function asignarCodigoMaterial() returns trigger as $acm$ begin if exists (
    select
        mt1.codigoMaterial
    from
        material as mt1
    where
        mt1.ambulatorio = new.ambulatorio
        and mt1.codigoMaterial >= all (
            select
                codigoMaterial
            from
                material as mt2
            where
                mt2.ambulatorio = mt1.ambulatorio
        )
) then begin new.codigoMaterial := (
    select
        mt1.codigoMaterial + 1
    from
        material as mt1
    where
        mt1.ambulatorio = new.ambulatorio
        and mt1.codigoMaterial >= all (
            select
                codigoMaterial
            from
                material as mt2
            where
                mt2.ambulatorio = mt1.ambulatorio
        )
);

end;

else begin new.codigoMaterial := 1;

end;

end if;

return new;

end;

$acm$ language plpgsql;

/* Trigger para insertar el número del material */
create trigger triggerCodigoMaterial before
insert
    on material for each row execute procedure asignarCodigoMaterial();

create table subvencion (
    codigoIngreso int NOT NULL DEFAULT nextval('secIngresos'),
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    fecha date NOT NULL,
    cantidad decimal(22, 2) NOT NULL DEFAULT 0.01,
    motivo varchar(50) NOT NULL,
    primary key (codigoIngreso, ambulatorio),
    foreign key (ambulatorio) references ambulatorio(codigoAmbulatorio) on delete restrict on update cascade
);

create table donativo (
    codigoIngreso int NOT NULL DEFAULT nextval('secIngresos'),
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    fecha date NOT NULL,
    cantidad decimal(22, 2) NOT NULL DEFAULT 0.01,
    donante varchar(50),
    primary key (codigoIngreso, ambulatorio),
    foreign key (ambulatorio) references ambulatorio(codigoAmbulatorio) on delete restrict on update cascade
);

create table hospital (
    codigoHospital int NOT NULL DEFAULT nextval('secHospitales'),
    nombre varchar(50) NOT NULL,
    direccion varchar(50) NOT NULL,
    telefono char(9) NOT NULL,
    provincia varchar(40) NOT NULL,
    primary key (codigoHospital),
    unique(nombre, provincia)
);

create table asociado (
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    hospital int NOT NULL DEFAULT currval('secHospitales'),
    distancia decimal(7, 2) NOT NULL DEFAULT 0 CHECK(distancia >= 0),
    primary key (ambulatorio, hospital),
    foreign key (ambulatorio) references ambulatorio(codigoAmbulatorio) on delete cascade on update cascade,
    foreign key (hospital) references hospital(codigoHospital) on delete cascade on update cascade
);

create table especialidad (
    nombre varchar(20) NOT NULL,
    descripcion varchar(200),
    primary key(nombre)
);

create table personalNoSanitario (
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    dni char(9) NOT NULL,
    nombre varchar(50) NOT NULL,
    fechaIncorporacion date NOT NULL,
    telefono char(9) NOT NULL,
    sueldo decimal(7, 2) NOT NULL,
    clase varchar(20) NOT NULL,
    primary key(ambulatorio, dni),
    foreign key(ambulatorio) references ambulatorio(codigoAmbulatorio) on delete restrict on update cascade
);

create table personalAdministrador (
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    personal char(9) NOT NULL,
    contrasena varchar(30) NOT NULL,
    primary key(ambulatorio, personal, contrasena),
    foreign key(ambulatorio, personal) references personalNoSanitario(ambulatorio, dni) on delete restrict on update cascade
);

create table personalSanitario (
    dni char(9) NOT NULL,
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    nombre varchar(50) NOT NULL,
    fechaIncorporacion date NOT NULL,
    telefono char(9) NOT NULL,
    sueldo decimal(7, 2) NOT NULL,
    primary key(ambulatorio, dni),
    foreign key(ambulatorio) references ambulatorio(codigoAmbulatorio) on delete restrict on update cascade
);

create table especializacionPersonal (
    especialidad varchar(20) NOT NULL,
    personal char(9) NOT NULL,
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    primary key(especialidad, personal, ambulatorio),
    foreign key(especialidad) references especialidad(nombre) on delete cascade on update cascade,
    foreign key(ambulatorio, personal) references personalSanitario(ambulatorio, dni) on delete cascade on update cascade
);

create table consulta (
    identificador int NOT NULL,
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    especialidad varchar(20) NOT NULL,
    primary key(identificador, ambulatorio),
    foreign key(ambulatorio) references ambulatorio(codigoAmbulatorio) on delete restrict on update cascade,
    foreign key(especialidad) references especialidad(nombre) on delete restrict on update cascade
);

create table pertenecer (
    ambulatorioPersonal int NOT NULL DEFAULT currval('secAmbulatorios'),
    personal char(9) NOT NULL,
    ambulatorioConsulta int NOT NULL DEFAULT currval('secAmbulatorios'),
    consulta int NOT NULL,
    check (ambulatorioPersonal = ambulatorioConsulta),
    primary key(
        ambulatorioPersonal,
        personal,
        ambulatorioConsulta,
        consulta
    ),
    foreign key(ambulatorioPersonal, personal) references personalSanitario(ambulatorio, dni) on delete cascade on update cascade,
    foreign key(ambulatorioConsulta, consulta) references consulta(ambulatorio, identificador) on delete cascade on update cascade
);

create table enfermedad (
    nombre varchar(30) NOT NULL,
    descripcion varchar(200),
    primary key(nombre)
);

create table paciente (
    cip varchar(14) NOT NULL,
    dni char(9) NOT NULL,
    numSeguridadSocial int NOT NULL,
    nombre varchar(60) NOT NULL,
    fechaNacimiento date NOT NULL,
    sexo varchar(12) NOT NULL,
    grupoSanguineo varchar(3) NOT NULL,
    nacionalidad VARCHAR(40) NOT NULL DEFAULT 'Española',
    direccion varchar(50) NOT NULL,
    telefono char(9) NOT NULL,
    unique(dni),
	primary key(cip)
);

create table tenerEnfermedad(
    enfermedad varchar(30) NOT NULL,
    paciente varchar(14) NOT NULL,
    primary key(enfermedad, paciente),
    foreign key(enfermedad) references enfermedad(nombre) on delete cascade on update cascade,
    foreign key(paciente) references paciente(cip) on delete cascade on update cascade
);

create table tipoCita(
    nombre varchar(30) NOT NULL,
    especialidad varchar(20) NOT NULL,
    descripcion varchar(200),
    primary key(nombre, especialidad),
    foreign key(especialidad) references especialidad(nombre) on delete restrict on update cascade
);

create table cita (
    fechaHoraInicio timestamp NOT NULL,
    fechaHoraFin timestamp CHECK (fechaHoraInicio < fechaHoraFin),
    paciente varchar(14) NOT NULL,
    consulta int NOT NULL,
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    tipo varchar(30) NOT NULL,
    especialidad varchar(20) NOT NULL,
    primary key(fechaHoraInicio, paciente, consulta, ambulatorio),
    foreign key (paciente) references paciente(cip) on delete restrict on update cascade,
    foreign key (consulta, ambulatorio) references consulta(identificador, ambulatorio) on delete restrict on update cascade,
    foreign key (tipo, especialidad) references tipoCita(nombre, especialidad) on delete restrict on update cascade
);

create table urgencia (
    cita timestamp NOT NULL,
    paciente varchar(14) NOT NULL,
    consulta int NOT NULL,
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    soborno decimal(6, 2) DEFAULT 0,
    gravedad int NOT NULL DEFAULT 1 CHECK(
        gravedad BETWEEN 1
        AND 10
    ),
    primary key(cita, paciente, consulta, ambulatorio),
    foreign key (cita, paciente, consulta, ambulatorio) references cita(fechaHoraInicio, paciente, consulta, ambulatorio) on delete restrict on update cascade
);

create table medicamento(
    nombre varchar(30) NOT NULL,
    prospecto varchar(500) NOT NULL,
    primary key(nombre)
);

create table receta (
    cita timestamp NOT NULL,
    paciente varchar(17) NOT NULL,
    consulta int NOT NULL,
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    codigoReceta int NOT NULL,
    medicamento varchar(30) NOT NULL,
    cantidad int NOT NULL DEFAULT 1,
    descripcion varchar(200) NOT NULL,
    fechaInicio date NOT NULL,
    fechaFin date CHECK (fechaInicio < fechaFin),
    primary key(codigoReceta, cita, paciente, ambulatorio, consulta),
    foreign key (cita, paciente, consulta, ambulatorio) references cita(fechaHoraInicio, paciente, consulta, ambulatorio) on delete restrict on update cascade,
    foreign key (medicamento) references medicamento(nombre) on delete restrict on update cascade
);

/* Función para asignar el codigo de la receta */
create
or replace function asignarCodigoReceta() returns trigger as $acr$ begin if exists (
    select
        r1.codigoReceta
    from
        receta r1
    where
        r1.cita = new.cita
        and r1.codigoReceta >= all (
            select
                codigoReceta
            from
                receta r2
            where
                r2.cita = new.cita
        )
) then begin new.codigoReceta := (
    select
        r1.codigoReceta + 1
    from
        receta r1
    where
        r1.cita = new.cita
        and r1.codigoReceta >= all (
            select
                codigoReceta
            from
                receta r2
            where
                r2.cita = new.cita
        )
);

end;

else begin new.codigoReceta := 1;

end;

end if;

return new;

end;

$acr$ language plpgsql;

/* Trigger para insertar el número de receta */
create trigger triggerCodigoReceta before
insert
    on receta for each row execute procedure asignarCodigoReceta();

create table derivarHospital (
    cita timestamp NOT NULL,
    paciente varchar(14) NOT NULL,
    consulta int NOT NULL,
    ambulatorio int NOT NULL DEFAULT currval('secAmbulatorios'),
    hospital int NOT NULL DEFAULT currval('secHospitales'),
    primary key(cita, paciente, consulta, ambulatorio, hospital),
    foreign key (cita, paciente, consulta, ambulatorio) references cita(fechaHoraInicio, paciente, consulta, ambulatorio) on delete restrict on update cascade,
    foreign key (hospital) references hospital(codigoHospital) on delete restrict on update cascade
);
