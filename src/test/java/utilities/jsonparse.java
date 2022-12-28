package utilities;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class jsonparse {
    public JSONObject fileRead() throws IOException, ParseException {
        JSONParser jparse = new JSONParser();
        FileReader reader= new FileReader("src/test/resources/JSON files/ESPN.json");
        Object obj1 =jparse.parse(reader);
        JSONObject jobj= (JSONObject) obj1;
        return jobj;
    }
    public Map fileReadMap() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File fileobj = new File("src/test/resources/JSON files/ESPN.json");
        Map<String,String> jobj = null;
        try {
            jobj = mapper.readValue(fileobj, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jobj;
    }
}
