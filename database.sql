create database mutant;
create user 'mutantuser' identified by 'ThePassword';
grant all on mutant.* to 'mutantuser';

CREATE TABLE `statistics` (
  `property` varchar(255) NOT NULL,
  `value` int DEFAULT NULL,
  PRIMARY KEY (`property`)
);

INSERT INTO mutant.statistics
(property, value)
VALUES('VALOR_HUMANOS', 0);
INSERT INTO mutant.statistics
(property, value)
VALUES('VALOR_MUTANTES', 0);

CREATE TABLE `dna` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dna` varchar(255) NOT NULL,
  `type` varchar(8) NOT NULL,
  PRIMARY KEY (`id`)
);