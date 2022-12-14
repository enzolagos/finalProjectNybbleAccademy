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

public class SearchMaxChar extends TestBaseTickTick {
    @Test
    @DisplayName("Verify user can do a search with 70 characters long")
    @Description("This test case is to verify user can do a search with 70 characters long")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/VzxpCb13IPbgRY/1?projectId=11232")
    @Epic("Search")
    @Feature("Search")
    @Severity(SeverityLevel.MINOR)
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
        actions.moveToElement(searchPage.searchTextBox.getControl()).sendKeys(dataHelper.string70char).sendKeys(Keys.ENTER).perform();
        searchPage.searchTextBox.step("Se busca en la barra de busquedas: '"+dataHelper.string70char+"'");
        Assertions.assertEquals(dataHelper.string70char,searchPage.searchMadeLabel.getText(),"La busqueda no se realizo correctamente");
    }
}
