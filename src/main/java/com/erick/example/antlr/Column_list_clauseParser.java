package com.erick.example.antlr;

import java.util.ArrayList;
import java.util.List;

import com.erick.example.antlr.MySQLParser.Column_list_clauseContext;
import com.erick.example.antlr.MySQLParser.Column_nameContext;

public class Column_list_clauseParser {
  private List<Column_nameContext> c_list;
  // private List<Column_nameContext> c_list;
  private ArrayList<Column_nameParser> c_namesParser;

  /**
  * column_name ( COMMA column_name  )* | ASTERISK
  */
  public Column_list_clauseParser(Column_list_clauseContext c_list_clause) {
    this.c_list = c_list_clause.column_name();
    c_namesParser = new ArrayList<Column_nameParser>();
    for (Column_nameContext c_name: c_list) {
      c_namesParser.add(new Column_nameParser(c_name));
    }
  }

  @Override
  public String toString() {
    String s = "";
    for (Column_nameParser c : c_namesParser) {
      s += "  " + c;
    }
    return s;
  }

  /**
   * @return the c_list
   */
  public List<Column_nameContext> getC_list() {
    return c_list;
  }

}
