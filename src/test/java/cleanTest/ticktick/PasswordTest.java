package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class PasswordTest extends TestBaseTickTick{
    @Test
    public void verifyUserCanChangePassword(){
        String user = getAlphaNumericString(6)+"@gmail.com";
        String password = getAlphaNumericString(6);
        homePage.signUpForFreeButton.click();
        registerPage.registerUser(user,password);
        mainPage.skipPopUpAfterRegister.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        mainPage.userButton.click();
        mainPage.settingsButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/webapp/#settings");
        settingsPage.profileSettingsButton.click();
        settingsPage.changePasswordButton.click();
        settingsPage.currentPassword.setText(password);
        settingsPage.newPassword.setText(password+"change");
        settingsPage.saveButton.click();
        settingsPage.doneButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/webapp/#p/inbox/tasks");
        mainPage.userButton.click();
        mainPage.signOutButton.click();
        Assertions.assertTrue(homePage.homeLabel.isControlDisplayed(), "El usuario no se deslogueo");

        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password+"change");
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");



    }
}
