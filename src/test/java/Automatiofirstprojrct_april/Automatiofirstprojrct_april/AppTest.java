package Automatiofirstprojrct_april.Automatiofirstprojrct_april;

import static org.testng.Assert.expectThrows;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends TesData {

	@BeforeTest
	public void mySetup() {
		Setup();

	}

	@Test(priority = 1, enabled = false)
	public void CheckWebsiteLanaguge(String Expactedlanguage) {
		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");

		Assert.assertEquals(ActualLanguage, Expactedlanguage);

	}

	@Test(priority = 2, enabled = false)
	public void CheckCurrency() {

		// xpathjust to recap what we mean by xpath you dont have to use it use css for
		// example
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();

		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}

	@Test(priority = 3, enabled = false)
	public void CheckContactNumber() {

		String ActualContactNumber = driver.findElement(By.linkText("+966554400000")).getText();

		Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);

	}

	@Test(priority = 4, enabled = false)
	public void CheckQitaflogo() {

		WebElement Thefooter = driver.findElement(By.tagName("footer"));
		boolean ActualImageIsDisplay = Thefooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo"))
				.findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();

		Assert.assertEquals(ActualImageIsDisplay, true);
	}

	@Test(priority = 5, enabled = false)
	public void CheckHotelTabIsNotSelectd() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-activities"));

		String ActualValue = HotelTab.getDomAttribute("aria-selected");

		Assert.assertEquals(ActualValue, ExpectedCheckHotelTabIsNotSelectd);

	}

	@Test(priority = 6, enabled = false)
	public void FlightDepatureDate() {

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualDepatureDate = dates.get(0).getText();
		Assert.assertEquals(ActualDepatureDate, tomorrowAsFormatedValue);
	}

	@Test(priority = 7, enabled = false)
	public void FlightReturnDate() {

		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualReturnDate = dates.get(1).getText();
		String dayAftertomorrowAsFormatedValue = String.format("%02d", dayAftertomorrow);

		Assert.assertEquals(ActualReturnDate, dayAftertomorrowAsFormatedValue);
	}

	@Test(priority = 8, enabled = true)
	public void ChangeTheWebsitelanaguage() {
		driver.get(Webistes[randomIndex]);

		if (driver.getCurrentUrl().contains("en")) {

			CheckWebsiteLanaguge("en");
		} else {
			CheckWebsiteLanaguge("ar");
		}
	}

	@Test(priority = 9, enabled = true)
	public void RandomlySelectCity() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();

		WebElement SearchInputFied = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));

		if (driver.getCurrentUrl().contains("en")) {

			SearchInputFied.sendKeys(englishCities[randomEnglishCity]);

		} else {

			SearchInputFied.sendKeys(arabicCities[randomArabicCity]);
		}

		WebElement SelectVisitorNumber = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));

		Select mySelector = new Select(SelectVisitorNumber);

		mySelector.selectByValue(Values[randomValue]);

		driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk")).click();

	}

	@Test(priority = 10)
	public void CheckTheResultsIsretrived() throws InterruptedException {
		Thread.sleep(10000);

		String Results = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']")).getText();

		if (driver.getCurrentUrl().contains("en")) {

			Assert.assertEquals(Results.contains("found"), true);
		} else {

			Assert.assertEquals(Results.contains("مكان إقامة"), true);

		}

	}

	@AfterTest
	public void AftermyTest() {
	}

}