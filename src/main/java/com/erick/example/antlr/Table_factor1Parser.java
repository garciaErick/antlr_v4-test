package com.erick.example.antlr;

import com.erick.example.antlr.MySQLParser.Table_factor1Context;

public class Table_factor1Parser {
  private Table_factor1Context t_factor1;
  private Table_factor2Parser t_factor2Parser;
  private Table_atomParser t_atomParser;

  /**
  *  table_factor2 ( ( INNER | CROSS  )? JOIN table_atom ( join_condition  )?  )?
  */
  public Table_factor1Parser(Table_factor1Context t_factor1) {
    this.t_factor1 = t_factor1;
    t_factor2Parser = new Table_factor2Parser(t_factor1.table_factor2());
    t_atomParser = new Table_atomParser(t_factor1.table_atom());
  }

  @Override
  public String toString(){
    String s = "";
    s += t_factor2Parser;                        //table_factor2
    if (t_factor1.INNER() != null)     
      s += t_factor1.INNER().getText() + " ";    //INNER
    else if (t_factor1.CROSS() != null)    
      s += t_factor1.CROSS().getText() + " ";    //CROSS
    if (t_factor1.JOIN() != null)    
      s+= t_factor1.JOIN().getText() + " ";      //JOIN
    if (t_atomParser != null)    
      s += t_atomParser;                         //table_atom
    //TODO - implement join_condition parse
    if (t_factor1.join_condition() != null)
      s += "\nLeft to parse: " + t_factor1.join_condition().getText() + " "; //join_condition
    return s;

  }

}
