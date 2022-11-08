package pages.ticktick;

import controls.*;
import org.openqa.selenium.By;

public class WeekPage {
    public Button taskButton = new Button(By.xpath("//*[contains(@class,\"CodeMirror-line \")]"),"taskButton");
    public Button dateTaskButton = new Button(By.xpath("//*[@class = \"flex items-center relative group px-[4px]\"]"));

}
