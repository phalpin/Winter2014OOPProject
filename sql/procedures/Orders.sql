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

    SELECT LAST_INSERT_ID() as 'orderId';
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

-- Order Read For User Id
DROP PROCEDURE IF EXISTS PizzaShop.Order_Read_For_UserId $$
CREATE PROCEDURE PizzaShop.Order_Read_For_UserId(
    IN p_userId INT
)
BEGIN

    -- Construct that beast.
        select o.id as 'OrderId', o.userId as 'UserId', p.id as 'PizzaId', p.pizzaSizeId as 'SizeId', p.pizzaTypeId as 'TypeId', pt.toppingId as 'ToppingId'
        from Pizzas p
        join Orders o on o.id = p.orderId
        left join PizzaToppings pt on pt.pizzaId = p.id
        where o.userId = p_userId;

END $$

-- DELIMITER ;