package controls;

import org.openqa.selenium.By;

public class Label extends Control{
    public Label(By locator) {
        super(locator);
    }

    public Label(By locator, String controlName) {
        super(locator, controlName);
    }
}
