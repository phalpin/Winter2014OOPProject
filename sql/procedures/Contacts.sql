-- DELIMITER $$
-- Contact Create
DROP PROCEDURE IF EXISTS PizzaShop.Contact_Create $$
CREATE PROCEDURE PizzaShop.Contact_Create(
    IN p_firstName VARCHAR(50),
    IN p_middleName VARCHAR(50),
    IN p_lastName VARCHAR(50),
    IN p_homeNumber VARCHAR(50),
    IN p_mobileNumber VARCHAR(50)
)
BEGIN    
	
    -- Insert the contact
    INSERT INTO Contacts
    (firstName, middleName, lastName, homeNumber, mobileNumber)
    VALUES
    (p_firstName,p_middleName,p_lastName,p_homeNumber,p_mobileNumber);
    
    -- Get the new contact id, assign it into the variable @v_ContactId
    SELECT LAST_INSERT_ID() AS 'ContactId';
END $$



-- Contact Read
DROP PROCEDURE IF EXISTS PizzaShop.Contact_Read $$
CREATE PROCEDURE PizzaShop.Contact_Read(
    IN p_contactId INT
)
BEGIN
    -- Read in the user.
    SELECT c.firstName, c.middleName, c.lastName, c.homeNumber, c.mobileNumber
	FROM Contacts c
	WHERE c.id = p_contactId;
END $$

-- Contact Update`
DROP PROCEDURE IF EXISTS PizzaShop.Contact_Update $$
CREATE PROCEDURE PizzaShop.Contact_Update(
    IN p_contactId INT,
    IN p_firstName VARCHAR(50),
    IN p_middleName VARCHAR(50),
    IN p_lastName VARCHAR(50),
    IN p_homeNumber VARCHAR(50),
    IN p_mobileNumber VARCHAR(50)
)
BEGIN
    -- Update the contacts table.
    UPDATE Contacts c
        SET c.firstName = p_firstName,
            c.middleName = p_middleName,
            c.lastName = p_lastName,
            c.homeNumber = p_homeNumber,
            c.mobileNumber = p_mobileNumber
        WHERE c.id = @p_contactId;
END $$

-- Contact Delete
DROP PROCEDURE IF EXISTS PizzaShop.Contact_Delete $$
CREATE PROCEDURE PizzaShop.Contact_Delete(
    IN p_contactId INT
)
BEGIN
    -- Delete the Contact
    DELETE FROM Contacts WHERE Contacts.id = p_contactId;
END $$
-- DELIMITER ;