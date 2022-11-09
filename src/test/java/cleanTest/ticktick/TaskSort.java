package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class TaskSort extends TestBaseTickTick{
    @Test
    public void verifyIfTasksSortWorksFine(){
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
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Atest").sendKeys(Keys.ENTER).perform();
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Btest").sendKeys(Keys.ENTER).perform();
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("22test").sendKeys(Keys.ENTER).perform();
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Aatest").sendKeys(Keys.ENTER).perform();
        Assertions.assertFalse(taskButtonsPage.tasksNoDate.isControlDisplayed(), "No se crearon las tareas");

        taskButtonsPage.sortTasksButton.click();
        taskButtonsPage.byTitleButton.click();
        Assertions.assertEquals(taskButtonsPage.firstTaskLabel.getText(),"22test","No se ordeno por titulo");
    }
}
