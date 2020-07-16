-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.6-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for rpl_oop
CREATE DATABASE IF NOT EXISTS `rpl_oop` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rpl_oop`;

-- Dumping structure for table rpl_oop.kamar
CREATE TABLE IF NOT EXISTS `kamar` (
  `id_kamar` int(11) NOT NULL AUTO_INCREMENT,
  `tipe_kamar` varchar(50) DEFAULT NULL,
  `status_kamar` varchar(50) NOT NULL,
  `biaya_kamar` int(11) NOT NULL,
  PRIMARY KEY (`id_kamar`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table rpl_oop.kamar: ~8 rows (approximately)
/*!40000 ALTER TABLE `kamar` DISABLE KEYS */;
INSERT INTO `kamar` (`id_kamar`, `tipe_kamar`, `status_kamar`, `biaya_kamar`) VALUES
	(1, 'VIP', 'Kosong', 600000),
	(2, 'Kelas 1', 'Kosong', 550000),
	(3, 'VIP+', 'Kosong', 750000),
	(4, 'VIP++', 'Kosong', 1000000),
	(5, 'Kelas 2', 'Kosong', 450000),
	(6, 'Kelas 1', 'Kosong', 550000),
	(7, 'Kelas 3', 'Kosong', 200000),
	(8, 'Kelas 3', 'Kosong', 200000);
/*!40000 ALTER TABLE `kamar` ENABLE KEYS */;

-- Dumping structure for table rpl_oop.pasien
CREATE TABLE IF NOT EXISTS `pasien` (
  `id_pasien` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pasien` varchar(50) NOT NULL,
  `tgl_pasien` date NOT NULL,
  PRIMARY KEY (`id_pasien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table rpl_oop.pasien: ~0 rows (approximately)
/*!40000 ALTER TABLE `pasien` DISABLE KEYS */;
/*!40000 ALTER TABLE `pasien` ENABLE KEYS */;

-- Dumping structure for table rpl_oop.resepsionis
CREATE TABLE IF NOT EXISTS `resepsionis` (
  `id_resepsionis` int(11) NOT NULL AUTO_INCREMENT,
  `nama_resepsionis` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `level` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_resepsionis`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table rpl_oop.resepsionis: ~5 rows (approximately)
/*!40000 ALTER TABLE `resepsionis` DISABLE KEYS */;
INSERT INTO `resepsionis` (`id_resepsionis`, `nama_resepsionis`, `username`, `password`, `level`) VALUES
	(1, 'Admin', 'admin', 'admin', 'admin'),
	(2, 'Riku', 'riku09', 'ikeh', 'user'),
	(3, 'Yuri', 'alpha1', 'order1', 'user'),
	(4, 'Lily', 'bungamentari', 'Cutyp13', 'user'),
	(5, 'Ginawan', 'gigi27', 'qweerty', 'user');
/*!40000 ALTER TABLE `resepsionis` ENABLE KEYS */;

-- Dumping structure for table rpl_oop.riwayat_penyakit
CREATE TABLE IF NOT EXISTS `riwayat_penyakit` (
  `id_riwayat` int(11) NOT NULL AUTO_INCREMENT,
  `nama_penyakit` varchar(50) DEFAULT NULL,
  `jenis_penyakit` varchar(50) DEFAULT NULL,
  `waktu_penyakit` date NOT NULL,
  PRIMARY KEY (`id_riwayat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table rpl_oop.riwayat_penyakit: ~0 rows (approximately)
/*!40000 ALTER TABLE `riwayat_penyakit` DISABLE KEYS */;
/*!40000 ALTER TABLE `riwayat_penyakit` ENABLE KEYS */;

-- Dumping structure for table rpl_oop.transkip
CREATE TABLE IF NOT EXISTS `transkip` (
  `id_transkip` int(11) NOT NULL AUTO_INCREMENT,
  `no_inap` varchar(50) DEFAULT NULL,
  `tgl_inap` date DEFAULT NULL,
  `id_pasien` int(11) DEFAULT NULL,
  `id_resepsionis` int(11) DEFAULT NULL,
  `id_riwayat` int(11) DEFAULT NULL,
  `id_kamar` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_transkip`),
  KEY `FK_transkip_pasien` (`id_pasien`),
  KEY `FK_transkip_resepsionis` (`id_resepsionis`),
  KEY `FK_transkip_riwayat_penyakit` (`id_riwayat`),
  KEY `FK_transkip_kamar` (`id_kamar`),
  CONSTRAINT `FK_transkip_kamar` FOREIGN KEY (`id_kamar`) REFERENCES `kamar` (`id_kamar`),
  CONSTRAINT `FK_transkip_pasien` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  CONSTRAINT `FK_transkip_resepsionis` FOREIGN KEY (`id_resepsionis`) REFERENCES `resepsionis` (`id_resepsionis`),
  CONSTRAINT `FK_transkip_riwayat_penyakit` FOREIGN KEY (`id_riwayat`) REFERENCES `riwayat_penyakit` (`id_riwayat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table rpl_oop.transkip: ~0 rows (approximately)
/*!40000 ALTER TABLE `transkip` DISABLE KEYS */;
/*!40000 ALTER TABLE `transkip` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
