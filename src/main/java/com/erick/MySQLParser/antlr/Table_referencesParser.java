package com.erick.MySQLParser.antlr;

import java.util.ArrayList;

import com.erick.example.antlr.MySQLParser.Table_referenceContext;
import com.erick.example.antlr.MySQLParser.Table_referencesContext;


public class Table_referencesParser {
  private Table_referencesContext t_references;
  private ArrayList<Table_referenceParser> t_referenceParser;

  /**
   * table_reference ( ( COMMA table_reference  ) | join_clause  )*
   */
  public Table_referencesParser(Table_referencesContext t_references) {
    this.t_references = t_references;
    t_referenceParser = new ArrayList<Table_referenceParser>();
    for(Table_referenceContext t : t_references.table_reference()){
      t_referenceParser.add(new Table_referenceParser(t));
    }
  }


  @Override
  public String toString() {
    String s = "FROM: ";
    for (Table_referenceParser t : t_referenceParser) {
      s += "    " + t;
    }
    if (t_references.join_clause() != null)
      s += "    " + t_references.join_clause();
    s += "\n";
    return s;
  }
}
