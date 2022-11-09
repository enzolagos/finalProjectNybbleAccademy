package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class CompletedTasks extends TestBaseTickTick{
    @Test
    public void verifyTasksCompletedAreInCompleteSection() throws InterruptedException {
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
        Assertions.assertTrue(taskButtonsPage.tasksNoDate.isControlDisplayed(), "No se crearon las tareas");

        taskButtonsPage.taskCheckboxByTaskTitle("Prueba").click();
        taskButtonsPage.taskCheckboxByTaskTitle("Prueba2").click();
        Assertions.assertTrue(taskButtonsPage.completedInboxLabel.isControlDisplayed(), "No se completaron las tareas");

        mainPage.completedTasksButton.click();
        Assertions.assertEquals(completedPage.listOfCompletedTasks.getAttribute("childElementCount"),"3","Las tareas no se muestran en la zona de completadas");

    }
}
