CREATE DATABASE PremierDB;
CREATE TABLE tblRep (rep_num CHAR(2) PRIMARY KEY,
last_name CHAR(15), 
first_name CHAR(15),
street CHAR(15),
city CHAR(15),
state CHAR(2),
zip CHAR(5),
commission DECIMAL(7,2), 
rate DECIMAL(5,2));
INSERT INTO tblRep 
VALUES('20', 'Kaiser', 'Valerie', '624 Randall', 'Grove', 'FL', '33321', '2054.50', '0.05');
INSERT INTO tblRep
VALUES('35', 'Hull', 'Richard', '532 Jackson', 'Sheldon', 'FL', '33553', '39216.00', '0.07');
INSERT INTO tblRep(rep_num, last_name, first_name)
VALUES('85','Webb', 'Tina');
SELECT * FROM tblRep;
CREATE TABLE tblCustomer (customer_num CHAR(3) PRIMARY KEY,
customer_name CHAR(35),
street CHAR(15),
city CHAR(15),
state CHAR(2),
zip CHAR(5),
balance DECIMAL(8,2),
credit_limit DECIMAL(7,2),
rep_num CHAR(2));
INSERT INTO tblCustomer
VALUES('842', 'All Season', '28 Lakeview', 'Grove', 'FL', '33321', '8221.00', '7500.00', '20');
INSERT INTO tblCustomer
VALUES('524', 'Klines', '838 Ridgeland', 'Fillmore', 'FL', '33336', '12762.00','15000.00', '20');
INSERT INTO tblCustomer
VALUES('148', 'Als Appliance and Sport', '2837 Greenway', 'Fillmore', 'FL', '33336', '6550.00','7500.00', '20');
SELECT * FROM tblCustomer;
DROP TABLE tblOrderLine;
CREATE TABLE tblOrderLine 
(order_num CHAR(5),
part_num CHAR(4),
num_ordered INT,
quoted_price DECIMAL(6,2),
CONSTRAINT orderAndPartNum PRIMARY KEY (order_num, part_num));
INSERT INTO tblOrderLine
VALUES('21608', 'AT94', '11', '21.95');
INSERT INTO tblOrderLine
VALUES('21610', 'DR93', '1', '495.00');
INSERT INTO tblOrderLine
VALUES('21610', 'DW11', '1', '399.99');
SELECT * FROM tblOrderLine;
CREATE TABLE tblOrders (order_num CHAR(5) PRIMARY KEY,
order_date DATE,
customer_num CHAR(3));
INSERT INTO tblOrders
VALUES('21608','2007-10-20','148');
INSERT INTO tblOrders
VALUES('21610','2007-10-20','356');
INSERT INTO tblOrders
VALUES('21613','2007-10-21','408');
SELECT * FROM tblOrders;
CREATE TABLE tblPart (part_num CHAR(4) PRIMARY KEY,
dscrption CHAR(15),
on_hand INT,
class CHAR(2),
warehouse CHAR(1),
price DECIMAL(6,2));
INSERT INTO tblPart
VALUES('AT94','Iron','50','HW','3','24.95');
INSERT INTO tblPart
VALUES('BV06','Home Gym','45','SG','2','794.95');
INSERT INTO tblPart
VALUES('CD52','Microwave Oven','32','AP','1','165.00');
SELECT * FROM tblPart;
SHOW TABLES;
SELECT * FROM tblRep;
SELECT customer_num, customer_name, balance, credit_limit
FROM tblcustomer
WHERE balance>credit_limit;
SELECT dscrption
FROM tblpart
WHERE warehouse = "3" and on_hand > 25;
SELECT customer_num,customer_name, (credit_limit-balance) AS available_credit
FROM tblcustomer
WHERE (credit_limit - balance) > 5000;
SELECT customer_num, customer_name, city, balance
FROM tblCustomer
ORDER BY city,customer_name;
SELECT Count(*) AS TOTAL, sum(balance) AS SUM, avg(balance) AS AVERAGE,
max(balance) AS MAX, min(balance) as MIN
FROM tblcustomer;
SELECT COUNT(DISTINCT(customer_num))
FROM tblorders;
SELECT part_num
FROM tblpart
WHERE class = "AP";
SELECT order_num
FROM tblorderline
WHERE part_num IN (SELECT part_num FROM tblpart WHERE class = "AP");
SELECT rep_num, avg(balance) as AvgOfBalance
FROM tblCustomer
GROUP BY rep_num
HAVING COUNT(*)<4
ORDER BY rep_num;
SELECT part_num, dscrption, price
FROM tblPart;
SELECT * FROM tblorders;
SELECT customer_name
FROM tblCustomer
WHERE credit_limit <= 7500;
SELECT order_num
FROM tblOrders
WHERE customer_num = "148" AND order_date = "2007-10-20";
SELECT customer_num, customer_name
FROM tblCustomer
WHERE rep_num = "35" OR rep_num = "65";
SELECT part_num, dscrption
FROM tblPart
WHERE class != "SG";
SELECT part_num, dscrption, on_hand
FROM tblPart
WHERE on_hand >= 10 AND on_hand <= 25;
SELECT part_num, dscrption, on_hand
FROM tblPart
WHERE on_hand BETWEEN 10 AND 25;
SELECT part_num, dscrption, (on_hand * price) AS on_hand_value
FROM tblPart 
WHERE class = "AP";
SELECT part_num, dscrption, (on_hand * price) AS on_hand_value
FROM tblPart
WHERE (on_hand * price) >= 7500;
SELECT part_num, dscrption
FROM tblPart
WHERE class IN ("SG","AP");
SELECT customer_name, customer_num
FROM tblCustomer
WHERE customer_name LIKE "K%";
SELECT *
FROM tblPart
ORDER BY dscrption;
SELECT *
FROM tblPart
ORDER BY class, part_num;
SELECT COUNT(customer_name)
FROM tblCustomer
WHERE balance > credit_limit;
SELECT SUM(balance)
FROM tblCustomer
WHERE rep_num = "65" AND balance < credit_limit;
SELECT part_num, dscrption, (on_hand * price) AS on_hand_value
FROM tblPart
WHERE on_hand  > (SELECT AVG(on_hand) FROM tblpart);
SELECT MAX(price)
FROM tblPart;
SELECT part_num, dscrption, price
FROM tblPart
WHERE price = (SELECT MAX(price) FROM tblPart);
SELECT rep_num, SUM(balance)
FROM tblCustomer
GROUP BY rep_num
ORDER BY rep_num; 
SELECT rep_num, SUM(balance)
FROM tblCustomer
GROUP BY rep_num
HAVING COUNT(*)<4 #Limits the groups, can only do HAVING after a GROUP BY
ORDER BY rep_num; 
SELECT credit_limit, COUNT(*) AS AmountOfCustomers
FROM tblCustomer
GROUP BY credit_limit
HAVING COUNT(*)>1;
SELECT credit_limit, COUNT(*) AS AmountOfCustomers
FROM tblCustomer
WHERE rep_num = '20' #limits before group is actually created
GROUP BY credit_limit;
SELECT credit_limit, COUNT(*) AS Expr1
FROM tblCustomer
WHERE rep_num = '20'
GROUP BY credit_limit
HAVING COUNT(*)>1; #ORDER BY goes after HAVING if necessary.
SELECT customer_num, customer_name
FROM tblCustomer
WHERE street is NULL; #nobody comes up because e/o has a street
#CONNECTING TABLES
SELECT customer_num, customer_name, tblRep.rep_num, last_name, first_name
FROM tblCustomer, tblRep
WHERE tblCustomer.rep_num = tblRep.rep_num; #use where to create relationship
SELECT customer_num, customer_name, tblRep.rep_num, last_name, first_name
FROM tblCustomer, tblRep
WHERE tblCustomer.rep_num = tblRep.rep_num #connection first
AND credit_limit = 7500; #then other wheres...
SELECT * FROM tblRep;
SELECT order_num, tblOrderLine.part_num, dscrption, num_ordered, quoted_price, price
FROM tblOrderLine, tblPart
WHERE tblPart.part_num = tblOrderLine.part_num;
SELECT dscrption
FROM tblPart, tblOrderLine
WHERE tblPart.part_num = tblOrderLine.part_num
AND order_num = '21610';
SELECT dscrption #will give same result
FROM tblPart
WHERE part_num IN(SELECT part_num FROM tblOrderLine
WHERE order_num = '21610');
SELECT order_num, order_date
FROM tblOrders
WHERE order_num IN (SELECT order_num FROM tblOrderLine WHERE
part_num = "DR93");
SELECT order_num, order_date #get same results this way...
FROM tblOrders
WHERE EXISTS (SELECT * FROM tblOrderLine 
WHERE tblOrders.order_num = tblOrderLine.order_num
AND part_num = "DR93");
SELECT tblOrders.order_num, order_date #joining more than 2 tables
FROM tblorderline, tblorders, tblpart
WHERE tblorderline.order_num = tblorders.order_num
AND tblorderline.part_num = tblpart.part_num
AND warehouse = '3';
SELECT customer_num, tblorders.order_num, order_date,
SUM(num_ordered * quoted_price) AS order_total
FROM tblorders, tblorderline
WHERE tblorders.order_num = tblorderline.order_num
GROUP BY tblorders.order_num, customer_num, order_date
HAVING SUM(num_ordered * quoted_price)>1000
ORDER BY tblorders.order_num;
SELECT R.rep_num, first_name, C.customer_num, customer_name #aliens?
FROM tblrep R, tblcustomer C
WHERE R.rep_num = C.rep_num;
SELECT F.customer_num, F.customer_name, S.customer_num, S.customer_name #ex of aliens --> looking at same table
FROM tblcustomer F, tblcustomer S
WHERE F.city = S.city
AND F.customer_num<S.customer_num #gets rid of redundancy
ORDER BY F.customer_num, S.customer_num;
SELECT rep_num,SUM(balance)
FROM tblcustomer
GROUP BY rep_num
HAVING SUM(balance)>10000;
SELECT part_num
FROM tblpart
WHERE dscrption is NULL;
SELECT order_num, order_date, tblorders.customer_num, customer_name
FROM tblorders, tblcustomer
WHERE tblcustomer.customer_num = tblorders.customer_num;
SELECT order_num, tblorders.customer_num, customer_name
FROM tblorders, tblcustomer
WHERE tblorders.customer_num = tblcustomer.customer_num AND
order_date = "2007-10-21";
SELECT tblorders.order_num, order_date, part_num, num_ordered, quoted_price
FROM tblorderline, tblorders
WHERE tblorderline.order_num = tblorders.order_num; #not sure about this one
SELECT tblcustomer.customer_num, customer_name
FROM tblcustomer,tblorders
WHERE tblcustomer.customer_num = tblorders.customer_num
AND tblorders.order_date IN('2007-10-21');
SELECT tblcustomer.customer_num, customer_name
FROM tblcustomer
WHERE EXISTS (SELECT * FROM tblorders 
WHERE tblcustomer.customer_num = tblorders.customer_num
AND tblorders.order_date IN('2007-10-21'));
SELECT tblcustomer.customer_num, customer_name
FROM tblcustomer,tblorders
WHERE tblcustomer.customer_num = tblorders.customer_num
AND tblorders.order_date != '2007-10-21';
SELECT tblorders.order_num, order_date, tblpart.part_num, dscrption, class
FROM tblorderline, tblpart, tblorders
WHERE tblorderline.order_num = tblorders.order_num AND tblorderline.part_num = tblpart.part_num
GROUP BY order_num, part_num;
SELECT tblorders.order_num, order_date, tblpart.part_num, dscrption, class
FROM tblorderline, tblpart, tblorders
WHERE tblorderline.order_num = tblorders.order_num AND tblorderline.part_num = tblpart.part_num
GROUP BY order_num, part_num
ORDER BY class, order_num;
SELECT rep_num, last_name, first_name
FROM tblrep
WHERE rep_num IN (SELECT rep_num FROM tblcustomer WHERE credit_limit = 5000);
SELECT tblrep.rep_num, last_name, first_name
FROM tblrep, tblcustomer
WHERE tblrep.rep_num = tblcustomer.rep_num AND credit_limit = 5000
GROUP BY rep_num;
SELECT tblcustomer.customer_num, customer_name
FROM tblcustomer, tblorders, tblorderline, tblpart
WHERE tblcustomer.customer_num = tblorders.customer_num AND tblorders.order_num = tblorderline.order_num
AND tblorderline.part_num = tblpart.part_num AND dscrption = "Gas Range";
SELECT A.part_num, A.dscrption, A.class, B.part_num, B.dscrption, B.class
FROM tblpart A, tblpart B
WHERE A.class = B.class AND A.part_num != B.part_num;
SELECT order_num, order_date
FROM tblorders, tblcustomer
WHERE tblcustomer.customer_num = tblorders.customer_num AND customer_name = "Johnson\'s Department Store";
SELECT tblorders.order_num, order_date
FROM tblorders, tblorderline, tblpart
WHERE tblorders.order_num = tblorderline.order_num AND tblorderline.part_num = tblpart.part_num AND dscrption = "Iron";
SELECT tblorders.order_num, order_date
FROM tblorders, tblorderline, tblpart, tblcustomer
WHERE (tblorders.order_num = tblorderline.order_num AND tblorderline.part_num = tblpart.part_num AND dscrption = "Gas Range")
OR (tblcustomer.customer_num = tblorders.customer_num AND customer_name = "Johnson\'s Department Store")
GROUP BY order_num;
SELECT tblorders.order_num, order_date
FROM tblorders, tblorderline, tblpart, tblcustomer
WHERE (tblorders.order_num = tblorderline.order_num AND tblorderline.part_num = tblpart.part_num AND dscrption = "Gas Range")
AND (tblcustomer.customer_num = tblorders.customer_num AND customer_name = "Johnson\'s Department Store")
GROUP BY order_num;
SELECT tblorders.order_num, order_date
FROM tblorders, tblorderline, tblpart, tblcustomer
WHERE (tblorders.order_num = tblorderline.order_num AND tblorderline.part_num = tblpart.part_num AND dscrption != "Treadmill")
AND (tblcustomer.customer_num = tblorders.customer_num AND customer_name = "Johnson\'s Department Store")
GROUP BY order_num;
#CLASS 5/17/2020
SELECT part_num, num_ordered, tblorderline.order_num, order_date, 
tblcustomer.customer_num, customer_name, last_name
FROM tblorderline, tblorders, tblcustomer, tblrep
WHERE tblorders.order_num = tblorderline.order_num AND tblcustomer.customer_num = tblorders.customer_num
AND tblrep.rep_num = tblcustomer.rep_num;
#UNION/INTERSECT/DIFFERENCE
SELECT customer_num, customer_name #SELECTS MUST BE THE SAME FOR BOTH TABLES...
FROM tblcustomer
WHERE rep_num = '65'
UNION
SELECT tblcustomer.customer_num, customer_name
FROM tblcustomer, tblorders
WHERE tblcustomer.customer_num = tblorders.customer_num;
SELECT customer_num, customer_name, balance, rep_num
FROM tblcustomer
WHERE balance > ALL(SELECT balance FROM tblcustomer WHERE rep_num = '65'); #ALL --> kind of like MAX
SELECT customer_num, customer_name, balance, rep_num
FROM tblcustomer
WHERE balance > ANY(SELECT balance FROM tblcustomer WHERE rep_num = '65'); #ALL --> kind of like MIN
SELECT tblcustomer.customer_num, tblcustomer.customer_name, #INNER JOIN -->
tblorders.order_num, tblorders.order_date
FROM tblcustomer
INNER JOIN tblorders
ON tblcustomer.customer_num = tblorders.customer_num
ORDER BY tblcustomer.customer_num;
SELECT tblcustomer.customer_num, tblcustomer.customer_name, #INNER JOIN -->
tblorders.order_num, tblorders.order_date
FROM tblcustomer
LEFT JOIN tblorders
ON tblcustomer.customer_num = tblorders.customer_num
ORDER BY tblcustomer.customer_num;











