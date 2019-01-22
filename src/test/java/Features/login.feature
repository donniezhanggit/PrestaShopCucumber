
Feature: Login

  Scenario: User will login to account
    Given user is on home page
    When user clicks on the Sign in button
    And user enters "oscar6161@gmail.com" and "Password61"
    Then user will click Sign in button again
    Then user confirms that fullname is shown by SignOutlink
    Then use clicks on My Personal Info and verify first and last name is correct
    Then user clicks save button
    Then user confirms the error message saying The password you entered is incorrect
    And user clicks on Back to your account and verify title contains My account
    Then Clickon My addresses
  Then confirms address details
  |name       |Oscar Bono|
  |street    |123 Street |
  |city        |Ankara            |
|country     |United States     |
  |phone       |9875436271        |
   # Then Clickon Add a new address
    #Then Verify that first name and last name matches the full name on top
    #Then Delete the first name and Click save
    #Then Verify error message firstname is required.

