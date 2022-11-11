package cleanTest.ticktick.recyclingbin;

import cleanTest.ticktick.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;
import utils.GetProperties;

public class RecyclingBin extends TestBaseTickTick {
    @Test
    @DisplayName("Verify user can empty the recycle bin")
    @Description("This test case is to verify user can create 2 tasks and delete them, and after that clean the trash bin")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/9MDEtj7qHGWkz6/1?projectId=11232")
    @Epic("Recycle bin")
    @Feature("Empty recycle bin")
    @Severity(SeverityLevel.NORMAL)
    @Story("Recycle bin")
    public void verifyUserCanEmptyRecyclingBin() throws InterruptedException {
        Actions actions = Session.getInstance().createAction();
        //Login
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //Test
        mainPage.inboxButton.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error no se ha entrado a Inbox");
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Prueba").sendKeys(Keys.ENTER).perform();
        taskButtonsPage.taskButton.step("Se creo la tarea 'Prueba'");
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Prueba2").sendKeys(Keys.ENTER).perform();
        taskButtonsPage.taskButton.step("Se creo la tarea 'Prueba2");
        Assertions.assertFalse(taskButtonsPage.tasksNoDate.isControlDisplayed(), "no se crearon las tareas");

        actions.moveToElement(taskButtonsPage.taskByTitle("Prueba").getControl()).contextClick().perform();
        taskButtonsPage.deleteButton.click();
        taskButtonsPage.deletedTaskPopup.step("Se elimino la tarea 'Prueba'");
        taskButtonsPage.deletedTaskPopup.waitUntilDissapear();
        actions.moveToElement(taskButtonsPage.taskByTitle("Prueba2").getControl()).contextClick().perform();
        taskButtonsPage.deleteButton.click();
        taskButtonsPage.deletedTaskPopup.step("Se elimino la tarea 'Prueba2'");
        Assertions.assertTrue(taskButtonsPage.deletedTaskPopup.isControlDisplayed(), "No se borro las tarea");

        homePage.trashButton.click();
        trashPage.clearTrashButton.click();
        Thread.sleep(2000); //el boton se clikea y desaparece tan rapido que no llega a aparecer el de confirmacion
        trashPage.confirmDeletionButton.click();
        Assertions.assertTrue(trashPage.recycleBinCleanedLabel.isControlDisplayed(),"La papelera de reciclaje no se limpio");



    }
}
