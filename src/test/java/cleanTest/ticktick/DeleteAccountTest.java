package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class DeleteAccountTest extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can delete an account")
    @Description("This test case is to verify user can create an account and delete it")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/Pv54fE7LCGZE3O/1?projectId=11232")
    @Epic("Settings")
    @Feature("Delete account")
    @Severity(SeverityLevel.NORMAL)
    @Story("Deleting account")
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
