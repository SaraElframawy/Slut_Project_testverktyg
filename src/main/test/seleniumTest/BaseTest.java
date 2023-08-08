package seleniumTest;
import Seleniumpages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    private String baseURL = "http://localhost:8080/laptimeform";
   public LandingPage landingPage;

   @BeforeClass
    public static void init(){
       WebDriverManager.chromedriver().setup();
   }
    @BeforeMethod
    public void setup() throws InterruptedException{
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless"); // Run Chrome in headless mode (without GUI)
        driver = new ChromeDriver(options);
        driver.get(baseURL);
        driver.manage().window().maximize();
        landingPage = new LandingPage();
        landingPage.setDriver(driver);


    }



}
