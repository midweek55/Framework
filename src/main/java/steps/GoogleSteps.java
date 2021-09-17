package steps;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagesobjects.GoogleBusquedaPage;
import utils.AccionesWeb;
import org.openqa.selenium.JavascriptExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;

public class GoogleSteps extends UIInteractionSteps
{
    Logger logger= Logger.getLogger("GoogleSteps");
    AccionesWeb aw= new AccionesWeb();
    SoftAssertions softAssertions = new SoftAssertions();

    By TXT_SP_EMAIL= By.xpath("//*[@id='contact_us__correo_electronico']");
    By txt_sp_telefono = By.xpath("//*[@id=\"contact_us__telefono\"]");
    By TXT_SP_NombreyApellido = By.xpath("//*[@id=\"contact_us__nombre\"]");
    By TXT_SP_Organizacion = By.xpath("//*[@id=\"contact_us__organizacion\"]");
    By TXT_SP_Pais = By.xpath("//*[@id=\"contact_us__pais\"]/div/div[2]/span");
    By TXT_SP_Ciudad = By.xpath("//*[@id=\"contact_us__ciudad\"]");
    By TXT_SP_Prueba = By.xpath("//*[@id=\"contact_us__prueba2020\"]");
    By TXT_SP_Servicio = By.xpath("//*[@id=\"contact_us__servicios_de_interes\"]/div/div[2]/span");
    By TXT_SP_Comentario = By.xpath("//*[@id=\"contact_us__productos_de_interes\"]/div/div[2]/span");
    @Step
    public void abrirGoogle()
    {
        try
        {
            getDriver().get("https://bits-angular-stg.dev01.bitsamericas.net/contactenos");
            getDriver().manage().window().maximize();
        }
        catch(Exception e)
        {
            logger.log(Level.INFO,"Ocurrio un error",e);
            softAssertions.fail("Fallo al ingresar a Google");
            softAssertions.assertAll();
        }
    }

    @Step
    public void escribirformulario1()
    {
        try
        {
          getDriver().findElement(TXT_SP_EMAIL).sendKeys("demomail@mail.com");
        }
        catch(Exception e)
        {
            logger.log(Level.INFO,"Ocurrio un error",e);
            softAssertions.fail("Fallo al realizar la busqueda en Google");
            softAssertions.assertAll();
        }
    }
    @Step
    public void step2(){
        getDriver().findElement(txt_sp_telefono).sendKeys("3133131313");
    }
    @Step
    public void step3(){
        getDriver().findElement(TXT_SP_NombreyApellido).sendKeys("Admin Hector");
    }
    @Step
    public void step4(){
        getDriver().findElement(TXT_SP_Organizacion).sendKeys("Empresa");
    }
    @Step
    public void step5(){
        getDriver().findElement(By.xpath("//*[@id=\"contact_us__pais\"]/div/div[2]/span")).click();
        getDriver().findElement(By.xpath("//*[@id=\"contact_us__pais\"]/div/ul/li[52]/div/a/div")).click();
    }
    @Step
    public void step6(){
        getDriver().findElement(TXT_SP_Ciudad).sendKeys("Medellin");
    }
    @Step
    public void step7(){
        getDriver().findElement(TXT_SP_Prueba).sendKeys("2021");
    }
    @Step
    public void step8(){
        getDriver().findElement(By.xpath("//*[@id=\"contact_us__servicios_de_interes\"]/div/div[2]/span")).click();
        getDriver().findElement(By.xpath("//*[@id=\"contact_us__servicios_de_interes\"]/div/ul/li[2]/div/a/div")).click();
    }
    @Step
    public void step9(){
        getDriver().findElement(By.xpath("//*[@id=\"contact_us__productos_de_interes\"]/div/div[2]/span")).click();
        getDriver().findElement(By.xpath("//*[@id=\"contact_us__productos_de_interes\"]/div/ul/li[2]/div/a")).click();
    }
    @Step
    public void step10(){
        getDriver().findElement(TXT_SP_Comentario).sendKeys("Esto es una prueba Automatizada");
    }
}
