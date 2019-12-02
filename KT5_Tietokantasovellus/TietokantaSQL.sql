-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: sql7.freemysqlhosting.net
-- Generation Time: 02.12.2019 klo 17:11
-- Palvelimen versio: 5.5.58-0ubuntu0.14.04.1
-- PHP Version: 7.0.33-0ubuntu0.16.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sql7313943`
--

-- --------------------------------------------------------

--
-- Rakenne taululle `Eläin`
--

CREATE TABLE `Eläin` (
  `EläinID` int(11) NOT NULL,
  `Nimi` varchar(25) NOT NULL,
  `Rotu` varchar(25) NOT NULL,
  `Ikä` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Vedos taulusta `Eläin`
--

INSERT INTO `Eläin` (`EläinID`, `Nimi`, `Rotu`, `Ikä`) VALUES
(1, 'Musti', 'Chihuahua', '9'),
(2, 'Nöpö', 'Mäyräkoira', '1'),
(3, 'Milo', 'Kääpiöluppakani', '5');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Eläin`
--
ALTER TABLE `Eläin`
  ADD PRIMARY KEY (`EläinID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Eläin`
--
ALTER TABLE `Eläin`
  MODIFY `EläinID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
