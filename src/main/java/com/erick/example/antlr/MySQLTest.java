package com.erick.example.antlr;

public class MySQLTest {

	public static void main(String[] args) {
    String query = "SELECT column_name from table_name";
//    String query = "CREATE VIEW test.v AS SELECT * FROM t;";
    MySQLExpressionParser parser = new MySQLExpressionParser();
    parser.parse(query);
	}
}
