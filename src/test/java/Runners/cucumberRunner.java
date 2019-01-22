package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\java\\Features\\login.feature"
        ,glue = "src\\test\\java\\StepDefinitions\\loginStepdefs"
        ,plugin ="html:target/test-report"
       // ,dryRun = true
)

public class cucumberRunner {

}
