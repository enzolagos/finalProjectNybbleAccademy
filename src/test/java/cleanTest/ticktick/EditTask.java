package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class EditTask extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can create and edit a task")
    @Description("This test case is to verify user can create and edit a task")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/OoJASNKVuDd7Zl/1?projectId=11232")
    @Epic("Tasks")
    @Feature("Edit task")
    @Severity(SeverityLevel.NORMAL)
    @Story("Task edition")
    public void verifyUserCanEditATask() throws InterruptedException {
        Actions actions = Session.getInstance().createAction();
        //Login
        String user = "prueprue@gmail.com";
        String password = "prueprue22";
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password);
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //Test
        mainPage.inboxButton.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error no se ha entrado a Inbox");
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Testing task").sendKeys(Keys.ENTER).perform();
        taskButtonsPage.taskButton.step("Se crea una tarea de nombre 'Testing task'");
        taskButtonsPage.taskByTitle("Testing task").click();
        actions.moveToElement(taskButtonsPage.taskTitleForEdit.getControl()).click().sendKeys("Edit").sendKeys(Keys.ENTER).perform();
        taskButtonsPage.taskTitleForEdit.step("Se edita la tarea creada agregandole 'Edit'");
        Assertions.assertTrue(taskButtonsPage.taskByTitle("Testing taskEdit").isControlDisplayed(),"La tarea no se modifico");

        actions.moveToElement(taskButtonsPage.taskByTitle("Testing taskEdit").getControl()).contextClick().perform();
        taskButtonsPage.deleteButton.click();
        taskButtonsPage.deletedTaskPopup.step("Se elimina la tarea");
        taskButtonsPage.deletedTaskPopup.waitUntilDissapear();

    }
}
