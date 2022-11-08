package pages.ticktick;

import controls.*;
import org.openqa.selenium.By;

public class RegisterPage {
    public TextBox nameTextBox = new TextBox(By.id("name"),"nameTextBox");
    public TextBox emailTextBox = new TextBox(By.xpath("//*[@autocomplete=\"username\"]"),"emailTextBox");
    public TextBox passwordTextBox = new TextBox(By.id("password"),"passwordTextBox");
    public Button registerButton = new Button(By.xpath("//*[@class=\"button__3eXSs \"]"),"registerButton");

    public void registerUser(String user, String password){
        nameTextBox.setText("Test");
        emailTextBox.setText(user);
        passwordTextBox.setText(password);
        registerButton.click();
    }

}
