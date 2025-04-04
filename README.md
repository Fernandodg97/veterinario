

# 🐾 Proyecto Veterinario Backend

Aplicación backend para la gestión de usuarios, mascotas y tratamientos veterinarios, desarrollada con **Spring Boot 3.4.4**, **Java 21** y **Couchbase** como base de datos NoSQL.

---

## 📦 Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.4
- Spring Data Couchbase
- Spring Web
- Maven (WAR packaging)
- Couchbase Server
- Tomcat (como servidor embebido)

---

## 🚀 Configuración del entorno

### Couchbase

Asegúrate de tener Couchbase Server corriendo en `localhost` y con el bucket `veterinario` creado. Usuario y contraseña deben ser `usuario`.

### `application.properties`

```properties
spring.application.name=veterinario
server.port=4040

# Configuración de Couchbase
spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER
spring.couchbase.connection-string=localhost
spring.couchbase.bucket.name=veterinario
spring.couchbase.username=usuario
spring.couchbase.password=usuario
```

---

## 🔧 Configuración de Beans

### `CouchbaseConfig.java`

Configura el acceso a Couchbase y crea el `CouchbaseTemplate`:

```java
@Configuration
@EnableCouchbaseRepositories(basePackages = "net.xeill.elpuig.veterinario.repositories")
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {
    // Métodos que configuran conexión, usuario, contraseña y bucket
}
```

### `CorsConfig.java`

Permite peticiones CORS desde cualquier origen:

```java
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return registry -> registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*");
    }
}
```

---

## 📁 Estructura del proyecto

```
net.xeill.elpuig.veterinario
├── configs
│   ├── CouchbaseConfig.java
│   └── CorsConfig.java
├── controllers
│   ├── UsuarioController.java
│   └── MascotaController.java
├── models
│   ├── Usuario.java
│   ├── Mascota.java
│   └── Tratamiento.java
├── repositories
│   └── UsuarioRepository.java
└── services
    └── UsuarioService.java
```

---

## 📮 API REST

### Usuarios

| Método | Endpoint                     | Descripción                       |
|--------|------------------------------|-----------------------------------|
| POST   | `/api/usuarios`              | Crear un usuario                  |
| GET    | `/api/usuarios`              | Obtener todos los usuarios        |
| GET    | `/api/usuarios/{id}`         | Obtener un usuario por ID         |
| GET    | `/api/usuarios/{email}`      | Obtener un usuario por email      |
| PUT    | `/api/usuarios/{id}`         | Editar un usuario por ID          |
| DELETE | `/api/usuarios/{id}`         | Eliminar un usuario               |

### Mascotas

| Método | Endpoint                                               | Descripción                              |
|--------|--------------------------------------------------------|------------------------------------------|
| POST   | `/api/usuarios/{id}/mascotas`                          | Agregar mascota a un usuario             |
| GET    | `/api/usuarios/{id}/mascotas`                          | Obtener todas las mascotas del usuario   |
| PUT    | `/api/usuarios/{usuarioId}/mascotas/{mascotaId}`      | Editar una mascota                       |
| DELETE | `/api/usuarios/{id}/mascotas/{mascotaId}`             | Eliminar una mascota                     |

### Tratamientos

| Método | Endpoint                                                                           | Descripción                                |
|--------|------------------------------------------------------------------------------------|--------------------------------------------|
| POST   | `/api/usuarios/{usuarioId}/mascotas/{mascotaId}/tratamientos`                     | Agregar tratamiento a una mascota          |
| GET    | `/api/usuarios/{usuarioId}/mascotas/{mascotaId}/tratamientos`                     | Obtener todos los tratamientos de mascota  |
| DELETE | `/api/usuarios/{usuarioId}/mascotas/{mascotaId}/tratamientos/{tratamientoId}`     | Eliminar tratamiento                       |

---

## 📤 Ejemplos de peticiones

### Crear usuario

```http
POST /api/usuarios
Content-Type: application/json

{
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan.perez@example.com",
  "numero_cuenta": "123456"
}
```

### Agregar mascota

```http
POST /api/usuarios/12345/mascotas
Content-Type: application/json

{
  "nombre": "Rex",
  "raza": "Pastor Alemán",
  "genero": "Macho",
  "fechaNacimiento": "2019-06-15",
  "peso": 30.5
}
```

### Agregar tratamiento

```http
POST /api/usuarios/12345/mascotas/111/tratamientos
Content-Type: application/json
{
  "mascotaId": "mascota001",
  "medicamento": "Antiinflamatorio",
  "dosis": "250mg",
  "duracion": "5 días"
}
```

---

## 👨‍💻 Autores
- [@Fernandodg97](https://github.com/Fernandodg97)
- [@Msedjari10](https://github.com/Msedjari10)
---

## 📄 Licencia

[CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/deed.es)
