package pl.itsqc.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TwitterExplorePage extends Page {
    final private Logger logger = Logger.getLogger(TwitterLogoutPage.class);
    final private WebDriverWait wdw = new WebDriverWait(TwitterLoginPage.driver, 5);

    @FindBy(xpath="//input[@data-testid=\"SearchBox_Search_Input\"]")
    private WebElement searchField;
    @FindBy(xpath="//div[contains(@data-testid,\"2415691112\")]")
    private WebElement followUnfollowButton;
    @FindBy(xpath="//div[@data-testid =\"2415691112-unfollow\"]")
    private WebElement followButton;
    @FindBy(xpath="//div[@data-testid =\"2415691112-follow\"]")
    private WebElement unfollowButton;
    @FindBy(xpath="//div[@data-testid=\"confirmationSheetConfirm\"]")
    private WebElement unfollowConfirmationButton;


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
    /**
     * click on follow button if it's available, if not, press unfollow
     */
//    public boolean followOrUnfollow(){
//        boolean status;
//        try{
//            wdw.until(ExpectedConditions.visibilityOf(followButton));
//            followButton.click();
//            status=true;
//            logger.info(new StringBuilder("following"));
//        }catch (Exception e) {
//            unfollowButton.click();
//            wdw.until(ExpectedConditions.visibilityOf(unfollowButton));
//            unfollowConfirmationButton.click();
//            status=false;
//            logger.info(new StringBuilder("unfollowing"));
//        }
//        return status;
//    }
    public boolean followOrUnfollow(){
        boolean status;
        wdw.until(ExpectedConditions.visibilityOf(followUnfollowButton));
        followUnfollowButton.click();
        try{
            wdw.until(ExpectedConditions.visibilityOf(unfollowConfirmationButton));
            unfollowConfirmationButton.click();
            status=false;
            logger.info(new StringBuilder("unfollowing"));
        }catch (Exception e) {
            status=true;
            logger.info(new StringBuilder("following"));
        }
        return status;
    }
    /**
     *
     * @return state attribute shows if profile is to be followed or unfollowed
     */
    public String getButtonState(){
        String state=followUnfollowButton.getAttribute("textContent");
        return state;
    }
}
