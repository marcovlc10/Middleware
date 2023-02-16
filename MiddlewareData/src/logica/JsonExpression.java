package logica;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.*;
import entidades.Alumno;

public class JsonExpression implements AbstractExpression {

    @Override
    public String interpret(String context) throws Exception {

        String result;

        Gson gson = new GsonBuilder().create();

        Alumno alm = gson.fromJson(context, Alumno.class);

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        result = mapper.writeValueAsString(alm);

        return result;

    }

}
