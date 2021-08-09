create table if not exists `book`(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `autor` longtext NOT NULL,
  `lancamento` datetime(6) NOT NULL,
  `preco` decimal(65,2) NOT NULL,
  `titulo` longtext NOT NULL,
  PRIMARY KEY (`id`)
)