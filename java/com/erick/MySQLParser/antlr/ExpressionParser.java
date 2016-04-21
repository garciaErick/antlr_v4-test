package com.erick.MySQLParser.antlr;

import java.util.ArrayList;

import com.erick.example.antlr.MySQLParser.ExpressionContext;
import com.erick.example.antlr.MySQLParser.Simple_expressionContext;

public class ExpressionParser {
  private ExpressionContext e_context;
  private ArrayList<Simple_ExpressionParser> s_expParsers;

  /**
   *  simple_expression (expr_op simple_expression)*
   */
  public ExpressionParser(ExpressionContext e_context) {
    s_expParsers = new ArrayList<Simple_ExpressionParser>();
    this.e_context = e_context;
    if (!e_context.simple_expression().isEmpty()) 
      for (Simple_expressionContext s_expression : e_context.simple_expression())
        s_expParsers.add(new Simple_ExpressionParser(s_expression));
  }

  @Override
  public String toString() {
    String s = "";
    for (Simple_ExpressionParser s_expParser : s_expParsers) {
      s += "" + s_expParser;
    }
    return s;
  }

}
