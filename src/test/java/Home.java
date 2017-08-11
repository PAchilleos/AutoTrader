import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class Home {

    @FindBy(xpath = "//*[@id=\"searchVehiclesMake\"]")
    WebElement make;

    @FindBy(xpath = "//*[@id=\"searchVehiclesModel\"]") //must be selected after make;
    WebElement model;

    @FindBy(xpath = "//*[@id=\"searchVehiclesPriceFrom\"]")
    WebElement minprice;

    @FindBy(xpath = "//*[@id=\"searchVehiclesPriceTo\"]")
    WebElement maxprice;

//    @FindBy(xpath = "//*[@id=\"radius\"]/option[1]")
//    WebElement dist;

    @FindBy(xpath = "//*[@id=\"js-header-nav\"]/ul/li[5]/div[2]/a")
    WebElement sign;


    @FindBy(xpath = "//*[@id=\"js-header-nav\"]/ul/li[5]/div[1]/a/i")
    WebElement prof1;

    @FindBy(xpath = "//*[@id=\"top-nav__signed-in\"]/li[6]/a")
    WebElement prof2;


    @FindBy(xpath = "//*[@id=\"postcode\"]") //enter keys into this
    WebElement postcode;

    @FindBy(xpath="//*[@id=\"search\"]/span") //get text to make sure there are cars
    WebElement srch;

    @FindBy(xpath="//*[@id=\"searchVehicles\"]/div/h1")
    WebElement blank;

    public void select_postcode(String s){
        postcode.sendKeys(s);
    }

    public void select_distance(WebDriver w, String s){
        Select dist = new Select(w.findElement(By.xpath("//*[@id=\"radius\"]")));


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        dist.selectByValue(s);

    }

    public void search_car(){
        String s = srch.getText();
        if (s.equals("Search 0 cars")){
            System.out.println("no cars to search");
        }
        else{
            srch.click();
        }
    }

    public void sign_in(){
        sign.click();
    }

    public void go_to_profile(){
        prof1.click();
        prof2.click();
    }

    public void click_nothing(){
        blank.click();
    } // THIS IS NECESSARY TRUST ME!!






}
