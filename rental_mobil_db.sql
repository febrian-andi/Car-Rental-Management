-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 05 Jun 2023 pada 19.26
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental_mobil_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_customer`
--

CREATE TABLE `tbl_customer` (
  `id_customer` int(20) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(300) NOT NULL,
  `no_telepon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_customer`
--

INSERT INTO `tbl_customer` (`id_customer`, `nama`, `alamat`, `no_telepon`) VALUES
(1, 'Dodo Kurniawan', 'Palembang', '081234567890'),
(2, 'Juan Casillas', 'Solo', '089923434567'),
(3, 'Kiko Junior', 'Jakarta', '082238994758'),
(4, 'Bagus Ahmad Nugraha', 'Bandung', '085478322331'),
(5, 'Bagas Adi Anugrah', 'Bandung', '085112344895');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_mobil`
--

CREATE TABLE `tbl_mobil` (
  `plat_nomor` varchar(15) NOT NULL,
  `merek` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_mobil`
--

INSERT INTO `tbl_mobil` (`plat_nomor`, `merek`, `status`, `harga`) VALUES
('AB 1234 CD', 'Avanza', 'Available', 200000),
('AB 9090 CY', 'Subaru', 'Available', 300000),
('AD 8379 CC', 'Xenia', 'Available', 300000),
('BB 3998 YN', 'Avanza', 'Available', 150000),
('BK 2388 YY', 'Ferrari', 'Booked', 450000),
('CD 2535 XY', 'BMW', 'Available', 300000),
('K 8299 OP', 'Ferrari', 'Booked', 500000),
('M 2199 AA', 'Avanza', 'Available', 250000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_peminjaman`
--

CREATE TABLE `tbl_peminjaman` (
  `id_peminjaman` int(20) NOT NULL,
  `plat_nomor` varchar(15) NOT NULL,
  `nama_customer` varchar(100) NOT NULL,
  `tgl_peminjaman` date NOT NULL,
  `tgl_pengembalian` date NOT NULL,
  `total_harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_peminjaman`
--

INSERT INTO `tbl_peminjaman` (`id_peminjaman`, `plat_nomor`, `nama_customer`, `tgl_peminjaman`, `tgl_pengembalian`, `total_harga`) VALUES
(1, 'BK 2388 YY', 'Dodo Kurniawan', '2023-05-18', '2023-05-20', 900000),
(2, 'K 8299 OP', 'Kiko Junior', '2023-05-19', '2023-05-20', 500000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_pengembalian`
--

CREATE TABLE `tbl_pengembalian` (
  `id_pengembalian` int(20) NOT NULL,
  `plat_nomor` varchar(50) NOT NULL,
  `nama_customer` varchar(100) NOT NULL,
  `tgl_pengembalian` date NOT NULL,
  `delay` int(11) NOT NULL,
  `denda` int(30) NOT NULL,
  `total_bayar` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_pengembalian`
--

INSERT INTO `tbl_pengembalian` (`id_pengembalian`, `plat_nomor`, `nama_customer`, `tgl_pengembalian`, `delay`, `denda`, `total_bayar`) VALUES
(1, 'CD 2535 XY', 'Kiki Junior', '2023-05-25', 1, 50000, 650000),
(2, 'M 2199 AA', 'Bagas Adi Anugrah', '2023-05-23', 2, 100000, 600000),
(3, '261378', 'Juan Casillas', '2023-05-26', 2, 100000, 121312),
(4, 'M 2199 AA', 'Bagas Adi Anugrah', '2023-05-27', 0, 0, 500000),
(5, 'M 2199 AA', 'Dodo Kurniawan', '2023-06-01', 1, 50000, 300000),
(6, 'CD 2535 XY', 'Juan Casillas', '2023-06-08', 0, 0, 600000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_customer`
--
ALTER TABLE `tbl_customer`
  ADD PRIMARY KEY (`id_customer`);

--
-- Indeks untuk tabel `tbl_mobil`
--
ALTER TABLE `tbl_mobil`
  ADD PRIMARY KEY (`plat_nomor`);

--
-- Indeks untuk tabel `tbl_peminjaman`
--
ALTER TABLE `tbl_peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`);

--
-- Indeks untuk tabel `tbl_pengembalian`
--
ALTER TABLE `tbl_pengembalian`
  ADD PRIMARY KEY (`id_pengembalian`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
