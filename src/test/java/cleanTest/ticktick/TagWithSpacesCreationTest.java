package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class TagWithSpacesCreationTest extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can create a tag with a space in its name")
    @Description("This test case is to verify user can create a tag with spaces")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/Wy9niAYQF8xPMl/1?projectId=11232")
    @Epic("Tags")
    @Feature("Tag invalid")
    @Severity(SeverityLevel.NORMAL)
    @Story("Tags")
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
        tagsPage.addTagButton.step("Se ha clickeado para aniadir una tarea");
        tagsPage.nameTagTB.setText("Testing Tag");
        tagsPage.saveButton.click();
        Assertions.assertTrue(tagsPage.getTagLabelByName("Testing Tag").isControlDisplayed(),"La tag no se creo");
    }
}
