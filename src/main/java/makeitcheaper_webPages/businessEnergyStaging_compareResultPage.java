package makeitcheaper_webPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class businessEnergyStaging_compareResultPage extends businessEnergyStaging_webDriver {

    public businessEnergyStaging_compareResultPage(WebDriver driver)  {
        super(driver);
    }

    public businessEnergyStaging_compareResultPage verifyResult()
    {
        /* Due to incorrect MPAN this is not fully implemented
         * Pending steps - Put Junit Assertion into try catch block. Catch exception to be used for defect log*/
        WebElement we = driver.findElement(By.xpath("//h2[text()='Choose a Plan. Request a call. Put your feet up']"));
        String strng = we.getText();
        Assert.assertEquals("Choose a Plan. Request a call. Put your feet up", strng);
        return new businessEnergyStaging_compareResultPage(driver);
    }

    //verify_available_offers
}
