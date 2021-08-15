-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema poseidon
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `demo` DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_0900_ai_ci ;
USE `demo` ;

CREATE TABLE IF NOT EXISTS `demo`.`BidList` (
  `Id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `account` VARCHAR(30) NOT NULL,
  `type` VARCHAR(30) NOT NULL,
  `bidQuantity` DOUBLE,
  `askQuantity` DOUBLE,
  `bid` DOUBLE ,
  `ask` DOUBLE,
  `benchmark` VARCHAR(125),
  `bidListDate` TIMESTAMP,
  `commentary` VARCHAR(125),
  `security` VARCHAR(125),
  `status` VARCHAR(10),
  `trader` VARCHAR(125),
  `book` VARCHAR(125),
  `creationName` VARCHAR(125),
  `creationDate` TIMESTAMP ,
  `revisionName` VARCHAR(125),
  `revisionDate` TIMESTAMP ,
  `dealName` VARCHAR(125),
  `dealType` VARCHAR(125),
  `sourceListId` VARCHAR(125),
  `side` VARCHAR(125),

  PRIMARY KEY (`Id`)
);

CREATE TABLE IF NOT EXISTS `demo`.`Trade` (
  `Id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `account` VARCHAR(30) NOT NULL,
  `type` VARCHAR(30) NOT NULL,
  `buyQuantity` DOUBLE,
  `sellQuantity` DOUBLE,
  `buyPrice` DOUBLE ,
  `sellPrice` DOUBLE,
  `tradeDate` TIMESTAMP,
  `security` VARCHAR(125),
  `status` VARCHAR(10),
  `trader` VARCHAR(125),
  `benchmark` VARCHAR(125),
  `book` VARCHAR(125),
  `creationName` VARCHAR(125),
  `creationDate` TIMESTAMP ,
  `revisionName` VARCHAR(125),
  `revisionDate` TIMESTAMP ,
  `dealName` VARCHAR(125),
  `dealType` VARCHAR(125),
  `sourceListId` VARCHAR(125),
  `side` VARCHAR(125),

  PRIMARY KEY (`Id`)
);

CREATE TABLE IF NOT EXISTS `demo`.`CurvePoint` (
  `Id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `CurveId` tinyint,
  `asOfDate` TIMESTAMP,
  `term` DOUBLE,
  `value` DOUBLE,
  `creationDate` TIMESTAMP,

  PRIMARY KEY (`Id`)
);

CREATE TABLE IF NOT EXISTS `demo`.`Rating` (
  `Id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `moodysRating` VARCHAR(125),
  `sandPRating` VARCHAR(125),
  `fitchRating` VARCHAR(125),
  `orderNumber` tinyint,

  PRIMARY KEY (`Id`)
);

CREATE TABLE IF NOT EXISTS `demo`.`RuleName` (
  `Id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(125),
  `description` VARCHAR(125),
  `json` VARCHAR(125),
  `template` VARCHAR(512),
  `sqlStr` VARCHAR(125),
  `sqlPart` VARCHAR(125),

  PRIMARY KEY (`Id`)
);

CREATE TABLE IF NOT EXISTS `demo`.`Users` (
  `Id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(125),
  `password` VARCHAR(125),
  `fullname` VARCHAR(125),
  `role` VARCHAR(125),

  PRIMARY KEY (`Id`)
);

insert into Users(fullname, username, password, role) values("Administrator", "admin", "$2a$10$pBV8ILO/s/nao4wVnGLrh.sa/rnr5pDpbeC4E.KNzQWoy8obFZdaa", "ADMIN");
insert into Users(fullname, username, password, role) values("User", "user", "$2a$10$pBV8ILO/s/nao4wVnGLrh.sa/rnr5pDpbeC4E.KNzQWoy8obFZdaa", "USER");

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
