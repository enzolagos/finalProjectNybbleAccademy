package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class TaskTemplate extends TestBaseTickTick{
    @Test
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
