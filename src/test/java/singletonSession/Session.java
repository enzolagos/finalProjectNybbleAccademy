package singletonSession;

import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GetProperties;

import java.time.Duration;

public class Session {
    private static Session session=null;
    private WebDriver browser;

    private Session(){
        //todo --> create properties file - browser
        browser = FactoryBrowser.make(GetProperties.getInstance().getBrowser()).create();
    }

    public static Session getInstance(){
        if(session==null){
            session = new Session();
        }
        return session;
    }
    public void closeBrowser(){
        browser.quit();
        session=null;
    }

    public WebDriver getBrowser() {
        return browser;
    }
    public void waitURLToChange(String url){
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }
    public String urlIs(){
        return new String(browser.getCurrentUrl()) ;
    }
    public Actions createAction(){
        return new Actions(this.browser);
    }



}
