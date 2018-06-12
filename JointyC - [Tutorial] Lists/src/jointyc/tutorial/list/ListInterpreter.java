package jointyc.tutorial.list;

import java.util.LinkedList;
import java.util.List;

import jointyc.analysis.parser.SyntaxTree;
import jointyc.analysis.semantic.Interpreter;
import jointyc.analysis.semantic.annotation.NonTerminalToken;
import jointyc.analysis.semantic.annotation.TerminalToken;
import jointyc.analysis.semantic.exception.SemanticException;

public class ListInterpreter implements Interpreter {

	@TerminalToken(type="listTut.string")
	private String string(SyntaxTree tree) {
		String string =  tree.token();
		return string.substring(1, string.length()-1);
	}
	
	@TerminalToken(type="listTut.number")
	private Double number(SyntaxTree tree) {
		return Double.valueOf(tree.token());
	}
	
	@NonTerminalToken(ruleHead="listTut.homoList", ruleProduction= {"$listTut.homoOpen", "$listTut.string"})
	private List<String> homoListString(String...strings) {
		List<String> list = new LinkedList<>();
		for(String s : strings) 
			list.add(s);
		return list;
	}
	
	@NonTerminalToken(ruleHead="listTut.homoList", ruleProduction= {"$listTut.homoOpen", "$listTut.number"})
	private List<Double> homoListNumber(Double...doubles) {
		List<Double> list = new LinkedList<>();
		for(Double d : doubles) 
			list.add(d);
		return list;
	}
	
	@NonTerminalToken(ruleHead="listTut.homoList", ruleProduction= {"$listTut.homoOpen", "listTut.list"})
	private List<List<?>> homoListList(List<?>...lists) {
		List<List<?>> list = new LinkedList<>();
		for(List<?> l : lists) 
			list.add(l);
		return list;
	}
	
	@NonTerminalToken(ruleHead="listTut.homoList", ruleProduction= {"$listTut.homoOpen", "$listTut.homoClose"})
	private List<?> emptyHomoList() {
		return new LinkedList<>();
	}
	
	@NonTerminalToken(ruleHead="listTut.mixList", ruleProduction= {"$listTut.mixOpen", "listTut.value"})
	private List<?> heteroList(Object...objects) {
		List<Object> list = new LinkedList<>();
		for(Object o : objects) 
			list.add(o);
		return list;
	}
	
	@NonTerminalToken(ruleHead="listTut.mixList", ruleProduction= {"$listTut.mixOpen", "$listTut.mixClose"})
	private List<?> emptyHeteroList() {
		return new LinkedList<>();
	}

}
