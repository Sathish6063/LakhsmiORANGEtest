package lakSTEPDEF;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.Baseorange;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepLAK extends Baseorange {

	@Given("User launches application")
	public void user_launches_application() {
		getBrowser("chrome");
		getUrl("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("User enters invalid credintials")
	public void user_enters_invalid_credintials() {
		sendkey(driver.findElement(By.id("txtUsername")), "hello");
		sendkey(driver.findElement(By.id("txtPassword")), "123");
	}

	@Then("User clicks login")
	public void user_clicks_login() {
		click(driver.findElement(By.id("btnLogin")));
		String text=driver.findElement(By.id("spanMessage")).getText();
		System.out.println(text);
	}

	@Given("User clicks on forgot password")
	public void user_clicks_on_forgot_password() throws Throwable {
		click(driver.findElement(By.linkText("Forgot your password?")));
		Thread.sleep(2000);
	}

	@When("User resets password with invalid useranme")
	public void user_resets_password_with_invalid_useranme() throws Throwable {
		sendkey(driver.findElement(By.id("securityAuthentication_userName")), "hello");
		click(driver.findElement(By.id("btnSearchValues")));
		Thread.sleep(2000);
	}

	@When("User resets password with valid username")
	public void user_resets_password_with_valid_username(){
		clear(driver.findElement(By.id("securityAuthentication_userName")));
		sendkey(driver.findElement(By.id("securityAuthentication_userName")), "Admin");
		click(driver.findElement(By.id("btnSearchValues")));
	}

	@Then("User clicks on cancel")
	public void user_clicks_on_cancel() throws Throwable {
		click(driver.findElement(By.id("btnCancel")));
		Thread.sleep(2000);
	}

	@When("User clicks login button without usernmae")
	public void user_clicks_login_button_without_usernmae() throws Throwable {
		sendkey(driver.findElement(By.id("txtPassword")), "hello");
		click(driver.findElement(By.id("btnLogin")));
		String text=driver.findElement(By.id("spanMessage")).getText();
		System.out.println(text);
		Thread.sleep(2000);
	}

	@When("User clicks login button without password")
	public void user_clicks_login_button_without_password() {
		clear(driver.findElement(By.id("txtPassword")));
		sendkey(driver.findElement(By.id("txtUsername")), "hello");
		click(driver.findElement(By.id("btnLogin")));
		String text=driver.findElement(By.id("spanMessage")).getText();
		System.out.println(text);
	}

	@Then("User clicks login with valid username and password")
	public void user_clicks_login_with_valid_username_and_password() {
		clear(driver.findElement(By.id("txtUsername")));
		clear(driver.findElement(By.id("txtPassword")));
		String text=driver.findElement(By.id("content")).getText();
		System.out.println(text);
		sendkey(driver.findElement(By.id("txtUsername")), "Admin");
		sendkey(driver.findElement(By.id("txtPassword")), "admin123");
		click(driver.findElement(By.id("btnLogin")));
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File navscr=ts.getScreenshotAs(OutputType.FILE);
		File desFile= new File("C:\\Users\\saskl\\eclipse-workspace\\OrangeLAKdemo\\snaps\\germancheck.png");
		try {
			FileHandler.copy(navscr, desFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

