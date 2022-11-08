package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class HabitFlowTest extends TestBaseTickTick{
    @Test
    public void verifyUerCanCreateAHabitAndDeleteIt(){
        String user = "testeoTest@gmail.com";
        String password = "testeoTest";
        //login
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password);
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //test
        mainPage.habitsButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/webapp/#q/all/habit");
        habitPage.addHabitButton.click();
        habitPage.habitTitle.setText("Test");
        habitPage.saveButton.click();
        Assertions.assertTrue(habitPage.habitControl.isControlDisplayed(), "Error, el habito no se creo");

        habitPage.habitControl.click();
        habitPage.habitOptionsButton.click();
        habitPage.deleteOptionButton.click();
        habitPage.deleteHabitButton.click();
        Assertions.assertTrue(habitPage.developAHabitLabel.isControlDisplayed(), "Error, el habito no se ha borrado");
    }
}
