package makeitcheapPrototype;

import Util.BaseUrl;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import makeitcheaper_webPages.businessEnergyStaging_compareResultPage;
import makeitcheaper_webPages.businessEnergyStaging_enterDetailsPage;
import makeitcheaper_webPages.businessEnergyStaging_landingPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class makeitcheapStepDefs {


    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
    }

        private WebDriver driver = new ChromeDriver();
        private businessEnergyStaging_landingPage bes_lp = new businessEnergyStaging_landingPage(driver);
        private businessEnergyStaging_enterDetailsPage bes_edp = new businessEnergyStaging_enterDetailsPage(driver);
        private businessEnergyStaging_compareResultPage bes_cr = new businessEnergyStaging_compareResultPage(driver);

    @Given("^I open the url \"([^\"]*)\"$")
    public void i_open_the_url(String arg1) throws Throwable {
        bes_lp.NavigateToTheSite(arg1);
    }

    @When("^I enter post code \"([^\"]*)\"$")
    public void i_enter_post_code(String arg1) throws Throwable {
        /* Parameter value from feature file - post_code */
        bes_lp.enterPostcode(arg1);
    }

    @And("^I click Compare$")
    public void i_click_Compare() throws Throwable {
        bes_lp.clickCompareButton();
    }

    @When("^I select \"([^\"]*)\" from What do you want to compare$")
    public void i_select_from_What_do_you_want_to_compare(String arg1) throws Throwable {
        /* Execute if condition based on compare_option value from feature file */
        bes_edp.compare_option(arg1);
    }

    @And("^I select Please select the address \"([^\"]*)\" of business premises$")
    public void i_select_Please_select_the_address_of_business_premises(String arg1) throws Throwable {
            /* This currently clicks the link 'Can't find your address?
            *  Due to incorrect MPAN number and some intermittent issues in
            *  select and action dropdown methods Can't find link is being selected */
            bes_edp.selectBusinessAddress(arg1);
    }

    @And("^I enter MPAN number \"([^\"]*)\"$")
    public void i_enter_MPAN_number(String arg1) throws Throwable {
            /* Currently MPAN is hard coded.
               Implementation pending - Accept the parameter as data table
             * from feature file and put into arguments[0].value  */
            bes_edp.enterMPANnum(arg1);
    }

    @And("^I select \"([^\"]*)\" from Who is your current business electricity supplier$")
    public void i_select_from_Who_is_your_current_business_electricity_supplier(String arg1) throws Throwable {
        /* Execute if condition based on current_business_supplier value from feature file */

        bes_edp.SelectCurrentBusinessElectricitySupplier(arg1);
    }

    @And("^I enter \"([^\"]*)\" from How much do you currently spend on your business electricity$")
    public void i_enter_from_How_much_do_you_currently_spend_on_your_business_electricity(String arg1) throws Throwable {
        /* Parameter value from feature file - correct_value */
        bes_edp.SelectCurrentSpendingOnBusinessElectricity(arg1);
    }

    @And("^I select \"([^\"]*)\" option for correct value$")
    public void i_select_option_for_correct_value(String arg1) throws Throwable {
        /* Parameter value from feature file - correct_value_dropdown */
        bes_edp.SelectConsumptionPeriod(arg1);
    }

    @And("^I enter contact details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_enter_contact_details(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        /* Parameter value from feature file -
         * <name> <business_name> <phone_number> <email_address> */
        bes_edp.enterContactDetails(arg1,arg2,arg3,arg4);
    }

    @And("^I click Show Result$")
    public void i_click_Show_Result() throws Throwable {
        bes_edp.clickShowResult();
    }

    @Then("^I verify available offers$")
    public void i_verify_available_offers() throws Throwable {
//        /* Due to incorrect MPAN this is not fully implemented
//        * Pending steps - Put Junit Assertion into try catch block. Catch exception to be used for defect log*/
            bes_cr.verifyResult();
    }

}
