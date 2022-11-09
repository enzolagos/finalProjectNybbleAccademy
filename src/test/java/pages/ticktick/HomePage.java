package pages.ticktick;

import controls.*;
import org.openqa.selenium.By;

public class HomePage {
    public Button signInButton = new Button(By.xpath("//*[text()=\"Sign In\"]"),"signInButton");
    public Button signUpForFreeButton = new Button(By.xpath("//*[@class=\"button_i9fzi introButton_3DVt6 btn-primary_3DiiP btn-med_3wsv_ btn-bold_xoKBD\"]"),"signUpForFreeButton");
    public Label homeLabel = new Label(By.xpath("//*[@class=\"introTitle_2Z0rA\"]"),"homeLabel");
    public Button trashButton = new Button(By.xpath("//*[text()=\"Trash\"]/.."),"trashButton");

}
