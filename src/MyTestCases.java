import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	WebDriver driver = new ChromeDriver();
	String Website = "https://codenboxautomationlab.com/practice/";
	Random rand = new Random();

	@BeforeTest
	public void MySetUp() {
		driver.manage().window().maximize();
		driver.get(Website);

	}

	@Test(priority = 1, description = "RadioButton", enabled = false)
	public void Radio_Button_Example() {

		List<WebElement> AllRadioButton = driver.findElements(By.className("radioButton"));
		int randomIndex = rand.nextInt(AllRadioButton.size());
		AllRadioButton.get(randomIndex).click();

	}

	@Test(priority = 2, description = "Dynamic_Dropdown", enabled = false)
	public void Dynamic_Dropdown_Example() throws InterruptedException {

		String[] countries_char = { "US", "CA", "OM", "JO", "BR", "AR", "FR", "DE" };

		int randomIndex = rand.nextInt(countries_char.length);

		WebElement DynamiceListCountre = driver.findElement(By.id("autocomplete"));
		DynamiceListCountre.sendKeys(countries_char[randomIndex]);
		Thread.sleep(1000);
		DynamiceListCountre.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(priority = 3, description = "Static Dropdown", enabled = false)

	public void Static_Dropdown() {

		WebElement StaticeDropdown = driver.findElement(By.id("dropdown-class-example"));

		Select sel = new Select(StaticeDropdown);

		sel.selectByIndex(3);

	}

	@Test(priority = 4, description = "CheckBox", enabled = false)

	public void CheckBoxes() throws InterruptedException {

		List<WebElement> CheckBox = driver.findElements(By.xpath("//input[@type='checkbox']"));

		//int randomIndex = rand.nextInt(CheckBox.size());
		Thread.sleep(1000);
		//CheckBox.getFirst().click();
		// CheckBox.getLast().click();
	    //CheckBox.get(randomIndex);

		for (int i = 0; i < CheckBox.size(); i++) {

			CheckBox.get(i).click();

		}
	}

	@Test(priority = 5, description = "Switch_window", enabled = false)

	public void switch_windoe_Button() throws InterruptedException {
		WebElement SwitchButton = driver.findElement(By.id("openwindow"));
		SwitchButton.click();
		List<String> windowHandels = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandels.get(1));
 
		 Thread.sleep(2000);
		WebElement contunt = driver.findElement(By.id("menu-menu-landing"));
		contunt.click();

		driver.switchTo().window(windowHandels.get(0));
		//windowHandels.close(); 
		
	}
	
	@Test(priority = 6 ,description = "Switch Tab" , enabled = false )
	public void Switch_Tab() throws InterruptedException {
		WebElement SwitchTap =driver.findElement(By.id("opentab"));
		SwitchTap.click();
		 Thread.sleep(5000);
		List<String> windowHandels = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandels.get(1));
		
		driver.close();
		
		driver.switchTo().window(windowHandels.get(0));

		
		
		
		
	}
	
	
	@Test(priority = 7, description = "Switch_To_Alert", enabled = false)
	
	public void SwitchToAlert() {
		
		WebElement InputSwitchToAlert =driver.findElement(By.id("name"));
		InputSwitchToAlert.sendKeys("Mustafa Mounther");
		
		//WebElement AlertButton =driver.findElement(By.id("alertbtn"));
		//AlertButton.click();
		
		WebElement ConfirmButton =driver.findElement(By.id("confirmbtn"));
		ConfirmButton.click();
		
		// 
		driver.switchTo().alert().accept();
		
		
		
	}
	
	@Test(priority = 8, description = " play with the data of the column ",enabled = false)

	public void Web_Table_Example() {

		WebElement TheTable = driver.findElement(By.id("product"));

		List<WebElement> TheTableWeb = TheTable.findElements(By.tagName("tr"));

		for (int i = 1; i < TheTableWeb.size(); i++) {
			
			int totalDataTable = TheTableWeb.get(i).findElements(By.tagName("td")).size();

			System.out.println(
					TheTableWeb.get(i).findElements(By.tagName("td")).get(totalDataTable - 1).getText());
		}

	}
}

























