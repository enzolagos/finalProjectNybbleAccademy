package cleanTest.ticktick.search;

import cleanTest.ticktick.TestBaseTickTick;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;
import utils.GetProperties;

public class SearchZeroChar extends TestBaseTickTick {
    @Test
    @DisplayName("Verify user can do a zero characters search")
    @Description("This test case is to verify user can do a zro characters search")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/RQpaTZDdTjY9po/1?projectId=11232")
    @Epic("Search")
    @Feature("Zero char search")
    @Severity(SeverityLevel.NORMAL)
    @Story("Search")
    public void verifyuserCanDoA70charactersLongSearch(){
        Actions actions = Session.getInstance().createAction();
        //Login
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(GetProperties.getInstance().getUser(), GetProperties.getInstance().getPwd());
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");
        //test
        searchPage.searchButton.click();
        actions.moveToElement(searchPage.searchTextBox.getControl()).sendKeys(dataHelper.stringSpaces).sendKeys(Keys.ENTER).perform();
        searchPage.searchTextBox.step("Se busca en la barra de busquedas: '"+dataHelper.stringSpaces+"'");
        Assertions.assertEquals("https://ticktick.com/webapp/#s/",Session.getInstance().urlIs(),"La busqueda no se llevo a cabo");
    }
}
