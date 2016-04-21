package com.erick.MySQLParser.antlr;

import java.util.ArrayList;

import com.erick.example.antlr.MySQLParser.Column_listContext;
import com.erick.example.antlr.MySQLParser.Expr_opContext;
import com.erick.example.antlr.MySQLParser.ExpressionContext;
import com.erick.example.antlr.MySQLParser.Join_conditionContext;

public class Join_conditionParser {
  private Join_conditionContext       j_condition;
  private ArrayList<ExpressionParser> expParsers;
  private ArrayList<Expr_opContext>   exp_Ops;
  private Column_listContext          c_list;

  /**
   * ( ON expression ( expr_op expression  )*  ) | ( USING column_list  )
   */
  public Join_conditionParser(Join_conditionContext j_condition) {
    this.j_condition = j_condition;
    if (!j_condition.expression().isEmpty()){
      expParsers = new ArrayList<ExpressionParser>();
      for (ExpressionContext e : j_condition.expression()) {
        expParsers.add(new ExpressionParser(e));
      }
    }
    if (!j_condition.expr_op().isEmpty()) {
      exp_Ops = new ArrayList<Expr_opContext>();
      for (Expr_opContext e_op : j_condition.expr_op()) {
        exp_Ops.add(e_op);
      }
    }
    if (j_condition.column_list() != null){
      c_list = j_condition.column_list();
    }
  }

  @Override
  public String toString() {
    String s = "";
    if (!expParsers.isEmpty()){
      s += "    " + j_condition.ON().getText() + "\n";
      for(ExpressionParser e: expParsers)
        s += e;
    }
    else if (c_list != null) {
      s += c_list;
    }
    return s;
  }

}
