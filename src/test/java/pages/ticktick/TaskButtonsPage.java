package pages.ticktick;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class TaskButtonsPage {
    public Button setDateButton =new Button(By.xpath("//div[contains(@class,\"preset-time\")]/a"),"setDateButton");
    public Button taskOptions = new Button(By.xpath("//*[contains(@class,\"preset-more\")]/a"),"taskOptionsButton");
    public Label tasksNoDate = new Label(By.xpath("//div[@section-id=\"noDate\"]"),"noDateTasks");
    public Label completedInboxLabel = new Label(By.xpath("//h6[text()=\"Completed\"]"),"completedInboxLabel");
    public Button taskButton = new Button(By.xpath("//*[contains(@class,\"CodeMirror-line \")]"),"taskButton");
    public Label taskTitleForEdit = new Label(By.xpath("(//*[@class=\" CodeMirror-line ticktick-active-line \"])[1]"),"taskTitleForEdit");
    public Label firstTaskLabel = new Label(By.xpath("(//*[contains(@class,\"tasklist-static-title-editor\")])[1]"),"firstTaskLabel");
    public Label deletedTaskPopup = new Label(By.xpath("//*[contains(text(),'deleted successfully')]"),"deletedPopUp");

    //Templates
    public Button taskFromTemplateButton = new Button(By.xpath("//*[text()=\"Add from Template\"]"),"taskFromTemplateButton");
    public Button dailyRecordOption = new Button(By.xpath("//*[text()=\"Daily record\"]"),"dailyRecordOption");


    //Sort
    public Button sortTasksButton = new Button(By.xpath("//*[contains(@class,'icon-sort-by-')]"),"sortTasksButton");
    public Button byTitleButton = new Button(By.xpath("//*[text()=\"By Title\"]"),"byTitleButton");

    //Dates
    public Button nextWeekButton = new Button(By.xpath("//*[contains(@class,\"icon-quick-nextweek\")]"),"nextWeekButton");
    public Button tomorrowButton = new Button(By.xpath("//*[contains(@class,\"icon-quick-tomorrow\")]"),"tomorrowButton");

    //Prioridades
    public Button highPriorityButton = new Button(By.xpath("//*[contains(@class,\"priority-3\")]"),"highPriorityButton");
    public Button lowPriorityButton = new Button(By.xpath("//*[contains(@class,\"priority-1\")]"),"lowPriorityButton");
    public Button nonPriorityButton = new Button(By.xpath("//*[contains(@class,\"priority-0\")]"),"nonPriorityButton");

    //Options
    public Button deleteButton = new Button(By.xpath("//*[text()='Delete']"),"deleteButton");
    public Button taskCheckboxByTaskTitle(String title){
        return new Button(By.xpath("//*[text()='"+title+"']/../../../../..//*[@class='icon-checkbox i-4 text-grey-40']"),"taskCheckbox");
    }
    public Button taskByTitle(String title){
        return new Button(By.xpath("//span[text()='"+title+"' and @class='tasklist-static-title-editor staticView_3VDnb editableView_KYyqL inline_3zuKd']"),"taskSection");
    }
}
