-- DELIMITER $$

-- Pizza Create
DROP PROCEDURE IF EXISTS PizzaShop.Pizza_Create $$
CREATE PROCEDURE PizzaShop.Pizza_Create(
    IN p_pizzaSizeId INT,
    IN p_pizzaTypeId INT,
    IN p_orderId INT
)
BEGIN    
    INSERT INTO Pizzas
    (pizzaSizeId, pizzaTypeId, orderId)
    VALUES
    (p_pizzaSizeId, p_pizzaTypeId, p_orderId);

    SELECT LAST_INSERT_ID() as 'id';
END $$



-- Pizza Read
DROP PROCEDURE IF EXISTS PizzaShop.Pizza_Read $$
CREATE PROCEDURE PizzaShop.Pizza_Read(
    IN p_pizzaId INT
)
BEGIN
    -- Read in the Main Pizza Items.
    SELECT * FROM Pizzas where id=p_pizzaId;

    -- Read in the Toppings.
    SELECT Toppings.* FROM PizzaToppings
    JOIN Toppings on Toppings.id = PizzaToppings.toppingId
    WHERE PizzaToppings.pizzaId = p_pizzaId;
END $$


-- Pizza Update
DROP PROCEDURE IF EXISTS PizzaShop.Pizza_Update $$
CREATE PROCEDURE PizzaShop.Pizza_Update(
    IN p_pizzaId INT,
    IN p_pizzaSizeId INT,
    IN p_pizzaTypeId INT,
    IN p_orderId INT
)
BEGIN
    UPDATE Pizzas p
    SET p.pizzaSizeId = p_pizzaSizeId,
        p.pizzaTypeId = p_pizzaTypeId,
        p.orderId = p_orderId
    WHERE p.id = p_pizzaId;
END $$

-- Pizza Delete
DROP PROCEDURE IF EXISTS PizzaShop.Pizza_Delete $$
CREATE PROCEDURE PizzaShop.Pizza_Delete(
    IN p_pizzaId INT
)
BEGIN
    -- Delete the Toppings Related to this pizza.
    DELETE FROM PizzaToppings WHERE PizzaToppings.pizzaId = p_pizzaId;

    -- Delete the Pizza row itself.
    DELETE FROM Pizzas WHERE Pizzas.id = p_pizzaId;
END $$


-- Pizza AddTopping
DROP PROCEDURE IF EXISTS PizzaShop.Pizza_AddTopping $$
CREATE PROCEDURE PizzaShop.Pizza_AddTopping(
    IN p_pizzaId INT,
    IN p_toppingId INT
)
BEGIN
    INSERT INTO PizzaToppings VALUES (p_pizzaId, p_toppingId);
END $$

-- Pizza RemoveTopping
DROP PROCEDURE IF EXISTS PizzaShop.Pizza_RemoveTopping $$
CREATE PROCEDURE PizzaShop.Pizza_RemoveTopping(
    IN p_pizzaId INT
)
BEGIN
    DELETE FROM PizzaToppings WHERE PizzaToppings.pizzaId = p_pizzaId;
END $$

-- DELIMITER ;