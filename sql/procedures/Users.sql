-- DELIMITER $$
-- User Create
DROP PROCEDURE IF EXISTS PizzaShop.User_Create $$
CREATE PROCEDURE PizzaShop.User_Create(
    IN p_firstName VARCHAR(50),
    IN p_middleName VARCHAR(50),
    IN p_lastName VARCHAR(50),
    IN p_homeNumber VARCHAR(50),
    IN p_mobileNumber VARCHAR(50),
    IN p_userName VARCHAR(25),
    IN p_passWord VARCHAR(100),
    IN p_salt VARCHAR(45),
    IN p_userType INT
)
BEGIN
    DECLARE v_ContactId INT;
    DECLARE v_UserId INT;
	
    -- Insert the contact
    INSERT INTO Contacts
    (firstName, middleName, lastName, homeNumber, mobileNumber)
    VALUES
    (p_firstName,p_middleName,p_lastName,p_homeNumber,p_mobileNumber);
    
    -- Get the new contact id, assign it into the variable @v_ContactId
    SET @v_ContactId = LAST_INSERT_ID();

    -- Now, Create the user record.
    INSERT INTO Users
    (contactId, userTypeId, username, password, salt)
    VALUES
    (@v_ContactId, p_userType, p_userName, p_passWord, p_salt);

    -- Now, grab the new user id, save it into v_UserId
    SET @v_UserId = LAST_INSERT_ID();

    SELECT @v_UserId as 'UserId', @v_ContactId as 'ContactId';
END $$



-- User Read
DROP PROCEDURE IF EXISTS PizzaShop.User_Read $$
CREATE PROCEDURE PizzaShop.User_Read(
    IN p_userId INT
)
BEGIN
    -- Read in the user.
    SELECT u.id, c.firstName, c.middleName, c.lastName, c.homeNumber, c.mobileNumber, u.userName, u.password
    FROM Users u
    JOIN Contacts c on u.contactId = c.id
    WHERE u.id = p_userId;
END $$

-- User Update
DROP PROCEDURE IF EXISTS PizzaShop.User_Update $$
CREATE PROCEDURE PizzaShop.User_Update(
    IN p_userId INT,
    IN p_firstName VARCHAR(50),
    IN p_middleName VARCHAR(50),
    IN p_lastName VARCHAR(50),
    IN p_homeNumber VARCHAR(50),
    IN p_mobileNumber VARCHAR(50),
    IN p_userName VARCHAR(25),
    IN p_passWord VARCHAR(100),
    IN p_salt VARCHAR(45),
    IN p_userType INT
)
BEGIN
    DECLARE v_contactId INT;
    -- Get the Contact Id
    SET v_contactId = (SELECT u.contactId FROM Users u WHERE u.id = p_userId);
    
    -- Update the contacts table.
    UPDATE Contacts c
        SET c.firstName = p_firstName,
            c.middleName = p_middleName,
            c.lastName = p_lastName,
            c.homeNumber = p_homeNumber,
            c.mobileNumber = p_mobileNumber
        WHERE c.id = @v_contactId;

    -- Update the users table
    UPDATE Users u
        SET u.userTypeId = p_userType,
            u.username = p_userName,
            u.password = p_passWord,
            u.salt = p_salt
        WHERE u.id = p_userId;
END $$

-- User Delete
DROP PROCEDURE IF EXISTS PizzaShop.User_Delete $$
CREATE PROCEDURE PizzaShop.User_Delete(
    IN p_userId INT
)
BEGIN
    DECLARE v_contactId INT;
    SET v_contactId = (SELECT u.contactId FROM Users u WHERE u.contactId = @v_contactId);

    -- Delete the Contact
    DELETE FROM Contacts WHERE Contacts.id = @v_contactId;

    -- Delete the User
    DELETE FROM Users WHERE u.id = p_userId;
END $$
-- DELIMITER ;