Feature: Check Eligibility
  As a hospital user
  I want to fill Basic Details, Patient Information, Treatment and Billing sections
  So that I can submit an Eligibility Check request successfully

  Background:
    Given User Launch Chrome Browser
    When User opens URL "https://onehcx-dev.sumasoft.com/login"
    And User enter email as "FA_Param3" and password as "Sumasoft@123"
    And Click on Login
    And User clicks on Eligibility

  @sanity @regression
  Scenario: Fill Basic Details section and proceed
    When User Click on Check Eligibility Button    
    Then close browser
    

  
