package pages.ticktick;

import controls.Button;
import controls.CheckBox;
import controls.Label;
import org.openqa.selenium.By;

public class TaskButtonsPage {
    public Button taskOptions = new Button(By.xpath("//*[contains(@class,\"preset-more\")]/a"),"taskOptionsButton");
    public Label tasksNoDate = new Label(By.xpath("//div[@section-id=\"noDate\"]"),"noDateTasks");
    public Label completedInboxLabel = new Label(By.xpath("//h6[text()=\"Completed\"]"),"completedInboxLabel");
    public Button taskButton = new Button(By.xpath("//*[contains(@class,\"CodeMirror-line \")]"),"taskButton");
    public Label taskTitleForEdit = new Label(By.xpath("(//*[@class=\" CodeMirror-line ticktick-active-line \"])[1]"),"taskTitleForEdit");
    public Label firstTaskLabel = new Label(By.xpath("(//*[contains(@class,\"tasklist-static-title-editor\")])[1]"),"firstTaskLabel");
    public Label deletedTaskPopup = new Label(By.xpath("//*[contains(text(),'deleted successfully')]"),"deletedPopUp");
    public Label taskCompletedPopUP = new Label(By.xpath("//span[contains(text(),\" completed\")]"),"taskCompletedPopup");
    //Templates
    public Button taskFromTemplateButton = new Button(By.xpath("//*[text()=\"Add from Template\"]"),"taskFromTemplateButton");
    public Button dailyRecordOption = new Button(By.xpath("//*[text()=\"Daily record\"]"),"dailyRecordOption");


    //Sort
    public Button sortTasksButton = new Button(By.xpath("//*[contains(@class,'icon-sort-by-')]"),"sortTasksButton");
    public Button byTitleButton = new Button(By.xpath("//*[text()=\"By Title\"]"),"byTitleButton");

    //Prioridades
    public Button highPriorityButton = new Button(By.xpath("//*[contains(@class,\"priority-3\")]"),"highPriorityButton");
    public CheckBox highPriorityCheckboxIndicator = new CheckBox(By.xpath("//*[@class=\"icon-checkbox i-4 text-priority-high\"]"),"highPriorityCheckboxIndicator");

    //Options
    public Button deleteButton = new Button(By.xpath("//*[text()='Delete']"),"deleteButton");
    public Button taskCheckboxByTaskTitle(String title){
        return new Button(By.xpath("//*[text()='"+title+"']/../../../../..//*[@class='icon-checkbox i-4 text-grey-40']"),"taskCheckbox");
    }
    public Button taskByTitle(String title){
        return new Button(By.xpath("//span[text()='"+title+"' and @class='tasklist-static-title-editor staticView_3VDnb editableView_KYyqL inline_3zuKd']"),"task"+title+"Section");
    }
}
