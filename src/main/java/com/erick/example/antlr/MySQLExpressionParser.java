package com.erick.example.antlr;

import java.util.BitSet;
import java.util.Locale;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class MySQLExpressionParser {
	private final ANTLRErrorListener _listener = createErrorListener();

	/**
	 * Parses a MySQL expression 
	 * @param expression
	 *            the expression to part
	 */
	public void parse(final String expression) {
		// Create a lexer that reads from our expression string
		final MySQLLexer lexer = new MySQLLexer(new ANTLRInputStream(expression));
		/*
		 * By default Antlr4 lexers / parsers have an attached error listener
		 * that prints errors to stderr. I prefer them to throw an exception
		 * instead so I implemented my own error listener which is attached
		 * here. I also remove any existing error listeners.
		 */
		lexer.removeErrorListeners();
		lexer.addErrorListener(_listener);
		/*
		 * The lexer reads characters and lexes them into token stream. The
		 * tokens are consumed by the parser that then builds an Abstract Syntax
		 * Tree.
		 */
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final MySQLParser parser = new MySQLParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(_listener);
		/*
		 * The StatContext is the root of our MySQL Abstract Syntax Tree
     * final StatContext MySQL_AST_root = parser.stat();
		 */
		// Visit all the branches of the tree to get our expression result.
    MySQLVisitor visitor = new MySQLVisitor(parser.stat());
	}

	/*
	 * Visits the branches in the expression tree recursively until we hit a
	 * leaf.
	 */

	/*
	 * Helper method to create an ANTLRErrorListener. We're only interested in
	 * the syntaxError method.
	 */
	private static ANTLRErrorListener createErrorListener() {
		return new ANTLRErrorListener() {
			public void syntaxError(final Recognizer<?, ?> arg0, final Object obj, final int line, final int position,
					final String message, final RecognitionException ex) {
				throw new IllegalArgumentException(String.format(Locale.ROOT,
						"Exception parsing expression: '%s' on line %s, position %s", message, line, position));
			}

			public void reportContextSensitivity(final Parser arg0, final DFA arg1, final int arg2, final int arg3,
					final int arg4, final ATNConfigSet arg5) {
			}

			public void reportAttemptingFullContext(final Parser arg0, final DFA arg1, final int arg2, final int arg3,
					final BitSet arg4, final ATNConfigSet arg5) {
			}

			public void reportAmbiguity(final Parser arg0, final DFA arg1, final int arg2, final int arg3,
					final boolean arg4, final BitSet arg5, final ATNConfigSet arg6) {
			}
		};
	}

}
