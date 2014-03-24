SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `PizzaShop` ;
CREATE SCHEMA IF NOT EXISTS `PizzaShop` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `PizzaShop` ;

-- -----------------------------------------------------
-- Table `PizzaShop`.`Contacts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`Contacts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(50) NOT NULL,
  `middleName` VARCHAR(50) NULL,
  `lastName` VARCHAR(50) NOT NULL,
  `homeNumber` VARCHAR(50) NULL,
  `mobileNumber` VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`Addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`Addresses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contactId` INT NOT NULL,
  `lineOne` VARCHAR(100) NOT NULL,
  `lineTwo` VARCHAR(100) NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `zip` INT NOT NULL,
  PRIMARY KEY (`id`, `contactId`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Addresses_Contacts1_idx` (`contactId` ASC),
  CONSTRAINT `fk_Addresses_Contacts1`
    FOREIGN KEY (`contactId`)
    REFERENCES `PizzaShop`.`Contacts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`UserTypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`UserTypes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`Sessions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`Sessions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `token` VARCHAR(45) NULL,
  `startedOn` DATETIME NULL,
  `userId` INT NOT NULL,
  PRIMARY KEY (`id`, `userId`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Sessions_Users1_idx` (`userId` ASC),
  CONSTRAINT `fk_Sessions_Users1`
    FOREIGN KEY (`userId`)
    REFERENCES `PizzaShop`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contactId` INT NOT NULL,
  `userTypeId` INT NOT NULL,
  `sessionId` INT NULL,
  `username` VARCHAR(25) NULL,
  `password` VARCHAR(100) NULL,
  `salt` VARCHAR(45) NULL,
  PRIMARY KEY (`id`, `contactId`, `userTypeId`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Users_Contacts1_idx` (`contactId` ASC),
  INDEX `fk_Users_UserTypes1_idx` (`userTypeId` ASC),
  INDEX `fk_Users_Sessions1_idx` (`sessionId` ASC),
  CONSTRAINT `fk_Users_Contacts1`
    FOREIGN KEY (`contactId`)
    REFERENCES `PizzaShop`.`Contacts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_UserTypes1`
    FOREIGN KEY (`userTypeId`)
    REFERENCES `PizzaShop`.`UserTypes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_Sessions1`
    FOREIGN KEY (`sessionId`)
    REFERENCES `PizzaShop`.`Sessions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`PizzaSizes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`PizzaSizes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `cost` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`PizzaTypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`PizzaTypes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `cost` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`Toppings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`Toppings` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Topping` VARCHAR(45) NULL,
  `Cost` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`Orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  PRIMARY KEY (`id`, `userId`),
  UNIQUE INDEX `idOrder_UNIQUE` (`id` ASC),
  INDEX `fk_Order_Users1_idx` (`userId` ASC),
  CONSTRAINT `fk_Order_Users1`
    FOREIGN KEY (`userId`)
    REFERENCES `PizzaShop`.`Users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`Pizzas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`Pizzas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  `pizzaSizeId` INT NOT NULL,
  `pizzaTypeId` INT NOT NULL,
  `orderId` INT NOT NULL,
  PRIMARY KEY (`id`, `pizzaSizeId`, `pizzaTypeId`, `orderId`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_SpecialPizza_PizzaSizes1_idx` (`pizzaSizeId` ASC),
  INDEX `fk_SpecialPizza_PizzaTypes1_idx` (`pizzaTypeId` ASC),
  INDEX `fk_Pizzas_Order1_idx` (`orderId` ASC),
  CONSTRAINT `fk_SpecialPizza_PizzaSizes1`
    FOREIGN KEY (`pizzaSizeId`)
    REFERENCES `PizzaShop`.`PizzaSizes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SpecialPizza_PizzaTypes1`
    FOREIGN KEY (`pizzaTypeId`)
    REFERENCES `PizzaShop`.`PizzaTypes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pizzas_Order1`
    FOREIGN KEY (`orderId`)
    REFERENCES `PizzaShop`.`Orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`PizzaToppings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`PizzaToppings` (
  `pizzaId` INT NOT NULL,
  `toppingId` INT NOT NULL,
  PRIMARY KEY (`pizzaId`, `toppingId`),
  INDEX `fk_SpecialPizza_has_PizzaToppings_PizzaToppings1_idx` (`toppingId` ASC),
  INDEX `fk_SpecialPizza_has_PizzaToppings_SpecialPizza1_idx` (`pizzaId` ASC),
  CONSTRAINT `fk_SpecialPizza_has_PizzaToppings_SpecialPizza1`
    FOREIGN KEY (`pizzaId`)
    REFERENCES `PizzaShop`.`Pizzas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SpecialPizza_has_PizzaToppings_PizzaToppings1`
    FOREIGN KEY (`toppingId`)
    REFERENCES `PizzaShop`.`Toppings` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`Beverages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`Beverages` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `cost` DOUBLE NULL,
  `size` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`Assorted`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`Assorted` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `cost` DOUBLE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`Sides`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`Sides` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Assorted_id` INT NULL,
  `Beverages_id` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_Sides_Assorted1_idx` (`Assorted_id` ASC),
  INDEX `fk_Sides_Beverages1_idx` (`Beverages_id` ASC),
  CONSTRAINT `fk_Sides_Assorted1`
    FOREIGN KEY (`Assorted_id`)
    REFERENCES `PizzaShop`.`Assorted` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sides_Beverages1`
    FOREIGN KEY (`Beverages_id`)
    REFERENCES `PizzaShop`.`Beverages` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PizzaShop`.`SidesInOrders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PizzaShop`.`SidesInOrders` (
  `sidesId` INT NOT NULL,
  `orderId` INT NOT NULL,
  PRIMARY KEY (`sidesId`, `orderId`),
  INDEX `fk_Sides_has_Order_Order1_idx` (`orderId` ASC),
  INDEX `fk_Sides_has_Order_Sides1_idx` (`sidesId` ASC),
  CONSTRAINT `fk_Sides_has_Order_Sides1`
    FOREIGN KEY (`sidesId`)
    REFERENCES `PizzaShop`.`Sides` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sides_has_Order_Order1`
    FOREIGN KEY (`orderId`)
    REFERENCES `PizzaShop`.`Orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
