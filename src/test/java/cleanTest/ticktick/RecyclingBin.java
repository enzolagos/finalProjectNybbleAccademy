package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class RecyclingBin extends TestBaseTickTick{
    @Test
    public void verifyUserCanEmptyRecyclingBin() throws InterruptedException {
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
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Prueba").sendKeys(Keys.ENTER).perform();
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Prueba2").sendKeys(Keys.ENTER).perform();
        //Assertions.assertFalse(taskButtonsPage.tasksNoDate.isControlDisplayed(), "no se crearon las tareas");

        actions.moveToElement(taskButtonsPage.taskByTitle("Prueba").getControl()).contextClick().perform();
        taskButtonsPage.deleteButton.click();
        taskButtonsPage.deletedTaskPopup.waitUntilDissapear();
        actions.moveToElement(taskButtonsPage.taskByTitle("Prueba2").getControl()).contextClick().perform();
        taskButtonsPage.deleteButton.click();
        Assertions.assertTrue(taskButtonsPage.deletedTaskPopup.isControlDisplayed(), "No se borro las tarea");

        homePage.trashButton.click();
        trashPage.clearTrashButton.click();
        Thread.sleep(2000);
        trashPage.confirmDeletionButton.click();
        Assertions.assertTrue(trashPage.recycleBinCleanedLabel.isControlDisplayed(),"La papelera de reciclaje no se limpio");



    }
}
