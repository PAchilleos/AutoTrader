import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn {

    @FindBy(xpath = "//*[@id=\"js-social__signup-tab\"]/span")
    WebElement signup;

    @FindBy(xpath="//*[@id=\"email\"]")
    WebElement eml;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement pass;

    @FindBy(xpath="//*[@id=\"social--signup--submit\"]")
    WebElement con;

    @FindBy(xpath ="//*[@id=\"email\"]")
    WebElement chkeml; //on a different site

    public void sign_up(){
        signup.click();
    }

    public void enter_email(String email){
        eml.sendKeys(email);
    }

    public void enter_password(String password){
        pass.sendKeys(password);
    }
    public void confirm_details(){
        con.click();
    }

    public WebElement getchkeml() {
        return chkeml;
    }
}
