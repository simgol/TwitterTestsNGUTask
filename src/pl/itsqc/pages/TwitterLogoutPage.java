package pl.itsqc.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TwitterLogoutPage extends Page {
    final private Logger logger = Logger.getLogger(TwitterLogoutPage.class);
    final private WebDriverWait wdw = new WebDriverWait(TwitterLoginPage.driver, 10);

    @FindBy(xpath="//div[@data-testid=\"confirmationSheetConfirm\"]")
    WebElement logoutButton;
    public TwitterLogoutPage(WebDriver driver) {
        super(driver);
    }
    /**
     * logout user from Twitter
     */
    public void logout(){
        driver.get("https://twitter.com/logout");
        wdw.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }
}
