-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-09-2024 a las 09:05:39
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbgestion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `buyer`
--

CREATE TABLE `buyer` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `age` int(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `buyer`
--

INSERT INTO `buyer` (`id`, `name`, `surname`, `age`) VALUES
(1, 'Juan', 'Pérez', 28),
(2, 'María', 'Gómez', 34),
(3, 'Carlos', 'López', 22),
(4, 'Ana', 'Martínez', 30),
(5, 'Luis', 'Hernández', 40),
(6, 'Sofía', 'Rodríguez', 25),
(7, 'Javier', 'García', 29),
(8, 'Laura', 'Fernández', 35),
(9, 'Diego', 'Jiménez', 31),
(10, 'Valentina', 'Morales', 27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `product`
--

INSERT INTO `product` (`id`, `category`, `name`, `price`) VALUES
(4, 'Electrónica', 'Smartphone Samsung', 600),
(5, 'Electrónica', 'Televisor LG', 400),
(6, 'Accesorios', 'Auriculares Sony', 150),
(7, 'Accesorios', 'Reloj Garmin', 250),
(8, 'Hogar', 'Cafetera Nespresso', 180),
(9, 'Hogar', 'Batidora Philips', 100),
(10, 'Muebles', 'Silla de Oficina', 300),
(11, 'Muebles', 'Escritorio IKEA', 250),
(12, 'Ropa', 'Zapatillas Nike', 120),
(13, 'Ropa deportiva', 'Camiseta Adidas', 40),
(14, 'Ropa', 'Pantalones Levi\'s', 60),
(15, 'Accesorios', 'Mochila Herschel', 70),
(16, 'Juguetes', 'Juguete LEGO', 50),
(17, 'Deportes', 'Bicicleta Trek', 500),
(18, 'Deportes', 'Pelota de Fútbol', 20);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `buyer`
--
ALTER TABLE `buyer`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `buyer`
--
ALTER TABLE `buyer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
