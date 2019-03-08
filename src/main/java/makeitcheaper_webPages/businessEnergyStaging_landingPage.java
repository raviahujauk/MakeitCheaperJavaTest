package makeitcheaper_webPages;

import Util.BaseUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Base64;

public class businessEnergyStaging_landingPage extends businessEnergyStaging_webDriver {

    String userName = "staging";
    // Password is Base64 encoded
    String Password = "UGFzc3dvcmQx";
    String businessEnergyURL;

//    static {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
//    }

//    WebDriver driver = new ChromeDriver();
    BaseUrl url = new BaseUrl();
//    JavascriptExecutor js = (JavascriptExecutor)driver;

    public businessEnergyStaging_landingPage(WebDriver driver) { super(driver);}

    public businessEnergyStaging_landingPage NavigateToTheSite(String param_url)
    {
        driver.manage().window().maximize();
        byte[] strAsByte= Base64.getDecoder().decode(Password);
        businessEnergyURL = url.BaseUrl(param_url);
        driver.get("https://"+userName+":"+new String(strAsByte)+"@"+businessEnergyURL);
        return new businessEnergyStaging_landingPage(driver);
    }

    public businessEnergyStaging_landingPage enterPostcode(String postCode)
    {
        driver.findElement(By.id("postcode-field")).sendKeys(postCode);
        return new businessEnergyStaging_landingPage(driver);
    }

    public businessEnergyStaging_enterDetailsPage clickCompareButton()
    {
        driver.findElement(By.id("compare-button")).click();
        return new businessEnergyStaging_enterDetailsPage(driver);
    }
}
