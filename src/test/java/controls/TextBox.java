package controls;

import org.openqa.selenium.By;

public class TextBox extends Control{
    public TextBox(By locator) {
        super(locator);
    }

    public TextBox(By locator, String controlName) {
        super(locator, controlName);
    }

    public void setText(String value){
        this.findControl();
        this.step("Set on control: "+controlName+" the value: ["+value+"]");
        this.control.clear();
        this.control.sendKeys(value);
    }
    public void addText(String value){
        this.findControl();
        this.step("Add on control: "+controlName+" the value: ["+value+"]");
        this.control.sendKeys(value);
    }
}
