-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307:3307
-- Generation Time: Nov 23, 2023 at 03:43 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ddpg`
--

-- --------------------------------------------------------

--
-- Table structure for table `consultas`
--

CREATE TABLE `consultas` (
  `Id_Consulta` int(11) NOT NULL,
  `Id_Paciente` int(11) NOT NULL,
  `Horario` varchar(200) NOT NULL,
  `Data_Consulta` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `consultas`
--

INSERT INTO `consultas` (`Id_Consulta`, `Id_Paciente`, `Horario`, `Data_Consulta`) VALUES
(1, 1, '20:30', '03/20/2023'),
(2, 3, '20:30', '20/04/2023'),
(3, 2, '20:45', '02/02/2004'),
(4, 1, '20:30', '02/04/2024'),
(5, 1, '20:00', '01/04/2004'),
(6, 1, '20:00', '04/04/2022');

-- --------------------------------------------------------

--
-- Table structure for table `funcionario`
--

CREATE TABLE `funcionario` (
  `Id_Funcionario` int(11) NOT NULL,
  `Nome` varchar(200) NOT NULL,
  `Cargo` varchar(100) NOT NULL,
  `CPF` varchar(100) NOT NULL,
  `Senha` varchar(200) NOT NULL,
  `Email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `funcionario`
--

INSERT INTO `funcionario` (`Id_Funcionario`, `Nome`, `Cargo`, `CPF`, `Senha`, `Email`) VALUES
(1, 'Julnei', 'Ortopedista', '123.532.424-32', '12345', 'julnei@ddpg.com'),
(2, 'Luzinete', 'Secretaria', '134.342.224-72', '12345', 'luzinete@ddpg.com');

-- --------------------------------------------------------

--
-- Table structure for table `pacientes`
--

CREATE TABLE `pacientes` (
  `Id_Paciente` int(11) NOT NULL,
  `Nome_Completo` varchar(200) NOT NULL,
  `CPF` varchar(150) NOT NULL,
  `Email` varchar(150) NOT NULL,
  `Telefone` varchar(200) NOT NULL,
  `Cidade` varchar(200) NOT NULL,
  `Data_Nascimento` varchar(200) NOT NULL,
  `Historico_Medico` varchar(255) NOT NULL,
  `Historico_Cirurgico` varchar(255) NOT NULL,
  `Alergias` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pacientes`
--

INSERT INTO `pacientes` (`Id_Paciente`, `Nome_Completo`, `CPF`, `Email`, `Telefone`, `Cidade`, `Data_Nascimento`, `Historico_Medico`, `Historico_Cirurgico`, `Alergias`) VALUES
(1, 'Julia', '143.432.523-34', 'guga@gmail.com', '(21) 98523-1235', 'Rio de Janeiro', '1 de Abril', 'TDAH', 'Nenhuma', 'Nenhuma'),
(2, 'Jurema', '143.432.523-34', 'guga@gmail.com', '(21) 98523-1235', 'Rio de Janeiro', '1 de Abril', 'TDAH', 'Nenhuma', 'Nenhuma'),
(3, 'Geraldo', '123.423.545-34', 'geraldO@gmail.com', '(21) 94245-2342', 'Rio de Janerio', '09/07/2002', 'Nenhuma', 'Nenhuma', 'Nenhuma'),
(7, 'Gustavo', '123123123', '12312312w3', '1231212312', 'Rio de Janeiro ', '01/04/2004', 'Autismo', 'Cranio', 'Amendoim'),
(8, 'Gustavo1', '1231231', '231231', '231231', '231231', '23123', '12312312312', '3123', '123123'),
(9, 'Gustavo', '178.610.237-45', 'gugatascheri@gmail.com', '(21) 98581-9889', 'Rio de Janeiro', '01/04/2004', 'asda', 'sdasd', 'asda');

-- --------------------------------------------------------

--
-- Table structure for table `prontuario`
--

CREATE TABLE `prontuario` (
  `Id_Prontuario` int(11) NOT NULL,
  `Id_Paciente` int(11) NOT NULL,
  `Diagnostico` varchar(255) NOT NULL,
  `Retorno` varchar(200) NOT NULL,
  `Remedios_Prescritos` varchar(255) NOT NULL,
  `Id_Consulta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `prontuario`
--

INSERT INTO `prontuario` (`Id_Prontuario`, `Id_Paciente`, `Diagnostico`, `Retorno`, `Remedios_Prescritos`, `Id_Consulta`) VALUES
(2, 2, 'Domingo a noite', 'Ritalina', 'Sim', 1),
(3, 1, 'Bico da Papagaia', 'Sim', 'Ritalina', 1),
(5, 1, 'Bico de papagaio', '02/04/2004', 'Ritalina', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consultas`
--
ALTER TABLE `consultas`
  ADD PRIMARY KEY (`Id_Consulta`),
  ADD KEY `Id_Paciente` (`Id_Paciente`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`Id_Funcionario`);

--
-- Indexes for table `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`Id_Paciente`);

--
-- Indexes for table `prontuario`
--
ALTER TABLE `prontuario`
  ADD PRIMARY KEY (`Id_Prontuario`),
  ADD KEY `Id_Paciente` (`Id_Paciente`),
  ADD KEY `Id_Consulta` (`Id_Consulta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consultas`
--
ALTER TABLE `consultas`
  MODIFY `Id_Consulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `Id_Funcionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `Id_Paciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `prontuario`
--
ALTER TABLE `prontuario`
  MODIFY `Id_Prontuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `consultas`
--
ALTER TABLE `consultas`
  ADD CONSTRAINT `consultas_ibfk_1` FOREIGN KEY (`Id_Paciente`) REFERENCES `pacientes` (`Id_Paciente`);

--
-- Constraints for table `prontuario`
--
ALTER TABLE `prontuario`
  ADD CONSTRAINT `prontuario_ibfk_1` FOREIGN KEY (`Id_Paciente`) REFERENCES `pacientes` (`Id_Paciente`),
  ADD CONSTRAINT `prontuario_ibfk_2` FOREIGN KEY (`Id_Consulta`) REFERENCES `consultas` (`Id_Consulta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
