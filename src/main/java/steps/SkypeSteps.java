package steps;

import net.thucydides.core.annotations.Step;
import pagesobjects.GoogleBusquedaPage;
import utils.MetodosSikuli;
import org.assertj.core.api.SoftAssertions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SkypeSteps
{
    Logger logger= Logger.getLogger("CalculadoraSteps");
    MetodosSikuli ms = new MetodosSikuli();
    SoftAssertions softAssertions = new SoftAssertions();

    @Step
    public void autenticarEnSkype()
    {
        try
        {
            ms.cargarRutaImagenes();
            Thread.sleep(2000);
            ms.abrirAplicacionWindows("Skype");
            ms.pulsarTecla("ENTER");
            Thread.sleep(7000);
            ms.cliquear("src/test/resources/images_sikuli/LetsGo.PNG");
            Thread.sleep(2000);
            ms.pulsarTecla("ENTER");
            Thread.sleep(2000);
            ms.escribir("src/test/resources/images_sikuli/Correo.PNG","prueba@gmail.com");
            Thread.sleep(2000);
            ms.pulsarTecla("ENTER");
            Thread.sleep(2000);
            ms.escribir("src/test/resources/images_sikuli/Contrasena.PNG","1234567");
            Thread.sleep(2000);
            ms.pulsarTecla("ENTER");
        }
        catch(Exception e)
        {
            logger.log(Level.INFO,"Ocurrio un error",e);
            softAssertions.fail("Fallo en el Quality Checkpoint de SKYPE");
            softAssertions.assertAll();
        }
    }

}
