package Automatiofirstprojrct_april.Automatiofirstprojrct_april;

import static org.testng.Assert.expectThrows;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

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
	private Object ActualDepatureDate;

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

	@Test(priority = 1,enabled = false)
	public void CheckWebsiteLanaguge(String Expactedlanguage) {
		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");


		Assert.assertEquals(ActualLanguage, Expactedlanguage);

	}

	@Test(priority = 2,enabled = false)
	public void CheckCurrency() {

		// xpathjust to recap what we mean by xpath you dont have to use it use css for
		// example
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();

		String ExpectedCurrency = "SAR";
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3,enabled = false)
	public void CheckContactNumber() {

		String ActualContactNumber = driver.findElement(By.linkText("+966554400000")).getText();

		String ExpectedContactNumber = "+966554400000";

		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);

	}

	@Test(priority = 4,enabled = false)
	public void CheckQitaflogo() {

		WebElement Thefooter = driver.findElement(By.tagName("footer"));
		boolean ActualImageIsDisplay = Thefooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo"))
				.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();

		Assert.assertEquals(ActualImageIsDisplay, true);
	}

	@Test(priority = 5,enabled = false)
	public void CheckHotelIsNotSelectd() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-activities"));

		String ActualValue = HotelTab.getDomAttribute("aria-selected");

		String ExpectedValue = "false";
		Assert.assertEquals(ActualValue, ExpectedValue);

	}

	@Test(priority = 6,enabled = false)
	public void FlightDepatureDate() {

		LocalDate date = LocalDate.now();
		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));

		String ActualDepatureDate = dates.get(0).getText();

		int tomorrow = date.plusDays(1).getDayOfMonth();
		String tomorrowAsFormatedValue = String.format("%02d", tomorrow);
		
		System.out.println(tomorrow);
		System.out.println(ActualDepatureDate);
		System.out.println(tomorrowAsFormatedValue);
		
		Assert.assertEquals(ActualDepatureDate,tomorrowAsFormatedValue);
	}

	@Test(priority = 7,enabled = false)
	public void FlightReturnDate() {
		LocalDate date = LocalDate.now();
		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));

		String ActualReturnDate = dates.get(1).getText();

		int dayAftertomorrow = date.plusDays(2).getDayOfMonth();
		String dayAftertomorrowAsFormatedValue = String.format("%02d", dayAftertomorrow);
		
		
		
		Assert.assertEquals(ActualReturnDate,dayAftertomorrowAsFormatedValue);
		System.out.println(ActualReturnDate);
		System.out.println(dayAftertomorrow);
		System.out.println(dayAftertomorrowAsFormatedValue);
		
	}
	
	@Test(priority = 8,invocationCount = 10 )
	public void ChangeTheWebsitelanaguage()  {
	String [] Webistes = {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
	
	Random rand = new Random();
	
	int randomIndex = rand.nextInt(Webistes.length);
	driver.get(Webistes[randomIndex]);
		
		if(driver.getCurrentUrl().contains("en")) {
			
			CheckWebsiteLanaguge("en");
		}else {
			CheckWebsiteLanaguge("ar");
		}
	}
	
	
	@AfterTest
	public void AftermyTest() {
	}

}