package cleanTest.ticktick;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class ListCreationDeletionTest extends TestBaseTickTick{
    @Test
    @DisplayName("Verify user can create and delete a list")
    @Description("This test case is to create a list and delete it")
    @Owner("Enzo Lagos")
    @Link("https://nybblegroup.atlassian.net/plugins/servlet/ac/com.infostretch.QmetryTestManager/qtm4j-test-management?project.key=NAQA&project.id=11232#!/TestCaseDetail/gqKAfoxkCy86WY/1?projectId=11232")
    @Epic("Lists")
    @Feature("Create-delete list")
    @Severity(SeverityLevel.NORMAL)
    @Story("Lists")
    public void verifyUserCanCreateAListAndDeleteIt() throws InterruptedException {
        //login
        homePage.signInButton.click();
        Session.getInstance().waitURLToChange("https://ticktick.com/signin");
        loginPage.login("testeoTest@gmail.com","testeoTest");
        Assertions.assertTrue(mainPage.inboxTitleLabel.isControlDisplayed(), "Error el usuario no se pudo loguear");

        //test
        String projectTitle = "Testing List";
        mainPage.addListButton.click();
        mainPage.titleList.setText(projectTitle);
        mainPage.saveButton.click();
        Assertions.assertTrue(mainPage.getListButton(projectTitle).isControlDisplayed(), "El proyecto no se creo");

        Thread.sleep(2000);
        //Hay un bug que hace que aparezca un popUp diciendo que el proyecto esta eliminado cuando ni siquiera se crea, sin el thread no puede hacer click en el proyecto y se rompe.
        mainPage.getListButton(projectTitle).click();
        mainPage.listOptionsButton(projectTitle).click();
        mainPage.deleteListButton.click();
        mainPage.deleteListButton.click();
        Assertions.assertTrue(mainPage.noListsLabel.isControlDisplayed(), "Error, el proyecto no se elimino");
        Thread.sleep(2000); //Y este es porque lo borra y sale tan rapido que no se borra fuera del navegador de selenium, aunque sin este thread el test pase igual

    }
}
