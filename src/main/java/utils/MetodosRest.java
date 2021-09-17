package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static net.serenitybdd.rest.SerenityRest.given;

/**
 * @author Jesid Cordoba
 * @version 1.0
 * Septiembre, 2021
 * contacto : jesid.cordoba@neoris.com
 * Metodos para APIs Rest
 * */
public class MetodosRest
{
    private MetodosRest()
    {

    }
    private static final Logger logger= Logger.getLogger("MetodosRest");
    private static final String notice = "\n----------------------------------------------------------------\n%s\n----------------------------------------------------------------";

    /**
     * allows to consult a REST service with get contentType.JSON method
     *
     * @param urlRequest URL of the REST service to consume with included parameters, if necessary.
     * @return object of type io.restassured.response.Response with the information returned by the service. whether
     * presents some Exception returns a null value
     */

    public static Response restGet(String urlRequest) {
        try {
            Response response = given().contentType(ContentType.JSON).relaxedHTTPSValidation()
                    .when().get(urlRequest)
                    .then().extract().response();
            response.getStatusCode();
            return response;

        } catch (Exception e) {
            logger.log(Level.SEVERE, String.format(notice, e.getMessage()));
            return null;
        }
    }

    /**
     * allows to consult a REST service with get contentType.JSON method
     *
     * @param urlRequest url of the REST service to consume with included parameters, if necessary.
     * @param header     object that implements the Map <V, K> interface that contains in key format, value the headers
     *                   necessary to consume the service
     * @return object of type io.restassured.response.Response with the information returned by the service. whether
     * presents some Exception returns a null value
     */

    public static Response restGetWithHeaders(String urlRequest, Map<String, String> header) {
        try {
            Response response = given().contentType(ContentType.JSON).relaxedHTTPSValidation().headers(header)
                    .when().get(urlRequest)
                    .then().extract().response();
            response.getStatusCode();
            return response;
        } catch (Exception e) {
            logger.log(Level.SEVERE, String.format(notice, e.getMessage()));
            return null;
        }
    }

    /**
     * allows to consult a REST service with post contentType.JSON method
     *
     * @param urlRequest url of the REST service to consume with included parameters, if necessary.
     * @param body       String that contains, in JSON format, the body to be published
     * @param headers    object that implements the Map <V, K> interface that contains in key format, value the headers
     *                   necessary to consume the service
     * @return object of type io.restassured.response.Response with the information returned by the service. whether
     * presents some Exception returns a null value
     */

    public static Response restPostWithHeaders(String urlRequest, String body, Map headers) {

        try {
            Response response = given().contentType(ContentType.JSON).relaxedHTTPSValidation().headers(headers).
                    body(body).when().post(urlRequest)
                    .then().extract().response();
            response.getStatusCode();
            return response;
        } catch (Exception e) {
            logger.log(Level.SEVERE, String.format(notice, e.getMessage()));
            return null;
        }
    }

    /**
     * allows to consult a REST service with post contentType.JSON method
     *
     * @param urlRequest url of the REST service to consume with included parameters, if necessary.
     * @param body       String that contains, in JSON format, the body to be published
     * @return object of type io.restassured.response.Response with the information returned by the service. whether
     * presents some Exception returns a null value
     */

    public static Response restPost(String urlRequest, String body) {
        try {
            Response response = given().contentType(ContentType.JSON).relaxedHTTPSValidation()
                    .body(body)
                    .when().post(urlRequest)
                    .then().extract().response();
            response.getStatusCode();
            return response;
        } catch (Exception e) {
            logger.log(Level.SEVERE, String.format(notice, e.getMessage()));
            return null;
        }
    }

    /**
     * allows to consult a REST service with Delete contentType.JSON method
     *
     * @param urlRequest url of the REST service to consume with included parameters, if necessary.
     * @param body       String that contains, in JSON format, the body to be published
     * @param headers    object that implements the Map <V, K> interface that contains in key format, value the headers
     *                   necessary to consume the service
     * @return object of type io.restassured.response.Response with the information returned by the service. whether
     * presents some Exception returns a null value
     */

    public static Response restDeleteWithBody(String urlRequest, String body, Map<String, Object> headers) {

        try {
            Response response = given().contentType(ContentType.JSON).relaxedHTTPSValidation()
                    .body(body).headers(headers).when().delete(urlRequest)
                    .then().extract().response();
            response.getStatusCode();
            return response;
        } catch (Exception e) {
            logger.log(Level.SEVERE, String.format(notice, e.getMessage()));
            return null;
        }

    }

    /**
     * allows to consult a REST service with Delete contentType.JSON method
     *
     * @param urlRequest url of the REST service to consume with included parameters, if necessary.
     * @param headers    object that implements the Map <V, K> interface that contains in key format, value the headers
     *                   necessary to consume the service
     * @return object of type io.restassured.response.Response with the information returned by the service. whether
     * presents some Exception returns a null value
     */

    public static Response restDelete(String urlRequest, Map<String, String> headers) {

        try {
            Response response = given().contentType(ContentType.JSON).relaxedHTTPSValidation().
                    headers(headers).when().delete(urlRequest).then().
                    extract().response();
            response.getStatusCode();
            return response;
        } catch (Exception e) {
            logger.log(Level.SEVERE, String.format(notice, e.getMessage()));
            return null;
        }
    }

    /**
     * allows to consult a REST service with PUT contentType.JSON method
     *
     * @param urlRequest url of the REST service to consume with included parameters, if necessary.
     * @param body       String that contains, in JSON format, the body to be published
     * @param headers    object that implements the Map <V, K> interface that contains in key format, value the headers
     *                   necessary to consume the service
     * @return object of type io.restassured.response.Response with the information returned by the service. whether
     * presents some Exception returns a null value
     */

    public static Response restPutWithHeaders(String urlRequest, String body, Map<String, String> headers) {

        try {
            Response response = given().contentType(ContentType.JSON).relaxedHTTPSValidation()
                    .headers(headers).body(body).when().put(urlRequest).then()
                    .extract().response();
            response.getStatusCode();
            return response;

        } catch (Exception e) {
            logger.log(Level.SEVERE, String.format(notice, e.getMessage()));
            return null;
        }

    }

    /**
     * allows to consult a REST service with PUT contentType.JSON method
     *
     * @param urlRequest url of the REST service to consume with included parameters, if necessary.
     * @param body       String that contains, in JSON format, the body to be published
     * @return object of type io.restassured.response.Response with the information returned by the service. whether
     * presents some Exception returns a null value
     */

    public static Response restPut(String urlRequest, String body) {

        try {
            Response response = given().contentType("Content-Type: text/xml;charset=UTF-8").relaxedHTTPSValidation()
                    .body(body).when().put(urlRequest).then()
                    .extract().response();
            response.getStatusCode();
            return response;

        } catch (Exception e) {
            logger.log(Level.SEVERE, String.format(notice, e.getMessage()));
            return null;
        }
    }
}
