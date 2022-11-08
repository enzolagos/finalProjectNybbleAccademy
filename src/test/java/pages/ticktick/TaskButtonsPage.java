package pages.ticktick;

import controls.Button;
import org.openqa.selenium.By;

public class TaskButtonsPage {
    public Button setDateButton =new Button(By.xpath("//div[contains(@class,\"preset-time\")]/a"),"setDateButton");
    public Button taskOptions = new Button(By.xpath("//*[contains(@class,\"preset-more\")]/a"),"taskOptionsButton");

    //Dates
    public Button nextWeekButton = new Button(By.xpath("//*[contains(@class,\"icon-quick-nextweek\")]"),"nextWeekButton");
    public Button tomorrowButton = new Button(By.xpath("//*[contains(@class,\"icon-quick-tomorrow\")]"),"tomorrowButton");

    //Prioridades
    public Button highPriorityButton = new Button(By.xpath("//*[contains(@class,\"priority-3\")]"),"highPriorityButton");
    public Button lowPriorityButton = new Button(By.xpath("//*[contains(@class,\"priority-1\")]"),"lowPriorityButton");
    public Button nonPriorityButton = new Button(By.xpath("//*[contains(@class,\"priority-0\")]"),"nonPriorityButton");
}
