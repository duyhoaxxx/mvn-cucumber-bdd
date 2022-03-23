Feature: Login Fb

  @displayed
  Scenario: Verify login page
    Given Open Web
    Then Verify email textbox displayed
    And Verify password textbox displayed
