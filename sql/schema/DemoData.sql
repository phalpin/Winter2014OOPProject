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


-- Insert the Pizza Sizes
INSERT INTO PizzaSizes (name, cost) VALUES
('Small', 5.00),
('Medium', 7.50),
('Large', 10.00);


-- Insert the Pizza Types
INSERT INTO PizzaTypes (name, cost) VALUES
('New York', 1.50),
('Chicago', 1.00),
('California', 0.75);


-- Create Non-user Contacts 'AKA Anonymous Customers'
CALL Contact_Create('Jane', 'Smith', 'Doe', '5619541234', '5614231654');
CALL Contact_Create('Sally', NULL, 'Jones', '5613862598', '5612984376');


-- Create the Users
CALL User_Create('Phillip', 'Daniel', 'Halpin', '9547539744', '9548957704', 'phalpin', 'h5SfzJHaLormGgHJgqLBV7qfQ+U1KTacCy09yXmmqIzqKvIomOsZNNTW4c5Vs3LL', '1404847572', 4);
CALL User_Create('Mario', NULL, 'Taccariello', '5619991234', '5612221234', 'mtaccariello', 'qA37HY9EEyIno2qUUbNclh/XRWJy0tHFfCn288/J+1G7W1p5mCRdrHaNIjycLNWr', '1548918348', 4);