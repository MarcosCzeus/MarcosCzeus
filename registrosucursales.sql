-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 27-09-2023 a las 05:49:19
-- Versión del servidor: 10.10.2-MariaDB
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `primecinema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrosucursales`
--

DROP TABLE IF EXISTS `registrosucursales`;
CREATE TABLE IF NOT EXISTS `registrosucursales` (
  `NombreDeSucursal` varchar(25) NOT NULL,
  `NombreGerente` varchar(50) NOT NULL,
  `DireccionSucursal` varchar(50) NOT NULL,
  `NumTelefonico` int(8) NOT NULL,
  `CodigoSucursal` int(8) NOT NULL,
  PRIMARY KEY (`CodigoSucursal`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
