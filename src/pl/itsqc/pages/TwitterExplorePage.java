package pl.itsqc.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TwitterExplorePage extends Page {
    final private Logger logger = Logger.getLogger(TwitterLogoutPage.class);
    final private WebDriverWait wdw = new WebDriverWait(TwitterLoginPage.driver, 10);

    @FindBy(xpath="//input[@data-testid=\"SearchBox_Search_Input\"]")
    WebElement searchField;
    @FindBy(xpath="//div[@data-testid=\"2415691112-follow\"]")
    WebElement followButton;
    @FindBy(xpath="//div[@data-testid=\"2415691112-unfollow\"]")
    WebElement unfollowButton;
    public TwitterExplorePage(WebDriver driver) {
        super(driver);
    }
    /**
     * search for given passphrase
     * @param channelName
     */
    public void searchChannel(String channelName){
        wdw.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(channelName);
        searchField.sendKeys(Keys.ENTER);
    }
    //data-testid="2415691112-follow"
    //data-testid="2415691112-unfollow"
    //textContent: "Follow"
    //textContent: "Following"
}
