package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class TestNext7Days extends TestBaseTickTick{
    @Test
    public void verifyTasksFlow() throws InterruptedException {
        Actions actions = Session.getInstance().createAction();
        //Login
        String user = "testeoTest@gmail.com";
        String password = "testeoTest";
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password);
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //Test
        mainPage.next7DaysButton.click();
        Assertions.assertTrue(mainPage.next7daysLabel.isControlDisplayed(), "Error no se ha entrado a las tareas de los proximos siete dias");
        actions.moveToElement(weekPage.taskButton.getControl()).click().sendKeys("Prueba").perform();
        taskButtonsPage.setDateButton.click();
        taskButtonsPage.nextWeekButton.click();
        taskButtonsPage.taskOptions.click();
        actions.moveToElement(taskButtonsPage.highPriorityButton.getControl()).click().sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);




    }
}
