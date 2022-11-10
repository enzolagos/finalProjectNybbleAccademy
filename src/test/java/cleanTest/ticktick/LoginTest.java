package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class LoginTest extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can login ")
    @Description("This test case is to verify user can login having a registered account")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/Pv54fE7LCGZgDw/1?projectId=11232")
    @Epic("Login")
    @Feature("Login account")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Login account")
    public void verifyUserCanLogin(){
        String user = "testeoTest@gmail.com";
        String password = "testeoTest";
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password);
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");
    }
}
