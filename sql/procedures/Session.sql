-- DELIMITER $$


-- Session create
DROP PROCEDURE IF EXISTS PizzaShop.Session_Create $$
CREATE PROCEDURE PizzaShop.Session_Create(
    IN p_token VARCHAR(45),
    IN p_startedOn DATETIME,
    IN p_userId INT
)
BEGIN
    DECLARE v_sessionId INT;

    -- Delete old session, if necessary.
    UPDATE Users u
    SET u.sessionId = NULL
    WHERE u.id = p_userId;

    DELETE FROM Sessions
    WHERE Sessions.userId = p_userId;

    -- Now, let's insert our new session.
    INSERT INTO Sessions
    (token, startedOn, userId)
    VALUES
    (p_token, p_startedOn, p_userId);

    SET @v_sessionId = LAST_INSERT_ID();

    UPDATE Users u
    SET u.sessionId = @v_sessionId
    WHERE u.id = p_userId;

    SELECT @v_sessionId as 'sessionId';
END $$


-- Session Read
DROP PROCEDURE IF EXISTS PizzaShop.Session_Read $$
CREATE PROCEDURE PizzaShop.Session_Read(
    IN p_id INT
)
BEGIN
    SELECT * FROM Sessions WHERE Sessions.id = p_id;
END $$


-- Session Update
DROP PROCEDURE IF EXISTS PizzaShop.Session_Update $$
CREATE PROCEDURE PizzaShop.Session_Update(
    IN p_id INT,
    IN p_token VARCHAR(45),
    IN p_startedOn DATETIME,
    IN p_userId INT
)
BEGIN
    UPDATE Sessions s
    SET s.token = p_token,
        s.startedOn = p_startedOn,
        s.userId = p_userId
    WHERE s.id = p_id;
END $$


-- Session Delete
DROP PROCEDURE IF EXISTS PizzaShop.Session_Delete $$
CREATE PROCEDURE PizzaShop.Session_Delete(
    IN p_id INT
)
BEGIN
    UPDATE Users SET Users.sessionId = NULL WHERE Users.sessionId = p_id;
    DELETE FROM Sessions WHERE Sessions.id = p_id;
END $$


-- Session ReadByToken
DROP PROCEDURE IF EXISTS PizzaShop.Session_ReadByToken $$
CREATE PROCEDURE PizzaShop.Session_ReadByToken(
    IN p_sessionToken INT
)
BEGIN
    SELECT * FROM Sessions WHERE Sessions.token = p_sessionToken;
END $$

-- DELIMITER ;