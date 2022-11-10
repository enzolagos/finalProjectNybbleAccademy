package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class LanguageText extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can change language to italian")
    @Description("This test case is to verify user can change language to Italian")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/51yJHZJjTZjJxN/1?projectId=11232")
    @Epic("Settings")
    @Feature("Change language")
    @Severity(SeverityLevel.NORMAL)
    @Story("Settings")
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
