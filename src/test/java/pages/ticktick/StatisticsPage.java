package pages.ticktick;

import controls.*;
import org.openqa.selenium.By;

public class StatisticsPage {
    public Label overviewSection = new Label(By.xpath("//h2[text()=\"Overview\"]"),"overviewSection");
    public Label myAchievementSection = new Label(By.xpath("//h2[text()=\"My Achievement Score\"]"),"myAchievement");
    public Label completionCurveSection = new Label(By.xpath("//h2[text()=\"Recent Completion Curve\"]"),"completionCurveSection");
    public Label weeklyHabitsSection = new Label(By.xpath("//h2[text()=\"Weekly Habit Status\"]"),"weeklyHabitsSection");


}
