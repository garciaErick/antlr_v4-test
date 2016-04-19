package com.erick.example.antlr;

import java.util.List;

import com.erick.example.antlr.MySQLParser.Column_list_clauseContext;
import com.erick.example.antlr.MySQLParser.Join_clauseContext;
import com.erick.example.antlr.MySQLParser.StatContext;
import com.erick.example.antlr.MySQLParser.Table_referencesContext;
import com.erick.example.antlr.MySQLParser.Where_clauseContext;

public class MySQLVisitor {
  private Table_referencesContext   t_references;
  private Column_list_clauseContext c_list_clause;
  private Where_clauseContext     w_clause;
  private List<Join_clauseContext>  j_clause_list;
  /**
   * Creates a Visitor for the SQL AST 
   * @param StatContext root
   *      - the root of our AST
   */
  public MySQLVisitor(StatContext root) {
    visit(root);
  }

  public void visit(final StatContext context) {
    /**
     * TODO Implement the Join Expression Parser
     */
    try{
      if (context.select_clause() != null) {  //SELECT
        SelectParser s_statementParser = new SelectParser(context.select_clause().get(0));
        this.t_references  = s_statementParser.getT_references();
        this.w_clause      = s_statementParser.getW_clause();
        System.out.println(s_statementParser);
      }
      if (t_references != null) {            //FROM
        Table_referencesParser t_referencesParser = new Table_referencesParser(t_references);
        this.j_clause_list = t_referencesParser.getJ_clause_list();
        System.out.println(t_referencesParser);
        System.out.println("Jclause " +  j_clause_list.isEmpty());
      }
      if (!j_clause_list.isEmpty()) {
        Join_clauseParser j_clauseParser = new Join_clauseParser(j_clause_list);
        System.out.println(j_clauseParser);
      }
    }
    catch(IllegalStateException e){
      System.out.println(e);
    }
  }

 
}
