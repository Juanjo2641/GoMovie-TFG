
INSERT INTO `generos` (`id_genero`, `nombre`) VALUES
(1, 'Fantasia'),
(2, 'Drama'),
(3, 'Romantico'),
(4, 'Comedia'),
(5, 'Infantil'),
(6, 'Accion');


INSERT INTO `peliculas` (`id_pelicula`, `descatalogado`, `descripcion`, `duracion`, `foto`, `nombre`, `precio`, `puntuacion`, `rebaja`, `stock`, `id_genero`) VALUES
(1, 0, 'La familia Corleone lucha por mantener su poder en Nueva York.', '2 horas y 55 minutos', '../../../assets/img/peliculas/1.webp', 'El Padrino', 10.99, 0, 0, 50, 2),
(2, 0, 'Un joven pobre y una joven rica se enamoran a bordo del Titanic, el barco más grande y lujoso del mundo.', '3 horas y 14 minutos', '../../../assets/img/peliculas/2.jpg', 'Titanic', 8.99, 0, 0, 75, 2),
(3, 0, 'Una actriz y un músico se enamoran en Los Ángeles mientras persiguen sus sueños.', '2 horas y 8 minutos', '../../../assets/img/peliculas/3.jpg', 'La La Land', 12.99, 0, 0, 25, 3),
(4, 0, 'La vida de Forrest Gump, un hombre con discapacidad intelectual, y su influencia en la historia de Estados Unidos.', '2 horas y 22 minutos', '../../../assets/img/peliculas/4.jpg', 'Forrest Gump', 9.99, 0, 0, 60, 4),
(5, 0, 'Simba, un joven león, debe enfrentarse a su malvado tío Scar para reclamar su lugar como rey de la selva.', '1 hora y 28 minutos', '../../../assets/img/peliculas/5.jpeg', 'El Rey León', 7.99, 0, 0, 100, 5),
(6, 0, 'Harry Potter descubre que es un mago y comienza su educación en Hogwarts, la escuela de magia y hechicería.', '2 horas y 32 minutos', '../../../assets/img/peliculas/6.webp', 'Harry Potter y la Piedra Filosofal', 11.99, 0, 0, 40, 1),
(7, 0, 'Frodo Bolsón y un grupo de amigos emprenden un peligroso viaje para destruir un anillo mágico que amenaza el mundo.', '2 horas y 58 minutos', '../../../assets/img/peliculas/7.jpg', 'El Señor de los Anillos: La Comunidad del Anillo', 13.99, 0, 0, 30, 1),
(8, 0, 'Un joven granjero llamado Luke Skywalker se une a la lucha contra el Imperio Galáctico con la ayuda de un jedi y un contrabandista.', '2 horas y 5 minutos', '../../../assets/img/peliculas/8.jpg', 'Star Wars: Episodio IV - Una Nueva Esperanza', 10.99, 0, 0, 50, 6),
(9, 0, 'Un ex-marine condenado a vivir en una silla de ruedas, sigue siendo, a pesar de ello, un auténtico guerrero.', '2 horas y 40 minutos', '../../../assets/img/peliculas/9.jpg', 'Avatar', 15.99, 0, 0, 90, 1),
(10, 0, 'En la elegante mansión sureña de Tara, vive Scarlett O\'Hara, la joven más bella, caprichosa y egoísta de la región.', '3 horas y 58 minutos', '../../../assets/img/peliculas/10.jpg', 'Lo que el viento se llevó', 9.99, 0, 0, 15, 2),
(11, 0, 'Narra la historia de Sophie, una joven sobre la que pesa una horrible maldición que le confiere el aspecto de una anciana.', '1 horas y 59 minutos', '../../../assets/img/peliculas/11.jpg', 'El castillo ambulante', 20.99, 0, 0, 70, 3),
(12, 0, 'Una pareja de enamorados ve truncada su felicidad cuando él es asesinado por un ladrón.', '2 horas y 1 minuto', '../../../assets/img/peliculas/12.jpg', 'Ghost. Más allá del amor', 17.99, 0, 0, 90, 3),
(13, 0, 'Hace mucho tiempo, en una lejanísima ciénaga, vivía un feroz ogro llamado Shrek.', '1 hora y 27 minutos', '../../../assets/img/peliculas/13.jpg', 'Shrek', 28.99, 0, 0, 20, 4),
(14, 0, 'Kevin McAllister es un niño de ocho años, miembro de una familia numerosa, que accidentalmente se queda abandonado en su casa.', '1 hora y 40 minutos', '../../../assets/img/peliculas/14.jpg', 'Solo en casa', 11.99, 0, 0, 20, 4),
(15, 0, 'Para el super-perro Bolt todos los días están llenos de aventuras, peligros e intriga, al menos hasta que las cámaras dejan de grabar.', '1 hora y 36 minutos', '../../../assets/img/peliculas/15.jpg', 'Bolt', 13.99, 0, 0, 90, 5),
(16, 0, 'El Grinch es una especie de ogro verde que siempre ha vivido aislado en la cima de una montaña, en las afueras de Villa Quién.', '1 hora y 45 minutos', '../../../assets/img/peliculas/16.jpg', 'El Grinch', 9.99, 0, 0, 25, 5),
(17, 0, 'El día de su boda, una asesina profesional sufre el ataque de algunos miembros de su propia banda, que obedecen las órdenes de Bill.', '1 hora y 50 minutos', '../../../assets/img/peliculas/17.jpg', 'Kill Bill: Volume 1', 19.99, 0, 0, 85, 6),
(18, 0, 'Basado en el anti-héroe menos convencional de la Marvel, Deadpool narra el origen de un ex-operativo de la fuerzas especiales llamado Wade Wilson.', '1 hora y 46 minutos', '../../../assets/img/peliculas/18.jpg', 'Deadpool', 29.99, 0, 0, 100, 6);


INSERT INTO `peliculas_tags` (`id_pelicula`, `id_tag`) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 3),
(3, 4),
(4, 5),
(5, 4),
(5, 6),
(6, 7),
(7, 7),
(7, 8),
(8, 9),
(9, 10),
(10, 3),
(11, 7),
(12, 3),
(13, 8),
(13, 11),
(14, 12),
(14, 13),
(15, 6),
(15, 15),
(16, 11),
(16, 12),
(16, 13),
(17, 2),
(17, 14),
(18, 14),
(18, 15);

INSERT INTO `roles` (`id_rol`, `nombre`) VALUES
(1, 'USER');


INSERT INTO `tags` (`id_tag`, `nombre`) VALUES
(1, 'Mafia'),
(2, 'Crimen'),
(3, 'Drama romantico'),
(4, 'Musica'),
(5, ' Comedia romantica'),
(6, 'Animales'),
(7, 'Magia'),
(8, 'Fantasia medieval'),
(9, 'Aventura espacial'),
(10, 'Naturaleza'),
(11, 'Cuentos'),
(12, 'Cine familiar'),
(13, 'Navidad'),
(14, 'Venganza'),
(15, 'Superheroes');


INSERT INTO `usuarios` (`id_usuario`, `apellido`, `direccion`, `dni`, `email`, `enabled`, `nombre`, `password`) VALUES
(1, 'Sanchez', NULL, NULL, 'hugo@g.com', b'0', 'Hugo', '$2a$04$GQl3Kkf0odPbWbPIi/6xZ.dgk8BotmCkx7lTT23iJip2898vm5Hui');

INSERT INTO `usuarios_roles` (`id_usuario`, `id_rol`) VALUES
(1, 1);

