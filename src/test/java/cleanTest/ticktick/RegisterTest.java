package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class RegisterTest extends TestBaseTickTick{
    @Test
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
