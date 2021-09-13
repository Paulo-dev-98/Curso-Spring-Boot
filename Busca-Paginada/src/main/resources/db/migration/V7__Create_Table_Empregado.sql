CREATE TABLE IF NOT EXISTS `empregado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` bigint NOT NULL,
  PRIMARY KEY (`id`)
) 