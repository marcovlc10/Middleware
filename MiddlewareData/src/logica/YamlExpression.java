package logica;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entidades.Boleta;

public class YamlExpression implements AbstractExpression {

    @Override
    public String interpret(String context) throws Exception {

        String result;

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Boleta boleta = mapper.readValue(context, Boleta.class);

        Gson gson = new GsonBuilder().create();

        result = gson.toJson(boleta);

        return result;
    }

}
