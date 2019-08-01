package pl.itsqc.tests;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pl.itsqc.pages.TwitterLoginPage;

public class TestSuiteOne extends TestBase {
    private final Logger logger = Logger.getLogger(TestSuiteOne.class);

    @Test
    public void loginToTwitter(){
        TwitterLoginPage loginPage = new TwitterLoginPage(driver);
        loginPage.navigateTo(baseUrl);
        loginPage.login("login", "password");
    }
}
