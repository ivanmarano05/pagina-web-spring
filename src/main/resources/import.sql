INSERT INTO `pelota` (`id`,`nombre`,`imagen`) VALUES (1,"Tango","tango.jpg");
INSERT INTO `pelota` (`id`,`nombre`,`imagen`) VALUES (2,"Jabulani","jabulani.jpg");
INSERT INTO `pelota` (`id`,`nombre`,`imagen`) VALUES (3,"Al Rihla","al rihla.jpg");

INSERT INTO `usuario` (`id`,`nombre`) VALUES (1,'ivo');
INSERT INTO `usuario` (`id`,`nombre`) VALUES (2,'martu');
INSERT INTO `usuario` (`id`,`nombre`) VALUES (3,'pepe');
INSERT INTO `usuario` (`id`,`nombre`) VALUES (4,'tito');

INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (1,"Emiliano Martinez","arquero","Argentina");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (2,"Manuel Neuer","arquero","Alemania");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (3,"Trent Alexander-Arnold","defensor","Inglaterra");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (4,"Matty Cash","defensor","Polonia");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (5,"Eder Militao","defensor","Brasil");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (6,"Raphael Varane","defensor","Francia");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (7,"Virgil Van Dijk","defensor","Holanda");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (8,"Diego Godin","defensor","Uruguay");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (9,"Jordi Alba","defensor","España");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (10,"Nicolas Tagliafico","defensor","Argentina");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (11,"Kevin De Bruyne","mediocampista","Belgica");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (12,"Aaron Ramsey","mediocampista","Gales");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (13,"Moises Caicedo","mediocampista","Ecuador");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (14,"Sergio Busquets","mediocampista","España");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (15,"Bruno Fernandes","mediocampista","Portugal");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (16,"Frenkie De Jong","mediocampista","Holanda");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (17,"Gareth Bale","delantero","Gales");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (18,"Lionel Messi","delantero","Argentina");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (19,"Karim Benzema","delantero","Francia");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (20,"Mehdi Taremi","delantero","Iran");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (21,"Neymar","delantero","Brasil");
INSERT INTO `jugador` (`id`,`nombre`,`posicion`,`pais`) VALUES (22,"Rafael Leao","delantero","Portugal");

INSERT INTO `equipo` (`id`,`nombre`,`pelota_id`,`usuario_id`) VALUES (1,"Fulminadores",1,1);
INSERT INTO `equipo` (`id`,`nombre`,`pelota_id`,`usuario_id`) VALUES (2,"Juego Lirico",2,2);

INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (1,1);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (1,3);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (1,5);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (1,7);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (1,9);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (1,11);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (1,13);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (1,15);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (1,17);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (1,19);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (1,21);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (2,2);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (2,4);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (2,6);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (2,8);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (2,10);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (2,12);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (2,14);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (2,16);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (2,18);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (2,20);
INSERT INTO `equipo_jugador` (`id_equipo`,`id_jugador`) VALUES (2,22);

INSERT INTO `user` (`id`,`enabled`,`password`,`username`) VALUES (1,b'1','$2a$10$l06MQWwQQr95kfOLiM3H6eAoF78a0uRNIAynpVjtA48Y3coWFJe.m', 'ivo');
INSERT INTO `user` (`id`,`enabled`,`password`,`username`) VALUES (2,b'1','$2a$10$uLVE9Pn0Z/s6eAi7mWqwAuKTHtYFGBODVNKmNLuw/MNeblqn9ZXiK', 'martu');
INSERT INTO `user` (`id`,`enabled`,`password`,`username`) VALUES (3,b'1','$2a$10$vZGoonp1kYvV1wkuYZzd.eZyQz4VoAJVewgrY3v6to.3cuRkqhUum', 'pepe');
INSERT INTO `user` (`id`,`enabled`,`password`,`username`) VALUES (4,b'1','$2a$10$JCMZIhQy5O4gOc/bldOXheUs4QCBl1QawKWphu9cm7ozUAc.l7Bxu', 'tito');

INSERT INTO `user_role` (`id`,`role`,`user_id`) VALUES (1,"ROLE_ADMIN","1");
INSERT INTO `user_role` (`id`,`role`,`user_id`) VALUES (2,"ROLE_ADMIN","2");
INSERT INTO `user_role` (`id`,`role`,`user_id`) VALUES (3,"ROLE_USUARIO","3");
INSERT INTO `user_role` (`id`,`role`,`user_id`) VALUES (4,"ROLE_USUARIO","4");