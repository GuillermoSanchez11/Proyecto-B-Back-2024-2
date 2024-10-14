[![Java CI](https://github.com/CodeFactory2024-2/Proyecto-B/actions/workflows/main.yml/badge.svg)](https://github.com/CodeFactory2024-2/Proyecto-B/actions/workflows/main.yml)
# Sistema de Gestión de Vuelos B 2024-2

## Descripción del Módulo

Este módulo permite al administrador de la aerolínea gestionar los tipos de aeronaves y un conjunto de vuelos para la aerolínea (crear, editar, eliminar y consultar).

### Funcionalidades MVP

1. **Gestión de Aeronaves (CRUD):**
   - **Crear, consultar, modificar y eliminar tipos de aviones:** Permite al administrador de la aerolínea gestionar los diferentes tipos de aviones que se pueden utilizar en los vuelos. 
   - Al crear un tipo de avión se debe incluir la siguiente información:
     - **Id Aeronave**
     - **Tipo de Avión:** Ejemplo: Boeing 737, Airbus A320, etc.
     - **Cantidad Máxima de Asientos**
     - **Distribución de Asientos:** Ejemplo: 2-4-2, 3-3-3, 2-2-2.
   - Este primer CRUD se entrega como parte del sprint I.

2. **Gestión de Vuelos (CRUD):**
   - **Crear vuelos directos:** Permite al administrador de la aerolínea crear vuelos directos con la información básica detallada más adelante.
   - **Consultar vuelos:** Permite al administrador consultar los vuelos creados para modificarlos o eliminarlos. Esta funcionalidad es exclusivamente para el administrador, diferente del módulo de búsqueda de vuelos.
   - **Modificar vuelos:** Permite modificar un vuelo ya creado, con las siguientes restricciones:
     - Si el vuelo tiene reservas realizadas, sólo permite modificar el tipo de aeronave y la cantidad máxima de pasajeros.
   - **Eliminar vuelos:** Permite eliminar un vuelo ya creado, siempre y cuando no tenga reservas activas.

### Interacciones con Otros Módulos:

- Recibe del módulo de **autorización y autenticación** el token de sesión con la información de rol y permisos.
- Recibe peticiones del módulo de **búsqueda de vuelos**.
- Recibe peticiones del módulo de **gestión de asientos**.

## Integrantes

- Daniel Andrés Agudelo García  
- Paulina García Aristizábal  
- David Camilo García Echavarría  
- Juan Sebastián Ortiz Tangarife  

## Descripción

Este proyecto incluye la implementación de un sistema de gestión de vuelos con una base de datos H2 en memoria y una colección de peticiones en Postman para interactuar con la API de vuelos y aeronaves, permitiendo al administrador realizar operaciones CRUD sobre ambos recursos.

## Herramientas Utilizadas

- **IDE:** IntelliJ IDEA, Visual Studio Code
- **Back-end:** Spring Boot, Java, Apache Maven 3.5, JDK 17
- **Base de Datos:** PostgreSQL
- **Pruebas de API:** Postman
- **Navegador Web:** Google Chrome

## Cómo ejecutar el proyecto

1. Clona el repositorio:
    ```sh
    git clone https://github.com/CodeFactory2024-2/Proyecto-B.git
    ```
2. Navega al directorio del proyecto:
    ```sh
    git checkout origin feature/flight-management
    ```
3. Compila y ejecuta el proyecto usando Maven:
    ```sh
    mvn spring-boot:run
    ```
4. Configura la base de datos:

    - Importa el archivo de la base de datos que se encuentra en el directorio `database` del proyecto (sigue las instrucciones en la sección [Importar Base de Datos](#importar-base-de-datos) de este README).

5. Configura las propiedades de conexión en el archivo `application.properties` o `application.yml` del proyecto. Asegúrate de actualizar las credenciales de la base de datos:

    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/Fabrica
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    ```

6. Compila y ejecuta el proyecto usando Maven dentro de la carpeta `Back`:

    ```sh
    cd Back
    mvn spring-boot:run
    ```

7. La aplicación estará disponible en `http://localhost:8080/graphql`.

## Importar Base de Datos

Sigue estos pasos para importar la base de datos necesaria para el proyecto:

1. Crea una base de datos vacía en PostgreSQL, si no lo has hecho ya:

    ```sql
    CREATE DATABASE vueloudea;
    ```

2. Importa el archivo de la base de datos (`vueloudea.sql` o `vueloudea.backup`) que se encuentra en el directorio `database` del proyecto:

    **Usando pgAdmin 4**:
    - Abre pgAdmin y conecta a tu servidor PostgreSQL.
    - Haz clic derecho sobre la base de datos `vueloudea` y selecciona **Restore**.
    - Selecciona el archivo SQL o backup que descargaste del repositorio y haz clic en **Restore**.

    **Usando la terminal**:

    - Para un archivo SQL:

      ```sh
      psql -U tu_usuario -d vueloudea -f database/vueloudea.sql
      ```

    - Para un archivo `.backup`:

      ```sh
      pg_restore -U tu_usuario -d vueloudea database/vueloudea.backup
      ```

3. Verifica que la base de datos se haya importado correctamente con todas las tablas y datos.

## Postman

Se recomienda crear una colección de Postman para probar las diferentes operaciones CRUD. Ajusta la URL base a `http://localhost:8080/graphql`.
