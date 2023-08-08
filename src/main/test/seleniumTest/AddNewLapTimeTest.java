package seleniumTest;

import Seleniumpages.AddNewLapTime;
import Seleniumpages.LandingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


@SpringBootTest(classes = seleniumTest.AddNewLapTimeTest.class)
@DirtiesContext
public class AddNewLapTimeTest extends BaseTest{
   AddNewLapTime addNewLapTime;

 /*  @BeforeEach
    public void setUp() {
        landingPage = new LandingPage(driver); // Initialize the LandingPage instance
    }*/
    @Test
    public void testLandingPage() {

        addNewLapTime = landingPage.addNewLapTimeButton();
       String input="2";
       addNewLapTime.inputLapTimeSave(input);
       addNewLapTime.saveButtonLapTime();
       String status=addNewLapTime.getTheTextOfTheLapTime();
       String expected="Varvtid:2.0";
         Assertions.assertEquals(status,expected);
    }



}
