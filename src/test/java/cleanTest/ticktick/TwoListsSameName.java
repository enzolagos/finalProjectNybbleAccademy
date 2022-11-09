package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import singletonSession.Session;

public class TwoListsSameName extends TestBaseTickTick{
    @Test
    public void verifyUserCanCreate2ListsWithSameName() throws InterruptedException {
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
        listsPage.listNameTB.addText("TestingList");
        listsPage.saveButton.click();
        listsPage.getProjectLabelbyName("TestingList").waitClickable();
        Assertions.assertEquals(listsPage.projectsList.getAttribute("childElementCount"),"1","La lista no se ha creado");
        action.moveToElement(listsPage.listsLabel.getControl()).moveToElement(listsPage.addListButton.getControl()).click().perform();
        listsPage.listNameTB.addText("TestingList");
        listsPage.saveButton.click();
        Assertions.assertEquals("2",listsPage.projectsList.getAttribute("childElementCount"),"La segunda lista no se ha creado");

    }
}
