package pages.ticktick;

import controls.*;
import org.openqa.selenium.By;

public class SearchPage {
    public Button searchButton = new Button(By.xpath("//*[contains(@class,\"icon-search-sidebar\")]"),"searchButton");
    public TextBox searchTextBox = new TextBox(By.xpath("//input[contains(@class,\"search-box\")]"),"searchTextBox");
    public Label searchMadeLabel = new Label(By.xpath("//span[text()=\"Search for\"]/following-sibling::span"),"searchMadeLabel");
}
