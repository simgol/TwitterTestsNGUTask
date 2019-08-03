package pl.itsqc.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.itsqc.pages.*;
import pl.itsqc.utils.Collector;

public class TestSuiteOne extends TestBase {
    private final Logger logger = Logger.getLogger(TestSuiteOne.class);
    @Test (description="Verification if a logged user can add a new tweet")
    public void VerificationIfUserCanLoginToTwitterAndAddTweet(){
        TwitterLoginPage loginPage = new TwitterLoginPage(driver);
        TwitterHomePage homePage = new TwitterHomePage(driver);
        TwitterLogoutPage logoutPage = new TwitterLogoutPage(driver);
        Collector collect = new Collector();
        //go to twitter login page and log in user
        loginPage.navigateTo(baseUrl);
        loginPage.login("t1esting@yandex.com", "t1estinG?");
        //send tweet: "sending message check" + local time
        String time=collect.getTime();
        logger.info(new StringBuilder(time));
        StringBuilder messageToBeSend = new StringBuilder("sending message check ").append(time);
        homePage.addTweet(messageToBeSend);
        Assert.assertEquals(homePage.getMessageContent().contains(time), true);
    }
    @Test(description = "Verification if a logged user is able to follow and unfollow a profile", priority = 1)
    public void VerificationIfUserCanFollowAndUnfollowProfile(){
        TwitterLeftNavigationBar leftBar = new TwitterLeftNavigationBar(driver);
        TwitterExplorePage explorePage = new TwitterExplorePage(driver);
        //go to explore section and search for given twitter account to follow
        leftBar.navigateToExplorePage();
        explorePage.searchChannel("ekstraklasa");
        boolean isFollowing = explorePage.followOrUnfollow();
        //TODO:add assertion
        if(isFollowing){
            Assert.assertEquals(explorePage.getButtonState(), "Following");
        }else{
            Assert.assertEquals(explorePage.getButtonState(), "Follow");
        }
        TwitterLogoutPage logoutPage = new TwitterLogoutPage(driver);
        logoutPage.logout();
        Assert.assertEquals(logoutPage.getTextAfterLogout().contains("See what’s happening in the world right now"), true);
    }
}