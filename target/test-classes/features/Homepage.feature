
@homepage
Feature: Homepage elements

  Scenario:
    Given  I am on the homepage
    Then  I accept cookies
    Then the page title should contain "The Pensions Regulator | workplace pensions law | auto enrolment | The Pensions Regulator"
    When I see the News section is displayed
    Then I see the news items as 3
    And Validate the navigation links and page headings for all the news items
      | Pension scam busting campaign hits over 100 pledges|
      | New Chair and four new members appointed to TPR's Determinations Panel|
      | Employers reminded of AE duties as penalties rise|
    Then I validate the news items dates are in descending order





