-- Create Demo Users
USE PizzaShop;

-- Create the User Types
INSERT INTO UserTypes (Name) VALUES ('Customer');
INSERT INTO UserTypes (Name) VALUES ('VIP');
INSERT INTO UserTypes (Name) VALUES ('User');
INSERT INTO UserTypes (Name) VALUES ('Administrator');

-- Create the Users
CALL User_Create('Phillip', 'Daniel', 'Halpin', '9547539744', '9548957704', 'phalpin', 'SFHALK@%FA', 'qwertyuiop', 4);
CALL User_Create('John', 'Joseph', 'Doe', '9545551234', '9545554321', 'jdoe', 'YFQUHF@$*!@', 'qwertyuiop', 1);