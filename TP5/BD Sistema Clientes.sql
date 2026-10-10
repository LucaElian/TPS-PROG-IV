CREATE DATABASE IF NOT EXISTS sistema_clientes;
USE sistema_clientes;

-- Tabla de usuarios (para login)
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL
);

-- Tabla de clientes
CREATE TABLE clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(15) NULL UNIQUE,
    cuil VARCHAR(15) NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    fecha_nacimiento VARCHAR(100) NOT NULL,
    direccion VARCHAR(150) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL,
    localidad VARCHAR(50) NOT NULL,
    provincia VARCHAR(50) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL,
    telefono VARCHAR(10) NOT NULL
);

-- Insert usuario admin
INSERT INTO usuarios (usuario, contrasena)
VALUES ('admin', 'pass');


INSERT INTO clientes (
     dni, cuil, nombre, apellido, sexo, fecha_nacimiento,
    direccion, nacionalidad, localidad, provincia,
    correo_electronico, telefono
) VALUES
('12345678', '20123456789', 'Juan','Perez', 'M', '1990-05-14',
 'Calle 123', 'Argentina', 'Rosario', 'Santa Fe',
 'juan.perez@example.com', '3411234567'),

('23456789', '20234567890', 'Maria','Lopez', 'F', '1985-08-22',
 'Av. Libertad 456', 'Argentina', 'La Plata', 'Buenos Aires',
 'maria.lopez@example.com', '2219876543'),

('34567890', '20345678901', 'Carlos','Sanchez', 'M', '1978-02-10',
 'San Martin 789', 'Argentina', 'Cordoba', 'Cordoba',
 'carlos.sanchez@example.com', '3516543210'),

('45678901', '20456789012', 'Lucia','Fernandez', 'F', '1992-07-19',
 'Mitre 321', 'Argentina', 'Mendoza', 'Mendoza',
 'lucia.fernandez@example.com', '2611122334'),

('56789012', '20567890123', 'Ana','Torres', 'F', '1995-11-30',
 'Belgrano 852', 'Argentina', 'Salta', 'Salta',
 'ana.torres@example.com', '3875566778'),

('67890123', '20678901234', 'Diego','Ramirez', 'M', '1980-01-25',
 'Colon 147', 'Argentina', 'Neuquen', 'Neuquen',
 'diego.ramirez@example.com', '2994433221'),

('78901234', '20789012345', 'Paula','Martinez', 'F', '1988-04-12',
 'Rivadavia 963', 'Argentina', 'San Miguel', 'Tucuman',
 'paula.martinez@example.com', '3819988776'),

('89012345', '20890123456', 'Jorge','Gomez', 'M', '1975-09-09',
 'Italia 753', 'Argentina', 'San Juan', 'San Juan',
 'jorge.gomez@example.com', '2641122334'),

('90123456', '20901234567', 'Camila','Diaz', 'F', '1993-12-05',
 'Urquiza 112', 'Argentina', 'Posadas', 'Misiones',
 'camila.diaz@example.com', '3765566778'),
 
 ('90123458', '20901234568', 'Maria','Diaz', 'F', '1993-12-11',
 'Los orcos 112', 'Argentina', 'Posadas', 'Misiones',
 'maria.diaz@example.com', '3765566778'),

('91234567', '20912345678', 'Fernando','Alvarez', 'M', '1982-06-17',
 'French 554', 'Argentina', 'San Salvador', 'Jujuy',
 'fernando.alvarez@example.com', '3881122334');