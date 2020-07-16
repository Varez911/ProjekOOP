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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table rpl_oop.kamar: ~0 rows (approximately)
/*!40000 ALTER TABLE `kamar` DISABLE KEYS */;
/*!40000 ALTER TABLE `kamar` ENABLE KEYS */;

-- Dumping structure for table rpl_oop.pasien
CREATE TABLE IF NOT EXISTS `pasien` (
  `id_pasien` int(11) NOT NULL AUTO_INCREMENT,
  `nama_pasien` varchar(50) NOT NULL,
  `tgl_pasien` date NOT NULL,
  PRIMARY KEY (`id_pasien`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table rpl_oop.pasien: ~0 rows (approximately)
/*!40000 ALTER TABLE `pasien` DISABLE KEYS */;
INSERT INTO `pasien` (`id_pasien`, `nama_pasien`, `tgl_pasien`) VALUES
	(1, 'Ridwan', '2020-07-12');
/*!40000 ALTER TABLE `pasien` ENABLE KEYS */;

-- Dumping structure for table rpl_oop.resepsionis
CREATE TABLE IF NOT EXISTS `resepsionis` (
  `id_resepsionis` int(11) NOT NULL AUTO_INCREMENT,
  `nama_resepsionis` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `level` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_resepsionis`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table rpl_oop.resepsionis: ~4 rows (approximately)
/*!40000 ALTER TABLE `resepsionis` DISABLE KEYS */;
INSERT INTO `resepsionis` (`id_resepsionis`, `nama_resepsionis`, `username`, `password`, `level`) VALUES
	(1, 'Admin', 'admin', 'admin', 'admin'),
	(2, 'Riku', 'riku09', 'ikeh', 'user'),
	(3, 'Yuri', 'alpha1', 'order1', 'user'),
	(4, 'Lily', 'bungamentari', 'Cutyp13', 'user');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table rpl_oop.transkip: ~0 rows (approximately)
/*!40000 ALTER TABLE `transkip` DISABLE KEYS */;
INSERT INTO `transkip` (`id_transkip`, `no_inap`, `tgl_inap`, `id_pasien`, `id_resepsionis`, `id_riwayat`, `id_kamar`) VALUES
	(1, '101A', '2020-07-12', 1, NULL, NULL, NULL);
/*!40000 ALTER TABLE `transkip` ENABLE KEYS */;

-- Dumping structure for table rpl_oop.user
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `level` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table rpl_oop.user: ~0 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
