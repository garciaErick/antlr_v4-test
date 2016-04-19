package com.erick.MySQLParser.antlr;

import com.erick.example.antlr.MySQLParser.Column_nameContext;
import com.erick.example.antlr.MySQLParser.Column_name_aliasContext;
import com.erick.example.antlr.MySQLParser.Schema_nameContext;
import com.erick.example.antlr.MySQLParser.Table_aliasContext;

public class Column_nameParser {
  private Column_nameContext c_name;
  private Schema_nameContext schema_name;
  private Column_name_aliasContext c_alias;
  private Table_aliasContext t_alias;

  /**
   * ((schema_name DOT)? ID DOT)? ID (column_name_alias)? | (table_alias DOT)? ID | USER_VAR (column_name_alias)?
   */
  public Column_nameParser(Column_nameContext c_name) {
    this.c_name = c_name;
    this.schema_name = c_name.schema_name();
    this.c_alias = c_name.column_name_alias();
    this.t_alias = c_name.table_alias();
    
  }

  /**
   * @return the c_name
   */
  public Column_nameContext getC_name() {
    return c_name;
  }

  /**
   * @return the schema_name
   */
  public Schema_nameContext getSchema_name() {
    return schema_name;
  }

  /**
   * @return the c_alias
   */
  public Column_name_aliasContext getC_alias() {
    return c_alias;
  }

  /**
   * @return the t_alias
   */
  public Table_aliasContext getT_alias() {
    return t_alias;
  }

  public String toString() {
    String s = "";
    s += "Column: " + c_name.ID(0) + "\n ";
    if (c_name.ID().size() > 1)
      s += "     ID: " + c_name.ID(1);
    s += "\n";
    // if (c_name.schema_name() != null)  //((schema_name DOT)
    //   s += c_name.schema_name().getText() + c_name.DOT(0);
    // if (c_name.USER_VAR() != null){ //USER_VAR ( column_name_alias  )?
    //   s += c_name.USER_VAR().getText();              //USER_VAR
    //   if (c_name.column_name_alias() != null)        //column_name_alias
    //     s += c_name.column_name_alias().getText(); 
    // }
    return s;
    
  }

}
