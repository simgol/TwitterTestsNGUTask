package pl.itsqc.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TwitterLoginPage extends Page{
    //objects definition
    @FindBy (xpath = "//button[@type=\"submit\"]")
    WebElement loginButton;
    @FindBy(xpath="//input[@class=\"js-username-field email-input js-initial-focus\"]")
    WebElement usernameField;
    @FindBy(xpath="//input[@class=\"js-password-field\"]")
    WebElement passwordField;

    private final Logger logger = Logger.getLogger(TwitterLoginPage.class);
    private final WebDriverWait wdw = new WebDriverWait(TwitterLoginPage.driver, 10);

    public TwitterLoginPage(WebDriver driver) {
        super(driver);
    }
    /**
     * navigation to givern url
     * @param url
     */
    public void navigateTo(String url){
        logger.info(new StringBuilder("Navigation to ").append(url));
        driver.get(url);
    }
    /**
     * login sequence
     * @param login
     * @param password
     */
    public void login(String login, String password){
        wdw.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(login);
        wdw.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
