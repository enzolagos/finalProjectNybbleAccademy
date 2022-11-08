package pages.ticktick;

import controls.*;
import org.openqa.selenium.By;

public class LoginPage {
    public TextBox userMailTextbox = new TextBox(By.id("emailOrPhone"),"userMailTextbox");
    public TextBox userPasswordTextbox = new TextBox(By.id("password"),"userPasswordTextbox");
    public Button loginButton = new Button(By.xpath("//*[@class=\"button__3eXSs \"]"),"loginButton");

    public void login(String user, String password){
        userMailTextbox.setText(user);
        userPasswordTextbox.setText(password);
        loginButton.click();
    }
}
