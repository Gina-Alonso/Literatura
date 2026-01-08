# 📚 LiterAlura - Catálogo de Libros Interactivo

**LiterAlura** es una aplicación de consola en Java que permite explorar, buscar y gestionar un catálogo de libros obtenidos desde una API externa. Los usuarios pueden interactuar con el sistema mediante un menú textual con múltiples opciones.

## ✨ Características

- 🔍 Búsqueda de libros a través de API externa
- 💾 Almacenamiento local en base de datos
- 📊 Múltiples opciones de consulta
- 🖥️ Interfaz de consola 
- 📚 Gestión de autores y sus obras

## 🛠️ Tecnologías Utilizadas

- **Java 17+**
- **Spring Boot** (opcional, dependiendo de la implementación)
- **Base de datos H2/MySQL/PostgreSQL**
- **Jackson** para procesamiento JSON
- **JPA/Hibernate** para persistencia
- **API Gutendex** (API de libros gratuitos)

## 📋 Prerrequisitos

- JDK 17 o superior
- Maven 3.6+ o Gradle
- Conexión a Internet (para consumo de API)
- IDE de preferencia (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Instrucciones de Instalación

### 1. Clonar el Repositorio
```bash
git clone https://github.com/tu-usuario/literalura.git
cd literalura
```
## 🖼️ Demostración de LiterAlura

### 1. Pantalla de Inicio
![Pantalla de inicio de LiterAlura](./images/inicio.png)
*Al ejecutar la aplicación, se muestra el menú principal*

### 2. Búsqueda en Tiempo Real
![Buscando libros en la API](./images/busqueda-api.gif)
*Proceso de búsqueda y obtención desde Gutendex API*

### 3. Resultados y Almacenamiento
![Libro encontrado y guardado](./images/resultado-guardado.png)
*El libro se muestra y se almacena automáticamente en la BD*

### 4. Consultas a la Base de Datos
![Consultando libros registrados](./images/consulta-bd.png)
*Listado completo de libros persistidos*

### 5. Diagrama de la Solución
![Arquitectura de LiterAlura](./images/arquitectura.svg)
*Diagrama de componentes y flujo de datos*
