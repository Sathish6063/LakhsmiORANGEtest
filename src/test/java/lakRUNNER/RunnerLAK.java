package lakRUNNER;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\saskl\\eclipse-workspace\\OrangeLAKdemo\\src\\test\\resources\\", glue= {"lakSTEPDEF"}, dryRun=false,monochrome=false,plugin="pretty")




public class RunnerLAK {
	
	public static WebDriver driver;



}
