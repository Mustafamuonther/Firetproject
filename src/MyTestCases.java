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
		WebDriver driver =new ChromeDriver();
		String Website ="https://codenboxautomationlab.com/practice/";
		Random rand= new Random();
	@BeforeTest
public void MySetUp(){
		driver.manage().window().maximize();
		driver.get(Website);
	
		
	}
	
	@Test(priority=1, description="RadioButton" )
	public void Radio_Button_Example(){
		
	List<WebElement>AllRadioButton=driver.findElements(By.className("radioButton"));
	int randomIndex =rand.nextInt(AllRadioButton.size());
	AllRadioButton.get(randomIndex).click();
		
	}
	 
	@Test (priority = 2 , description="Dynamic_Dropdown")
	 public void Dynamic_Dropdown_Example() throws InterruptedException {
		
		String[] countries_char = {"US","CA","OM","JO","BR","AR","FR","DE"};
		
		int randomIndex =rand.nextInt(countries_char.length);
		
		
		WebElement DynamiceListCountre =driver.findElement(By.id("autocomplete"));
		DynamiceListCountre.sendKeys(countries_char[randomIndex]);
		Thread.sleep(1000);
		DynamiceListCountre.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
		
		
	}
	
	@Test(priority = 3, description ="Static Dropdown" )
	
	public void Static_Dropdown(){
		
		WebElement StaticeDropdown=driver.findElement(By.id("dropdown-class-example"));
		
		Select sel =new Select(StaticeDropdown);
		
		sel.selectByIndex(3);
		
	}
	
	@Test (priority = 4, description="CheckBox")

	public void CheckBoxes () throws InterruptedException {
		
		
		List<WebElement> CheckBox =driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		int randomIndex=rand.nextInt(CheckBox.size());
		Thread.sleep(1000);
		 CheckBox.getFirst().click();
		// CheckBox.getLast().click();
		CheckBox.get(randomIndex);
		
		
		
		
		for (int i=0 ; i<CheckBox.size(); i++) {
			
		CheckBox.get(i);
			
			
		}
	}
}
