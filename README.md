# bankaya-exercise
Exercise

Dejo el código como tal y un archivo llamado bayanka_exercise.zip con el código cómo tal.
Las respuestas de las preguntas las pueden encontrar en el archivo: 
Examen_Bankaya_Er-ramani.pdf

Para instalar el proyecto sólo hace falta hacer un mvn spring-boot:run en la consola.

Las rutas son las siguientes:

WSDL:
http://localhost:8080/ws/abilities.wsdl

H2 Console:
http://localhost:8080/h2-console/

Las credenciales del H2 están en el application.properties

Para probar cada uno de los endpoints dentro de src hay una carpeta llamada ws-request con las definiciones de cada Request

Para probarlo en con un cURL puedes hacer el siguiente:

```curl --header "content-type: text/xml" -d @{nombreDelArchivoRequest}.xml http://localhost:8080/ws```

Contacto:
erramani.velasco@gmail.com