CREATE TABLE IF NOT EXISTS `user_permissao` (
  `id_user` bigint(20) NOT NULL,
  `id_permissao` bigint(20) NOT NULL,
  PRIMARY KEY (`id_user`,`id_permissao`),
  KEY `fk_user_permissao_permissao` (`id_permissao`),
  CONSTRAINT `fk_user_permissao` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_user_permissao_permissao` FOREIGN KEY (`id_permissao`) REFERENCES `permissao` (`id`)
) ENGINE=InnoDB;