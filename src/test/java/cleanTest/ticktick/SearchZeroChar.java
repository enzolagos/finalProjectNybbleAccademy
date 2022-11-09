package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class SearchZeroChar extends TestBaseTickTick{
    @Test
    public void verifyuserCanDoA70charactersLongSearch(){
        Actions actions = Session.getInstance().createAction();
        //Login
        String user = "prueprue@gmail.com";
        String password = "prueprue22";
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password);
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");
        //test
        searchPage.searchButton.click();
        actions.moveToElement(searchPage.searchTextBox.getControl()).sendKeys(dataHelper.stringSpaces).sendKeys(Keys.ENTER).perform();
        Assertions.assertEquals("https://ticktick.com/webapp/#s/",Session.getInstance().urlIs(),"La busqueda no se llevo a cabo");
    }
}
