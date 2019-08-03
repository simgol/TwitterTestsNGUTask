package pl.itsqc.tests;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pl.itsqc.utils.Collector;

public class TestBase {
    private final Logger logger = Logger.getLogger(TestBase.class);
    WebDriver driver;
    public final String baseUrl = "https://twitter.com/login";
    @BeforeTest
    public void setup(){
        Collector collect = new Collector();
        String os = collect.getOSName();
        //set FF as the driver
        String key="webdriver.gecko.driver";
        String driverLocation="";
        //based on the OS, point the path of the WebDriver for FF
        if (os.toLowerCase().contains("linux")){
            driverLocation=ClassLoader.getSystemResource("geckodriver_linux").getPath();
        }else if (os.toLowerCase().contains("windows")){
            driverLocation=ClassLoader.getSystemResource("geckodriver.exe").getPath();
        }else if(os.toLowerCase().contains("mac")){
            driverLocation=ClassLoader.getSystemResource("geckodriver_mac").getPath();
        }
        logger.info(new StringBuilder("WebDriver for FireFox path: ").append(driverLocation));
        //env setup
        System.setProperty(key, driverLocation);
        //init
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    @AfterTest
    public void cleanup(){
        driver.close();
    }
}
