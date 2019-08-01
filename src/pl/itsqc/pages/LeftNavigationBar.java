package pl.itsqc.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LeftNavigationBar extends Page {
    private Logger logger = Logger.getLogger(LeftNavigationBar.class);

    public LeftNavigationBar(WebDriver driver) {
        super(driver);
    }
}
