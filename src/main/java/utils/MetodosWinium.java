package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import java.io.File;
import java.io.IOException;

public class MetodosWinium
{
    static DesktopOptions options;
    static WiniumDriverService service;
    static WiniumDriver driver;

    public WiniumDriver abrirApp(String rutaApp)
    {
        options = new DesktopOptions();
        options.setApplicationPath(rutaApp);
        File driverPath = new File("C:\\Users\\jesid.cordoba\\IdeaProjects\\FrameworkPOM\\src\\test\\resources\\drivers\\Winium\\Winium.Desktop.Driver.exe");
        WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
        try
        {
            service.start();
        }
        catch (IOException e)
        {
            System.out.println("Exception while starting WINIUM service");
            e.printStackTrace();
        }
        return driver = new WiniumDriver(service, options);
    }

    public void escribir(String elemento, String dato)
    {
        driver.findElement(By.id(elemento)).clear();
        driver.findElement(By.id(elemento)).sendKeys(dato);
    }


    public void cliquear(String elemento)
    {
        driver.findElement(By.id(elemento)).click();
    }

    public String capturarTexto(String elemento)
    {
        String texto = driver.findElement(By.id(elemento)).getAttribute("Name");
        return texto;
    }

    public void cerrarApp(String rutaApp, String elemento)
    {
        driver.findElement(By.id(elemento)).click();
        service.stop();
    }
}
