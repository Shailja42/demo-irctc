package testCoreFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue= {"StepDefination"},
        tags={"@login"}
        )
       

public class TestRunnerFile extends AbstractTestNGCucumberTests
{
	
}