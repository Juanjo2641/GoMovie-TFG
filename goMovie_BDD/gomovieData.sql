INSERT INTO `peliculas` (`id_pelicula`, `foto`, `nombre`, `descripcion`, `duracion`, `precio`, `stock`, `rebaja`, `descatalogado`, `id_genero`) VALUES
(1, '../../../assets/img/peliculas/1.webp', 'El Padrino', 'La familia Corleone lucha por mantener su poder en Nueva York.','2 horas y 55 minutos', 10.99, 50, 0, 0, 2),
(2, '../../../assets/img/peliculas/2.jpg', 'Titanic', 'Un joven pobre y una joven rica se enamoran a bordo del Titanic, el barco más grande y lujoso del mundo.', '3 horas y 14 minutos', 8.99, 75, 0, 0, 2),
(3, '../../../assets/img/peliculas/3.jpg', 'La La Land', 'Una actriz y un músico se enamoran en Los Ángeles mientras persiguen sus sueños.', '2 horas y 8 minutos', 12.99, 25, 0, 0, 3),
(4, '../../../assets/img/peliculas/4.jpg', 'Forrest Gump', 'La vida de Forrest Gump, un hombre con discapacidad intelectual, y su influencia en la historia de Estados Unidos.', '2 horas y 22 minutos', 9.99, 60, 0, 0, 4),
(5, '../../../assets/img/peliculas/5.jpeg', 'El Rey León', 'Simba, un joven león, debe enfrentarse a su malvado tío Scar para reclamar su lugar como rey de la selva.', '1 hora y 28 minutos', 7.99, 100, 0, 0, 5),
(6, '../../../assets/img/peliculas/6.webp', 'Harry Potter y la Piedra Filosofal', 'Harry Potter descubre que es un mago y comienza su educación en Hogwarts, la escuela de magia y hechicería.', '2 horas y 32 minutos', 11.99, 40, 0, 0, 1),
(7, '../../../assets/img/peliculas/7.jpg', 'El Señor de los Anillos: La Comunidad del Anillo', 'Frodo Bolsón y un grupo de amigos emprenden un peligroso viaje para destruir un anillo mágico que amenaza el mundo.', '2 horas y 58 minutos', 13.99, 30, 0, 0, 1),
(8, '../../../assets/img/peliculas/8.jpg', 'Star Wars: Episodio IV - Una Nueva Esperanza', 'Un joven granjero llamado Luke Skywalker se une a la lucha contra el Imperio Galáctico con la ayuda de un jedi y un contrabandista.', '2 horas y 5 minutos', 10.99, 50, 0, 0, 6),
(9, '../../../assets/img/peliculas/9.jpg', 'Avatar', 'Un ex-marine condenado a vivir en una silla de ruedas, sigue siendo, a pesar de ello, un auténtico guerrero.', '2 horas y 40 minutos', 15.99, 90, 0, 0, 1),
(10, '../../../assets/img/peliculas/10.jpg', "Lo que el viento se llevó", "En la elegante mansión sureña de Tara, vive Scarlett O'Hara, la joven más bella, caprichosa y egoísta de la región.", '3 horas y 58 minutos', 9.99, 15, 0, 0, 2),
(11, '../../../assets/img/peliculas/11.jpg', 'El castillo ambulante', 'Narra la historia de Sophie, una joven sobre la que pesa una horrible maldición que le confiere el aspecto de una anciana.', '1 horas y 59 minutos', 20.99, 70, 0, 0, 3),
(12, '../../../assets/img/peliculas/12.jpg', 'Ghost. Más allá del amor', 'Una pareja de enamorados ve truncada su felicidad cuando él es asesinado por un ladrón.', '2 horas y 1 minuto', 17.99, 90, 0, 0, 3),
(13, '../../../assets/img/peliculas/13.jpg', 'Shrek', 'Hace mucho tiempo, en una lejanísima ciénaga, vivía un feroz ogro llamado Shrek.', '1 hora y 27 minutos', 28.99, 20, 0, 0, 4),
(14, '../../../assets/img/peliculas/14.jpg', 'Solo en casa', 'Kevin McAllister es un niño de ocho años, miembro de una familia numerosa, que accidentalmente se queda abandonado en su casa.', '1 hora y 40 minutos', 11.99, 20, 0, 0, 4),
(15, '../../../assets/img/peliculas/15.jpg', 'Bolt', 'Para el super-perro Bolt todos los días están llenos de aventuras, peligros e intriga, al menos hasta que las cámaras dejan de grabar.', '1 hora y 36 minutos', 13.99, 90, 0, 0, 5),
(16, '../../../assets/img/peliculas/16.jpg', 'El Grinch', 'El Grinch es una especie de ogro verde que siempre ha vivido aislado en la cima de una montaña, en las afueras de Villa Quién.', '1 hora y 45 minutos', 9.99, 25, 0, 0, 5),
(17, '../../../assets/img/peliculas/17.jpg', 'Kill Bill: Volume 1', 'El día de su boda, una asesina profesional sufre el ataque de algunos miembros de su propia banda, que obedecen las órdenes de Bill.', '1 hora y 50 minutos', 19.99, 85, 0, 0, 6),
(18, '../../../assets/img/peliculas/18.jpg', 'Deadpool', 'Basado en el anti-héroe menos convencional de la Marvel, Deadpool narra el origen de un ex-operativo de la fuerzas especiales llamado Wade Wilson.', '1 hora y 46 minutos', 29.99, 100, 0, 0, 6);

INSERT INTO `generos` (`id_genero`, `nombre`) VALUES
(1, 'Fantasia'),
(2, 'Drama'),
(3, 'Romantico'),
(4, 'Comedia'),
(5, 'Infantil'),
(6, 'Accion');