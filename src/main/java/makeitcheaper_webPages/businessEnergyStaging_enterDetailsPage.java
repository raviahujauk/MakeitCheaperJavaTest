package makeitcheaper_webPages;

import org.openqa.selenium.*;

public class businessEnergyStaging_enterDetailsPage extends businessEnergyStaging_webDriver {

    JavascriptExecutor js = (JavascriptExecutor)driver;

public businessEnergyStaging_enterDetailsPage(WebDriver driver)  {
    super(driver);
}

    public businessEnergyStaging_enterDetailsPage compare_option(String compOption)
    {
        /* Execute if condition based on compOption value from feature file */
        if (compOption.equals("ELECTRICITY")){
            driver.findElement(By.xpath("//label[contains(text(),'Electricity')]")).submit();
        }
        return new businessEnergyStaging_enterDetailsPage(driver);
    }

    public businessEnergyStaging_enterDetailsPage selectBusinessAddress(String bizAddress)
    {
        WebElement we2 = driver.findElement(By.id("mpan-manual-open"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", we2);
        return new businessEnergyStaging_enterDetailsPage(driver);
    }
    public businessEnergyStaging_enterDetailsPage enterMPANnum(String MPANnum)
    {
        /* Currently MPAN is hard coded.
           Implementation pending - Accept the parameter as data table
         * from feature file and put into arguments[0].value  */

        WebElement we0 = driver.findElement(By.xpath("//span/input[@data-index=0]"));
        js.executeScript("arguments[0].value='03';", we0);

        WebElement we2 = driver.findElement(By.xpath("//span/input[@data-index=2]"));
        js.executeScript("arguments[0].value='801';", we2);

        WebElement we5 = driver.findElement(By.xpath("//span/input[@data-index=5]"));
        js.executeScript("arguments[0].value='110';", we5);

        WebElement we8 = driver.findElement(By.xpath("//span/input[@data-index=8]"));
        js.executeScript("arguments[0].value='22';", we8);

        WebElement we10 = driver.findElement(By.xpath("//span/input[@data-index=10]"));
        js.executeScript("arguments[0].value='0001';", we10);

        WebElement we14 = driver.findElement(By.xpath("//span/input[@data-index=14]"));
        js.executeScript("arguments[0].value='4969';", we14);

        WebElement we18 = driver.findElement(By.xpath("//span/input[@data-index=18]"));
        js.executeScript("arguments[0].value='380';", we18);

        //Thread.sleep(5000);
        return new businessEnergyStaging_enterDetailsPage(driver);
    }

    public businessEnergyStaging_enterDetailsPage SelectCurrentBusinessElectricitySupplier(String electricitySupplier)
    {
        /* Execute if condition based on current_business_supplier value from feature file */
        if (electricitySupplier.equals("E.ON")) {
            WebElement we2 = driver.findElement(By.id("supplier-19"));
            js.executeScript("arguments[0].click();", we2);
        }
        return new businessEnergyStaging_enterDetailsPage(driver);
    }

    public businessEnergyStaging_enterDetailsPage SelectCurrentSpendingOnBusinessElectricity(String CurrentSpending)
    {
        /* Parameter value from feature file - correct_value */
        WebElement we = driver.findElement(By.name("consumption[cost]"));
        js.executeScript("arguments[0].value='"+CurrentSpending+"';", we);
        return new businessEnergyStaging_enterDetailsPage(driver);
    }

    public businessEnergyStaging_enterDetailsPage SelectConsumptionPeriod(String consumptionPeriod) throws InterruptedException {
        /* Parameter value from feature file - correct_value_dropdown */
        WebElement we = driver.findElement(By.id("consumption_period"));
        js.executeScript("arguments[0].click();",we);
        //js.executeScript("arguments[0].value='"+consumptionPeriod+"';", we);
        Thread.sleep(2000);
        driver.findElement(By.id("consumption_period")).sendKeys(Keys.ENTER);
        return new businessEnergyStaging_enterDetailsPage(driver);
    }


    public businessEnergyStaging_enterDetailsPage enterContactDetails(String name, String business_name, String phone_number, String quote_email) throws InterruptedException {
        /* Parameter value from feature file -
         * <name> <business_name> <phone_number> <email_address> */
        WebElement we = driver.findElement(By.id("details_quote_name"));
        js.executeScript("arguments[0].value='"+name+"';", we);

        WebElement we2 = driver.findElement(By.id("details_quote_business_name"));
        js.executeScript("arguments[0].value='"+business_name+"';", we2);

        WebElement we3 = driver.findElement(By.id("details_quote_phone_number"));
        js.executeScript("arguments[0].value='"+phone_number+"';", we3);

        WebElement we4 = driver.findElement(By.id("details_quote_email"));
        js.executeScript("arguments[0].value='"+quote_email+"';", we4);
        return new businessEnergyStaging_enterDetailsPage(driver);
    }


    public businessEnergyStaging_compareResultPage clickShowResult() throws InterruptedException {
        WebElement we = driver.findElement(By.xpath("//button[@class='sme-calc-submit btn btn-default btn-next pull-right']"));
        js.executeScript("arguments[0].click();", we);
        return new businessEnergyStaging_compareResultPage(driver);
    }


}
