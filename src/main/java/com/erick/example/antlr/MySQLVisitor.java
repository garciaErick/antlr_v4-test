package com.erick.example.antlr;

import java.util.List;

import com.erick.example.antlr.MySQLParser.Column_list_clauseContext;
import com.erick.example.antlr.MySQLParser.Join_clauseContext;
import com.erick.example.antlr.MySQLParser.Select_clauseContext;
import com.erick.example.antlr.MySQLParser.StatContext;
import com.erick.example.antlr.MySQLParser.Table_referencesContext;
import com.erick.example.antlr.MySQLParser.Where_clauseContext;

public class MySQLVisitor {
  private Select_clauseContext      s_statement;
  private Table_referencesContext   t_references;
  private Column_list_clauseContext c_list;
  private Where_clauseContext       w_clause;
  private List<Join_clauseContext>  j_clause_list;
  /**
   * Creates a Visitor for the SQL AST 
   * @param StatContext root
   *            - the root of our AST
   */
  public MySQLVisitor(StatContext root) {
    visit(root);
  }

  public void visit(final StatContext context) {
    /**
     * TODO Make grammar work with "DOT"
     * TODO Implement the Join Expression Parser
     * TODO Ask about what parts to parse
     */
    try{
      if (context.select_clause() != null) {
        SelectParser s_statementParser = new SelectParser(context.select_clause().get(0));
        this.s_statement               = s_statementParser.getS_statement();
        this.t_references              = s_statementParser.getT_references();
        this.c_list                    = s_statementParser.getC_list();
        this.w_clause                  = s_statementParser.getW_clause();
        System.out.println("Select Parser");
        System.out.println(s_statementParser);
      }
      if (t_references != null) {
        Table_referencesParser t_referencesParser = new Table_referencesParser(getT_references());
        this.j_clause_list = t_referencesParser.getJ_clause_list();
        System.out.println("\nTable References Parser");
        System.out.println(t_referencesParser);
      }
      if (!j_clause_list.isEmpty()) {
        Table_referencesParser t_referencesParser = new Table_referencesParser(getT_references());
        this.j_clause_list = t_referencesParser.getJ_clause_list();
      }
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
  }

  /**
   * @return the s_statement
   */
  public Select_clauseContext getS_statement() {
    return s_statement;
  }

  /**
   * @return the t_references
   */
  public Table_referencesContext getT_references() {
    return t_references;
  }
  /**
   * @return the c_list
   */
  public Column_list_clauseContext getC_list() {
    return c_list;
  }
  /**
   * @return the w_clause
   */
  public Where_clauseContext getW_clause() {
    return w_clause;
  }

  /**
   * @return the j_clause_list
   */
  public List<Join_clauseContext> getJ_clause_list() {
    return j_clause_list;
  }
}
