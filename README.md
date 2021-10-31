README

La solución utiliza:
● Banco de datos en memoria: H2.
● Proceso de build vía Maven.
● Persistencia con JPA. Hibernate
● Framework SpringBoot.
● Java 11
● La base de datos se crea ejecutando el .jar de h2, el nombre de la BD es test
● Script de creación de tablas en BD:

DROP TABLE IF EXISTS PHONE;
DROP TABLE IF EXISTS USUARIO;
CREATE TABLE USUARIO(ID UUID PRIMARY KEY, NAME VARCHAR(255), EMAIL VARCHAR(255), PASSWORD VARCHAR(255), CREATED DATE, MODIFIED DATE, LAST_LOGIN DATE, TOKEN UUID, ISACTIVE BOOLEAN);
CREATE TABLE PHONE(ID UUID PRIMARY KEY, NUMBER VARCHAR(255), CITYCODE VARCHAR(255), COUNTRYCODE VARCHAR(255), ID_USUARIO UUID);


● Cómo probar el microservicio

1.- descargar el código fuente de https://github.com/betsytrujillo/creacionUsuario.git
2.- ubicarse dentro del directorio raíz del proyecto: ~/creacionUsuario
3.- ejecutar el comando mvn spring-boot:run
4.- una vez iniciado el servicio, utilizar una herramienta que permita hacer peticiones REST. Ej: POSTMAN, SOAPUI
5.- En la herramienta seleccionada cree un request del tipo POST con la url: http://localhost:8080/createUser
6.- En la sección Body ingresar en formato JSON el request. Ej:
{
	"name":"Ana Cruz",
	"email":"anacruz@gmail.com",
	"password":"anita15",
	"phones":[
		{
			"number":"12343567",
			"cityCode":"3",
			"countryCode":"569"
		}
	]
}

Ejemplo de Response OK:

{
    "usuario": {
        "email": "anacruz@gmail.com",
        "password": "anita15",
        "phones": [
            {
                "number": "12343567",
                "cityCode": "3",
                "countryCode": "569"
            }
        ],
        "name": "Ana Cruz"
    },
    "id": "913a9560-9758-4b01-b763-410b7e3b23a4",
    "created": "2021-10-31T02:26:44.026+00:00",
    "modified": "2021-10-31T02:26:44.026+00:00",
    "last_login": "2021-10-31T02:26:44.026+00:00",
    "token": "e367373c-f189-44a9-9140-7cb49fd768aa",
    "isactive": true
}

Ejemplo de Response con Email ya existente:

{
    "message": "El correo ingresado ya existe en base de datos",
    "status_code": 400,
    "uri": "/createUser"
}

Fin.

● Diagrama de la solución.
