package Seleniumpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{
    By addNewAddNewLapTime = By.linkText("Add a new laptime");


    public AddNewLapTime addNewLapTimeButton(){
        click(addNewAddNewLapTime);
        return new AddNewLapTime();
    }



}
