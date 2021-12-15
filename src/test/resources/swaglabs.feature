@selenium
  Feature: Tests logins of saucedemo.com
    Scenario: Standard user
      When a user enters https://www.saucedemo.com/
      And inputs a standard_user in the username field
      And inputs a correct password secret_sauce
      And clicks the login button
      Then he should be redirected to the homepage

    Scenario: Locked out user
      When a user enters https://www.saucedemo.com/
      And inputs a locked_out_user in the username field
      And inputs a correct password secret_sauce
      And clicks the login button
      Then he should be receiving a locked out error

    Scenario: Problem user
      When a user enters https://www.saucedemo.com/
      And inputs a problem_user in the username field
      And inputs a correct password wrong
      And clicks the login button
      Then he should be receiving a user does not exist error