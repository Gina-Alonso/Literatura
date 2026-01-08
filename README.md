# 📚LiterAlura - Catálogo de Libros Interactivo
![Gutendex API](https://img.shields.io/badge/Gutendex-API-blue?logo=bookstack)
![Java 21](https://img.shields.io/badge/Java%2021-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?logo=postgresql&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apache-maven&logoColor=white)
![Jackson](https://img.shields.io/badge/Jackson-1C1C1C?logo=json&logoColor=white)

**Autor:** [@Gina-Alonso](https://github.com/Gina-Alonso)  
**BootCamp:** Oracle Next Education / Alura Latam
**Challenge:** LiterAlura  
**Fecha:** Diciembre 2025
## Acerca del Challenge
**LiterAlura** es una aplicación de consola en Java que permite explorar, buscar y gestionar un catálogo de libros obtenidos desde una API externa. Los usuarios pueden interactuar con el sistema mediante un menú textual con múltiples opciones.

## Características

- 🔍 Búsqueda de libros a través de API externa
- 💾 Almacenamiento local en base de datos
- 📊 Múltiples opciones de consulta
- 🖥️ Interfaz de consola 
- 📚 Gestión de autores y sus obras

## Tecnologías Utilizadas

- **Java 21+**
- **Spring Boot**
- **Base de datos PostgreSQL**
- **Jackson** para procesamiento JSON
- **JPA/Hibernate** para persistencia
- **API Gutendex** (API de libros gratuitos)

## Prerrequisitos

- JDK 21 o superior
- Maven 3.6+ o Gradle
- Conexión a Internet (para consumo de API)
- IDE de preferencia (IntelliJ IDEA)

## Instrucciones de Instalación

### 1. Clonar el Repositorio
```bash
git clone https://github.com/Gina-Alonso/Literatura.git
cd literalura
```
## Demostración de LiterAlura

### Pantalla del Menu
![Pantalla del Menu de LiterAlura](./src/img/literalura_menu.png)

*Al ejecutar la aplicación, se muestra el menú principal*

### 1. Buscar libro
![Buscando libros en la API](./src/img/literalura_buscar_libro.png)

*Proceso de búsqueda y obtención desde Gutendex API el libro se almacena automáticamente en la BD*

### 2. Buscar libro por autor
![Libro encontrado y guardado](./src/img/literalura_buscar_libroxautor.png)

*Proceso de busqueda del libro de un determinado autor desde la BD*

### 3. Libros Registrados
![Libro encontrado y guardado](./src/img/literalura_libros_registrados.png)

*Listado completo de los libros persistidos*

### 4. Libros Registrados
![Consultando libros registrados](./src/img/literalura_autores_registrados.png)

*Listado completo de autores persistidos*

### 5. Autores vivos en determinado anio
![Arquitectura de LiterAlura](./src/img/literalura_autores_vivos.png)

*Consulta de los autores en la BD*

### 6. Libros por idioma
![Arquitectura de LiterAlura](./src/img/literalura_librosxidioma.png)

*Consulta de libros por idioma*

### 7. Estadisticas
![Arquitectura de LiterAlura](./src/img/literalura_est.png)

*Estadisticas*

### 8. Top 5 libros mas descargados
![Arquitectura de LiterAlura](./src/img/literalura_top5.png)
*Consulta de los 5 libros mas descargados*
