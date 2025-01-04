/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import javax.script.*;
import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		//Name of all scripting languages in our environment
		List<ScriptEngineFactory> scriptEngineFactory = scriptEngineManager.getEngineFactories();
		scriptEngineFactory.iterator().forEachRemaining(it -> System.out.println(it.getEngineName()));
		//ATTENTION! Nashorn is an intrepreter for JS in Java!
		//JavaScript Nashorn is depreciated in Java 15! 
		//ATTENTION! You have to use now - graal.js!
		/*ScriptEngine engine = scriptEngineManager.getEngineByName("JavaScript");
		try{
		    Object result = engine.eval("console.log('Hello world');");
		    System.out.println(result);
		}
		catch(ScriptException ex)
		{
		    ex.printStackTrace();
		}*/
		ScriptEngine engine = scriptEngineFactory.iterator().next().getScriptEngine();
		Object options = scriptEngineFactory.iterator().next().getParameter("THREADING");
		//NULL means that multithreading is not safe!
		System.out.println("Do we allow multitreading = "+options);
		try{
		    //We are working on script scope. We can also add the variables to manager. In that case
		    //the variables will be avaiable in all scripts engines!
		    engine.eval("n = 123");
		    System.out.println("We can operate on the value from the script = "+engine.eval("n += 1"));
		    engine.put("a", "abc");
		    System.out.println("We can add the variable to the script = "+engine.eval("a+n"));
		    Object a = engine.get("a");
		    System.out.println("We can get the value from the script = "+a);
		    //We can write to file or read from the file - not all enignes approved!
		    engine.getContext().setWriter(new PrintWriter("plik.txt"));
		    //We can also call the method from the Script
		    engine.eval("function abc(arg){ return arg;}");
		    Object myFunction = ((Invocable) engine).invokeFunction("abc", "tam to była nazwa, teraz podaje argument");
		    System.out.println(myFunction);
		    //We can compile our code (if the engine allows to). Thanks to it the code is more efficience!
		    CompiledScript script = ((Compilable) engine).compile("function abc(arg){ return arg;}");
		    System.out.println("Do we compile the code = " + script); // if it's nor null it means it's work!
		    if(script != null) System.out.println("Call the method = " +script.eval()); // if we compile the code, we can call it!
		    
		}
		catch(ScriptException | FileNotFoundException | NoSuchMethodException ex)
		{
		    ex.printStackTrace();
		}
		
	}
}
