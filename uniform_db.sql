-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 
-- サーバのバージョン： 5.5.39
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uniform_db`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `admin_info`
--

CREATE TABLE `admin_info` (
  `user_id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `admin_info`
--

INSERT INTO `admin_info` (`user_id`, `password`) VALUES
('test', 'test');

-- --------------------------------------------------------

--
-- テーブルの構造 `order_info`
--

CREATE TABLE `order_info` (
  `order_id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(264) NOT NULL,
  `address` varchar(100) NOT NULL,
  `tel_number` varchar(20) NOT NULL,
  `uniform_id` varchar(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `message` varchar(200) NOT NULL,
  `payment` varchar(20) NOT NULL,
  `send` varchar(20) NOT NULL,
  `order_date` date NOT NULL,
  `order_time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- テーブルの構造 `uniform_info`
--

CREATE TABLE `uniform_info` (
  `uniform_id` varchar(20) NOT NULL,
  `type` varchar(100) NOT NULL,
  `stock` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `uniform_info`
--

INSERT INTO `uniform_info` (`uniform_id`, `type`, `stock`, `price`) VALUES
('1', 'ユニフォームA', 5, 10000),
('2', 'ユニフォームB', 50, 5000),
('3', 'ユニフォームC', 100, 2000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_info`
--
ALTER TABLE `admin_info`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `order_info`
--
ALTER TABLE `order_info`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `foreign_key` (`uniform_id`);

--
-- Indexes for table `uniform_info`
--
ALTER TABLE `uniform_info`
  ADD PRIMARY KEY (`uniform_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `order_info`
--
ALTER TABLE `order_info`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- ダンプしたテーブルの制約
--

--
-- テーブルの制約 `order_info`
--
ALTER TABLE `order_info`
  ADD CONSTRAINT `foreign_key` FOREIGN KEY (`uniform_id`) REFERENCES `uniform_info` (`uniform_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
