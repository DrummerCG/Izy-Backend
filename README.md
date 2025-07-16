# Izy-Backend

Este es el backend para la aplicación **Izy Academic**, una plataforma de formación. Provee los servicios RESTful para la gestión de usuarios, incluyendo registro y autenticación segura de contraseñas.

## ✨ Tecnologías Utilizadas

*   **Lenguaje**: Java 21
*   **Framework**: Spring Boot 3.5.3
*   **Seguridad**: Spring Security (para hasheo de contraseñas y configuración de endpoints)
*   **Base de Datos**: Spring Data JPA / Hibernate con MariaDB
*   **Build Tool**: Maven
*   **Utilidades**: Lombok

---

## 🚀 Cómo Correrlo en Local

Sigue estos pasos para tener una instancia del backend corriendo en tu máquina.

### 1. Prerrequisitos

Asegúrate de tener instalado lo siguiente:
-   [JDK 21](https://www.oracle.com/java/technologies/downloads/#jdk21-windows) o una versión superior.
-   [Apache Maven](https://maven.apache.org/download.cgi)
-   Una instancia de [MariaDB](https://mariadb.org/download/) corriendo.
-   Un cliente de Git como [Git SCM](https://git-scm.com/downloads).

### 2. Clonar el Repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
cd Izy-Backend
```

### 3. Configurar la Base de Datos

Necesitas crear la base de datos y la tabla de usuarios.

a. Conéctate a tu cliente de MariaDB (HeidiSQL, DBeaver, o la línea de comandos).

b. Crea la base de datos:

```sql
CREATE DATABASE izy_academy_db;
```

c. Selecciona la base de datos que acabas de crear:

```sql
USE izy_academy_db;
```

d. Ejecuta el siguiente script para crear la tabla `users`:

```sql
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### 4. Configurar la Aplicación

Abre el archivo `src/main/resources/application.properties`. La configuración por defecto asume que MariaDB está corriendo en `localhost:3306` y que el usuario es `root` sin contraseña. Si tu configuración es diferente, ajústala:

```properties
# Tu usuario de la base de datos
spring.datasource.username=tu_usuario # ej: root

# Tu contraseña de la base de datos
spring.datasource.password=tu_contraseña
```

### 5. Ejecutar el Backend

Desde la carpeta raíz del proyecto, ejecuta el siguiente comando de Maven:

```bash
mvn spring-boot:run
```

¡Y listo! El servidor estará corriendo en `http://localhost:8080`.

---

## 🔌 Endpoints de la API

Todos los endpoints de autenticación se encuentran bajo el prefijo `/auth`.

### Registrar un Nuevo Usuario
*   **Endpoint**: `POST /auth/register`
*   **Descripción**: Crea un nuevo usuario en la base de datos. La contraseña se guarda hasheada de forma segura.
*   **Request Body**:
    ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "password": "a-strong-password"
    }
    ```
*   **Respuestas**:
    *   `201 Created`: Si el registro es exitoso.
    *   `409 Conflict`: Si el email ya está en uso.

### Iniciar Sesión
*   **Endpoint**: `POST /auth/login`
*   **Descripción**: Valida las credenciales del usuario.
*   **Request Body**:
    ```json
    {
      "email": "john.doe@example.com",
      "password": "a-strong-password"
    }
    ```
*   **Respuestas**:
    *   `200 OK`: Si las credenciales son correctas. El cuerpo de la respuesta será el nombre completo del usuario (ej: `"John Doe"`).
    *   `401 Unauthorized`: Si el email no existe o la contraseña es incorrecta.
