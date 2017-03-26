import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.csvreader.CsvReader;

@RunWith(Parameterized.class)
public class SeleniumTest {
	private WebDriver driver;
	private String url;
	static ArrayList<String[]> csvList;
	String id;
	String email;
	
	public SeleniumTest (String id, String email) {
		this.id = id;
		this.email = email;
	}

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "F:/Firefox/firefox.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(-2000, 0));
		url = "http:/121.193.130.195:8080/";
	}
	
	@After
	public void tearDown(){
		driver.quit(); 
	}
	
	@Parameters
	public static Collection<Object[]> getData() {
		 readcsv();
		 Object[][] obj = new Object[109][];
		 int count = 0;
		 while(!csvList.get(count)[0].equals("")){
			 obj[count] = new Object[]{csvList.get(count)[0], csvList.get(count)[1]};
			 count++;
		 }
		 return Arrays.asList(obj);
	}

	@Test
	public void test() {
		String pwd = id.substring(id.length() - 6 , id.length());
        
        driver.get(url);
 		driver.findElement(By.id("name")).sendKeys(id);
 		driver.findElement(By.id("pwd")).sendKeys(pwd);
 		driver.findElement(By.id("submit")).click();	 
 		
 		List<WebElement> element  = (List<WebElement>) driver.findElements(By.tagName("td"));
 		
 		
 		assertEquals(this.email, element.get(1).getText()); 
	}
	
	
	public static void readcsv() {
		 try {      
			 csvList = new ArrayList<String[]>();  
		     String csvFilePath = "src/inputgit.csv";  
		     CsvReader reader = new CsvReader();
		     while(reader.readRecord()){
		    	csvList.add(reader.getValues());  
		     }   		  
		     reader.close();  
		    }catch(Exception ex){  
		        System.out.println(ex);  
		    }
	}
}
