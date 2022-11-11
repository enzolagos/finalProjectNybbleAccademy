package cleanTest.ticktick.statistics;

import cleanTest.ticktick.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import singletonSession.Session;
import utils.GetProperties;

public class StatisticsTest extends TestBaseTickTick {
    @Test
    @DisplayName("Verify user can see statistics page")
    @Description("This test case is to verify user can see statistics page")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/89M4FLygTMRKnb/1?projectId=11232")
    @Epic("Statistics")
    @Feature("Statistics")
    @Severity(SeverityLevel.NORMAL)
    @Story("Statistics")
    public void verifyUserCanSeeStatisticsSections(){
        //Login
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");
        //test
        mainPage.userButton.click();
        mainPage.statistics.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/webapp/#statistics");
        Assertions.assertTrue(statisticsPage.overviewSection.isControlDisplayed(),"La seccion Overview no se mostro");
        Assertions.assertTrue(statisticsPage.completionCurveSection.isControlDisplayed(),"La seccion Completed curve no se mostro");
        Assertions.assertTrue(statisticsPage.myAchievementSection.isControlDisplayed(),"La seccion My Achievement no se mostro");
        Assertions.assertTrue(statisticsPage.weeklyHabitsSection.isControlDisplayed(),"La seccion Weekly Habits no se mostro");


    }
}
