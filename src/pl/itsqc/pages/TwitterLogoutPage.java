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
    private WebElement logoutButton;
    @FindBy(className = "StaticLoggedOutHomePage-signupBlock")
    private WebElement signupTitle;

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
    /**
     * method needed for assertion to check correctness of logout operation
     * @return textContent the signup title visible after logout
     */
    public String getTextAfterLogout(){
        wdw.until(ExpectedConditions.visibilityOf(signupTitle));
        String textContent = signupTitle.getAttribute("textContent");
        return textContent;
    }
}
