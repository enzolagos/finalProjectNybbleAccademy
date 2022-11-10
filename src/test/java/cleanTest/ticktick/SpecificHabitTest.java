package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class SpecificHabitTest extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can create an specific habit")
    @Description("Verify user can create a habit with this settings:\n" +
            "\n" +
            "Frequency: Weekly\n" +
            "\n" +
            "Goal Days: 7 Days\n" +
            "\n" +
            "Section: Night\n" +
            "\n")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/v9vzFoJgCj1NM6/1?projectId=11232")
    @Epic("Habist")
    @Feature("Create habit")
    @Severity(SeverityLevel.NORMAL)
    @Story("Habits")
    public void verifyUserCanCreateAnEspecificHabit(){
        String user = "prueprue@gmail.com";
        String password = "prueprue22";
        //login
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password);
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //test
        mainPage.habitsButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/webapp/#q/all/habit");
        habitPage.addHabitButton.click();
        String title = getAlphaNumericString(6);
        habitPage.habitTitle.setText(title);
        habitPage.frequencyOptionButton.click();
        habitPage.weeklyOption.click();
        habitPage.okButton.click();
        habitPage.goalDaysOptionButton.click();
        habitPage.sevenDaysButton.click();
        habitPage.sectionOptionButton.click();
        habitPage.nightButton.click();
        habitPage.saveButton.click();
        Assertions.assertEquals(title,habitPage.habitControl.getText(),"No se ha creado el habito especifico");
    }
}
