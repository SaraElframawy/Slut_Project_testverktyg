package com.example.spring_thymeleaf.SeleniumTest;
import com.example.spring_thymeleaf.Seleniumpages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public WebDriver driver;
    private String baseURL = "http://localhost:8080/laptimes";
   public LandingPage landingPage;

   @BeforeAll
    public static void init(){

   }
    @BeforeEach
    public void setup() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
       // options.addArguments("--headless"); // Run Chrome in headless mode (without GUI)
        driver = new ChromeDriver(options);
        driver.get(baseURL);
        driver.manage().window().maximize();
        landingPage = new LandingPage();
        landingPage.setDriver(driver);


    }
    @AfterEach
    public void quit() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }




}
