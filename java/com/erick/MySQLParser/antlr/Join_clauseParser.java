package com.erick.MySQLParser.antlr;

import java.util.List;

import com.erick.example.antlr.MySQLParser.Join_clauseContext;

public class Join_clauseParser {
  private List<Join_clauseContext> j_clause_list;

  /**
   *
   */
  public Join_clauseParser(List<Join_clauseContext> j_clause_list) {
    this.j_clause_list = j_clause_list;
  }

  @Override
  public String toString() {
    String s = "JOIN CLAUSE:" ;
    for(Join_clauseContext j : this.j_clause_list){
      // s+= "Table Atom: " + j.table_atom().getText();
      s+= j.getText();
    }
    return s;
  }
}




