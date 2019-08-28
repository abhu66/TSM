-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Agu 2019 pada 11.18
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
(2, 'PT. OPQR STUV WXY', '081218209580', 'OSVALDO', 'DEPOK CIMANGGIS', '2019-08-28', '2019-08-28', 'admin', 'admin'),
(3, 'PT. ABCD ABCD', '081218209588', 'ADNAN PUTRA', 'CIBUBUR', '2019-08-28', '2019-08-28', 'admin', 'admin');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
