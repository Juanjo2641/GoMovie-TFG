-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-05-2023 a las 09:36:16
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gomovie`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles`
--

CREATE TABLE `detalles` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `total` double NOT NULL,
  `orden_id` int(11) DEFAULT NULL,
  `pelicula_id_pelicula` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generos`
--

CREATE TABLE `generos` (
  `id_genero` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `generos`
--

INSERT INTO `generos` (`id_genero`, `nombre`) VALUES
(1, 'Fantasia'),
(2, 'Drama'),
(3, 'Romantico'),
(4, 'Comedia'),
(5, 'Infantil'),
(6, 'Accion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenes`
--

CREATE TABLE `ordenes` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `fecha_creacion` datetime DEFAULT NULL,
  `fecha_recibida` datetime DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `total` double NOT NULL,
  `usuario_id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `id_pelicula` int(11) NOT NULL,
  `descatalogado` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `duracion` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` float NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `rebaja` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `id_genero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `peliculas`
--

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas_tags`
--

CREATE TABLE `peliculas_tags` (
  `id_pelicula` int(11) NOT NULL,
  `id_tag` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `peliculas_tags`
--

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_rol` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_rol`, `nombre`) VALUES
(1, 'USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tags`
--

CREATE TABLE `tags` (
  `id_tag` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tags`
--

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `apellido`, `direccion`, `dni`, `email`, `enabled`, `nombre`, `password`) VALUES
(1, 'Sanchez', NULL, NULL, 'hugo@g.com', b'0', 'Hugo', '$2a$04$GQl3Kkf0odPbWbPIi/6xZ.dgk8BotmCkx7lTT23iJip2898vm5Hui');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_roles`
--

CREATE TABLE `usuarios_roles` (
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios_roles`
--

INSERT INTO `usuarios_roles` (`id_usuario`, `id_rol`) VALUES
(1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdurdo71oa161lmmal7oeaor74` (`orden_id`),
  ADD KEY `FKqbsgr68hhvxr9q78oguv8m84f` (`pelicula_id_pelicula`);

--
-- Indices de la tabla `generos`
--
ALTER TABLE `generos`
  ADD PRIMARY KEY (`id_genero`);

--
-- Indices de la tabla `ordenes`
--
ALTER TABLE `ordenes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8ls94k8t8xgv61l6nu4yydft2` (`usuario_id_cliente`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id_pelicula`),
  ADD KEY `FKkmp5bgqii3j0y90q99y6xav0x` (`id_genero`);

--
-- Indices de la tabla `peliculas_tags`
--
ALTER TABLE `peliculas_tags`
  ADD PRIMARY KEY (`id_pelicula`,`id_tag`),
  ADD KEY `FKl7ppfval6poxf094t8ldkmhuf` (`id_tag`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `tags`
--
ALTER TABLE `tags`
  ADD PRIMARY KEY (`id_tag`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `UKkfsp0s1tflm1cwlj8idhqsad0` (`email`);

--
-- Indices de la tabla `usuarios_roles`
--
ALTER TABLE `usuarios_roles`
  ADD KEY `FKhcbndx0dnk4c3ww8jfg98k7el` (`id_rol`),
  ADD KEY `FKt5th9sao5wjukq9ij7154ktuw` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalles`
--
ALTER TABLE `detalles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `generos`
--
ALTER TABLE `generos`
  MODIFY `id_genero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `ordenes`
--
ALTER TABLE `ordenes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `id_pelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tags`
--
ALTER TABLE `tags`
  MODIFY `id_tag` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD CONSTRAINT `FKdurdo71oa161lmmal7oeaor74` FOREIGN KEY (`orden_id`) REFERENCES `ordenes` (`id`),
  ADD CONSTRAINT `FKqbsgr68hhvxr9q78oguv8m84f` FOREIGN KEY (`pelicula_id_pelicula`) REFERENCES `peliculas` (`id_pelicula`);

--
-- Filtros para la tabla `ordenes`
--
ALTER TABLE `ordenes`
  ADD CONSTRAINT `FK8ls94k8t8xgv61l6nu4yydft2` FOREIGN KEY (`usuario_id_cliente`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD CONSTRAINT `FKkmp5bgqii3j0y90q99y6xav0x` FOREIGN KEY (`id_genero`) REFERENCES `generos` (`id_genero`);

--
-- Filtros para la tabla `peliculas_tags`
--
ALTER TABLE `peliculas_tags`
  ADD CONSTRAINT `FK10v0kubkegr4mna91h6ft5in0` FOREIGN KEY (`id_pelicula`) REFERENCES `peliculas` (`id_pelicula`),
  ADD CONSTRAINT `FKl7ppfval6poxf094t8ldkmhuf` FOREIGN KEY (`id_tag`) REFERENCES `tags` (`id_tag`);

--
-- Filtros para la tabla `usuarios_roles`
--
ALTER TABLE `usuarios_roles`
  ADD CONSTRAINT `FKhcbndx0dnk4c3ww8jfg98k7el` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`),
  ADD CONSTRAINT `FKt5th9sao5wjukq9ij7154ktuw` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
