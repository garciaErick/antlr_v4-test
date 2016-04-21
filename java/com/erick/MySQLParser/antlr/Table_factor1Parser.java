package com.erick.MySQLParser.antlr;

import com.erick.example.antlr.MySQLParser.Table_factor1Context;

public class Table_factor1Parser {
  private Table_factor1Context t_factor1;
  private Table_factor2Parser t_factor2Parser;
  private Table_atomParser t_atomParser;
  private Join_conditionParser j_condParser;

  /**
  *  table_factor2 ( ( INNER | CROSS  )? JOIN table_atom ( join_condition  )?  )?
  */
  public Table_factor1Parser(Table_factor1Context t_factor1) {
    this.t_factor1 = t_factor1;
    t_factor2Parser = new Table_factor2Parser(t_factor1.table_factor2());
    t_atomParser = new Table_atomParser(t_factor1.table_atom());
    if (t_factor1.join_condition() != null)
      j_condParser = new Join_conditionParser(t_factor1.join_condition());
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
    if (t_factor1.join_condition() != null){
      s += "\n" + j_condParser;
    }
    return s;

  }

}
