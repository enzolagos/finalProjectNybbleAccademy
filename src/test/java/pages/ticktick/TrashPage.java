package pages.ticktick;

import controls.*;
import org.openqa.selenium.By;

public class TrashPage {
    public Button clearTrashButton = new Button(By.xpath("//a[@title=\"Clear Trash\"]"),"clearTrashButton");
    public Button confirmDeletionButton = new Button(By.xpath("//button[text()=\"Confirm\"]"),"confirmDeletionButton");
    public Label recycleBinCleanedLabel = new Label(By.id("task-ul-list-empty"),"recycleBinCleanedLabel");
}
