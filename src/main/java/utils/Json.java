package utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Json {

    private Json() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Json.class);

    private static DocumentContext datosJson;

    public static String readFile(String pathFile) {
        String text = "";
        try {

            File file = new File("src/test/resources/dataDriven/".concat(pathFile).concat(".json"));
            try (FileReader fr = new FileReader(file)) {
                try (BufferedReader br = new BufferedReader(fr)) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        text = text.concat(line);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return text;
    }

    public static void stringToJson(String file) {

        datosJson = JsonPath.parse(file);
    }

    public static String getUrl(String typeParameter) {

        String protocol = datosJson.read("protocol").toString();
        String authority = datosJson.read("authority").toString();
        String path = datosJson.read("path").toString();

        String parameters = "";
        String url = protocol.concat("://").concat(authority).concat("/").concat(path);

        if (typeParameter.equals("WithKey")) {
            parameters = getParametersWithKeyValue();
        } else {
            parameters = getParameters();
        }
        if (!parameters.equals("")) {
            url = url.concat(parameters);
        }

        return url;

    }

    public static Map<String, String> getHeaders() {
        return datosJson.read("services[0].headers");
    }

    public static String getBody() {
        String body = datosJson.read("services[0].body");
        return body.replace("\'", "");
    }

    public static String getTypeMethod() {
        return datosJson.read("services[0].method");
    }

    public static Map<String, String> getKeyResponse() {
        return datosJson.read("services[0].keyResponse");
    }

    public static Map<String, String> getExpectedResponse() {
        return datosJson.read("services[0].expectedResponse");
    }

    public static String getDescription() {
        return datosJson.read("services[0].description");
    }

    public static String getParametersWithKeyValue() {

        String parameters = "";
        Map<String, String> mapWithParameters = datosJson.read("services[0].parameters");

        if (!mapWithParameters.isEmpty()) {

            int sizeMap = mapWithParameters.size();
            int count = 1;
            parameters = "?";

            for (Map.Entry<String, String> key : mapWithParameters.entrySet()) {
                if (count < sizeMap) {
                    parameters = parameters.concat(key.getKey()).concat("=").concat(key.getValue().concat("&"));
                } else {
                    parameters = parameters.concat(key.getKey()).concat("=").concat(key.getValue());
                }
                count++;
            }

        }
        return parameters;
    }

    public static String getParameters() {

        String parameters = "";

        Map<String, String> mapWithParameters = datosJson.read("services[0].parameters[0]");

        if (!mapWithParameters.isEmpty()) {

            int sizeMap = mapWithParameters.size();
            int count = 1;
            parameters = "/";

            for (Map.Entry<String, String> key : mapWithParameters.entrySet()) {
                if (count < sizeMap) {
                    parameters = parameters.concat(key.getValue().concat("/"));
                } else {
                    parameters = parameters.concat(key.getValue());
                }
                count++;
            }

        }
        return parameters;
    }

    public static String getTypeParameters() {
        return datosJson.read("typeParameter");
    }

}
