package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class LogoutTest extends TestBaseTickTick{
    @Test
    public void verifyUserCanLogout() {
        //Data
        String userMail = "testeoTest@gmail.com";
        String password = "testeoTest";
        //Test
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(userMail,password);
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        mainPage.userButton.click();
        mainPage.signOutButton.click();
        Assertions.assertTrue(homePage.homeLabel.isControlDisplayed(), "Error el user no se deslogueo");

    }
}
