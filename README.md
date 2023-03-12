MI EQUIPO MUNDIALISTA

Mi Equipo Mundialista es una página web en la que podrás crear tu equipo para el Mundial Qatar 2022.
En el mismo podrás elegir un nombre, luego una pelota y finalmente 11 jugadores.

DISEÑO

El diseño cuenta con distintos templates:
- Index: Da la bienvenida al usuario y lo invita a navegar en el sitio web.
- Crear Equipo: Se debe completar el nombre que llevará el equipo.
- Elegir Pelota: Se debe elegir la pelota que tendrá el equipo.
- Elegir Jugadores: Se eligirán los 11 jugadores que integrarán al equipo. En caso de elegir uno repetido, se deberá elegir otro hasta llegar a 11.
- Mi Equipo: Se podrán ver los datos del equipo creado. En caso que se quiera acceder sin tener un equipo creado, el sistema redirigirá al usuario a "Crear Equipo".
- Ver Equipos: Se podrá ver la lista de los usuarios y los nombres de sus equipos.
- Detalles Equipo: Se podrá ver los datos del usuario accediendo mediante el template "Ver Equipos".

Además, cuenta con otros dos templates relacionados a los usuarios:
- Login: Se debe ingresar un usuario y una contraseña.
- Crear Usuario: Se debe ingresar el nuevo usuario y su contraseña. No se aceptan usuarios repetidos, en caso de tener el mismo nombre, se deberá pensar otro diferente.

FUNCIONALIDAD

La página web fue realizada en Spring Boot y cuenta con un controlador para los datos del equipo (maneja todo lo relacionado a la creación, modificación y eliminación del mismo) y otro controlador que trabaja los datos del usuario (login, logout, creación y eliminación del mismo).

Las entidades son las siguientes:
- Equipo
- Pelota
- Jugador
- Usuario
- User
- UserRole

A su vez, existen las capas de servicio (interfaz e implementación) y repositorio para interactuar con la base de datos.

En cuanto a base de datos, los datos son insertados con un archivo semilla llamado "import.sql".

Finalmente, quedan adjuntados los diagramas de clases y de entidad-relación para entender como interactúan los objetos entre sí. El nombre de esos archivos son "DER.jpg" y "Diagrama de Clases.jpg".

TESTS

Los tests fueron cubiertos en un 94% de su totalidad, incluyendo controladores, servicios, entidades y modelos, entre otras.
