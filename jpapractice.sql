-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 06, 2020 at 08:35 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jpapractice`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `AUTHOR_ID` int(11) NOT NULL,
  `AUTHOR_NAME` varchar(40) NOT NULL,
  `AGE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`AUTHOR_ID`, `AUTHOR_NAME`, `AGE`) VALUES
(1, 'John', 22),
(9, 'Abraham', 25);

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

CREATE TABLE `blog` (
  `BLOG_ID` int(11) NOT NULL,
  `BLOG_NAME` varchar(30) NOT NULL,
  `READ_TIME` int(11) NOT NULL,
  `REVIEW` int(11) NOT NULL,
  `AUTHOR_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`BLOG_ID`, `BLOG_NAME`, `READ_TIME`, `REVIEW`, `AUTHOR_ID`) VALUES
(1, 'blog1', 2, 4, 1),
(10, 'Blog2', 4, 5, 9),
(11, 'Blog3', 3, 4, 9),
(12, 'Blog4', 2, 3, 9);

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `CAR_ID` int(11) NOT NULL,
  `CAR_NAME` varchar(30) NOT NULL,
  `MODEL` int(11) NOT NULL,
  `REGISTRATION_NUMBER` varchar(30) NOT NULL,
  `OWNER_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`CAR_ID`, `CAR_NAME`, `MODEL`, `REGISTRATION_NUMBER`, `OWNER_ID`) VALUES
(1, 'WAGON R', 2020, 'KL082020', 1),
(7, 'Crecta', 2019, 'KL09A2019', 7);

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `PERSON_ID` int(11) NOT NULL,
  `PERSON_NAME` varchar(40) NOT NULL,
  `AGE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`PERSON_ID`, `PERSON_NAME`, `AGE`) VALUES
(1, 'JOHN', 24),
(7, 'Abraham', 22);

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `POST_ID` int(11) NOT NULL,
  `POST_NAME` varchar(30) NOT NULL,
  `RATING` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`POST_ID`, `POST_NAME`, `RATING`) VALUES
(1, 'CORE JAVA', 0),
(2, 'sPRING-DATA-JPA', 0),
(3, 'Kafka', 4);

-- --------------------------------------------------------

--
-- Table structure for table `post_tags`
--

CREATE TABLE `post_tags` (
  `POST_ID` int(11) NOT NULL,
  `TAG_ID` int(11) NOT NULL,
  `IS_ACTIVE` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `post_tags`
--

INSERT INTO `post_tags` (`POST_ID`, `TAG_ID`, `IS_ACTIVE`) VALUES
(1, 1, 1),
(1, 2, 1),
(3, 3, 0),
(3, 4, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tag`
--

CREATE TABLE `tag` (
  `TAG_ID` int(11) NOT NULL,
  `TAG_NAME` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tag`
--

INSERT INTO `tag` (`TAG_ID`, `TAG_NAME`) VALUES
(1, 'Technology'),
(2, 'Software'),
(3, 'Developer'),
(4, 'Kafka Messaging');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`AUTHOR_ID`);

--
-- Indexes for table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`BLOG_ID`),
  ADD KEY `AUTHOR_ID` (`AUTHOR_ID`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`CAR_ID`),
  ADD KEY `OWNER_ID` (`OWNER_ID`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`PERSON_ID`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`POST_ID`);

--
-- Indexes for table `post_tags`
--
ALTER TABLE `post_tags`
  ADD PRIMARY KEY (`POST_ID`,`TAG_ID`),
  ADD KEY `TAG_ID` (`TAG_ID`);

--
-- Indexes for table `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`TAG_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `AUTHOR_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `blog`
--
ALTER TABLE `blog`
  MODIFY `BLOG_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
  MODIFY `CAR_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `PERSON_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `POST_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tag`
--
ALTER TABLE `tag`
  MODIFY `TAG_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`AUTHOR_ID`) REFERENCES `author` (`AUTHOR_ID`);

--
-- Constraints for table `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `car_ibfk_1` FOREIGN KEY (`OWNER_ID`) REFERENCES `person` (`PERSON_ID`);

--
-- Constraints for table `post_tags`
--
ALTER TABLE `post_tags`
  ADD CONSTRAINT `post_tags_ibfk_1` FOREIGN KEY (`POST_ID`) REFERENCES `post` (`POST_ID`),
  ADD CONSTRAINT `post_tags_ibfk_2` FOREIGN KEY (`TAG_ID`) REFERENCES `tag` (`TAG_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
