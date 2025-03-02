package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/html-reports/Runner_Test.html",
                "pretty"},
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@Getir",
        dryRun = false
        )
public class Runner {

}
