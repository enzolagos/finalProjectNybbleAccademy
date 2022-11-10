package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class TaskTemplate extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can create two lists with the same name")
    @Description("This test case is to verify user can create 2 lists with same name")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/qW7KCJdksdpJRZ/1?projectId=11232")
    @Epic("Lists")
    @Feature("Lists")
    @Severity(SeverityLevel.NORMAL)
    @Story("Lists")
    public void verifyIfUserCanCreateATaskUsingATemplate() throws InterruptedException {
        Actions actions = Session.getInstance().createAction();
        //Login
        String user = "testingTasks@gmail.com";
        String password = "testingTasks";
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password);
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().perform();
        taskButtonsPage.taskOptions.click();
        taskButtonsPage.taskFromTemplateButton.click();
        taskButtonsPage.dailyRecordOption.click();
        Assertions.assertEquals(taskButtonsPage.firstTaskLabel.getText(),"Daily record","La task no se ha importado");

        /*actions.moveToElement(taskButtonsPage.taskByTitle("Daily record").getControl()).contextClick().perform();
        taskButtonsPage.deleteButton.click();
        taskButtonsPage.deletedTaskPopup.waitUntilDissapear();*/
    }
}
