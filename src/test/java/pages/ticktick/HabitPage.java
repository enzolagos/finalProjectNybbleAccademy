package pages.ticktick;

import controls.*;
import org.openqa.selenium.By;

public class HabitPage {
    public Button addHabitButton = new Button(By.xpath("//*[@class=\"inline-block w-[18px] h-[18px] mr-[8px] cursor-pointer\"]"),"addHabitButton");
    public TextBox habitTitle = new TextBox(By.xpath("//*[@placeholder=\"Daily Check-in\"]"),"habitTitle");
    public Button saveButton = new Button(By.xpath("//*[text()=\"Save\"]"),"saveButton");
    public Control habitControl = new Control(By.xpath("//div[contains(@class,\"habit_\")]/p"),"habitControl");
    public Button habitOptionsButton = new Button(By.xpath("//*[@title=\"more\"]"),"habitOptionsButton");
    public Button deleteOptionButton = new Button(By.xpath("//*[text()=\"Delete\"]/.."),"deleteOptionButton");
    public Button deleteHabitButton = new Button(By.xpath("//button[text()=\"Delete\"]"),"deleteHabitButton");
    public Label developAHabitLabel = new Label(By.xpath("//*[@class=\"title_wenfT\"]"),"developAHabitLabel");

    public Button okButton = new Button(By.xpath("//button[text()='OK']"),"okButton");
    //frequency
    public Button frequencyOptionButton = new Button(By.xpath("//div[text()=\"Frequency\"]/following-sibling::div"),"frequencyOptionsButton");
    public Button weeklyOption = new Button(By.xpath("//div[text()=\"Weekly\"]"),"weeklyOption");

    //goal days
    public Button goalDaysOptionButton = new Button(By.xpath("//div[text()=\"Goal Days\"]/following-sibling::div"),"goalDaysOptionsButton");
    public Button sevenDaysButton = new Button(By.xpath("//span[text()=\"7 days\"]"),"7daysOption");

    //section
    public Button sectionOptionButton = new Button(By.xpath("//div[text()=\"Section\"]/following-sibling::div"),"sectionOptionsButton");
    public Button nightButton = new Button(By.xpath("//span[text()=\"Night\"]"),"7daysOption");


}
