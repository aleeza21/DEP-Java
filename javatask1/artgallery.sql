-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Jul 10, 2024 at 11:03 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `artgallery`
--

-- --------------------------------------------------------

--
-- Table structure for table `artists`
--

CREATE TABLE `artists` (
  `artist_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `bio` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artists`
--

INSERT INTO `artists` (`artist_id`, `name`, `bio`) VALUES
(1, 'Aleeza Zaman', 'A profound artist with experience over 2 years in the art industry'),
(2, 'Alex ', 'An expert Artist from Uk'),
(3, 'Leonardo da Vinci', 'Italian polymath of the Renaissance whose areas of interest included invention, painting, sculpting, architecture, science, music, mathematics, engineering, literature, anatomy, geology, astronomy, botany, paleontology, and cartography.'),
(4, 'Vincent van Gogh', 'Dutch Post-Impressionist painter who is among the most famous and influential figures in Western art.');

-- --------------------------------------------------------

--
-- Table structure for table `art_pieces`
--

CREATE TABLE `art_pieces` (
  `art_piece_id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `artist_id` int(11) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `year` year(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `art_pieces`
--

INSERT INTO `art_pieces` (`art_piece_id`, `title`, `artist_id`, `description`, `year`) VALUES
(1, 'Sunset', 1, 'Beautiful scenery with sunset ', '2012'),
(2, 'Mona Lisa', 1, 'Iconic portrait of Lisa Gherardini, likely painted between 1503 and 1506.', '0000'),
(3, 'The Starry Night', 2, 'Depiction of the view from the east-facing window of his asylum room at Saint-Rémy-de-Provence.', '0000');

-- --------------------------------------------------------

--
-- Table structure for table `exhibitions`
--

CREATE TABLE `exhibitions` (
  `exhibition_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `exhibitions`
--

INSERT INTO `exhibitions` (`exhibition_id`, `name`, `start_date`, `end_date`, `description`) VALUES
(1, 'Sunflowers', '2015-10-01', '2015-10-19', 'Art exhibition for beautiful affection of people with the sunflower'),
(2, 'Masterpieces', '2025-01-01', '2025-03-31', 'An exhibition showcasing Leonardo da Vinci\'s greatest works.'),
(3, 'Night Sky', '2025-04-15', '2025-06-30', 'A collection highlighting Van Gogh\'s fascination with the night sky.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artists`
--
ALTER TABLE `artists`
  ADD PRIMARY KEY (`artist_id`);

--
-- Indexes for table `art_pieces`
--
ALTER TABLE `art_pieces`
  ADD PRIMARY KEY (`art_piece_id`),
  ADD KEY `artist_id` (`artist_id`);

--
-- Indexes for table `exhibitions`
--
ALTER TABLE `exhibitions`
  ADD PRIMARY KEY (`exhibition_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artists`
--
ALTER TABLE `artists`
  MODIFY `artist_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `art_pieces`
--
ALTER TABLE `art_pieces`
  MODIFY `art_piece_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `exhibitions`
--
ALTER TABLE `exhibitions`
  MODIFY `exhibition_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `art_pieces`
--
ALTER TABLE `art_pieces`
  ADD CONSTRAINT `art_pieces_ibfk_1` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`artist_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
