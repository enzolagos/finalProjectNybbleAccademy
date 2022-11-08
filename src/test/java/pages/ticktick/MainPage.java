package pages.ticktick;

import controls.*;
import org.openqa.selenium.By;

public class MainPage {
    //LABELS
    public Label inboxPopUpLabel = new Label(By.xpath("//h1[text()=\"Inbox\"]"),"inboxPopUpLabel");
    public Label inboxTitleLabel = new Label(By.xpath("//h5[text()='Inbox']"),"inboxTitleLabel");
    public Label noListsLabel = new Label(By.xpath("//*[text()=\"Use lists to categorize and manage your tasks and notes\"]"),"noListsLabel");
    public Label italianLabel = new Label(By.xpath("//*[text()=\"Cestino\"]"),"italianLabel");
    public Button todayButton = new Button(By.xpath("//*[text()=\"Today\"]/.."),"todayButton");
    public Label next7daysLabel =new Label(By.xpath("//h5[text()=\"Next 7 Days\"]"),"next7daysLabel");

    //BUTTONS
    public Button skipPopUpAfterRegister = new Button(By.xpath("//*[text()=\"Skip\"]"),"skipPopUpAfterRegister");
    public Button habitsButton = new Button(By.xpath("//*[@href=\"#q/all/habit\"]"),"habitsButton");
    public Button addListButton = new Button(By.xpath("//*[@class=\"add-icon w-[18px] h-[18px] flex-none opacity-0 group-hover:opacity-100 group-focus-visible:opacity-100 focus-visible:opacity-100 focus:opacity-100\"]"),"addListButton");
    public TextBox titleList = new TextBox(By.id("edit-project-name"),"titleList");
    public Button saveButton = new Button(By.xpath("//button[text()=\"Save\"]"),"saveButton");
    public Button userButton = new Button(By.id("tl-bar-user"),"userButton");
    public Button signOutButton = new Button(By.xpath("//*[text()=\"Sign Out\"]"),"signOutButton");
    public Button settingsButton = new Button(By.xpath("//*[text()=\"Settings\"]"),"settingsButton");
    public Button deleteListButton = new Button(By.xpath("//*[text()=\"Delete\"]"),"deleteListButton");
    public Button syncButton = new Button(By.xpath("//*[text()=\"Sync\"]"),"syncButton");
    public Button next7DaysButton = new Button(By.xpath("//*[text()=\"Next 7 Days\"]/.."),"next7DaysButton");

    //body
    public Control bodyControl = new Control(By.xpath("//body"),"bodyControl");

    public Button getListButton(String projectTitle){
        return new Button(By.xpath("//*[text()='"+projectTitle+"']/.."),"projectTitleButton");
    }
    public Button listOptionsButton(String projectTitle){
        return new Button(By.xpath("//*[@id=\"project-ul\"]//*[text()='"+projectTitle+"']//following-sibling::*//div"));
    }
    public Label projectTitleLabel(String projectTitle){
        return new Label(By.xpath("//h5[text()='"+projectTitle+"']"),"projectTitleLabel");
    }

}
