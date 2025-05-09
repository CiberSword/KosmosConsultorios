--@Autor: <Daniel Eduardo Jarquin López>
--@Fecha creación: <09/05/2025>
--@Descripción: <Carga inicial de datos>

INSERT INTO especialidad (nombre, descripcion)
VALUES
    ('Cardiología', 'Especialidad médica que se ocupa del diagnóstico y tratamiento de las enfermedades del corazón y el sistema circulatorio.'),
    ('Pediatría', 'Especialidad médica que se dedica al cuidado y tratamiento de los niños y adolescentes.'),
    ('Neurología', 'Especialidad médica que se enfoca en el diagnóstico y tratamiento de los trastornos del sistema nervioso.'),
    ('Ginecología', 'Especialidad médica que se ocupa de la salud del sistema reproductivo femenino.'),
    ('Ortopedia', 'Especialidad médica que trata las enfermedades y lesiones del sistema musculoesquelético.');

INSERT INTO doctor (nombre, apellido_paterno, apellido_materno, especialidad_id)
VALUES
    ('Juan', 'Pérez', 'Gómez', 1), -- Cardiología
    ('Ana', 'Martínez', 'López', 2), -- Pediatría
    ('Carlos', 'Gutiérrez', 'Ramírez', 3); -- Neurología

INSERT INTO consultorio (numero_consultorio, piso)
VALUES
    ('101', '1A'),
    ('102', '1B'),
    ('201', '2A');
