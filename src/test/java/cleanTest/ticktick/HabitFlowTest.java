package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class HabitFlowTest extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can create and delete a habit")
    @Description("This test case is to verify user can create an account and delete it")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/MvyJfbPoIV2Dgm/1?projectId=11232")
    @Epic("Habits")
    @Feature("Habits crud")
    @Severity(SeverityLevel.NORMAL)
    @Story("Habits")
    public void verifyUerCanCreateAHabitAndDeleteIt(){
        Actions actions = Session.getInstance().createAction();
        String user = getAlphaNumericString(6)+"@gmail.com";
        String password = getAlphaNumericString(6);
        homePage.signUpForFreeButton.click();
        registerPage.registerUser(user,password);
        mainPage.skipPopUpAfterRegister.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //test
        mainPage.habitsButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/webapp/#q/all/habit");
        habitPage.addHabitButton.click();
        habitPage.habitTitle.setText("Test");
        habitPage.saveButton.click();
        Assertions.assertTrue(habitPage.habitControl.isControlDisplayed(), "Error, el habito no se creo");

        actions.moveToElement(habitPage.habitControl.getControl()).contextClick().perform();
        habitPage.habitControl.step("Se hizo click derecho sobre el habito");
        habitPage.deleteOptionButton.click();
        habitPage.deleteHabitButton.click();
        Assertions.assertTrue(habitPage.developAHabitLabel.isControlDisplayed(), "Error, el habito no se ha borrado");
    }
}
