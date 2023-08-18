CREATE USER spring_app_usr WITH ENCRYPTED PASSWORD 'spring_app_password';

CREATE DATABASE first_database_spring;

-- Ejecutar una vez se haya creado la base de datos

CREATE TABLE IF NOT EXISTS personas(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS carros(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    modelo VARCHAR(255) NOT NULL,
    matricula VARCHAR(255) NOT NULL,
    duenio INTEGER NOT NULL,
    CONSTRAINT FK_PERSONA FOREIGN KEY(duenio) REFERENCES personas(id)
);

CREATE TABLE IF NOT EXISTS incidentes(
    reporte INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    lugar VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS carros_incidentes(
    reporte INTEGER NOT NULL,
    carro INTEGER NOT NULL,
    costos DECIMAL(19,2) NOT NULL,
    CONSTRAINT FK_INCIDENTE FOREIGN KEY(reporte) REFERENCES incidentes(reporte),
    CONSTRAINT FK_CARRO FOREIGN KEY(carro) REFERENCES carros(id)
);

GRANT SELECT, INSERT, UPDATE, DELETE ON personas TO spring_app_usr;
GRANT SELECT, INSERT, UPDATE, DELETE ON carros TO spring_app_usr;
GRANT SELECT, INSERT, UPDATE, DELETE ON incidentes TO spring_app_usr;
GRANT SELECT, INSERT, UPDATE, DELETE ON carros_incidentes TO spring_app_usr;

INSERT INTO personas(nombre, direccion)
VALUES ('Persona 1', 'Direccion 1'), ('Persona 2', 'Direccion 2'),
       ('Persona 3', 'Direccion 3'), ('Persona 4', 'Direccion 4'),
       ('Persona 5', 'Direccion 5'), ('Persona 6', 'Direccion 6');
INSERT INTO carros(modelo, matricula, duenio)
VALUES ('Modelo 1', 'Matricula 1', 4), ('Modelo 2', 'Matricula 2', 3),
       ('Modelo 3', 'Matricula 3', 4), ('Modelo 4', 'Matricula 4', 2),
       ('Modelo 5', 'Matricula 5', 6), ('Modelo 6', 'Matricula 6', 6),
       ('Modelo 7', 'Matricula 7', 3), ('Modelo 8', 'Matricula 8', 1),
       ('Modelo 9', 'Matricula 9', 1), ('Modelo 10', 'Matricula 10', 4),
       ('Modelo 11', 'Matricula 11', 3), ('Modelo 12', 'Matricula 12', 5);

INSERT INTO incidentes(lugar, fecha)
-- FECHAS ENERO
VALUES ('Lugar 1', '2023-01-05'), ('Lugar 2', '2023-01-07'), ('Lugar 3', '2023-01-10'),
       ('Lugar 4', '2023-01-12'), ('Lugar 5', '2023-01-13'), ('Lugar 6', '2023-01-21'),
       ('Lugar 7', '2023-01-23'), ('Lugar 8', '2023-01-27'), ('Lugar 9', '2023-01-30'),
-- FECHAS FEBRERO
       ('Lugar 1', '2023-02-10'), ('Lugar 2', '2023-02-13'), ('Lugar 3', '2023-02-13'),
       ('Lugar 4', '2023-02-16'), ('Lugar 5', '2023-02-19'), ('Lugar 6', '2023-02-20'),
       ('Lugar 7', '2023-02-20'), ('Lugar 8', '2023-02-21'), ('Lugar 9', '2023-02-23'),
-- FECHAS MARZO
       ('Lugar 1', '2023-03-02'), ('Lugar 2', '2023-03-03'), ('Lugar 3', '2023-03-07'),
       ('Lugar 4', '2023-03-07'), ('Lugar 5', '2023-03-14'), ('Lugar 6', '2023-03-16'),
       ('Lugar 7', '2023-03-19'), ('Lugar 8', '2023-03-20'), ('Lugar 9', '2023-03-24'),
-- FECHAS ABRIL
       ('Lugar 1', '2023-04-05'), ('Lugar 2', '2023-04-06'), ('Lugar 3', '2023-04-08'),
       ('Lugar 4', '2023-04-10'), ('Lugar 5', '2023-04-13'), ('Lugar 6', '2023-04-23'),
       ('Lugar 7', '2023-04-23'), ('Lugar 8', '2023-04-23'), ('Lugar 9', '2023-04-24');

INSERT INTO carros_incidentes(reporte, carro, costos)
    VALUES (1,1,3535.66),(2,5,9849.33),(3,2,2815.39),(4,1,8178.92),
           (5,12,1418.09),(6,5,9439.52),(7,6,2716.74),(8,9,6494.74),
           (9,12,524.26),(10,5,1337.77),(11,3,3196.96),(12,11,7694.27),
           (13,12,3216.91),(14,7,4971.56),(15,11,9620.31),(16,4,7061.55),
           (17,12,9923.31),(18,7,1462.87),(19,1,6387.74),(20,4,8311.25),
           (21,2,1616.67),(22,8,4515.44),(23,7,8972.85),(24,6,1134.49),
           (25,8,4573.65),(26,6,7407.64),(27,3,1871.7),(28,4,8854.36),
           (29,5,3127.44),(30,10,4905.89),(31,3,4146.94),(32,9,4107.93),
           (33,8,7861.79),(34,1,1380.56),(35,12,7721.62),(36,1,647.16),
           (1,10,1288.7),(5,8,5503.12),(6,7,6814.91),(11,1,4072.16),
           (11,1,8257.81),(17,8,1578.35),(17,10,793.41),(18,12,4819.33),
           (18,8,4573.08),(22,9,6375.79),(23,7,7159.02),(28,11,5701.4),
           (29,9,1998.28),(31,6,5466.65),(33,2,9040.11),(34,12,6250.51),
           (35,6,8490.88),(35,4,1414.71), (36,5,2594.41);