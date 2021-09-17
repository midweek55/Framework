package utils;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AccionesWeb extends PageObject
{
    public void abrirUrl(String url)
    {
        getDriver().manage().window().maximize();
        getDriver().get(url);
    }

    public void cliquear(By elemento)
    {
        getDriver().findElement(elemento).click();
    }

    public void cliquearViaJavaScript(By elemento)
    {
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", elemento);
    }

    public void escribir(By elemento, String dato)
    {
        getDriver().findElement(elemento).clear();
        getDriver().findElement(elemento).sendKeys(dato);
    }

    public void cambiarFrame(WebElement frame)
    {
        getDriver().switchTo().frame(frame);
    }

    public void cambiarPestana()
    {
        for(String winHandle : getDriver().getWindowHandles()){
            getDriver().switchTo().window(winHandle);
        }
    }

    public void cerrarAlerta()
    {
        getDriver().switchTo().alert().accept();
    }

    public void escribirEnAlerta(String dato)
    {
        getDriver().switchTo().alert().sendKeys(dato);
        getDriver().switchTo().alert().accept();
    }

    public void scrollAElemento(By elemento)
    {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", elemento);
    }

    public void scrollPorCoordenadas(int ejex, int ejey)
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("javascript:window.scrollBy("+ejex+","+ejey+")");
    }

    public void esperaImplicita(int tiempo)
    {
        waitFor(tiempo).seconds();
    }

    public void esperaExplicita(By elemento, int tiempo)
    {
        WebDriverWait wait = new WebDriverWait(getDriver(),tiempo);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(elemento)));
    }

    public void capturarPantalla()
    {
        Serenity.takeScreenshot();
    }

    public void listarElementosPorTagName(String tag, int posicion)
    {
        List<WebElement> elements =getDriver().findElements(By.tagName(tag));
        for(int i=0; i<elements.size();i++)
        {
           elements.get(i).click();
        }
        elements.get(posicion).click();
    }
    public void cerrarNavegador()
    {
        getDriver().quit();
    }
}
