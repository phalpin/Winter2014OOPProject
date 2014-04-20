-- Create Demo Users
USE PizzaShop;

-- Create the User Types
INSERT INTO UserTypes (Name) VALUES ('Customer');
INSERT INTO UserTypes (Name) VALUES ('VIP');
INSERT INTO UserTypes (Name) VALUES ('User');
INSERT INTO UserTypes (Name) VALUES ('Administrator');

-- Insert the Pizza Toppings
INSERT INTO Toppings (Topping, Cost) VALUES
('Pepperoni', 0.25),
('Sausage', 0.50),
('Jalapenos', 0.75),
('Black Olives', 0.50);

-- Create Non-user Contacts 'AKA Anonymous Customers'
CALL Contact_Create('Jane', 'Smith', 'Doe', '5619541234', '5614231654');
CALL Contact_Create('Sally', NULL, 'Jones', '5613862598', '5612984376');

-- Create the Users
CALL User_Create('Phillip', 'Daniel', 'Halpin', '9547539744', '9548957704', 'phalpin', 'h5SfzJHaLormGgHJgqLBV7qfQ+U1KTacCy09yXmmqIzqKvIomOsZNNTW4c5Vs3LL', '1404847572', 4);
CALL User_Create('John', 'Joseph', 'Doe', '9545551234', '9545554321', 'jdoe', 'YFQUHF@$*!@', 'qwertyuiop', 1);