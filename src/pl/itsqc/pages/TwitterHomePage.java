package pl.itsqc.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TwitterHomePage extends Page {
    final private Logger logger = Logger.getLogger(TwitterHomePage.class);
    private final WebDriverWait wdw = new WebDriverWait(TwitterHomePage.driver, 20);
    @FindBy(xpath = "//div[@data-testid=\"tweetTextarea_0\"]")
    WebElement messageTextfield;
    @FindBy(xpath="//div[@data-testid=\"tweetButtonInline\"]")
    WebElement tweetButton;
    public TwitterHomePage(WebDriver driver) {
        super(driver);
    }
    /**
     * send message
     * @param message
     */
    public void addTwitt(StringBuilder message){
        wdw.until(ExpectedConditions.visibilityOf(messageTextfield));
        messageTextfield.sendKeys(message);
        tweetButton.click();
    }
    /**
     *
     * @return currentUrl
     */
    public String getUrl(){
        //wdw.until(ExpectedConditions.visibilityOf(messageTextfield));
        String currentUrl=driver.getCurrentUrl();
        return currentUrl;
    }
}
