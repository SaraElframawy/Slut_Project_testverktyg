package com.example.spring_thymeleaf.SeleniumTest;
import com.example.spring_thymeleaf.Seleniumpages.AddNewLapTime;
import io.qase.api.annotation.QaseTitle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddNewLapTimeTest extends BaseTest{
    AddNewLapTime addNewLapTime;
    @Test
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
