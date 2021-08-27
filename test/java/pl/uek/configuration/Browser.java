package pl.uek.configuration;

import pl.uek.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public enum Browser {
    FF {
        @Override
        public WebDriver newDriver() {
            System.setProperty("webdriver.gecko.driver", Configuration.INSTANCE.getValue("webdriver.gecko.driver"));
            return new FirefoxDriver();
        }
    },
    RFF {
        @Override
        public WebDriver newDriver() {
            return new RemoteWebDriver(Configuration.INSTANCE.getGridUrl(), DesiredCapabilities.firefox());
        }
    },
    CH {
        @Override
        public WebDriver newDriver() {
            System.setProperty("webdriver.chrome.driver", Configuration.INSTANCE.getValue("webdriver.chrome.driver"));
            return new ChromeDriver();
        }
    },
    RCH {
        @Override
        public WebDriver newDriver() {
            return new RemoteWebDriver(Configuration.INSTANCE.getGridUrl(), DesiredCapabilities.chrome());
        }
    };

    public abstract WebDriver newDriver();
}