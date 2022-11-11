package cleanTest.ticktick.tasks;

import cleanTest.ticktick.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;
import utils.RandomString;

public class TaskSort extends TestBaseTickTick {
    @Test
    @DisplayName("Verify user can create tasks and sort them by title")
    @Description("This test case is to verify user can create 4 tasks and sort them by title")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/Pv54fE7LCGZLoQ/1?projectId=11232")
    @Epic("Tasks")
    @Feature("Sort tasks")
    @Severity(SeverityLevel.NORMAL)
    @Story("Tasks")
    public void verifyIfTasksSortWorksFine(){
        Actions actions = Session.getInstance().createAction();
        //register + login
        String user = RandomString.getAlphaNumericString(6)+"@gmail.com";
        String password = RandomString.getAlphaNumericString(6);
        homePage.signUpForFreeButton.click();
        registerPage.registerUser(user,password);
        mainPage.skipPopUpAfterRegister.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //Test
        mainPage.inboxButton.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error no se ha entrado a Inbox");
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Atest").sendKeys(Keys.ENTER).perform();
        taskButtonsPage.taskButton.step("Se crea task Aatest");
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Btest").sendKeys(Keys.ENTER).perform();
        taskButtonsPage.taskButton.step("Se crea task Bbtest");
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("22test").sendKeys(Keys.ENTER).perform();
        taskButtonsPage.taskButton.step("Se crea task 22test");
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Aatest").sendKeys(Keys.ENTER).perform();
        taskButtonsPage.taskButton.step("Se crea task Aatest");
        Assertions.assertTrue(taskButtonsPage.tasksNoDate.isControlDisplayed(), "No se crearon las tareas");

        taskButtonsPage.sortTasksButton.click();
        taskButtonsPage.byTitleButton.click();
        Assertions.assertEquals(taskButtonsPage.firstTaskLabel.getText(),"22test","No se ordeno por titulo");
    }
}
