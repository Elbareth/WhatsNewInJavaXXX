/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import javax.script.*;
import java.util.*;

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
		
	}
}
