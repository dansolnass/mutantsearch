create database mutant;
create user 'mutantuser' identified by 'ThePassword';
grant all on mutant.* to 'mutantuser';

CREATE TABLE "mutant"."statistics" (
  "property" varchar(255) NOT NULL,
  "value" int DEFAULT NULL,
  PRIMARY KEY ("property")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;