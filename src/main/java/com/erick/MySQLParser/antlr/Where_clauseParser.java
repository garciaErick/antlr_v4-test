package com.erick.MySQLParser.antlr;

import com.erick.example.antlr.MySQLParser.Where_clauseContext;

public class Where_clauseParser {
  private ExpressionParser expParser;
  private Where_clauseContext w_clause;

  /**
   * WHERE expression
   */
  public Where_clauseParser(Where_clauseContext w_clause) {
    this.w_clause = w_clause;
    if (w_clause.expression() != null)
      expParser = new ExpressionParser(w_clause.expression());
  }

  @Override
  public String toString() {
    String s = "";
    s += this.w_clause.WHERE().getText() + ": \n";
    if (w_clause.expression() != null)
      s += expParser;
    return s;
  }

}
