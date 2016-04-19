package com.erick.example.antlr;

import com.erick.MySQLParser.antlr.MySQLExpressionParser;

public class MySQLTest {

	public static void main(String[] args) {
		String query = "SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate FROM Orders INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID";
//     String query = "SELECT * FROM table_name;";
//		 String query = "SELECT column_one, column_two FROM Customers WHERE Country=Mexico";
		// String query = "SELECT column_one, column_two, column_three from
		// table_name";
		// String query = "SELECT column_one ,column_two, column_three FROM
		// table_name WHERE column_name operator value;";

		MySQLExpressionParser parser = new MySQLExpressionParser();
		parser.parse(query);
	}
}
//SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate FROM Orders INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID"