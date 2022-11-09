package pages.ticktick;

import controls.*;
import org.openqa.selenium.By;

public class ListsPage {
    public Label listsLabel = new Label(By.xpath("//*[text()=\"Lists\" and contains(@class,\"text-xs\")]"),"listsName");
    public Button addListButton = new Button(By.xpath("(//*[name()='use' and @*[contains(.,'#list-add')]])[1]"),"addListButton");
    public TextBox listNameTB = new TextBox(By.id("edit-project-name"),"listName");
    public Button saveButton = new Button(By.xpath("//button[text()=\"Save\"]"),"saveButton");
    public UnorderedList  projectsList = new UnorderedList(By.id("project-ul"),"listOfProjects");
    public Label getProjectLabelbyName(String name){
        return new Label(By.xpath("//p[text()='"+name+"' and contains(@class,'text-s')]"),"project"+name+"Label");
    }
    public Button duplicateList = new Button(By.xpath("//*[text()='Duplicate']"),"duplicateButton");
}
