package cleanTest.ticktick.tasks;

import cleanTest.ticktick.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;
import utils.RandomString;

public class CompletedTasks extends TestBaseTickTick {
    @Test
    @DisplayName("Verify completed tasks are moved to completed section")
    @Description("This test case is to verify user can complete 2 tasks and are moved to completed section")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/dax6tqaAC427A8/1?projectId=11232 ")
    @Epic("Tasks")
    @Feature("Completed tasks")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story Tasks flow")
    public void verifyTasksCompletedAreInCompleteSection(){
        Actions actions = Session.getInstance().createAction();
        //Login
        String user = RandomString.getAlphaNumericString(6)+"@gmail.com";
        String password = RandomString.getAlphaNumericString(6);
        homePage.signUpForFreeButton.click();
        registerPage.registerUser(user,password);
        mainPage.skipPopUpAfterRegister.waitClickable();
        mainPage.skipPopUpAfterRegister.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //Test
        mainPage.inboxButton.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error no se ha entrado a Inbox");
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Prueba").sendKeys(Keys.ENTER).perform();
        taskButtonsPage.taskButton.step("Se creo la tarea 'Prueba'");
        actions.moveToElement(taskButtonsPage.taskButton.getControl()).click().sendKeys("Prueba2").sendKeys(Keys.ENTER).perform();
        taskButtonsPage.taskButton.step("Se creo la tarea 'Prueba2'");
        Assertions.assertTrue(taskButtonsPage.taskByTitle("Prueba").isControlDisplayed(), "No se creo la primer tarea");
        Assertions.assertTrue(taskButtonsPage.taskByTitle("Prueba2").isControlDisplayed(), "No se creo la segunda tarea");

        taskButtonsPage.taskCheckboxByTaskTitle("Prueba").click();
        taskButtonsPage.taskCheckboxByTaskTitle("Prueba2").click();
        taskButtonsPage.taskCompletedPopUP.waitUntilDissapear();
        Assertions.assertTrue(taskButtonsPage.completedInboxLabel.isControlDisplayed(), "No se completaron las tareas");

        mainPage.completedTasksButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/webapp/#q/all/completed");
        Assertions.assertEquals(completedPage.listOfCompletedTasks.getAttribute("childElementCount"),"3","Las tareas no se muestran en la zona de completadas");

    }
}
