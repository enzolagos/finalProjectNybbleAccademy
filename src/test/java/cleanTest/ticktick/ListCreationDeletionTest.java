package cleanTest.ticktick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class ListCreationDeletionTest extends TestBaseTickTick{
    @Test
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
