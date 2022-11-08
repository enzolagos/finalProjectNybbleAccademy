package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class LanguageText extends TestBaseTickTick{
    @Test
    public void verifyUserCanChangeLanguageToItalian(){
        String user = getAlphaNumericString(6)+"@gmail.com";
        String password = getAlphaNumericString(6);
        homePage.signUpForFreeButton.click();
        registerPage.registerUser(user,password);
        mainPage.skipPopUpAfterRegister.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //Test
        mainPage.userButton.click();
        mainPage.settingsButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/webapp/#settings");
        settingsPage.languageListButton.click();
        settingsPage.italianoOption.click();
        settingsPage.doneButton.click();
        Assertions.assertTrue(mainPage.italianLabel.isControlDisplayed(), "Error el lenguaje no se ha cambiado");

    }
}
