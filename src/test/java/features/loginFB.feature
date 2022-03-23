@LoginFb
Feature: Login Fb

  @displayed
  Scenario: Verify login page
    Given Open Web
    Then Verify email textbox displayed
    And Verify password textbox displayed
    And Close Web

  @multiple_param0
  Scenario: Verify login page
    Given Open Web
    When Input to User and Password
      | User           | Password |
      | kane@gmail.com | 123123   |
    Then Verify email textbox displayed
    And Verify password textbox displayed
    And Close Web

  @multiple_param
  Scenario Outline: Verify login page
    Given Open Web
    When Input to User and Password
      | User   | Password   |
      | <User> | <Password> |
    Then Verify email textbox displayed
    And Verify password textbox displayed
    And Close Web

    Examples:
      | User                | Password | Name | Phone Number |
      | kane.pham@gmail.com | 123123   | Kane | 0987654321   |
