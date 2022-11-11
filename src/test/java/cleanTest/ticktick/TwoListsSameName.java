package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class TwoListsSameName extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can create two lists with the same name")
    @Description("This test case is to verify user can create 2 lists with same name")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/qW7KCJdksdpJRZ/1?projectId=11232")
    @Epic("Lists")
    @Feature("Lists")
    @Severity(SeverityLevel.NORMAL)
    @Story("Lists")
    public void verifyUserCanCreate2ListsWithSameName(){
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
        listsPage.listsLabel.step("Se clickea boton para agregar lista");
        listsPage.listNameTB.addText("TestingList");
        listsPage.saveButton.click();
        listsPage.getProjectLabelbyName("TestingList").waitClickable();
        Assertions.assertEquals(listsPage.projectsList.getAttribute("childElementCount"),"1","La lista no se ha creado");
        action.moveToElement(listsPage.listsLabel.getControl()).moveToElement(listsPage.addListButton.getControl()).click().perform();
        listsPage.listsLabel.step("Se clickea boton para agregar lista");
        listsPage.listNameTB.addText("TestingList");
        listsPage.saveButton.click();
        Assertions.assertEquals("2",listsPage.projectsList.getAttribute("childElementCount"),"La segunda lista no se ha creado");

    }
}
