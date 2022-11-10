package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class RegisterTest extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can register")
    @Description("This test case is to verify user can register")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/OoJASNKVuDdM91/1?projectId=11232")
    @Epic("Register")
    @Feature("Register")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register")
    public void verifyUserCanRegister(){
        //Seteo data
        String userMail = getAlphaNumericString(6)+"@gmail.com";
        String password = getAlphaNumericString(6);
        //Registro
        homePage.signUpForFreeButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signup");
        registerPage.nameTextBox.setText("Test");
        registerPage.emailTextBox.setText(userMail);
        registerPage.passwordTextBox.setText(password);
        registerPage.registerButton.click();
        Assertions.assertTrue(mainPage.inboxPopUpLabel.isControlDisplayed(), "Error el usuario no se ha registrado");

    }
}
