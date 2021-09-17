package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/E2E.feature"},
        tags = "@Regresion",
        glue = "stepsdefinitions",
        plugin = {"pretty","json:target/cucumber-reports/cucumber.json"},
        snippets= SnippetType.CAMELCASE)
public class TestE2ERunner
{

}
