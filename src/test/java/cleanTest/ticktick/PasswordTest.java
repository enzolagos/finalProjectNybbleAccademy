package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class PasswordTest extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can change password")
    @Description("This test case is to verify user can change password")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/am1RiRzltLk4jL/1?projectId=11232")
    @Epic("Settings")
    @Feature("Change password")
    @Severity(SeverityLevel.CRITICAL)
    @Story("change password")
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
