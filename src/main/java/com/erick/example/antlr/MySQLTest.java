package com.erick.example.antlr;

public class MySQLTest {

	public static void main(String[] args) {
		String query = "select fff from bob.sam";
		// String query = "SELECT column_one, column_two, column_three from
		// table_name";
		// String query = "SELECT column_one ,column_two, column_three FROM
		// table_name WHERE column_name operator value;";

		MySQLExpressionParser parser = new MySQLExpressionParser();
		parser.parse(query);
	}
}
