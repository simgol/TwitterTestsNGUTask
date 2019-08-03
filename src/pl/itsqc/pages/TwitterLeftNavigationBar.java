package pl.itsqc.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TwitterLeftNavigationBar extends Page {
    private Logger logger = Logger.getLogger(TwitterLeftNavigationBar.class);

    @FindBy(xpath = "//a[@data-testid=\"AppTabBar_Home_Link\"]")
    private WebElement homePageLink;
    @FindBy(xpath = "//a[@data-testid=\"AppTabBar_Explore_Link\"]")
    private WebElement explorePageLink;
    //TODO:add here left bar navigation objects (notifications, bookmarks etc.) if needed for future tests
    public TwitterLeftNavigationBar(WebDriver driver) {
        super(driver);
    }

    /**
     * navigate to home/link click
     */
    public void navigateToHomePage() {
        homePageLink.click();
    }

    /**
     * navigate to explore/link click
     */
    public void navigateToExplorePage() {
        explorePageLink.click();
    }
}