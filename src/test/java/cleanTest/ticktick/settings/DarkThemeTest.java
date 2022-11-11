package cleanTest.ticktick.settings;

import cleanTest.ticktick.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomString;

public class DarkThemeTest extends TestBaseTickTick {
    @Test
    @DisplayName("Verify user can set dark theme")
    @Description("This test case is to verify user can set a theme differenf from the original, in this case dark")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/v9vzFoJgCj1yvz/1?projectId=11232")
    @Epic("Settings")
    @Feature("Change Theme")
    @Severity(SeverityLevel.MINOR)
    @Story("Theme")
    public void verifyUserCanChangeTheme(){
        //Register
        String user = RandomString.getAlphaNumericString(6)+"@gmail.com";
        String password = RandomString.getAlphaNumericString(6);
        homePage.signUpForFreeButton.click();
        registerPage.registerUser(user,password);
        mainPage.skipPopUpAfterRegister.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //Test
        mainPage.userButton.click();
        mainPage.settingsButton.click();
        settingsPage.themeButton.click();
        settingsPage.darkOption.click();
        Assertions.assertTrue(mainPage.bodyControl.getAttribute("className").contains("dark"), "Error no se ha cambiado el tema");
    }
}
