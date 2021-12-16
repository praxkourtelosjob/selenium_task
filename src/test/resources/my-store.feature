@selenium
Feature: Tests logins of http://automationpractice.com
  Scenario: Create account
    When a user enter http://automationpractice.com
    And clicks on the Sign In tag
    And fills the Email address field
    And clicks on the Create an account button
    And fills the account creation form
    And clicks register
    Then an account will be created

  Scenario: Search for summer dresses
    When I log in
    And click on dresses
    And click on summer dresses
    Then I should be presented with the summer dresses

  Scenario: Add a summer dress to my basket
    When I log in
    And click on dresses
    And click on summer dresses
    And click on the Add to cart of the first summer
    Then I should see a prompt confirming I added the item to my cart

  Scenario: Checkout my dress
    When I log in
    And click on dresses
    And click on summer dresses
    And click on the Add to cart of the first summer
    And click on Proceed to checkout
    And click on Proceed to checkout on Order screen
    And click on Proceed to checkout on Order screen
    And agree on the terms and conditions
    And click on Proceed to checkout on Order screen
    And click on the Pay by bank wire
    And click on the I confirm my order
    Then I should receive a confirmation of my order
