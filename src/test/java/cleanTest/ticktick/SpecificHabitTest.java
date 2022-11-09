package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class SpecificHabitTest extends TestBaseTickTick{
    @Test
    public void verifyUserCanCreateAnEspecificHabit() throws InterruptedException {
        Actions action = Session.getInstance().createAction();
        String user = "prueprue@gmail.com";
        String password = "prueprue22";
        //login
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password);
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //test
        mainPage.habitsButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/webapp/#q/all/habit");
        habitPage.addHabitButton.click();
        String title = getAlphaNumericString(6);
        habitPage.habitTitle.setText(title);
        habitPage.frequencyOptionButton.click();
        habitPage.weeklyOption.click();
        habitPage.okButton.click();
        habitPage.goalDaysOptionButton.click();
        habitPage.sevenDaysButton.click();
        habitPage.sectionOptionButton.click();
        habitPage.nightButton.click();
        habitPage.saveButton.click();
        Assertions.assertEquals(title,habitPage.habitControl.getText(),"No se ha creado el habito especifico");
    }
}
