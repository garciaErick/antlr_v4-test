package com.erick.MySQLParser.antlr;

import com.erick.example.antlr.MySQLParser.Partition_clauseContext;
import com.erick.example.antlr.MySQLParser.Table_aliasContext;
import com.erick.example.antlr.MySQLParser.Table_atomContext;
import com.erick.example.antlr.MySQLParser.Table_nameContext;

public class Table_atomParser {
  private Table_atomContext t_atom;
  private Table_nameContext t_name;
  private Table_aliasContext t_alias;
  private Partition_clauseContext p_clause;

  /**
   *
   */
  public Table_atomParser(Table_atomContext t_atom) {
    this.t_atom = t_atom;
    t_name = t_atom.table_name();
    t_alias = t_atom.table_alias();
    p_clause = t_atom.partition_clause();
    

  }

  @Override
  public String toString() {
    String s = "";
    s += t_atom.getText() + " ";
    // s += "  Table Name: "  + t_name.getText() + "\n";
    // if (t_alias != null)
    //   s += "  Table Alias: "  + t_alias.getText();
    return s;
  }

}
