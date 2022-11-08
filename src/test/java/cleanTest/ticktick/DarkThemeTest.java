package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DarkThemeTest extends TestBaseTickTick{
    @Test
    public void verifyUserCanChangeTheme(){
        //Register
        String user = getAlphaNumericString(6)+"@gmail.com";
        String password = getAlphaNumericString(6);
        homePage.signUpForFreeButton.click();
        registerPage.registerUser(user,password);
        mainPage.skipPopUpAfterRegister.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //Test
        mainPage.userButton.click();
        mainPage.settingsButton.click();
        settingsPage.themeButton.click();
        settingsPage.darkOption.click();
        Assertions.assertEquals(mainPage.bodyControl.getAttribute("className"),"sidebar-focus tick webkit en_US dark", "Error no se ha cambiado el tema");
    }
}
