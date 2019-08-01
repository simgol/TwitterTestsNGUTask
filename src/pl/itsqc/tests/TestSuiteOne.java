package pl.itsqc.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.itsqc.pages.TwitterHomePage;
import pl.itsqc.pages.TwitterLoginPage;
import pl.itsqc.utils.Collector;

public class TestSuiteOne extends TestBase {
    private final Logger logger = Logger.getLogger(TestSuiteOne.class);
    @Test (description="Verification if a logged user can add a new tweet")
    public void VerificationIfUserCanLoginToTwitterAndAddTweet(){
        TwitterLoginPage loginPage = new TwitterLoginPage(driver);
        TwitterHomePage homePage = new TwitterHomePage(driver);
        Collector collect = new Collector();
        //go to twitter login page and log in user
        loginPage.navigateTo(baseUrl);
        loginPage.login("t1esting@yandex.com", "t1estinG?");
        //TODO: add assertion, example: Assert.assertEquals(homePage.getUrl(), "https://twitter.com/home");
        //send tweet
        StringBuilder messageToBeSend = new StringBuilder("sending message check ").append(collect.getTime());
        homePage.addTwitt(messageToBeSend);
        //TODO: add assertion, example: Assert.assertEquals(messageToBeSend, messageToBeSend);
    }
    @Test(description = "Verification if a logged user is able to follow and unfollow a profile in the application", priority = 1)
    public void VerificationIfUserCanFollowAndUnfollowProfile(){
        //TODO: add test to follow profile estraklasa and once it's followed sucesfully unfollow it and logout
        //TODO: add logout in LeftNavigationBar
    }
}
