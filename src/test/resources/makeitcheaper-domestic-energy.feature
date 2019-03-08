Feature: Find a domestic energy bill
  As a user running the application
  I can add the address details and basic information
  So that I can request a callback and get a quote

  @domestic-energy
  Scenario Outline: Find cheaper domestic energy
    Given I open the url "https://business-energy-staging.makeitcheaper.com/"
    When I enter post code "<post_code>"
    And I click Compare
    And I select "<compare_option>" from What do you want to compare
    And I select Please select the address "<address>" of business premises
    And I enter MPAN number "<MPAN_number>"
    And I select "<current_business_supplier>" from Who is your current business electricity supplier
    And I enter "<correct_value>" from How much do you currently spend on your business electricity
    And I select "<correct_value_dropdown>" option for correct value
    And I enter contact details "<name>" "<business_name>" "<phone_number>" "<email_address>"
    And I click Show Result
    Then I verify available offers

    Examples:
    | post_code | compare_option | address                                              | MPAN_number                    |   current_business_supplier | correct_value | correct_value_dropdown | name      | business_name       | phone_number    | email_address         |
    | EC3R 7AG  |  ELECTRICITY   | The Minster Building 21 Mincing Lane London EC3R 7AG | 03 801 110 22 0001 4969 380    | E.ON                        | 400           | Quarter                | Test Name | Test Business Name  |  07504075040    |  testing@testing.com  |
