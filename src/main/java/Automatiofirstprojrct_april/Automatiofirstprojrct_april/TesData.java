package Automatiofirstprojrct_april.Automatiofirstprojrct_april;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesData {
	String TheWebsuteUrl = "https://www.almosafer.com/en";
	WebDriver driver = new ChromeDriver();
	String ExpectedCurrency = "SAR";
	String ExpectedContactNumber = "+966554400000";
	String  ExpectedCheckHotelTabIsNotSelectd = "false";
	LocalDate date = LocalDate.now();
	int tomorrow = date.plusDays(1).getDayOfMonth();
	String tomorrowAsFormatedValue = String.format("%02d", tomorrow);
	int dayAftertomorrow = date.plusDays(2).getDayOfMonth();
	String[] Webistes = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };

	Random rand = new Random();

	int randomIndex = rand.nextInt(Webistes.length);
	String[] englishCities = { "dubai", "jeddeh", "riyadh" };
	int randomEnglishCity = rand.nextInt(englishCities.length);

	String[] arabicCities = { "دبي", "جدة" };
	int randomArabicCity = rand.nextInt(arabicCities.length);
	String[] Values = { "A", "B" };
	int randomValue = rand.nextInt(Values.length);
	
	
	public void Setup() {
		driver.get(TheWebsuteUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		WebElement SettingbuttonEn = driver
				.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));
		// WebElement SettingbuttonAR
		// driver.findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));
		SettingbuttonEn.click();
	}
}
