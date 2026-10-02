CREATE SCHEMA SegurosGroup;
USE SegurosGroup;

CREATE TABLE usuarios
(
    nombreUsuario VARCHAR(25) NOT NULL PRIMARY KEY,
    pass VARCHAR(25),
    tipoUsuario INT,
    dni VARCHAR(10),
    nombre VARCHAR(50),
    apellido VARCHAR(50)
);

CREATE TABLE tipoSeguros
(
    idTipo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(50)
);

CREATE TABLE seguros
(
    idSeguro INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(200),
    idTipo INT,
    costoContratacion DECIMAL(10,2),
    costoAsegurado DECIMAL(10,2)
);

CREATE TABLE contratacion(
    idContratacion INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombreUsuario VARCHAR(25),
    idSeguro INT,
    costoContratacion DECIMAL(10,2)
);

-- Inserción de usuarios
INSERT INTO usuarios (nombreUsuario,pass,tipoUsuario,dni,nombre,apellido) VALUES ('admin','admin',1,'30600282','Pepe','Pérez');
INSERT INTO usuarios (nombreUsuario,pass,tipoUsuario,dni,nombre,apellido) VALUES ('user1','user1',2,'30600282','Marcela','Fernández');
INSERT INTO usuarios (nombreUsuario,pass,tipoUsuario,dni,nombre,apellido) VALUES ('user2','user2',2,'30600282','José','Rodríguez');

-- Tipos de seguros
INSERT INTO tipoSeguros (descripcion) VALUES ('Seguro de casas');
INSERT INTO tipoSeguros (descripcion) VALUES ('Seguro de vida');
INSERT INTO tipoSeguros (descripcion) VALUES ('Seguro de motos');

-- Inserción de seguros
INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('Seguro de salud para intervenciones quirúrgicas de alta complejidad a costo accesible.', 1, 600.00, 15000.00);
INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('Cobertura total para motos particulares: street, custom, enduro y scooters.', 3, 1200.00, 28000.00);
INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('Protección integral contra incendio y robo para viviendas familiares.', 1, 2500.00, 150000.00);
INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('Seguro de vida individual con indemnización por fallecimiento accidental.', 2, 1500.00, 500000.00);
INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('Cobertura de responsabilidad civil exclusiva para motocicletas de alta cilindrada.', 3, 800.00, 45000.00);
INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('Seguro para casas de veraneo con cobertura contra daños por granizo y tormentas.', 1, 3200.00, 95000.00);
INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('Plan de vida preventivo con servicios de asistencia médica domiciliaria.', 2, 1100.00, 200000.00);
INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('Seguro contra robo en vía pública para ciclomotores y mensajería.', 3, 1400.00, 35000.00);
INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('Cobertura básica para departamentos de alquiler, incluye rotura de cristales.', 1, 950.00, 60000.00);
INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES ('Seguro de vida colectivo para grupos familiares con beneficios de sepelio.', 2, 2200.00, 800000.00);

-- Contrataciones
INSERT INTO contratacion (nombreUsuario,idSeguro,costoContratacion) VALUES ('user1',3,2500);
INSERT INTO contratacion (nombreUsuario,idSeguro,costoContratacion) VALUES ('user2',1,600);

-- Procedimientos almacenados
DELIMITER $$

CREATE PROCEDURE traerTodosUsuarios()
BEGIN
    SELECT * FROM usuarios;
END$$

CREATE PROCEDURE traerUnUsuario(IN NombreU VARCHAR(25))
BEGIN
    SELECT * FROM usuarios WHERE nombreUsuario = NombreU;
END$$

DELIMITER ;