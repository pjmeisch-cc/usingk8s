# DocumentService

Eine Spring Boot Anwendung mit den _web, actuator_ and _elasticsearch_ Komponenten. 

## Dockerimage

Die Docker Umgebung muss eingerichtet sein (entweder ein lokaler docker Service oder entsprechend konfigurierte DOCKER_HOST Environment).

Mit dem Kommando  `mvn package` wird die Anwendung gebaut und in ein Docker-Image gepackt. Das Image hat den Namen _codecentric/documentservice:VERSION_.


