
//History of databse queries which i used during project 

use `velocitye-comm`;

select * from User;
select * from orders;
select * from Products;

SELECT Status, Uid, SUM(total_amount) AS total_sum FROM `velocitye-comm`.`orders` WHERE Uid = 4 AND Status = 'Pending Payment' GROUP BY Status, Uid;


delete from  orders where Status='Pending Done';


Select Products.Pid,Description,orders.quantity from Products 
INNER JOIN orders on Products.Pid = orders.Pid where Uid=5;  

Select Products.Pid,Description,orders.quantity from Products INNER JOIN orders on Products.Pid = orders.Pid where orders.Uid=1;

Select Products.Pid,Description,orders.quantity from Products INNER JOIN orders on Products.Pid = orders.Pid where orders.Uid=2;

update User set Role='Guest' where Uid=6;


SELECT Uid,Pid, SUM(total_amount) AS total_sum FROM ( SELECT Uid,total_amount FROM orders ORDER BY id DESC   LIMIT 2   ) AS recent_orders  GROUP BY Uid;



SELECT  ro.Pid
FROM (
    SELECT  Pid
    FROM orders
    ORDER BY id DESC
    LIMIT 2
) AS ro
WHERE ro.Pid NOT IN (SELECT p.Pid FROM products p);


SELECT p.Pid,p.Name,p.Description,p.Price,p.Quantity
FROM products p
LEFT JOIN (
    SELECT Pid
    FROM orders
    ORDER BY id DESC
    LIMIT 2
) recent_orders ON p.Pid = recent_orders.Pid
WHERE recent_orders.Pid IS NULL
LIMIT 1000;


select products.Pid from products left join orders
on products.Pid = orders.Pid;

SELECT p.Pid
FROM products p
LEFT JOIN orders o ON p.Pid = o.Pid
WHERE o.Pid IS NULL;

SELECT o.Status, o.Uid, u.UserName, SUM(o.total_amount) AS total_sum
FROM `velocitye-comm`.`orders` o
JOIN `velocitye-comm`.`User` u ON o.Uid = u.Uid
WHERE o.Status = 'Pending Payment'
GROUP BY o.Status, o.Uid, u.UserName;
SELECT o.Status, o.Uid, u.UserName, SUM(o.total_amount) AS total_sum
FROM `velocitye-comm`.`orders` o
JOIN `velocitye-comm`.`User` u ON o.Uid = u.Uid
WHERE o.Status = 'Pending Payment'
GROUP BY o.Status, o.Uid, u.UserName;
update orders set Status='Pending Payment' where id=45;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




CREATE TABLE User (
Uid int not null auto_increment,
 LastName varchar(255),
 FirstName varchar(255),
 UserName varchar(205),
 PassWord varchar(205),
 City varchar(255),
 Email varchar(255),
 Phone varchar(255),
 primary key(Uid)
);
drop table User;
CREATE TABLE  Products (
Pid int not null auto_increment,
 Description  varchar(255),
 Name varchar(255),
 Price int,
 Quantity int,
 primary key(Pid)
);
ALTER TABLE Products ADD COLUMN TotalProductPrice BIGINT;

insert into User (FirstName,LastName,UserName,Password,City,Email,Phone,Role)VALUES('Ringmaster','Dethe','Ranga01','Ringmaster@123','katraj','Ringmaster@gmail.com','9874561231','Admin' ); 
ALTER TABLE Products MODIFY Price BIGINT;

UPDATE products SET Quantity = 1, Price = 200 WHERE Pid = 1002;

ALTER TABLE User ADD CONSTRAINT unique_username UNIQUE (UserName);
delete from Products where Pid=101;
INSERT INTO products (Pid,Description, Name, Price, Quantity)
VALUES (106,'Ice Lilac, 12GB RAM, 256GB', 'Motorola G64 5G', 16850, 4);
UPDATE products SET Quantity = 2 ,Price=2000 WHERE Pid = 102;

SELECT SUM(orders.total_amount) AS total_amount_sum, User.Uid, User.UserName 
FROM orders 
INNER JOIN User ON User.Uid = orders.id 
GROUP BY User.Uid, User.UserName
LIMIT 0, 1000;

SELECT SUM(orders.total_amount) AS total_amount_sum, User.Uid, User.UserName 
FROM orders 
INNER JOIN User ON User.Uid = orders.id 
LIMIT 0, 1000;

SELECT SUM(orders.total_amount) AS total_amount_sum, User.Uid, User.UserName FROM orders INNER JOIN User ON User.Uid = orders.Uid  WHERE User.Uid = 2 GROUP BY User.Uid, User.UserName ;

SELECT SUM(total_amount) AS total_amount FROM orders WHERE orders.Uid =1; 

SELECT Uid, SUM(total_amount) AS total_sum
FROM (
    SELECT Uid, total_amount
    FROM orders
    ORDER BY id DESC
    LIMIT 2
) AS recent_orders
GROUP BY Uid;


select * from User;
select * from Products;
select * from orders;
SELECT * FROM Products ORDER BY Name;
UPDATE Products set Quantity = 10  WHERE Pid = 101;
delete from Products where Pid=1003;
SELECT * FROM User WHERE username = 'Indra01' AND password = 'indra@123';
DELETE FROM `velocitye-comm`.`orders`
WHERE orders.id BETWEEN 3 AND 39;
DELETE FROM `velocitye-comm`.`orders`
WHERE orders.id = 2;

UPDATE `velocitye-comm`.`orders`
SET Status = 'Pending Done'
WHERE Status = 'Pending Payment';
UPDATE `velocitye-comm`.`orders`
SET Status = 'Pending Done'
WHERE Status = 'Pending Payment' AND orders.id IS NOT NULL;
SET SQL_SAFE_UPDATES = 0;
update orders set Status='Pending Payment' where id in(41,42);
update User set Role='customer' where Uid=9;
