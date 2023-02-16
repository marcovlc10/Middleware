package logica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidades.Alumno;

public class JsonPacket {
    
    public static String toJson(Alumno alm) {
        
        Gson gson = new GsonBuilder().create();
        
        return gson.toJson(alm);
        
    }
    
    public static Alumno toAlumno(String alm) {
        
        Gson gson = new GsonBuilder().create();
        
        return gson.fromJson(alm, Alumno.class);
        
    }
    
}
