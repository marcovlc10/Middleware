package logica;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import entidades.Boleta;
import java.util.logging.Level;
import java.util.logging.Logger;

public class YamlPacket {

    public static String toYaml(Boleta boleta) {
        String result = "";
        
        try {

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

            result = mapper.writeValueAsString(boleta);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(YamlPacket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
    }

    public static Boleta toBoleta(String boleta) {
        try {
            return new ObjectMapper(new YAMLFactory()).readValue(boleta, Boleta.class);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(YamlPacket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
