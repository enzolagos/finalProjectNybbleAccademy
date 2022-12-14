package controls;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonSession.Session;

import java.time.Duration;

public class Control {
    protected By locator;
    protected WebElement control;
    protected String controlName; //reflection solucionaria esto
    public WebDriverWait wait = new WebDriverWait(Session.getInstance().getBrowser(), Duration.ofSeconds(10));


    public Control(By locator){
        this.locator = locator;
    }
    public Control (By locator, String controlName){
        this.locator=locator;
        this.controlName=controlName;
    }


    protected void findControl(){
        control= Session.getInstance().getBrowser().findElement(this.locator);
    }
    @Step("{0}")
    public void step(String action){}
    public void doubleClick(){
        this.findControl();
        this.step("Double click on "+controlName);
        control.click();
        control.click();
    }
    public void click(){
        this.findControl();
        this.step("Click on "+controlName);
        control.click();
    }
    public boolean isControlDisplayed(){
        try{
            this.findControl();
            this.step("Check the "+ controlName + " is display:true");
            return control.isDisplayed();
        }catch (Exception e){
            this.step("Check the "+ controlName + " is display:false");

            return false;}
    }
    public String getText(){
        this.findControl();
        this.step("Get Text from "+controlName+", the value is: "+control.getText());
        return control.getText();
    }

    public String getAttribute(String value){
        this.findControl();
        this.step("Attribute named: "+value+" was getted.");
        return control.getAttribute(value);
    }
    public void waitClickable()
    {
        wait.until(ExpectedConditions.elementToBeClickable(this.locator));
    }
    public void waitTextToBe(String texto){
        wait.until(ExpectedConditions.textToBe(this.locator,texto));
    }

    public void waitUntilChangeState(String attribute,String value){
        wait.until(ExpectedConditions.attributeToBe(this.locator,attribute,value));
    }
    public void waitUntilDissapear(){
        wait.until(ExpectedConditions.invisibilityOf(this.getControl()));

    }
    public WebElement getControl() {
        this.findControl();
        return control;
    }

}
