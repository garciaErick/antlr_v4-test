package com.erick.example.antlr;

import java.util.List;

import com.erick.example.antlr.MySQLParser.Join_clauseContext;
import com.erick.example.antlr.MySQLParser.Table_referenceContext;
import com.erick.example.antlr.MySQLParser.Table_referencesContext;


public class Table_referencesParser {
  private List<Table_referenceContext> t_references;
  private List<Join_clauseContext>     j_clause_list;


  /**
  *
  */
  public Table_referencesParser(Table_referencesContext t_references) {
    this.t_references  = t_references.table_reference();
    this.j_clause_list = t_references.join_clause();
  }

  /**
   * @return the t_references
   */
  public List<Table_referenceContext> getT_references() {
    return t_references;
  }

  /**
   * @return the j_clause_list
   */
  public List<Join_clauseContext> getJ_clause_list() {
    return j_clause_list;
  }

  @Override
  public String toString() {
    String s = "T_REFERENCES: \n";
    for(Table_referenceContext t : this.t_references){
      Table_factor1Parser t_factor1 = new Table_factor1Parser(t.table_factor1());
      s += "  Table Factor1: " + t_factor1;
      if(t.table_atom() != null)
        s += "  Table Atom: " + t.table_atom().getText();
      // s+= "Table References: "  + t.getText();
  }
    s += "\n";
    for(Join_clauseContext j : this.j_clause_list){
      s+= "Table Atom: " + j.table_atom().getText();
      s+= j.getText();
    }
    return s;
  }
}
