CRUD


# CRUD EN SPRING BOOT Y RELACIONES
## API REST CON SPRING BOOT
### Actividad 3 — Tema 4

**Instituto Tecnológico de Oaxaca**

**Carrera:** Ingeniería en Sistemas Computacionales
**Materia:** Programación Web
**Docente:**Maestra Adelina Martínez Nieto
**Estudiante:** Chavez Hernandez Luis Eduardo

Oaxaca de Juárez, Oaxaca — 2026

---

## Descripción del proyecto
Actividad en la que se construye un CRUD con ayuda de mysql y springboot desplegado en un vps en la cual elegi por hacer la relación entre dos entidades: `Materia` y `Profesor`. Cada materia pertenece a un profesor, y un profesor puede tener asignadas varias materias. El proyecto sigue una arquitectura ordenada con carpetas Entidad - Repository - Service -Controller, y todas las operaciones del CRUD (crear, leer, actualizar, eliminar) fueron probadas con postman y persisten correctamente en la base de datos, reflejando la relación entre ambas entidades.

El proyecto se desplegó en el VPS del equipo en un puerto nuevo 8086, distinto al de las Actividades 1 y 2, y la fase local fue probada con ayuda de xamp y postman.

---

## Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL (XAMPP en local, MySQL en el VPS)
* Maven
* Git y GitHub
* Visual Studio Code
* VPS Azure con Ubuntu
* Postman

---

## Entidades y relación

* **Profesor**: `id`, `nombre`, `especialidad`
* **Materia**: `id`, `nombre`, `creditos`, `semestre`, `profesor`<--:) (relación)

**Tipo de relación:** Muchos a uno (`@ManyToOne`) desde `Materia` hacia `Profesor`, y uno a muchos (`@OneToMany`) desde `Profesor` hacia `Materia`. Varias materias pueden pertenecer al mismo profesor, pero cada materia tiene asignado un único profesor. La llave foránea (`profesor_id`) se definió con `@JoinColumn` en la entidad `Materia`.

**Captura de las entidades relacionadas:**

<img width="1274" height="421" alt="image" src="https://github.com/user-attachments/assets/64fb379f-b17b-44a8-a62a-b6c1cd202af7" />
<img width="1218" height="251" alt="image" src="https://github.com/user-attachments/assets/53d07f20-892a-4ccc-9253-d85d95a26e4f" />
<img width="1105" height="315" alt="image" src="https://github.com/user-attachments/assets/a5e4b144-4061-4708-a9ef-415ae5853500" />

---

## Arquitectura por capas

* `Materia.java` y `Profesor.java`: entidades (`@Entity`)
* `MateriaRepository.java` y `ProfesorRepository.java`: repositorios, extienden `JpaRepository`
* `MateriaService.java`: capa de servicio con la lógica de negocio
* `MateriaController.java` y `ProfesorController.java`: controladores REST con los endpoints del CRUD

---

## Endpoints del CRUD

### Crear profesor

```
POST /api/profesores
```
Body:
```json
{
    "nombre": "Adelina Martínez",
    "especialidad": "Programación Web"
}
```

**Captura:**
<img width="1113" height="709" alt="image" src="https://github.com/user-attachments/assets/6377ef23-3d2b-4bd6-95df-fd3e37b77495" />

---

### Crear una materia (relacionada con un profesor)

```
POST /api/materias
```
Body:
```json
{
    "nombre": "Spring Boot",
    "creditos": 5,
    "semestre": 7,
    "profesor": { "id": 1 }
}
```

**Captura:**
<img width="1004" height="663" alt="image" src="https://github.com/user-attachments/assets/a8b0666c-681b-44f6-8b59-03a442c462f9" />


---

### Leer (listar todas las materias, con el profesor reflejado)

```
GET /api/materias
```

Muestra la lista completa de materias, **incluyendo los datos del profesor asignado** (no solo su id), demostrando que la relación funciona correctamente.

**Captura:**
<img width="963" height="703" alt="image" src="https://github.com/user-attachments/assets/8cfe2b79-e2eb-4db1-a227-b5a2c69f59e4" />


---

### Leer una materia por id

```
GET /api/materias/{id}
```

**Captura:**
<img width="787" height="660" alt="image" src="https://github.com/user-attachments/assets/295f8236-3741-4a2b-9751-1ed2e53162c7" />


---

### Actualizar una materia

```
PUT /api/materias/{id}
```
Body:
```json
{
    "nombre": "Spring Boot Avanzado",
    "creditos": 6,
    "semestre": 8,
    "profesor": { "id": 1 }
}
```

**Captura:**
<img width="770" height="697" alt="image" src="https://github.com/user-attachments/assets/e015816e-19af-479e-9e00-31f289d6228f" />


---

### Eliminar una materia

```
DELETE /api/materias/{id}
```

**Captura:**
<img width="768" height="634" alt="image" src="https://github.com/user-attachments/assets/041550ca-45a9-422d-9bb0-04487784111a" />


---

## Ejecución local

```
.\mvnw.cmd spring-boot:run
```

Base de datos local usada para pruebas: `act3_luis_local` (XAMPP / MySQL).

---

## Proyecto funcionando en el VPS
Mi proyecto no cuenta con una vista thymeleaf, es directamente el acceso con get al json y sus funciones con PUT,DELETE,POST
```

http://68.155.154.235:8086/api/materias

```

Base de datos en el VPS: `act3_luis` (MySQL).

Las instancias de las Actividades 1 y 2 siguen corriendo sin afectaciones en sus puertos originales:

```
http://68.155.154.235:8082/quiensoy
http://68.155.154.235:8084/vista/materias
```

---




** Enlaces**
* Proyecto corriendo en el VPS: http://68.155.154.235:8086/api/materias
* http://68.155.154.235:8086/api/profesores
  
POST http://68.155.154.235:8084/api/materias
POST http://68.155.154.235:8086/api/materias
POST http://68.155.154.235:8086/api/profesores
PUT  http://68.155.154.235:8086/api/materias/{id}
DELETE http://68.155.154.235:8086/api/materias/{id}
