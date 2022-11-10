package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class DuplicatedListTest extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can create duplicated list")
    @Description("This test case is to verify user can create a list and then create another with the same name")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/qW7KCJdksdpJRZ/1?projectId=11232")
    @Epic("Lists")
    @Feature("Lists")
    @Severity(SeverityLevel.MINOR)
    @Story("Duplicated lists")
    public void verifyUserCanDuplicatedAList() throws InterruptedException {
        Actions action = Session.getInstance().createAction();
        //register + login
        String user = getAlphaNumericString(6)+"@gmail.com";
        String password = getAlphaNumericString(6);
        homePage.signUpForFreeButton.click();
        registerPage.registerUser(user,password);
        mainPage.skipPopUpAfterRegister.click();
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //test
        action.moveToElement(listsPage.listsLabel.getControl()).moveToElement(listsPage.addListButton.getControl()).click().perform();
        listsPage.addListButton.step("Se creo una lista nueva");
        String title = getAlphaNumericString(6);
        listsPage.listNameTB.addText(title);
        listsPage.saveButton.click();
        listsPage.getProjectLabelbyName(title).waitClickable();
        Assertions.assertEquals(listsPage.projectsList.getAttribute("childElementCount"),"1","La lista no se ha creado");
        action.moveToElement(listsPage.getProjectLabelbyName(title).getControl()).contextClick().perform();
        listsPage.duplicateList.click();
        listsPage.getProjectLabelbyName(title+" copy").step("Se duplico la lista");
        Assertions.assertTrue(listsPage.getProjectLabelbyName(title+" copy").isControlDisplayed(),"La lista no se duplico");
    }
}
