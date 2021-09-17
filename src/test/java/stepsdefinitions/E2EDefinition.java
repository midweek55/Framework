package stepsdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.CalculadoraSteps;
import steps.FakeApiSteps;
import steps.GoogleSteps;
import steps.SkypeSteps;
import utils.Json;

public class E2EDefinition
{

    SkypeSteps skypeSteps=new SkypeSteps();
    CalculadoraSteps calculadoraSteps=new CalculadoraSteps();
    GoogleSteps googleSteps=new GoogleSteps();
    FakeApiSteps fakeApiSteps=new FakeApiSteps();

    @Given("^Ingreso al portal contactenos$")
    public void portalcotactenos() {
    	googleSteps.abrirGoogle();
    }
    @Then("Escribo el correo electronico en iniciar proyecto")
    public void portalcotactenosform1(){
        googleSteps.escribirformulario1();
    }
    @Then("Escribo el telefono")
    public void step2(){
        googleSteps.step2();
    }
    @Then("Escribo el Nombre Completo")
    public void step3(){
        googleSteps.step3();
    }
    @Then("Escribo la Organizacion")
    public void step4(){
        googleSteps.step4();
    }
    @Then("Selecciono un pais")
    public void step5(){
        googleSteps.step5();
    }
    @Then("Escribo una ciudad")
    public void step6(){
        googleSteps.step6();
    }
    @Then("Escribo una prueba")
    public void step7(){
        googleSteps.step7();
    }
    @Then("Seleciono un servicio de interes")
    public void step8(){
        googleSteps.step8();
    }
    @Then("Seleciono un producto de interes")
    public void step9(){
        googleSteps.step9();
    }
    @Then("Escribo un comentario")
    public void step10(){
        googleSteps.step10();
    }
}

