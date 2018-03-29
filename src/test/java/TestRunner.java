

/**
 * Created by jwacker on 3/22/2018.
 */
import org.junit.runner.RunWith;
import cucumber.api.junit.*;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty",
        "html:target/test-report",
        "json:target/test-report.json",
        "junit:target/test-report.xml"},
        features="src/test/features",
        glue={"StepDefinitions"},
        tags = {"not @ignore"})
public class TestRunner {}
