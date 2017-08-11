import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Results {

    @FindBy(xpath = "/html/body/main/section[1]/div[1]/form/ul/li[3]/div/button/span/span[2]") // get make from dropdown menu and compare to result
    WebElement make_result;

    @FindBy(xpath = "//*[@id=\"postcode\"]")
    WebElement postcode_result;

    @FindBy(xpath = "/html/body/main/section[1]/div[1]/form/ul/li[1]/fieldset/div[1]/div/select")
    WebElement distance_result;

    public WebElement getPostcode_result() {
        return postcode_result;
    }

    public WebElement getDistance_result() {
        return distance_result;
    }
}
