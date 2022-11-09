package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;


public class TaskFailure extends TestBaseTickTick{
    @Test
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
        Assertions.assertTrue(taskButtonsPage.taskByTitle(dataHelper.string2050char).isControlDisplayed(),"La tarea no se creo");

    }
}
