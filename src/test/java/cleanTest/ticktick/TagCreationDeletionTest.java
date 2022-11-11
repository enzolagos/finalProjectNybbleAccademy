package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class TagCreationDeletionTest extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can create a tag and delete it")
    @Description("This test case is to verify user can create a tag and delete it later")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/wRoVuNGKuJW4DZ/1?projectId=11232")
    @Epic("Tags")
    @Feature("TAG crud")
    @Severity(SeverityLevel.NORMAL)
    @Story("Tags")
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
        tagsPage.getTagLabelByName("TestingTag").step("Se crea el tag 'TestingTag'");
        Assertions.assertTrue(tagsPage.getTagLabelByName("TestingTag").isControlDisplayed(),"La tag no se creo");
        action.moveToElement(tagsPage.getTagLabelByName("TestingTag").getControl()).contextClick().perform();
        tagsPage.deleteOptionButton.click();
        tagsPage.deleteOptionButton.click();
        tagsPage.noTagsLabel.step("El tag se ha eliminado");
        Assertions.assertTrue(tagsPage.noTagsLabel.isControlDisplayed(),"No hay tags creados");

    }
}
