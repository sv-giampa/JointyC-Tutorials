/**
 * LICENSE HERE 
 **/

package jointyc.template;

import jointyc.analysis.parser.SyntaxTree;
import jointyc.analysis.semantic.Interpreter;
import jointyc.analysis.semantic.annotation.NonTerminalToken;
import jointyc.analysis.semantic.annotation.TerminalToken;

public class TemplateInterpreter implements Interpreter{

	@TerminalToken(type="template.templateTerminal")
	private String templateTerminal(SyntaxTree tree) {
		/*
		 * return a representation for the terminal token
		 */
		
		System.out.println("    [interpreter]: templateTerminal = " + tree.token()); //first print
		return tree.token();
	}
	
	@NonTerminalToken(ruleHead="template.axiom")
	private void axiom() {
		/*
		 * When the axiom is reached, the last semantic operations are applying
		 * 
		 * FIRST: put final operations here (e.g. close streams, close files, compute the final object, etc...)
		 * 
		 * SECOND: return the final result or object (e.g. a final representation of a program to send to a code generator)
		 */
		
		System.out.println("    [interpreter]: axiom semantics"); //last print

	}
	
	@NonTerminalToken(ruleHead="template.templateRule")
	private void templateRule() {
		/* 
		 * do some semantic operation for this rule
		 * (e.g. compute a partial result or representation, create sub-objects, define fields for the final object, etc...)
		 */
		
		System.out.println("    [interpreter]: templateRule semantics"); //second print
	}

}
