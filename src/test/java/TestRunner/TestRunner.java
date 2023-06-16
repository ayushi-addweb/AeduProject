package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"/Users/addweb/IdeaProjects/Aedu/src/test/java/Feature"},
        glue = {"Steps"},
        plugin = {"html:/Users/addweb/IdeaProjects/Aedu/Report/Aedu.html"}
)

public class TestRunner
{
abcdmnds
}
