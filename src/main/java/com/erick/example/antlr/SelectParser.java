package com.erick.example.antlr;

import com.erick.example.antlr.MySQLParser.Column_list_clauseContext;
import com.erick.example.antlr.MySQLParser.Select_clauseContext;
import com.erick.example.antlr.MySQLParser.Table_referencesContext;
import com.erick.example.antlr.MySQLParser.Where_clauseContext;

public class SelectParser {
	private Select_clauseContext      s_statement;
	private Table_referencesContext   t_references;
	private Column_list_clauseContext c_list;
	private Where_clauseContext       w_clause;

	/**
	 * Creates a Select Clause Parser
	 * @param Select_clauseContext
	 *            - The select clause to parse
	 */
	public SelectParser(Select_clauseContext select_clauseContext) {
		this.s_statement  = select_clauseContext;
		this.c_list       = s_statement.column_list_clause();
		this.t_references = s_statement.table_references();
		this.w_clause     = s_statement.where_clause();
	}

	/**
	 * Getters
	 */
	public Select_clauseContext getS_statement() {
		return s_statement;
	}
	public Table_referencesContext getT_references() {
		return t_references;
	}
	public Column_list_clauseContext getC_list() {
		return c_list;
	}
	public Where_clauseContext getW_clause() {
		return w_clause;
	}
	
	public String toString(){
		String s = "SELECT: " + this.getC_list().getText() + "\nFROM: " + this.getT_references().getText();
		if(this.getW_clause() != null)
			s+= "\n" + this.getW_clause().getText();
		return s;
	}

}
