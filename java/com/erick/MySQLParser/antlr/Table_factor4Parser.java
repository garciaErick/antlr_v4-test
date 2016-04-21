package com.erick.MySQLParser.antlr;

import com.erick.example.antlr.MySQLParser.Table_factor4Context;

public class Table_factor4Parser {
  Table_factor4Context t_factor4;

  /**
   * table_atom ( NATURAL ( ( LEFT | RIGHT  ) ( OUTER  )?  )? JOIN table_atom  )?
   */
  public Table_factor4Parser(Table_factor4Context t_factor4) {
    this.t_factor4 = t_factor4;
  }

  @Override
  public String toString() {
    String s = "";
    s += t_factor4.table_atom(0).getText() + " ";   //table_atom
    // s += t_factor4.getText();
    return s;
  }

}
