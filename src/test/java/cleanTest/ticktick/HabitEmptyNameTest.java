package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class HabitEmptyNameTest extends TestBaseTickTick{
    @Test
    public void verifyUserCanCreateAnEspecificHabit() throws InterruptedException {
        //register + login
        String user = getAlphaNumericString(6)+"@gmail.com";
        String password = getAlphaNumericString(6);
        homePage.signUpForFreeButton.click();
        registerPage.registerUser(user,password);
        mainPage.skipPopUpAfterRegister.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //test
        mainPage.habitsButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/webapp/#q/all/habit");
        habitPage.addHabitButton.click();
        String title = dataHelper.stringSpaces;
        habitPage.habitTitle.setText(title);
        habitPage.saveButton.click();
        Assertions.assertTrue(habitPage.developAHabitLabel.isControlDisplayed(),"El habito con TITULO VACIO se ha creado");
    }
}
