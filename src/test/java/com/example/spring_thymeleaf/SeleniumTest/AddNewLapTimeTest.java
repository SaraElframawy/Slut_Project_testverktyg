package com.example.spring_thymeleaf.SeleniumTest;

import com.example.spring_thymeleaf.Seleniumpages.AddNewLapTime;
import io.qase.api.annotation.QaseTitle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


//@SpringBootTest(classes = SeleniumTest.AddNewLapTimeTest.class)
//@DirtiesContext
public class AddNewLapTimeTest extends BaseTest{
   AddNewLapTime addNewLapTime;

 /*  @BeforeEach
    public void setUp() {
        landingPage = new LandingPage(driver); // Initialize the LandingPage instance
    }*/
    @Test
    @Disabled
    @QaseTitle("add new lap time on localhost project")
    public void testLandingPage() {

        addNewLapTime = landingPage.addNewLapTimeButton();
       String input="2";
       addNewLapTime.inputLapTimeSave(input);
       addNewLapTime.saveButtonLapTime();
       String status=addNewLapTime.getTheTextOfTheLapTime();
       String expected="Varvtid: 2.0";
         Assertions.assertEquals(status,expected);
    }

}
