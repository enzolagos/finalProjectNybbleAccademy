package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class StatisticsTest extends TestBaseTickTick{
    @Test
    public void verifyUserCanSeeStatisticsSections(){
        //Login
        String user = "prueprue@gmail.com";
        String password = "prueprue22";
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password);
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
