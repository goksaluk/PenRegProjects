package com.pen_regulator.pages;

import com.pen_regulator.utilities.ConfigurationReader;
import com.pen_regulator.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homepage extends BasePage{

    public Homepage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//title")
    public WebElement pageTitle;

    @FindBy(id = "cookie-accept")
    public WebElement cookies;

    @FindBy(xpath = "//a[text()='News']")
    public  WebElement news;

    @FindBy(xpath = "//a[text()='News']/parent::h3/following-sibling::ul/li/a")
    public List<WebElement> newsLinks;

    @FindBy(xpath = "//a[text()='News']/parent::h3/following-sibling::ul/li/div")
    public List<WebElement> dates;

    @FindBy(xpath = "//h1")
    public WebElement pageHeading;

    public void navigateToHomepage(){
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String getPageTitle(){
        return Driver.get().getTitle();
    }


    public boolean checkDateOrder() throws ParseException {

        ArrayList<Date> datesList = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("EEE d MMM yyyy");

        for (WebElement date : dates) {
            datesList.add(formatter.parse(date.getText()));
        }


        boolean flag=false;
        for (int i=0; i<datesList.size()-1; i++) {
            if(datesList.get(i).after(datesList.get(i+1))){
                flag = true;
            }else {
                flag=false;
                break;
            }
        }
       // System.out.println("datesList = " + datesList);
        return flag;
    }

    public void close(){
        Driver.closeDriver();
    }












}
