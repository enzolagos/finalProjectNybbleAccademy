package pages.ticktick;

import controls.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TagsPage {
    public Label tagsLabel = new Label(By.xpath("//p[text()=\"Tags\" and contains(@class,\"xs\")]"),"tagsLabel");
    public Button addTagButton = new Button(By.xpath("(//*[name()='use' and @*[contains(.,'#list-add')]])[2]"),"addTagButton");
    public TextBox nameTagTB = new TextBox(By.id("edit-tag-name"),"nameTagTB");
    public Button saveButton = new Button(By.xpath("//button[text()=\"Save\"]"),"saveButton");
    public Label getTagLabelByName(String name){
        return new Label(By.xpath("//p[text()='"+name+"' and contains(@class,\"text-s\")]"),"tag"+name+"Label");
    }
    public Button deleteOptionButton = new Button(By.xpath("//*[text()=\"Delete\"]"),"deleteOptionButton");
    public Label noTagsLabel = new Label(By.xpath("//*[contains(text(),\"Categorize your tasks\")]"),"noTagsLabel");

}
