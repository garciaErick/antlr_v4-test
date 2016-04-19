package com.erick.MySQLParser.antlr;

import com.erick.example.antlr.MySQLParser.Table_factor2Context;

public class Table_factor2Parser {
  private Table_factor2Context t_factor2;
  private Table_factor3Parser t_factor3Parser;
  private Table_atomParser t_atomParser;

  /**
  * table_factor3 ( STRAIGHT_JOIN table_atom ( ON expression  )?  )?
  */
  public Table_factor2Parser(Table_factor2Context t_factor2) {
    this.t_factor2 =t_factor2;
    t_factor3Parser = new Table_factor3Parser(t_factor2.table_factor3());
    if ( t_factor2.table_atom() != null )
      t_atomParser = new Table_atomParser(t_factor2.table_atom());
  }


  @Override
  public String toString(){
    String s = "";
    s+= t_factor3Parser;                   //table_factor3
    if (t_factor2.STRAIGHT_JOIN() != null) //STRAIGHT_JOIN table_atom
      s+= t_factor2.STRAIGHT_JOIN().getText() + " "  + t_atomParser + " ";
    if (t_factor2.ON() != null)            //ON expression
      s += t_factor2.ON().getText() + " " + t_factor2.expression().getText() + " ";
    return s;

  }

}
