Feature: Login

  @sanity
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome Browser
    When User opens URL "https://onehcx-dev.sumasoft.com/login"
    And User enter email as "FA_Param3" and password as "Sumasoft@123"
    And Click on Login
    Then Title page should be "One HCX"
    When User click on logout link 
    Then Title page should be "One HCX1"
    And  close browser
  
  @regression
  Scenario Outline: Successful Login with Valid Credentials
    Given User Launch Chrome Browser
    When User opens URL "https://onehcx-dev.sumasoft.com/login"
    And User enter email as "<userId>" and password as "<Password>"
    And Click on Login
    Then Title page should be "One HCX"
    When User click on logout link 
    Then Title page should be "One HCX"
    And  close browser
    
 Examples:
|userId|Password|
|FA_Param3|Sumasoft@123|
|FA_Param3|Sumasoft@123|