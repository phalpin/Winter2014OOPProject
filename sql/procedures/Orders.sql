-- DELIMITER $$

-- Order Create
DROP PROCEDURE IF EXISTS PizzaShop.Order_Create $$
CREATE PROCEDURE PizzaShop.Order_Create(
    IN p_userId INT
)
BEGIN    
    INSERT INTO Orders
    (userId)
    VALUES
    (p_userId);

    SELECT LAST_INSERT_ID();
END $$



-- Order Read
DROP PROCEDURE IF EXISTS PizzaShop.Order_Read $$
CREATE PROCEDURE PizzaShop.Order_Read(
    IN p_orderId INT
)
BEGIN

    -- Order Object.
    SELECT * FROM Orders WHERE id = p_orderId;

    -- Pizzas List.
    SELECT * FROM Pizzas WHERE orderId = p_orderId;

END $$

-- DELIMITER ;