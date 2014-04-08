-- DELIMITER $$

-- Topping Create
DROP PROCEDURE IF EXISTS PizzaShop.Topping_Create $$
CREATE PROCEDURE PizzaShop.Topping_Create(
    IN p_toppingName VARCHAR(45),
    IN p_cost DOUBLE
)
BEGIN

    INSERT INTO Toppings
    (Topping, Cost)
    VALUES
    (p_toppingName, p_cost);

    SELECT LAST_INSERT_ID();
END $$


-- Topping Read
DROP PROCEDURE IF EXISTS PizzaShop.Topping_Read $$
CREATE PROCEDURE PizzaShop.Topping_Read(
    IN p_Id INT
)
BEGIN
    SELECT * FROM Toppings WHERE Toppings.Id = p_Id;
END $$

-- Topping Update
DROP PROCEDURE IF EXISTS PizzaShop.Topping_Update $$
CREATE PROCEDURE PizzaShop.Topping_Update(
    IN p_Id INT,
    IN p_toppingName VARCHAR(45),
    IN p_cost DOUBLE
)
BEGIN
    UPDATE Toppings
    SET Toppings.Topping = p_toppingName,
        Toppings.Cost = p_cost
    WHERE Toppings.id = p_Id;
END $$

-- Topping Delete
DROP PROCEDURE IF EXISTS PizzaShop.Topping_Delete $$
CREATE PROCEDURE PizzaShop.Topping_Delete(
    IN p_id INT
)
BEGIN
    DELETE FROM Toppings WHERE Toppings.id = p_id;
END $$
 
-- DELIMITER ;
