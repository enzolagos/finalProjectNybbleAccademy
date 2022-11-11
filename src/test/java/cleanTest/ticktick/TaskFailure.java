package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;


public class TaskFailure extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can create a task with 2050 characters long name")
    @Description("This test case is to verify user can create a task which name is 2050 characters long")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/am1RiRzltLk8Z9/1?projectId=11232")
    @Epic("Tasks")
    @Feature("2050 char long task")
    @Severity(SeverityLevel.NORMAL)
    @Story("Tasks")
    public void verifyUserCanNotCreateTasksTitleLongerThan2050Char() throws InterruptedException {
        Actions actions = Session.getInstance().createAction();
        //Login
        String user = "prueprue@gmail.com";
        String password = "prueprue22";
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password);
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //test
        mainPage.inboxButton.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error no se ha entrado a Inbox");
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys(dataHelper.string2050char).sendKeys(Keys.ENTER).perform();
        taskButtonsPage.taskButton.step("Se intenta aniadir tarea de 2050 caracteres titulo");
        Assertions.assertTrue(taskButtonsPage.taskByTitle(dataHelper.string2050char).isControlDisplayed(),"La tarea no se creo");

    }
}
