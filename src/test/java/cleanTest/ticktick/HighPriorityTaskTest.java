package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class HighPriorityTaskTest extends TestBaseTickTick{
    @Test
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
