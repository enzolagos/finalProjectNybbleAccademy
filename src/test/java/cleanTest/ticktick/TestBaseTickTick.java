package cleanTest.ticktick;

import com.google.common.collect.ImmutableMap;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ticktick.*;
import singletonSession.Session;
import utils.DataHelper;
import utils.GetProperties;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@ExtendWith(TestResultExtension.class)
public class TestBaseTickTick {
    //Paginas
    public HomePage homePage = new HomePage();
    public LoginPage loginPage = new LoginPage();
    public RegisterPage registerPage = new RegisterPage();
    public MainPage mainPage = new MainPage();
    public HabitPage habitPage = new HabitPage();
    public SettingsPage settingsPage = new SettingsPage();
    public TaskButtonsPage taskButtonsPage = new TaskButtonsPage();
    public TrashPage trashPage = new TrashPage();
    public CompletedPage completedPage = new CompletedPage();
    public ListsPage listsPage = new ListsPage();
    public SearchPage searchPage = new SearchPage();
    public StatisticsPage statisticsPage = new StatisticsPage();
    public TagsPage tagsPage = new TagsPage();

    //Helpers
    public DataHelper dataHelper = new DataHelper();


    @BeforeEach
    public void setup(){allureEnvironmentWriter(
            ImmutableMap.<String, String>builder()
                    .put("Browser", GetProperties.getInstance().getBrowser())
                    .put("URL", GetProperties.getInstance().getHost())
                    .put("User", GetProperties.getInstance().getUser())
                    .put("Pwd", GetProperties.getInstance().getPwd())
                    .build(), System.getProperty("user.dir")
                    + "/build/allure-results/");
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
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
