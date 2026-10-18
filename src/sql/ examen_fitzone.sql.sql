--PARTE 1: creación de tabla
create table socios (
    id_socio int primary key,
    nombres varchar(50) not null,
    apellidos varchar(50) not null,
    edad int not null,
    fecha_registro varchar(10) not null,
    activo boolean not null
);

-- PARTE 2: inserción de datos
-- insertar 5 registros variados
insert into socios (id_socio, nombres, apellidos, edad, fecha_registro, activo) values 
(1, 'Carlos', 'Pérez', 16, '2026-01-15', true),
(2, 'Ana', 'Gómez', 25, '2026-02-10', true),
(3, 'Luis', 'Martínez', 12, '2026-03-05', false),
(4, 'María', 'Rodríguez', 30, '2026-02-20', true),
(5, 'Pedro', 'Sánchez', 17, '2026-04-01', false);

-- PARTE 3: consultas sql
-- consulta 1: nombres, apellidos y edad de socios activos y mayores a 18 años
select nombres, apellidos, edad 
from socios 
where activo = true and edad > 18;

-- consulta 2: socios registrados después de '2026-02-01'
select * 
from socios 
where fecha_registro > '2026-02-01';

-- consulta 3: todos los socios ordenados por edad de mayor a menor
select * 
from socios 
order by edad desc;


-- PARTE 4: modificación de tabla y actualización
-- agregar nueva columna 'email' tipo varchar(100)
alter table socios add column email varchar(100);

-- realizar un update asignando correo a un socio mediante su id_socio
update socios set email = 'carlos_perez@gmail.com' where id_socio = 1;

-- consultar todos para verificar nueva columna creada
select * from socios
