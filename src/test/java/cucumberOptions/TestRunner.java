package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
        glue = "stepDefinitions",
        monochrome = true,
        plugin = {"pretty",
                "html:target/site/cucumber-report-default.html", "json:target/site/cucumber.json"},
        snippets = SnippetType.CAMELCASE,
        tags = "@multiple_param")


public class TestRunner {
}
