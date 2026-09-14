CREATE DATABASE bdInventario;

USE bdInventario;


CREATE TABLE Categorias (
    IdCategoria INT NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(45) NOT NULL,
    Estado BIT NOT NULL DEFAULT 1,
    PRIMARY KEY (IdCategoria)
);


CREATE TABLE Productos (
    Codigo VARCHAR(20) NOT NULL,
    Nombre VARCHAR(45) NOT NULL,
    Precio DECIMAL(10,2) NOT NULL,
    Stock INT NOT NULL,
    IdCategoria INT NOT NULL,
    Estado BIT NOT NULL DEFAULT 1,

    PRIMARY KEY (Codigo),

    FOREIGN KEY (IdCategoria)
        REFERENCES Categorias(IdCategoria)
);


DELIMITER $$

CREATE PROCEDURE sp_AgregarProducto (
    IN pCodigo VARCHAR(20),
    IN pNombre VARCHAR(45),
    IN pPrecio DECIMAL(10,2),
    IN pStock INT,
    IN pIdCategoria INT
)
BEGIN

    INSERT INTO Productos (
        Codigo,
        Nombre,
        Precio,
        Stock,
        IdCategoria
    )
    VALUES (
        pCodigo,
        pNombre,
        pPrecio,
        pStock,
        pIdCategoria
    );

END $$

DELIMITER ;