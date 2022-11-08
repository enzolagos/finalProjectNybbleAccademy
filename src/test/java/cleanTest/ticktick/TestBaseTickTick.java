package cleanTest.ticktick;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.ticktick.*;
import singletonSession.Session;

public class TestBaseTickTick {
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();
    public MainPage mainPage = new MainPage();
    public HabitPage habitPage = new HabitPage();
    public SettingsPage settingsPage = new SettingsPage();
    public WeekPage weekPage = new WeekPage();
    public TaskButtonsPage taskButtonsPage = new TaskButtonsPage();

    @BeforeEach
    public void setup(){
        // todo create properties file
        Session.getInstance().getBrowser().get("https://ticktick.com/");
    }
    @AfterEach
    public void cleanup(){
        Session.getInstance().closeBrowser();
    }

    //para solucionar el server error que causaba date
    static String getAlphaNumericString(int n)
    {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
