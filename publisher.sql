-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2024 at 07:02 AM
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
-- Database: `publisher`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE `articles` (
  `article_id` bigint(20) NOT NULL,
  `contents` longtext DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `preview` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  `writer_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`article_id`, `contents`, `created_at`, `preview`, `title`, `updated_at`, `writer_id`) VALUES
(1, ' Lorem ipsum odor amet, consectetuer adipiscing elit. Donec in nisi in lectus tempor. At litora dolor maximus lacinia facilisis tempus sodales aliquet. Aliquam elit integer cubilia felis netus semper malesuada. Aefficitur lectus justo iaculis urna proin lacus. Eget himenaeos magna, dis litora et velit? Vivamus ut sollicitudin posuere libero; at aliquet rhoncus tincidunt. Congue mattis vel augue diam inceptos montes habitasse libero. Fringilla ac et, at dui aliquet inceptos consequat. Dapibus sodales pharetra aliquam urna habitasse tellus laoreet dignissim.\r\n\r\nPorttitor euismod lobortis nisi ad integer erat. Turpis lectus mollis lobortis a platea hac nisl enim erat. Aptent maximus sit pharetra nisi neque aliquet? Litora curabitur sagittis pharetra ut efficitur. Nulla sem ac justo cursus penatibus vehicula. Ultrices purus inceptos rhoncus, sodales quis viverra hac?', '2024-10-28', ' Lorem ipsum odor amet, consectetuer adipiscing el', 'TestArticle1Up', '2024-10-28', 3),
(2, ' Porttitor euismod lobortis nisi ad integer erat. Turpis lectus mollis lobortis a platea hac nisl enim erat. Aptent maximus sit pharetra nisi neque aliquet? Litora curabitur sagittis pharetra ut efficitur. Nulla sem ac justo cursus penatibus vehicula. Ultrices purus inceptos rhoncus, sodales quis viverra hac?\r\n\r\nMattis penatibus laoreet hendrerit sociosqu condimentum. Laoreet mollis nibh nec sagittis auctor vehicula ad rhoncus. Montes quam eget magna convallis vivamus urna pharetra etiam. Fringilla iaculis commodo ullamcorper varius lacus tellus, leo est. Curabitur nullam enim fermentum maximus a nostra inceptos porttitor ut. Varius et quis hac euismod blandit augue. Nam semper curae faucibus pellentesque vestibulum elementum? Elementum pellentesque justo suscipit dictum vivamus in suspendisse suscipit ante.', '2024-10-28', ' Porttitor euismod lobortis nisi ad integer erat. ', 'Test Article 2', '2024-10-28', 4),
(102, ' Adipiscing nec proin; semper torquent feugiat rutrum sagittis. Egestas ut habitant litora orci nostra varius dui diam. Aliquam dis rutrum imperdiet parturient sapien primis. Curae risus amet volutpat mi at mollis. Nisi praesent at scelerisque nisl diam nascetur. Enim condimentum arcu ornare cras a dictum. Quisque posuere lectus finibus, risus consequat ridiculus.\r\n\r\nSemper dapibus ullamcorper libero lobortis gravida, congue tincidunt. Cursus fermentum hac lectus litora morbi nisl adipiscing elementum imperdiet. Nibh amet imperdiet imperdiet non odio montes dolor eu. Vel nibh vitae sapien; suscipit nascetur suscipit. Morbi pellentesque ultricies commodo molestie finibus eget ipsum quis. Consectetur mus efficitur inceptos ex nullam hendrerit magnis posuere nec. Integer massa condimentum tempor per praesent! Porta nascetur lectus turpis inceptos turpis phasellus.', '2024-10-29', ' Adipiscing nec proin; semper torquent feugiat rut', 'TestArticle3', '2024-10-29', 4);

-- --------------------------------------------------------

--
-- Table structure for table `articles_seq`
--

CREATE TABLE `articles_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `articles_seq`
--

INSERT INTO `articles_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Table structure for table `subscriptions`
--

CREATE TABLE `subscriptions` (
  `id` bigint(20) NOT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subscriptions`
--

INSERT INTO `subscriptions` (`id`, `article_id`, `customer_id`) VALUES
(153, 2, 3),
(203, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `subscriptions_seq`
--

CREATE TABLE `subscriptions_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subscriptions_seq`
--

INSERT INTO `subscriptions_seq` (`next_val`) VALUES
(301);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `account_status` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `updated_at` date DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `account_status`, `created_at`, `email`, `password`, `role`, `updated_at`, `user_name`) VALUES
(1, 'active', '2024-10-28', 'test@nnUp.com', '$2a$10$7pnXnMvJmK/YJ5bAnioKQuoUwQy3YkO8HeSrU5CmgsCF06GuAIe8.', 'USER', '2024-10-29', 'testUser1U'),
(2, 'active', '2024-10-28', 'test2@test.com', '$2a$10$DbC1S5hzneEEjSRD4ygUieS2WP2dofPEeWvbM62Mr012M39L8ue/y', 'USER', '2024-10-28', 'testUser2'),
(3, 'active', '2024-10-28', 'writer1@test.com', '$2a$10$az.NNNLoLAa6HncWqUhk/OTeUpW6nEL76jxnooqRFlePcpKrssZ46', 'WRITER', '2024-10-28', 'testWriter1'),
(4, 'active', '2024-10-28', 'writer2@test.com', '$2a$10$4rVzHwwFG.KOYHFxBjFkSOw5TWVZsb3/g88zhIKFb.3R0TWahEy0.', 'WRITER', '2024-10-28', 'testWriter2'),
(5, 'active', '2024-10-28', 'admin@nn.com', '$2a$10$v/nBh7Zit1clkmofOuFAoebJOPt9NFmAuD5tMIVTMXBNew3RUhZVm', 'ADMIN', '2024-10-28', 'testAdmin');

-- --------------------------------------------------------

--
-- Table structure for table `users_seq`
--

CREATE TABLE `users_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users_seq`
--

INSERT INTO `users_seq` (`next_val`) VALUES
(201);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`article_id`),
  ADD KEY `FK644er7xp7rhsph62i3v9yqom8` (`writer_id`);

--
-- Indexes for table `subscriptions`
--
ALTER TABLE `subscriptions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7t4orvqtmv58o6yiofq7rc5yf` (`article_id`),
  ADD KEY `FK3bkdy5i21dwrpthg07h9vnyhs` (`customer_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `FK644er7xp7rhsph62i3v9yqom8` FOREIGN KEY (`writer_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `subscriptions`
--
ALTER TABLE `subscriptions`
  ADD CONSTRAINT `FK3bkdy5i21dwrpthg07h9vnyhs` FOREIGN KEY (`customer_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `FK7t4orvqtmv58o6yiofq7rc5yf` FOREIGN KEY (`article_id`) REFERENCES `articles` (`article_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
