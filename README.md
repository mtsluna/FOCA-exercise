# FOCA-exercise
Proyecto de demostración para FOCA Software Factory

## Deploy
En primer lugar para poder ejecutar ambos proyectos se debe de clonar el repositorio de GIT.
Utilizando los siguientes comandos:
``` curl
 git clone https://github.com/mtsluna/FOCA-exercise.git
```

Una vez que ya tenga los proyectos en su repositorio local ya podra comenzar a ejecutarlos.

## Ejecutar Backend
Para ejecutar el backend usted debe primero tener creada una Base de Datos MySQL con el nombre: "superheroesstatsdb"

Pasos para la ejecución:

1. Abrir una consola de CMD sobre la raiz de los 2 proyectos.
2. Ubicarse sobre la carpeta "api-rest-superheroes" con el siguiente comando:
``` curl
cd api-rest-superheroes
```
3. Ejecutar el comando para iniciar la aplicacion
``` curl
mvnw spring-boot:run
```

Una vez realizados todos estos pasos ya deberia de tener corriendo el servidor en el puerto 8080 (default). 
En el caso de no funcionar intente revisando las variables de entorno y la disponibilidad del puerto 8080.

Una vez ejecutado puede acceder a los servicios del mismo con los siguientes endpoints:
- ENDPOINT Raiz: http://localhost:8080/
- ENDPOINT Swagger: http://localhost:8080/swagger-ui.html#/

## Ejecutar FrontEnd
1. Abrir una consola de CMD sobre la raiz de los 2 proyectos.
2. Ubicarse sobre la carpeta "frontend-superheroes" con el siguiente comando:
``` curl
cd frontend-superheroes
```
3. Descargar las dependencias del proyecto (Paciencia suele demorar) con el siguiente comando:
``` curl
npm install
```
4. Ejecutar el comando para iniciar la aplicacion
``` curl
ng serve
```

Una vez ejecutado puede acceder a los servicios del mismo con los siguientes endpoints:
- ENDPOINT Raiz: http://localhost:4200/
- ENDPOINT Home: http://localhost:4200/home
- ENDPOINT Stats: http://localhost:4200/stats
- ENDPOINT Stats Graphic: http://localhost:4200/stats/graphics

## Teconologías usadas
- Java con el framework Spring Boot, con las siguientes dependencias:
  - [Swagger UI](https://swagger.io/): Documentador de endpoints
- Angular, con las siguientes dependencias:
  - [Bootstrap](https://getbootstrap.com/)
  - [Jquery](https://jquery.com/)
  - [Popper.js](https://popper.js.org/)
  - [MDBootstrap](https://mdbootstrap.com/)
  - [Charts.js](https://www.chartjs.org/docs/latest/)
 - MySQL
