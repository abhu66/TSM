-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 30 Sep 2019 pada 05.48
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `translator_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `contact` varchar(15) DEFAULT NULL,
  `pic` varchar(50) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `created_date` date NOT NULL,
  `updated_date` date DEFAULT NULL,
  `created_by` varchar(30) NOT NULL,
  `updated_by` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `client`
--

INSERT INTO `client` (`id`, `name`, `contact`, `pic`, `address`, `created_date`, `updated_date`, `created_by`, `updated_by`) VALUES
(1, 'PT.ABCD EFGHI JKLMN', '081218209581', 'ABU KHOERUL ISKANDAR ALI', 'JL. PETA BARAT NO.60 KALIDERES JAKARTA BARAT', '2019-08-28', '2019-08-28', 'admin', 'admin'),
(2, 'PT. OPQR STUV WXY', '081218209580', 'OSVALDO ERENS', 'DEPOK CIMANGGIS', '2019-08-28', '2019-09-11', 'admin', 'admin'),
(3, 'PT. ABCD ABCD', '081218209588', 'ADNAN PUTRA', 'CIBUBUR', '2019-08-28', '2019-08-28', 'admin', 'admin'),
(4, 'PT. AMAN SEJAHTERA', '02154355431', 'ANDRE', 'JAKARTA SELATAN', '2019-09-08', '2019-09-08', 'admin', 'admin'),
(5, 'CHRISTIAN', '081218209581', 'CHRISTIAN', 'MALANG EAST JAVA', '2019-09-16', '2019-09-16', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `languages`
--

CREATE TABLE `languages` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `created_date` date NOT NULL,
  `updated_date` date DEFAULT NULL,
  `created_by` varchar(30) NOT NULL,
  `updated_by` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `languages`
--

INSERT INTO `languages` (`id`, `name`, `description`, `created_date`, `updated_date`, `created_by`, `updated_by`) VALUES
(1, 'AHMARIC-ENG', 'AHMARIC TO ENGLISH', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(2, 'ENG-AHMARIC', 'ENGLISH TO AHMARIC', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(3, 'AHMARIC-INA', 'AHMARIC TO BAHASA', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(4, 'INA-AHMARIC', 'BAHASA TO AHMARIC', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(5, 'ARABIC-ENG', 'ARABIC TO ENGLISH', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(6, 'ENG-ARABIC', 'ENGLISH TO ARABIC', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(7, 'ARABIC-INA', 'ARABIC TO BAHASA', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(8, 'INA-ARABIC', 'BAHASA TO ARABIC', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(9, 'ABKHAZIAN-ENG', 'ABKHAZIAN TO ENGLISH', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(10, 'ENG-ABKHAZIAN', 'ENGLISH TO ABKHAZIAN', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(11, 'ABKHAZIAN-INA', 'ABKHAZIAN TO BAHASA', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(12, 'INA-ABKHAZIAN', 'BAHASA TO ABKHAZIAN', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(13, 'ACHOLI-ENG', 'ACHOLI TO ENGLISH', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(14, 'ENG-ACHOLI', 'ENGLISH TO ACHOLI', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(15, 'ACHOLI-INA', 'ACHOLI TO BAHASA', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(16, 'INA-ACHOLI', 'BAHASA TO ACHOLI', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(17, 'AFAR-ENG', 'AFAR TO ENGLISH', '2019-09-30', '2019-09-30', 'admin', 'admin'),
(18, 'ENG-AFAR', 'ENGLISH TO AFAR', '2019-09-30', '2019-09-30', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `order_client`
--

CREATE TABLE `order_client` (
  `id` int(11) NOT NULL,
  `project_number` int(11) NOT NULL,
  `date_order` date NOT NULL,
  `client_id` int(11) NOT NULL,
  `order_type` varchar(15) DEFAULT NULL,
  `language` int(11) NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `qty` enum('Page','Word') NOT NULL,
  `qty_value` int(11) DEFAULT NULL,
  `rate` enum('IDR','USD') NOT NULL,
  `rate_value` double NOT NULL,
  `deadline_client` enum('Date','Time') NOT NULL,
  `deadline_client_value` varchar(30) DEFAULT NULL,
  `translator_id` int(11) DEFAULT NULL,
  `translator_deadline` enum('Date','Time') NOT NULL,
  `translator_deadline_value` varchar(30) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  `created_date` date NOT NULL,
  `updated_date` date DEFAULT NULL,
  `created_by` varchar(30) NOT NULL,
  `updated_by` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `translator`
--

CREATE TABLE `translator` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `contact` varchar(15) DEFAULT NULL,
  `created_date` date NOT NULL,
  `updated_date` date DEFAULT NULL,
  `created_by` varchar(30) NOT NULL,
  `updated_by` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `translator`
--

INSERT INTO `translator` (`id`, `name`, `contact`, `created_date`, `updated_date`, `created_by`, `updated_by`) VALUES
(1, 'DIDI SISWANDI', '089675116160', '2019-08-31', '2019-08-31', 'admin', 'admin'),
(2, 'AGUNG', '081218209581', '2019-08-31', '2019-08-31', 'admin', 'admin'),
(3, 'ANA MARIANAS', '08778787134', '2019-08-31', '2019-09-11', 'admin', 'admin'),
(4, 'RITAS', '089675116160', '2019-08-31', '2019-09-11', 'admin', 'admin'),
(5, 'ANGGITA WULANDARI', '08121209582', '2019-09-08', '2019-09-08', 'admin', 'admin'),
(6, 'NEIDA SHINTIA', '089675116160', '2019-09-11', '2019-09-11', 'admin', 'admin'),
(7, 'GILANG', '08128292929', '2019-09-16', '2019-09-16', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('admin','employee') NOT NULL,
  `created_date` date NOT NULL,
  `updated_date` date DEFAULT NULL,
  `created_by` varchar(30) NOT NULL,
  `updated_by` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `name`, `username`, `password`, `role`, `created_date`, `updated_date`, `created_by`, `updated_by`) VALUES
(1, 'admin', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', '2019-08-28', '2019-08-28', 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `languages`
--
ALTER TABLE `languages`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indeks untuk tabel `order_client`
--
ALTER TABLE `order_client`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `translator`
--
ALTER TABLE `translator`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `client`
--
ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `languages`
--
ALTER TABLE `languages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT untuk tabel `order_client`
--
ALTER TABLE `order_client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `translator`
--
ALTER TABLE `translator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
