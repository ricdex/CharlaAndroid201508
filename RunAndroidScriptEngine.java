
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;



public class RunAndroidScriptEngine {

	private static Context cx;
	private static void init()
	{

		  cx = Context.enter();
		  cx.setOptimizationLevel(-1);

	}
	
	public static Boolean runProcess(String functionName,String script ,Object[] parametros ) throws Exception
	{
			
			if(script==null)
				throw new Exception("Script null");
			
			if(script.equals(""))
				throw new Exception("Script vacio");
			
			init();
			
		  Scriptable scope = cx.initStandardObjects();
			
		  ScriptableObject.putProperty(
		          scope, "javaContext", Context.javaToJS(new ProcesadorUtil(), scope));

          // Evaluate the script.
          cx.evaluateString(scope, script, "ScriptAPI", 1, null);
          
          Function function = (Function) scope.get(functionName, scope);
          
          Boolean resultado = (Boolean) function.call(cx, scope, scope, parametros);
          
          return resultado;
	}
}
