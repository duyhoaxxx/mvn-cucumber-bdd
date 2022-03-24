@LoginNopcommerce
Feature: Login Nopcommerce

  @register
  Scenario Outline: Register
    Given Click Register Header
    When Input Register Form
      | First Name   | Last Name   | Password   |
      | <First Name> | <Last Name> | <Password> |
    Then Verify Register Success
    And Logout Account
    Examples:
      | First Name | Last Name | Password |
      | Kane       | Pham      | 123123   |

  @login
  Scenario Outline: Login
    Given Click Login Header
    When Input to "Email" textbox with value "<Email>"
    And Input to "Password" textbox with value "<Password>"
    And Click to "Log in" button
    Then Verify Login Success
    Examples:
      | Email     | Password |
      | kaneEmail | 123123   |

