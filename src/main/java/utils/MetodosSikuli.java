package utils;

import org.sikuli.script.*;

public class MetodosSikuli
{
    Screen screen = new Screen();

    public void cargarRutaImagenes()
    {
        ImagePath.add(System.getProperty("user.dir"));
    }

    public void abrirAplicacionWindows(String nombreApp)
    {
        pulsarTecla("WINDOWS");
        screen.type(nombreApp);
    }

    public void cliquear(String nombreImagen) throws FindFailed
    {
        screen.click(nombreImagen);
    }

    public void escribir(String rutaImagen, String dato)
    {
        screen.type(rutaImagen,dato);
    }

    public void pulsarTecla(String tecla)
    {
        switch(tecla)
        {
            case "ENTER":
                screen.type(Key.ENTER);
                break;
            case "WINDOWS":
                screen.type(Key.WIN);
                break;
            case "ESPACIO":
                screen.type(Key.SPACE);
                break;
            case "SHIFT":
                screen.type(Key.SHIFT);
                break;
            case "ESCAPE":
                screen.type(Key.ESC);
                break;
            case "F1":
                screen.type(Key.F1);
                break;
            case "F2":
                screen.type(Key.F1);
                break;
            case "F3":
                screen.type(Key.F1);
                break;
            case "F4":
                screen.type(Key.F1);
                break;
            case "F5":
                screen.type(Key.F1);
                break;
            default:
                break;
        }
    }
}