package steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class PreencherFormsStep {
	
	WebDriver driver;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Drives\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	
	@Dado("que estou no site {string}")
	public void que_estou_no_site(String url) {

		driver.get(url);

	}
	
	@Quando("preencho todos os campos")
	public void preencho_todos_os_campos() {
		
		WebElement Make = driver.findElement(By.id("make"));
		Select select = new Select(Make);
		select.selectByVisibleText("BMW");
		
		WebElement Model = driver.findElement(By.id("model"));
		select = new Select(Model);
		select.selectByVisibleText("Moped");
		
		driver.findElement(By.id("cylindercapacity")).sendKeys("50");
		
		driver.findElement(By.id("engineperformance")).sendKeys("60");
		
		driver.findElement(By.cssSelector("#dateofmanufacture")).sendKeys("06/06/2021");
		
		WebElement numberSeats = driver.findElement(By.id("numberofseats"));
		select = new Select(numberSeats);
		select.selectByVisibleText("2");
		
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[1]/div[7]/p/label[1]/span")).click();
		
		WebElement comboNumberSeatsMotor = driver.findElement(By.id("numberofseatsmotorcycle"));
		select = new Select(comboNumberSeatsMotor);
		select.selectByVisibleText("1");
		
		WebElement comboFuel = driver.findElement(By.id("fuel"));
		select = new Select(comboFuel);
		select.selectByVisibleText("Gas");
		
		driver.findElement(By.id("payload")).sendKeys("25");
		
		driver.findElement(By.id("totalweight")).sendKeys("250");
		
		driver.findElement(By.cssSelector("#listprice")).sendKeys("1000");
		
		driver.findElement(By.cssSelector("#licenseplatenumber")).sendKeys("8789");
		
		driver.findElement(By.cssSelector("#annualmileage")).sendKeys("10100");
		
		driver.findElement(By.cssSelector("#nextenterinsurantdata")).click();
		
		driver.findElement(By.id("firstname")).sendKeys("Andrea");
		
		driver.findElement(By.id("lastname")).sendKeys("Cardoso");

		driver.findElement(By.id("birthdate")).sendKeys("05/19/1983");

		driver.findElement(By.xpath("//form[@id='insurance-form']/div/section[2]/div[4]/p/label[2]/span")).click();

		driver.findElement(By.id("streetaddress")).sendKeys("Rua Nove de Julho 565");

		WebElement country = driver.findElement(By.id("country"));
		select = new Select(country);
		select.selectByVisibleText("Brazil");

		driver.findElement(By.id("zipcode")).sendKeys("17509110");

		driver.findElement(By.id("city")).sendKeys("Marília");

		WebElement comboOccupation = driver.findElement(By.id("occupation"));
		select = new Select(comboOccupation);
		select.selectByVisibleText("Employee");

		driver.findElement(By.xpath("//form[@id='insurance-form']/div/section[2]/div[10]/p/label/span")).click();

		driver.findElement(By.id("website")).sendKeys("www.github/andreianet.com");

		driver.findElement(By.id("nextenterproductdata")).click();
		
		driver.findElement(By.id("startdate")).sendKeys("06/15/2022");

		WebElement insurance = driver.findElement(By.id("insurancesum"));
		select = new Select(insurance);
		select.selectByVisibleText("5.000.000,00");

		WebElement merit = driver.findElement(By.id("meritrating"));
		select = new Select(merit);
		select.selectByVisibleText("Bonus 2");

		WebElement damage = driver.findElement(By.id("damageinsurance"));
		select = new Select(damage);
		select.selectByVisibleText("No Coverage");

		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]/span")).click();

		WebElement courtesyCar = driver.findElement(By.id("courtesycar"));
		select = new Select(courtesyCar);
		select.selectByVisibleText("Yes");

		driver.findElement(By.id("nextselectpriceoption")).click();
		
		driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[2]/span")).click();

		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement next = wait
				.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("nextsendquote"))));
		next.click();
		
		driver.findElement(By.id("email")).sendKeys("andreia.netsys@gmail.com");

		driver.findElement(By.id("phone")).sendKeys("14998986191");

		driver.findElement(By.id("username")).sendKeys("andreia");

		driver.findElement(By.id("password")).sendKeys("Deia124578");

		driver.findElement(By.id("confirmpassword")).sendKeys("Deia124578");

		driver.findElement(By.id("Comments")).sendKeys("Aguardando");
				

	}

	@Quando("clico em Send")
	public void clico_em_send() {
		
		driver.findElement(By.id("sendemail")).click();

	}

	@Então("deve ser exibida a mensagem {string}")
	public void deve_ser_exibida_a_mensagem(String sendSuccess) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(15))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		WebElement usuario = wait.until(ExpectedConditions.elementToBeClickable(By.className("sa-placeholder")));

		String buscaElemento = driver.findElement(By.xpath("/html/body/div[4]/h2")).getText();

		assertEquals(sendSuccess, buscaElemento);

	}
	
	@After
	public void dps() {
		driver.quit();
	}

}
