package com.erick.MySQLParser.antlr;

import com.erick.example.antlr.MySQLParser.Between_opContext;
import com.erick.example.antlr.MySQLParser.Is_or_is_notContext;
import com.erick.example.antlr.MySQLParser.Left_elementContext;
import com.erick.example.antlr.MySQLParser.Relational_opContext;
import com.erick.example.antlr.MySQLParser.Right_elementContext;
import com.erick.example.antlr.MySQLParser.Simple_expressionContext;
import com.erick.example.antlr.MySQLParser.Target_elementContext;

public class Simple_ExpressionParser {
  private Simple_expressionContext s_expression;
  private Left_elementContext      l_element;
  private Right_elementContext     r_element;
  private Relational_opContext     r_op;
  private Target_elementContext    t_element;
  private Between_opContext        b_op;
  private Is_or_is_notContext      is_or_is_not;

  /**
   * left_element relational_op right_element | 
   * target_element between_op left_element AND right_element | 
   * target_element is_or_is_not NULL
   */
  public Simple_ExpressionParser(Simple_expressionContext s_expression) {
    this.s_expression = s_expression;
    if (s_expression.left_element() != null){
      this.l_element    = s_expression.left_element();
      this.r_op         = s_expression.relational_op();
      this.r_element    = s_expression.right_element();
    }
    else if (s_expression.between_op() != null) {
      this.t_element    = s_expression.target_element();
      this.b_op         = s_expression.between_op();
      this.l_element    = s_expression.left_element();
      this.r_element    = s_expression.right_element();
    }
    else if (s_expression.is_or_is_not() != null) {
      this.t_element    = s_expression.target_element();
      this.is_or_is_not = s_expression.is_or_is_not();
    }
  }

  @Override
  public String toString() {
    String s = "";
    if (s_expression.left_element() != null) //left_element relational_op right_element ·
      s += "    Left Element: " + this.l_element.getText() + "\n    Relational Operation: " 
        + this.r_op.getText() + "\n    Right Element: " + this.r_element.getText();
    else if (s_expression.between_op() != null) //target_element between_op left_element AND right_element | 
      s += "    Target Element: " + this.t_element.getText() + "\n    Between Operation: "
        + this.b_op.getText() + "\n    Left Element:  " + this.l_element.getText() 
        + "\n     " + this.s_expression.AND().getText() + "\n     Right Element" 
        + this.r_element.getText();
    else if (s_expression.is_or_is_not() != null) //left_element relational_op right_element
      s += "    Target Element: " + this.t_element.getText() + "\n    Is or is not:  " 
        + this.is_or_is_not.getText() + "\n    " + this.s_expression.NULL().getText();
    return s;
  }
}
