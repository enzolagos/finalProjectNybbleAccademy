package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class DeleteAccountTest extends TestBaseTickTick{
    @Test
    public void verifyUserCanDeleteAccount() {
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
        settingsPage.deleteAccountButton.click();
        settingsPage.passwordForDeletionTB.setText(password);
        settingsPage.firstDeleteCheckbox.click();
        settingsPage.secondDeleteCheckbox.click();
        settingsPage.confirmButton.click();
        Assertions.assertTrue(homePage.signInButton.isControlDisplayed(),"La cuenta no se ha eliminado");
    }
}
