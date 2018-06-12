/**
 *  Copyright 2017 Salvatore Giampà
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 **/

package jointyc.tutorial.helloworld;

import java.util.List;

import jointyc.analysis.parser.SyntaxTree;
import jointyc.analysis.semantic.Interpreter;
import jointyc.analysis.semantic.annotation.NonTerminalToken;
import jointyc.analysis.semantic.annotation.TerminalToken;
import jointyc.analysis.semantic.exception.SemanticException;

public class HelloWorldInterpreter implements Interpreter{
	
	@TerminalToken(type="HelloWorld.hello")
	private void hello() {
		System.out.print("hello ");
	}
	
	@TerminalToken(type="HelloWorld.world")
	private void world() {
		System.out.print("world");
	}
	
	@TerminalToken(type="HelloWorld.exclamation")
	private void exclamation() {
		System.out.print("!");
	}

	//non empty non-terminal "hello" node
	@NonTerminalToken(ruleHead = "HelloWorld.hello", ruleProduction = {"!#"})
	private void nonEmptyHello() {
		System.out.println("the world has been greeted :-D");
	}

	//empty non-terminal "hello" node
	@NonTerminalToken(ruleHead = "HelloWorld.hello", ruleProduction = {"#"})
	private void emptyHello() {
		System.out.println("no greeting to the world :-(");
	}

	//empty "exclamation" node
	@NonTerminalToken(ruleHead = "HelloWorld.exclamation", ruleProduction = {"#"})
	private void emptyExclamation() {
		System.out.println("\ngreeting not enthusiastic :-(");
	}

	//non empty "exclamation" node
	@NonTerminalToken(ruleHead = "HelloWorld.exclamation", ruleProduction = {"$HelloWorld.exclamation"})
	private void nonTerminalHello() {
		System.out.println("\nenthusiastic greeting :-D");
	}

}
