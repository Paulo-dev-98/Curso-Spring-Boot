CREATE TABLE IF NOT EXISTS `personagem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `idade` int NOT NULL,
  `sexo` varchar(6) NOT NULL,
  `origem` varchar(500) NOT NULL,
  `universo` varchar(20) NOT NULL,
  `habitacao` varchar(20) NOT NULL,
  `personalidade` varchar(50) NOT NULL,
  `poder` varchar(500) NOT NULL,
  `frase_de_efeito_numero_1` varchar(1000) NOT NULL,
  `frase_de_efeito_numero_2` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) 