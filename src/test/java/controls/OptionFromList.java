package controls;

import org.openqa.selenium.By;

public class OptionFromList extends Control{
    public OptionFromList(By locator) {
        super(locator);
    }

    public OptionFromList(By locator, String controlName) {
        super(locator, controlName);
    }
}
