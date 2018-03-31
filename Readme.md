# Examen Cash Online con Spring Boot, MySQL, JPA, Hibernate Rest API 

## Requerimientos

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Pasos

**1. Clonar aplicación**

```
git clone https://github.com/ignMango/testimangop1.git
```

**2. Create Mysql database**

```
create database examen
Ahora esta con las credenciales de heroku
```

**3. Cambiar usuario y clave  mysql**

+ abrir `src/main/resources/application.properties`

+ cambiar `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**2. correr app usando maven**

```
mvn package
java -jar target/examen-0.0.1-SNAPSHOT.jar
```

O -

```bash
mvn spring-boot:run
```

La app arrancara en <http://localhost:8080>.

## Rest APIs

The app defines following CRUD APIs.

    
    GET /user/{Id} //{1} {11} {21}
    
    POST /user/add
    
    DELETE /user/{Id}

Se puede testear con postman o rest-client(Firefox)

## Heroku

<https://examencashp1.herokuapp.com/>
