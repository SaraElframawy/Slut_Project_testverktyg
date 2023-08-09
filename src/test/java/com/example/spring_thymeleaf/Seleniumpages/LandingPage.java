package com.example.spring_thymeleaf.Seleniumpages;

import io.qase.api.annotation.Step;
import org.openqa.selenium.By;
public class LandingPage extends BasePage{
    By addNewAddNewLapTime = By.id("addtodo-button");

    @Step("Pressing the add new lap time button")
    public AddNewLapTime addNewLapTimeButton(){
        click(addNewAddNewLapTime);
        return new AddNewLapTime();
    }
}
