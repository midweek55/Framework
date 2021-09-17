package utils;

import io.restassured.response.Response;

import java.util.logging.Level;
import java.util.logging.Logger;

import static net.serenitybdd.rest.SerenityRest.given;

/**
 * @author Jesid Cordoba
 * @version 1.0
 * Septiembre, 2021
 * contacto : jesid.cordoba@neoris.com
 * Metodos para APIs SOAP
 * */

public class MetodosSoap
{
    private MetodosSoap()
    {

    }
    private static final Logger logger= Logger.getLogger("MetodosRest");
    private static final String notice = "\n----------------------------------------------------------------\n%s\n----------------------------------------------------------------";

    /**
     * Permite consultar un servicio SOAP con el metodo POST contentType.XML
     *
     * @param urlRequest  url del servicio SOAP con los parametros incluidos, de ser necesario.
     * @param requestBody String que esta en el JSON
     * @return objeto de tipo io.restassured.response.Response con la informacion retornada por el servicio.
     * Ya sea que se presente alguna excepcion al retornar un valor nulo.
     */

    public static Response requestSoap(String urlRequest, String requestBody) {
        try {
            Response response = given().contentType("text/xml;charset=UTF-8").relaxedHTTPSValidation().
                    headers("SOAPAction","",
                            "User-Agent","Apache-HttpClient/4.1.1 (java 1.5)",
                            "Host","")
                    .body(requestBody)
                    .when().get(urlRequest)
                    .then().extract().response();
            response.getStatusCode();
            response.asString();
            return response.getBody().path("Address1");

        } catch (Exception e) {
            logger.log(Level.SEVERE, String.format(notice, e.getMessage()));
            return null;
        }
    }
}
