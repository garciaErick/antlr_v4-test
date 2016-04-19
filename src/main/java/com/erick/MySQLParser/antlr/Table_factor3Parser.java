package com.erick.MySQLParser.antlr;

import java.util.ArrayList;

import com.erick.example.antlr.MySQLParser.Table_factor3Context;
import com.erick.example.antlr.MySQLParser.Table_factor4Context;

public class Table_factor3Parser {
  private ArrayList<Table_factor4Parser> t_factor4Parser;
  Table_factor3Context t_factor3;

  /**
   * table_factor4 ( ( LEFT | RIGHT  ) ( OUTER  )? JOIN table_factor4 join_condition  )?
   */
  public Table_factor3Parser(Table_factor3Context t_factor3) {
    this.t_factor3 = t_factor3;
    t_factor4Parser = new ArrayList<Table_factor4Parser>();
    for (Table_factor4Context tf4 : t_factor3.table_factor4()) {
      t_factor4Parser.add(new Table_factor4Parser(tf4));
    }
  }

  @Override
  public String toString() {
    String s = "";
    s += t_factor4Parser.get(0) + " ";       //table_factor4
    if (t_factor3.LEFT() != null)            //LEFT
      s += t_factor3.LEFT().getText()  + " ";   
    else if (t_factor3.RIGHT() != null)      //RIGHT
      s += t_factor3.RIGHT().getText() + " ";   
    if (t_factor3.OUTER() != null)           //OUTER
      s += t_factor3.OUTER().getText() + " ";   
    if (t_factor3.JOIN() != null)            //JOIN
      s += t_factor3.JOIN().getText()  + " ";   
    if (t_factor4Parser.size() > 1 )         //table_factor4
      s += t_factor4Parser.get(1)      + " ";
    if (t_factor3.join_condition() != null)  //join_condition
      s += t_factor3.join_condition().getText() + " ";
    return s;
  }

}
