package cleanTest.ticktick.loginRegister;

import cleanTest.ticktick.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class LogoutTest extends TestBaseTickTick {
    @Test
    @DisplayName("Verify user can logout after registering")
    @Description("This test case is to verify user can logout")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/1Z8Rc2YWF7DYQj/1?projectId=11232")
    @Epic("Logout")
    @Feature("Logout account")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Logout account")
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
