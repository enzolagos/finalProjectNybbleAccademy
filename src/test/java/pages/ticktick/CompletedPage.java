package pages.ticktick;

import controls.Control;
import org.openqa.selenium.By;

public class CompletedPage {
    public Control listOfCompletedTasks = new Control(By.xpath("//div[contains(@section-id,\"completed\")]/.."),"listOfCompletedTasks");
}
