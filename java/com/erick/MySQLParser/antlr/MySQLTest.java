package com.erick.MySQLParser.antlr;

public class MySQLTest {

	public static void main(String[] args) {
//		String query = "SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate FROM Orders INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID";
//     String query = "SELECT * FROM table_name;";
		 // String query = "SELECT column_one, column_two FROM Customers WHERE Country=Mexico";
		// String query = "SELECT column_one, column_two, column_three from
		// table_name";
		// String query = "SELECT column_one ,column_two, column_three FROM
		// table_name WHERE column_name operator value;";
//    String query = "SELECT `dbowlizer` .  `department` .  `id` AS `id` , `dbowlizer` .  `department` .  `name` AS `name` , `dbowlizer` .  `department` .  `location` AS `location` , `dbowlizer` .  `city` .  `city_id` AS `city_id` , `dbowlizer` .  `city` .  `city_name` AS `city_name` , `dbowlizer` .  `city` .  `province` AS `province` FROM ( `dbowlizer` .  `department` JOIN `dbowlizer` .  `city` ON ( ( `dbowlizer` .  `department` .  `location` = `dbowlizer` .  `city` .  `city_name`))) WHERE ( `dbowlizer` .  `city` .  `province` = 'ONTARIO')";
    String query = "SELECT dbowlizer.department.id AS id, dbowlizer .  department .  name AS name , dbowlizer .  department .  location AS location , dbowlizer .  city .  city_id AS city_id , dbowlizer .  city .  city_name AS city_name , dbowlizer .  city .  province AS province FROM ( dbowlizer .  department JOIN `dbowlizer` .  `city` ON ( ( `dbowlizer` .  `department` .  `location` = `dbowlizer` .  `city` .  `city_name`))) WHERE ( `dbowlizer` .  `city` .  `province` = 'ONTARIO')";
		MySQLExpressionParser parser = new MySQLExpressionParser();
		parser.parse(query);
	}
}
//SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate FROM Orders INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID"
