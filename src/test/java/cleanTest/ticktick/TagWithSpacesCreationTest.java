package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class TagWithSpacesCreationTest extends TestBaseTickTick{
    @Test
    public void verifyUserCanCreateATag(){
        Actions action = Session.getInstance().createAction();
        //Login
        String user = "prueprue@gmail.com";
        String password = "prueprue22";
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login(user,password);
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");
        //test
        action.moveToElement(tagsPage.tagsLabel.getControl()).moveToElement(tagsPage.addTagButton.getControl()).click().perform();
        tagsPage.nameTagTB.setText("Testing Tag");
        tagsPage.saveButton.click();
        Assertions.assertTrue(tagsPage.getTagLabelByName("Testing Tag").isControlDisplayed(),"La tag no se creo");
    }
}
