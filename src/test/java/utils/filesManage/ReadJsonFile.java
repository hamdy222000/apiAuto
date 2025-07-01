package utils.filesManage;

import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import utils.Logs;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJsonFile {
    private static String filePath ;

    private static String read(String jsonFile, String key) {
        filePath = "src/main/resources/test-data/"+jsonFile+".json";
        try {
            String jsonContent = new String( Files.readAllBytes(Paths.get(filePath)));
            if (key == null) return jsonContent;
            else{
                Object value = JsonPath.read(jsonContent, "$." + key);

                if (value instanceof String) {
                    return (String) value;
                } else {
                    return new ObjectMapper().writeValueAsString(value);
                }

            }

        } catch (Exception e) {
            Logs.error((key == null ? "cannot read json file" : "Cannot read JsonPath key '" + key +  "' from '"+jsonFile+"' - ") + e.getMessage());
        }
        return "";
    }

    public static String getKey(String jsonFile, String key){
        return read(jsonFile , key);
    }

    public static String asString(String jsonFile){
        return read(jsonFile , null);
    }


}
