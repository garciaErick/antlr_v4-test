package com.erick.example.antlr;

import java.util.List;

import com.erick.example.antlr.MySQLParser.Join_clauseContext;
import com.erick.example.antlr.MySQLParser.Table_referencesContext;

public class Table_referencesParser {
  private Table_referencesContext t_references;
  private List<Join_clauseContext> j_clause_list;

  /**
   *
   */
  public Table_referencesParser(Table_referencesContext t_references) {
    this.t_references = t_references;
    this.j_clause_list = t_references.join_clause();
  }

  /**
   * @return the t_references
   */
  public Table_referencesContext getT_references() {
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
    String s = "T_REFERENCES: " + t_references.getText();
    if(!this.j_clause_list.isEmpty())
      s+=j_clause_list.get(0).getText();
    return s;
  }
}
