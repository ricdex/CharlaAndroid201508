import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.namru6.metaweb.odk.ui.Validate;





public class RunJavaScriptEngine {

	
	
	public static Invocable generateValidate(String script  ) throws Exception
	{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine  = manager.getEngineByName("nashorn");
		engine.eval(script);
	    Invocable inv = (Invocable) engine;
        return inv;

	}
}
