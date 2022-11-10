package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class HighPriorityTaskTest extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can create a task with high priority")
    @Description("This test case is to verify user can create a high priority task")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/am1RiRzltLkOKL/1?projectId=11232")
    @Epic("Tasks")
    @Feature("High priority task")
    @Severity(SeverityLevel.NORMAL)
    @Story("Tasks")
    public void verifyTasksCompletedAreInCompleteSection() throws InterruptedException {
        Actions actions = Session.getInstance().createAction();
        //Login
        String user = "testingTasks@gmail.com";
        String password = "testingTasks";
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password);
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //Test
        mainPage.inboxButton.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error no se ha entrado a Inbox");
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("High Priority Task").moveToElement(taskButtonsPage.taskOptions.getControl()).click().perform();
        taskButtonsPage.highPriorityButton.click();
        actions.sendKeys(Keys.ENTER).perform();
        Assertions.assertTrue(taskButtonsPage.highPriorityCheckboxIndicator.isControlDisplayed());
    }
}
