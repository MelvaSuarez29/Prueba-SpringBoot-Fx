# 📚 Corrección de Examen – POO
### JavaFX con BCrypt + Spring Boot REST API

Este repositorio contiene **dos proyectos independientes** desarrollados como parte de la corrección de un examen de **Programación Orientada a Objetos**. Ambos muestran el uso de tecnologías modernas para el desarrollo de aplicaciones de escritorio y servicios web.

---

# 🗂️ Estructura del repositorio

```text
/
├── login-hash/                # Proyecto JavaFX + BCrypt
│   ├── src/main/java/com/epn/loginhash/...
│   └── src/main/resources/...
├── colegios-springboot/       # Proyecto Spring Boot REST API
│   ├── src/main/java/com/epn/...
│   └── pom.xml
└── README.md                  # Este archivo
```

---

# 🔐 Proyecto 1: JavaFX – Login y Registro con BCrypt

Aplicación de escritorio desarrollada en **JavaFX** que permite la autenticación de administradores y el registro de clientes utilizando **BCrypt** para almacenar las contraseñas de forma segura en una base de datos MySQL.

## 📌 Requisitos funcionales

- Inicio de sesión con:
  - Correo electrónico
  - Contraseña (enmascarada)
  - ComboBox de roles:
    - Administrador
    - Cliente
    - Invitado
- Únicamente el rol **Administrador** puede acceder al sistema.
- Al iniciar sesión correctamente se abre la ventana de **Registro de Clientes**.
- El registro almacena todos los datos del cliente.
- Las contraseñas se guardan utilizando **BCrypt**.
- La tabla `clientes` contiene los siguientes campos:

| Campo | Descripción |
|--------|-------------|
| id_cliente | Identificador |
| nombre | Nombre del cliente |
| correo | Correo electrónico |
| telefono | Número telefónico |
| contrasena_hash | Contraseña cifrada |
| direccion | Dirección |
| rol | Rol del usuario |

---

## 💻 Tecnologías utilizadas

- JavaFX 21
- Java 17
- MySQL 9.x
- JDBC
- JBCrypt 0.4
- Maven

---

## 🗄️ Configuración de la base de datos

### 1. Crear la base de datos

```sql
CREATE DATABASE IF NOT EXISTS login_hash;
USE login_hash;
```

### 2. Ejecutar el archivo

```
database.sql
```

Este archivo crea la tabla e inserta un administrador de prueba.

### 3. Configurar la conexión

Modificar las credenciales en:

```
ClienteDAO.java
```

```java
private static final String URL = "jdbc:mysql://localhost:3307/login_hash";
private static final String USER = "root";
private static final String PASSWORD = "tu_contraseña";
```

---

## ✅ Correcciones realizadas

| Problema encontrado | Solución aplicada |
|----------------------|-------------------|
| El FXML apuntaba al paquete `Contoller` | Se corrigió a `controller` |
| Rutas incorrectas de archivos FXML | Se movieron a `resources/com/epn/loginhash/` |
| Hash BCrypt inválido | Se generó un nuevo hash para `admin123` |
| La búsqueda del usuario se hacía por nombre | Se cambió la consulta a `WHERE correo = ?` |
| No existía validación de usuario | Se implementó `Optional` para validar existencia |

---

## ▶️ Ejecución

Clase principal:

```
Launcher.java
```

Credenciales del administrador:

```
Correo:
admin@epn.edu.ec

Contraseña:
admin123
```

---

# 🚀 Proyecto 2: Spring Boot – API REST de Colegios

Aplicación desarrollada con **Spring Boot** para administrar colegios mediante una API REST utilizando **Spring Data JPA** y **MySQL**.

---

## 📌 Endpoints disponibles

| Método | Endpoint | Descripción |
|---------|----------|-------------|
| GET | `/examen` | Mensaje de bienvenida |
| GET | `/colegio` | Listar colegios |
| GET | `/Colegio/{id}` | Buscar colegio por ID |
| POST | `/Colegio` | Registrar colegio |
| PUT | `/Colegio/{id}` | Actualizar colegio |
| DELETE | `/Colegio/{id}` | Eliminar colegio |

---

## 💻 Tecnologías utilizadas

- Spring Boot 3.4.0
- Spring Data JPA
- Hibernate
- MySQL 9.x
- Java 17
- Maven

---

## 🗄️ Configuración de la base de datos

Archivo:

```
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/base_de_colegios?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> **Nota:** El proyecto utiliza el puerto **3307**. Puede modificarse según la configuración local.

---

## 📋 Modelo de datos

Entidad **Colegio**

| Campo | Tipo |
|--------|------|
| id | Integer |
| nombre | String |
| ubicacion | String |
| tipo | String |
| num_estudiantes | Integer |
| director | String |

---

## ✅ Correcciones realizadas

- Actualización del `pom.xml` para utilizar Spring Boot **3.4.0**.
- Configuración de Java 17.
- Corrección de las anotaciones JPA (`@Entity`, `@Id`, etc.).
- Implementación del manejo de excepciones en los métodos de actualización y eliminación.
- Implementación del controlador REST con `@RestController`.
- Corrección de los endpoints del controlador.

---

## ▶️ Ejecución

Clase principal:

```
TestColegio.java
```

La aplicación se ejecuta en:

```
http://localhost:8080
```

---

## 📌 Pruebas con cURL

Obtener todos los colegios

```bash
curl -X GET http://localhost:8080/colegio
```

---

# 🛠️ Requisitos generales

- JDK 17 o superior
- Maven
- MySQL 8.x o 9.x
- IntelliJ IDEA o Eclipse

---

# 📦 Dependencias principales

## Proyecto JavaFX

- javafx-controls 21.0.6
- javafx-fxml 21.0.6
- jbcrypt 0.4
- mysql-connector-j 9.7.0

---

## Proyecto Spring Boot

- spring-boot-starter-web
- spring-boot-starter-data-jpa
- mysql-connector-j 9.7.0

---

# 📝 Notas

- Ambos proyectos son completamente independientes.
- No comparten base de datos.
- JavaFX utiliza MySQL en el puerto **3307**.
- Spring Boot utiliza MySQL en el puerto **3307**.
- Las contraseñas del proyecto JavaFX se almacenan utilizando **BCrypt**.
- La API REST implementa únicamente operaciones CRUD para la entidad Colegio.

---

# 👩‍💻 Autor

**Melva Suárez**

Corrección de Examen – Programación Orientada a Objetos
---

# 📄 Licencia

Proyecto desarrollado con fines educativos.
