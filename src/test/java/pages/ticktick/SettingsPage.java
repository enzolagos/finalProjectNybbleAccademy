package pages.ticktick;

import controls.*;
import org.openqa.selenium.By;

public class SettingsPage {
    public Button profileSettingsButton = new Button(By.xpath("//*[@href=\"#settings/profile\"]"),"profileSettingsButton");
    public Button changePasswordButton = new Button(By.xpath("//*[text()=\"Change Password\"]"),"changePasswordButton");
    public TextBox currentPassword = new TextBox(By.xpath("//*[@placeholder=\"Current Password\"]"),"currentPassword");
    public TextBox newPassword = new TextBox(By.xpath("//*[@placeholder=\"New password\"]"),"newPassword");
    public Button saveButton = new Button(By.xpath("//*[text()=\"Save\"]"),"saveButton");
    public Button doneButton = new Button(By.xpath("//button[text()=\"Done\"]"),"doneButton");
    public Button languageListButton = new Button(By.xpath("//*[contains(text(),\"English\")]"),"languageListButton");
    public OptionFromList italianoOption = new OptionFromList(By.xpath("//*[contains(text(),\"Italiano\")]"),"italianoOption");
    public Button themeButton = new Button(By.xpath("//*[text()=\"Theme\"]"),"themeButton");
    public Button darkOption = new Button(By.xpath("//*[@data-id=\"night\"]/div"),"darkOption");





}
