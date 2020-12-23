package com.pen_regulator.step_definitions;

import com.pen_regulator.pages.Homepage;
import com.pen_regulator.utilities.BrowserUtils;
import com.pen_regulator.utilities.ConfigurationReader;
import com.pen_regulator.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class HomepageStepDefinitions {

    Homepage homepage = new Homepage();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 15);

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homepage.navigateToHomepage();
    }

    @Then("I accept cookies")
    public void iAcceptCookies() {
        homepage.cookies.click();
    }

    @Then("the page title should contain {string}")
    public void thePageTitleShouldContain(String partTitle) {
        Assert.assertEquals(partTitle, homepage.getPageTitle());
    }

    @When("I see the News section is displayed")
    public void iSeeTheNewsSectionIsDisplayed() {
        BrowserUtils.waitForVisibility(homepage.news, 10);
        homepage.news.isDisplayed();
    }

    @Then("I see the news items as {int}")
    public void iSeeTheNewsItemsAs(int numItems) {
        Assert.assertEquals(numItems, homepage.newsLinks.size());
    }

    @Then("Validate the navigation links and page headings for all the news items")
    public void validate_the_navigation_links_and_page_headings_for_all_the_news_items(List<String> pageHeadings) {

        for (int i =0 ; i<homepage.newsLinks.size(); i++){
            homepage.newsLinks.get(i).click();
            BrowserUtils.waitForVisibility(homepage.pageHeading,10);
            Assert.assertEquals(pageHeadings.get(i), homepage.pageHeading.getText());
            Driver.get().navigate().back();
            BrowserUtils.waitForVisibility(homepage.news,10);
        }
    }


    @Then("I validate the news items dates are in descending order")
    public void iValidateTheNewsItemsDatesAreInDescendingOrder() throws ParseException {
        Assert.assertTrue(homepage.checkDateOrder( ));
        //System.out.println("homepage.checkDateOrder() = " + homepage.checkDateOrder());
        Driver.closeDriver();
    }
}
