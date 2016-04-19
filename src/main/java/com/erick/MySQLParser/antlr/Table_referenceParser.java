package com.erick.MySQLParser.antlr;

import com.erick.example.antlr.MySQLParser.Table_referenceContext;

public class Table_referenceParser {
  private Table_referenceContext t_reference;
  private Table_factor1Parser    t_factor1Parser;
  private Table_atomParser       t_atomParser;

  /**
   *  table_factor1 | table_atom
   */
  public Table_referenceParser(Table_referenceContext t_reference) {
    this.t_reference = t_reference;
    t_factor1Parser = new Table_factor1Parser(t_reference.table_factor1());
    // t_atomParser = new Table_atomParser(t_reference.table_atom());

  }

  @Override
  public String toString() {
    String s = "";
    s += "Goal: " + t_reference.getText() + "\n";
    if (t_factor1Parser != null)
      s += "\n" + t_factor1Parser;
    // if (t_atomParser != null)
    //   s += "" + t_atomParser;
    return s;
  }

}
