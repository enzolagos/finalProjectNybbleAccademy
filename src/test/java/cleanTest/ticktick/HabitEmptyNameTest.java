package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class HabitEmptyNameTest extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can not create an habit with an empty name")
    @Description("This test case is to verify user can not create a habit with a non character name")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/lw8vt8kaInOqan/1?projectId=11232")
    @Issue("https://nybblegroup.atlassian.net/browse/NAQA-420")
    @Epic("Habits")
    @Feature("Empty habit name")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Habits")
    public void verifyUserCanCreateAnEspecificHabit(){
        //register + login
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
        String title = dataHelper.stringSpaces;
        habitPage.habitTitle.setText(title);
        habitPage.saveButton.click();
        Assertions.assertTrue(habitPage.developAHabitLabel.isControlDisplayed(),"El habito con TITULO VACIO se ha creado");
    }
}
