package steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import utils.MetodosWinium;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculadoraSteps {

    Logger logger= Logger.getLogger("CalculadoraSteps");
    MetodosWinium mw=new MetodosWinium();
    String resultado;
    String rutaCalculadora;
    SoftAssertions softAssertions = new SoftAssertions();

    @Step
    public void sumar()
    {
        try
        {
            Serenity.takeScreenshot();
            rutaCalculadora="C:\\Windows\\System32\\calc.exe";
            mw.abrirApp(rutaCalculadora);
            mw.cliquear("num8Button");
            mw.cliquear("multiplyButton");
            mw.cliquear("num8Button");
            mw.cliquear("equalButton");
            resultado=mw.capturarTexto("CalculatorResults");
            //mw.cerrarApp(rutaCalculadora,"Close");
        }
        catch(Exception e)
        {
            logger.log(Level.INFO,"Ocurrio un error",e);
            softAssertions.fail("Fallo en el Quality Checkpoint de CALCULADORA");
            softAssertions.assertAll();
        }
    }
}
