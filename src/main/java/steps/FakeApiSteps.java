package steps;

import io.restassured.response.Response;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.python.antlr.ast.Str;
import utils.Json;
import utils.MetodosRest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FakeApiSteps extends UIInteractionSteps
{
    Logger logger= Logger.getLogger("FakeApiSteps");
    SoftAssertions softAssertions = new SoftAssertions();
    private Response response;

    @Step
    public void consumirAPIRest(String tipoMetodo, String key)
    {
        String url=Json.getUrl(key);
        logger.info("El servicio sera consumido: " + url + " ," + Json.getDescription());
        try
        {
            switch (tipoMetodo) {
                case "GET":
                    response = MetodosRest.restGet(url);
                    break;
                case "GETWITHHEADER":
                    response = MetodosRest.restGetWithHeaders(url, Json.getHeaders());
                    break;
                case "POST":
                    response = MetodosRest.restPostWithHeaders(url, Json.getBody(), Json.getHeaders());
                    break;
                case "DELETE":
                    response = MetodosRest.restDelete(url, Json.getHeaders());
                    break;
                case "PUT":
                    response = MetodosRest.restPut(url, Json.getBody());
                    break;
                default:
            }
        }
        catch(Exception e)
        {
            logger.log(Level.INFO,"Ocurrio un error");
            softAssertions.fail("Error consumiendo el servicio");
            softAssertions.assertAll();
        }
    }

    @Step
    public void verificarStatusCode(int statusCode)
    {
        try
        {
            int sc = response.getStatusCode();
            if (sc == statusCode) {
                logger.info("PASSED - STATUS CODE IS: " + sc);
            } else {
                Assert.fail("THE STATUS CODE IS NOT THE EXPECTED: " + sc);
            }
        }
        catch(Exception e)
        {
            logger.log(Level.INFO,"Ocurrio un error");
            softAssertions.fail("Error verificando el status code");
            softAssertions.assertAll();
        }
    }

    @Step
    public void verificarDatos(Map<String, String> keysResponse, Map<String, String> expectedValues)
    {
        try
        {
            List<String> results = getValorRespuestaDeMapa(keysResponse);
            List<String> expecteds = getValorEsperadoDeMapa(expectedValues);

            if (!results.equals(expecteds)) {
                Assert.fail("THE EXPECTED DATA IS NOT THE SAME FOR CONSUMPTION");
            } else {
                logger.info("GREAT, PASSED");
            }
        }
        catch(Exception e)
        {
            logger.log(Level.INFO,"Ocurrio un error");
            softAssertions.fail("Error verificando los datos");
            softAssertions.assertAll();
        }
    }

    private List<String> getValorRespuestaDeMapa(Map<String, String> keysResponse)
    {
        List<String> result = new ArrayList<>();
        try
        {
            for (Map.Entry<String, String> key : keysResponse.entrySet()) {
                Object path = response.path(key.getValue());
                if (path == null) {
                    result.add("NO HAY DATOS");
                } else {
                    result.add(path.toString());
                }
            }

        }
        catch(Exception e)
        {
            logger.log(Level.INFO,"Ocurrio un error");
            softAssertions.fail("Error capturando el codigo de respuesta");
            softAssertions.assertAll();
        }
        return result;
    }

    private List<String> getValorEsperadoDeMapa(Map<String, String> expectedValue)
    {
        List<String> result = new ArrayList<>();
        try
        {
            for (Map.Entry<String, String> key : expectedValue.entrySet())
            {
                Object path = key.getValue();
                if (path == null) {
                    result.add("NO HAY DATOS");
                } else {
                    result.add(path.toString());
                }
            }

        }
        catch(Exception e)
        {
            logger.log(Level.INFO,"Ocurrio un error");
            softAssertions.fail("Error capturando el valor esperado");
            softAssertions.assertAll();
        }
        return result;
    }

    public Map<String, String> getHeadersWithToken(String token)
    {

        Map<String, String> headersWithToken = Json.getHeaders();
        headersWithToken.put("Authorization", token);

        return headersWithToken;
    }

}
