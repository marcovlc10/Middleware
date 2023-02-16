package logica;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Interpreter {
    
    public static String convert(String context) {
        String result = "";
        
        AbstractExpression ae;
        
        try {
            ae = new JsonExpression();
            result = ae.interpret(context);
        } catch (Exception ex) {
            ae = new YamlExpression();
            try {
                result = ae.interpret(context);
            } catch (Exception ex1) {
                Logger.getLogger(Interpreter.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        return result;
    }
    
}
