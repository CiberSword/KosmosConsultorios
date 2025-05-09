## Servicio de citas médicas creado con Spring Boot!

Hola! Este archivo contiene la serie de pasos a seguir para realizar el despliegue del servicio.
Se asume que ya se cuenta con PostgreSQL instalado, se tiene la BD creada y el usuario 'postgres' con la
contraseña 'KosmosBD' y los permisos asignados.

#### Requerimientos:

Para la ejecución del proyecto se requiere que el sistema cuente con:

- Java JDK (Al menos la versión 17).
- Maven (debe estar configurado en las variables de entorno).

#### Pasos a seguir:

1. Ubicarse en la carpeta raiz del proyecto


2. Ejecutar el comando
    ```sh
    mvn clean install
    ```
    Este comando realizará el build del frontend del proyecto y moverá los archivos a la carpeta de ficheros estáticos.


3. Ejecutar el comando
    ```sh
    mvn spring-boot:run
    ```
   Se iniciará el proceso de compilación y ejecución del proyecto con Maven. Podrás confirmar que el
   servicio arrancó correctamente al ver el mensaje "Started KosmosConsultoriosApplication in X seconds (process running for X.X)"
   en consola.

@CiberSword, 2025
