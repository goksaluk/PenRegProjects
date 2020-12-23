$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Homepage.feature");
formatter.feature({
  "name": "Homepage elements",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@homepage"
    }
  ]
});
formatter.scenario({
  "name": "",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@homepage"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "HomepageStepDefinitions.iAmOnTheHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I accept cookies",
  "keyword": "Then "
});
formatter.match({
  "location": "HomepageStepDefinitions.iAcceptCookies()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the page title should contain \"The Pensions Regulator | workplace pensions law | auto enrolment | The Pensions Regulator\"",
  "keyword": "Then "
});
formatter.match({
  "location": "HomepageStepDefinitions.thePageTitleShouldContain(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see the News section is displayed",
  "keyword": "When "
});
formatter.match({
  "location": "HomepageStepDefinitions.iSeeTheNewsSectionIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see the news items as 3",
  "keyword": "Then "
});
formatter.match({
  "location": "HomepageStepDefinitions.iSeeTheNewsItemsAs(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the navigation links and page headings for all the news items",
  "rows": [
    {
      "cells": [
        "New Chair and four new members appointed to TPR\u0027s Determinations Panel"
      ]
    },
    {
      "cells": [
        "Employers reminded of AE duties as penalties rise"
      ]
    },
    {
      "cells": [
        "Pension trustees must be ready for possible sponsor distress, says regulator"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "HomepageStepDefinitions.validate_the_navigation_links_and_page_headings_for_all_the_news_items(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validate the news items dates are in descending order",
  "keyword": "Then "
});
formatter.match({
  "location": "HomepageStepDefinitions.iValidateTheNewsItemsDatesAreInDescendingOrder()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});