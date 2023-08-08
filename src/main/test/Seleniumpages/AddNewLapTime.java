package Seleniumpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewLapTime extends BasePage{
    By inputSearch = By.id("input-laptime");
    By saveButton = By.id("save-button");
    By logOfTheLapTime = By.xpath("/html/body/div/div[1]/h3");



    public void inputLapTimeSave(String lapTime){
        sendKeys(inputSearch,lapTime);

    }
    public void saveButtonLapTime(){
        click(saveButton);
    }
    public String getTheTextOfTheLapTime(){
        return getText(logOfTheLapTime);



    }
}
