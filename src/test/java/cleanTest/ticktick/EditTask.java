package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class EditTask extends TestBaseTickTick{
    @Test
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
        taskButtonsPage.taskByTitle("Testing task").click();
        actions.moveToElement(taskButtonsPage.taskTitleForEdit.getControl()).click().sendKeys("Edit\n").sendKeys("Tambien edito la descripcion").perform();
        Assertions.assertTrue(taskButtonsPage.taskByTitle("Testing taskEdit").isControlDisplayed(),"La tarea no se modifico");

    }
}
