package Automatiofirstprojrct_april.Automatiofirstprojrct_april;

import static org.testng.Assert.expectThrows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	String TheWebsuteUrl = "https://www.almosafer.com/en";
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void mySetup() {
		driver.get(TheWebsuteUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		WebElement SettingbuttonEn = driver
				.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));
		// WebElement SettingbuttonAR
		// driver.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));
		SettingbuttonEn.click();

	}

	@Test(priority = 1)
	public void CheckWebsiteLanaguge() {
		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");

		String Expactedlanguage = "en";

		Assert.assertEquals(ActualLanguage, Expactedlanguage);

	}

	@Test(priority = 2)
	public void CheckCurrency() {

		// xpathjust to recap what we mean by xpath you dont have to use it use css for
		// example
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();

		String ExpectedCurrency = "SAR";
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3)
	public void CheckContactNumber() {

		String ActualContactNumber = driver.findElement(By.linkText("+966554400000")).getText();

		String ExpectedContactNumber = "+966554400000";

		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);

	}

	@Test(priority =4)
	public void CheckQitaflogo() {
		
		WebElement Thefooter = driver.findElement(By.tagName("footer"));
		boolean ActualImageIsDisplay = Thefooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo")).findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();
		
		Assert.assertEquals(ActualImageIsDisplay, true);
	}
	@AfterTest
	public void AftermyTest() {
	}

}