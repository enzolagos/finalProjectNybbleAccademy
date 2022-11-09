package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class TagCreationDeletionTest extends TestBaseTickTick{
    @Test
    public void verifyUserCanCreateandDeleteATag() throws InterruptedException {
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
        tagsPage.nameTagTB.setText("TestingTag");
        tagsPage.saveButton.click();
        Assertions.assertTrue(tagsPage.getTagLabelByName("TestingTag").isControlDisplayed(),"La tag no se creo");
        action.moveToElement(tagsPage.getTagLabelByName("TestingTag").getControl()).contextClick().perform();
        tagsPage.deleteOptionButton.click();
        tagsPage.deleteOptionButton.click();
        Assertions.assertTrue(tagsPage.noTagsLabel.isControlDisplayed(),"No hay tags creados");

    }
}
