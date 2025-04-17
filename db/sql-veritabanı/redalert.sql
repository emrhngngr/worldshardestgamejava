-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2024 at 03:05 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `redalert`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`) VALUES
(33, 'a', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
(34, 'b', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
(36, 'qaa', 'b0e9dc663382addcc0d7bb0813e6df9c6de6ca63254a14e910ab462b4bab1cc9'),
(37, 'e', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3'),
(38, 'rec', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3');

-- --------------------------------------------------------

--
-- Table structure for table `userstats`
--

CREATE TABLE `userstats` (
  `stat_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `time` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `userstats`
--

INSERT INTO `userstats` (`stat_id`, `user_id`, `time`) VALUES
(10, 33, 7.216666666666646),
(11, 33, 16.0833333333337),
(12, 34, 29.98333333333291),
(13, 33, 30.79999999999953),
(14, 33, 39.249999999999055),
(15, 33, 42.049999999998896),
(16, 34, 45.866666666665346),
(17, 36, 30.433333333332886),
(18, 34, 29.04999999999963),
(19, 34, 30.599999999999543),
(20, 34, 30.233333333332897),
(21, 33, 28.999999999999634),
(22, 37, 27.049999999999745),
(23, 37, 27.049999999999745),
(24, 37, 27.049999999999745),
(25, 33, 26.71666666666643),
(26, 33, 26.24999999999979),
(27, 33, 27.099999999999742),
(28, 38, 25.799999999999816),
(29, 33, 26.13333333333313),
(30, 33, 27.133333333333074),
(31, 33, 27.53333333333305),
(32, 33, 26.349999999999785),
(33, 33, 26.383333333333116),
(34, 33, 37.48333333333249),
(35, 37, 41.53333333333226),
(36, 37, 33.683333333332705),
(37, 37, 28.89999999999964);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `userstats`
--
ALTER TABLE `userstats`
  ADD PRIMARY KEY (`stat_id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `userstats`
--
ALTER TABLE `userstats`
  MODIFY `stat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `userstats`
--
ALTER TABLE `userstats`
  ADD CONSTRAINT `userstats_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
