# Taller Backend Sofka - Mejorar Crud de Usuarios
En este taller se realizó una API RestFull desde cero con las operaciones básicas CRUD.

# Tecnologías usadas
* Spring Boot 2.6.0
* MySQL
## Compilador
* Maven
## Java version
* Java 11
## Dependencias
* Spring Web
* MySQL Driver
* Lombok
* Open API-UI 1.5.12 (Swagger)

## Configuración del .properties
```
# Configurar la coneccion a la base de datos
spring.datasource.url=jdbc:mysql://localhost:3307/TallerBackend
spring.datasource.username=root
spring.datasource.password=usbw
spring.datasource.driver.class=com.mysql.jdbc.Driver
# Indicar el DBMS
spring.jpa.database= MYSQL
# Indica si debe mostrar el log de las consultas sql ejecutadas
# Bueno a la hora de depurar
spring.jpa.show-sql: true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
spring.jpa.hibernate.naming_strategy= org.hibernate.cfg.ImprovedNamingStrategy
#Ruta específica de Swagger
springdoc.api-docs.path=/TallerBackend
#Ruta específica de Swagger-UI
springdoc.swagger-ui.path=/TallerBackend-UI.html
```

## Resumen
La estructura de la API consta de 4 paquetes:


![Estructura del proyecto.](https://i.ibb.co/6v86s4b/1.png)
>Estructura del proyecto.

* Al tener las capas de manera independiente se puede manejar de una manera más cómoda el proyecto (Es importante no mezclar funciones entre las diferentes capas).

* Se implementó un sistema de manejo de errores global (AdviceControler) para no ensuciar el código en el Rest Controller.

* Si al buscar o borrar un usuario se envía un id que no existe el AdviceControler manejará la excepcion y responderá adecuadamente el HTTP Status.

* Se utilizó los nombres standard de cada clase e interfaz.

* Se siguieron buenas prácticas al momento de establecer las URI para cada petición HTTP y se definió un URI base ( "api/v1/" ) para que la API este abierta a futuros cambios.

* Con la libreria Lombok permite mantener los DTO´s de una manera mas legible al encargarse de realizar los getters/setters, constructores necesarios por medio de anotaciones.

## Documentación
Para generar de forma automática la documentación se utilizaron anotaciones en los métodos del RestControler especificando los disitintos parámetros o tipos de retornos y respuestas HTTP.

### Capturas de la documentación

Para poder acceder y testear la API se debe utilizar la siguiente url, en donde Swagger nos permite generar las distintas peticiones desde la propia documentación sin necesidad de usar PostMan o Insomnia.

`<Interfaz Gráfica de la Documentación>`: <http://localhost:8080/TallerBackend-UI.html"Interfaz>

![Documentación con interfaz Gráfica.](https://i.ibb.co/GWjF5qb/3.png)
>Documentación con interfaz Gráfica.

`<Documentación formato Json>`: <http://localhost:8080/TallerBackend>

![Documentación formato Json.](https://i.ibb.co/BTwGVqR/2.png)
>Documentación formato Json.


## Hecho con 💛 by Kevealci.
