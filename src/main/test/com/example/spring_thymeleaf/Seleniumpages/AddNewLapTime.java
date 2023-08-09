package com.example.spring_thymeleaf.Seleniumpages;

import io.qase.api.annotation.Step;
import org.openqa.selenium.By;

public class AddNewLapTime extends BasePage{
    By inputSearch = By.id("input-laptime");
    By saveButton = By.id("save-button");
    By logOfTheLapTime = By.xpath("/html/body/div/div[1]/h3");


    @Step("Enter a laptime number {lapTime}")
    public void inputLapTimeSave(String lapTime){
        sendKeys(inputSearch,lapTime);

    }
    @Step("Clicking on the save button")
    public void saveButtonLapTime(){
        click(saveButton);
    }
    @Step("Get te text from the page to compare it with what was expecting")
    public String getTheTextOfTheLapTime(){
        return getText(logOfTheLapTime);



    }
}
