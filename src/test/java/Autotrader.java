import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;


public class Autotrader {
    private WebDriver wd;
    private static TestReport rep;

    @BeforeClass
    public static void setup(){
        rep = new TestReport();
        rep.setUp("AutoTraderReport");
    }

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        wd = new ChromeDriver(options);

    }

    @Test
    public void postcodetest() {
        ExtentTest t = rep.startTest("Postcode Test");
        PSE p = new PSE();
        String s = "N22 5JD";

        wd.navigate().to("http://www.autotrader.co.uk/");
        t.log(Status.INFO,"Went to homepage");
        FW fl = new FW();
        fl.wt(wd,30,5);
        Home h = PageFactory.initElements(wd,Home.class);
        Results r = PageFactory.initElements(wd,Results.class);
        h.select_postcode(s);
        t.log(Status.INFO,"Entered Postcode");
        h.search_car();
        t.log(Status.INFO,"Searched Cars");
        p.t(2);
        s=s.replaceAll("\\s+","");

        assertEquals(s.toLowerCase(),r.getPostcode_result().getAttribute("value"));
        if (s.toLowerCase().equals(r.getPostcode_result().getAttribute("value"))){
            t.log(Status.PASS,"Postcodes match");
        }
        else{
            t.log(Status.FAIL,"Postcodes do not match");
        }


    }

    @Test
    public void distancetest(){  //NEED TO FIX
        ExtentTest t = rep.startTest("Test 2");
        PSE p = new PSE();
        String dist = "10";
        String s = "N22 5JD";
        wd.navigate().to("http://www.autotrader.co.uk/");
        t.log(Status.INFO,"Went to homepage");
        FW fl = new FW();
        fl.wt(wd,30,5);
        Home h = PageFactory.initElements(wd,Home.class);
        Results r = PageFactory.initElements(wd,Results.class);

        h.select_postcode(s);
        t.log(Status.INFO,"Entered Postcode");
        h.click_nothing();
        h.select_distance(wd,dist);
        t.log(Status.INFO,"Selected distance");
        h.search_car();
        t.log(Status.INFO,"Searched Cars");
        p.t(3);

        assertEquals(dist,r.getDistance_result().getAttribute("value"));
        t.log(Status.INFO,"Checked whether distances matched");

        if (dist.equals(r.getDistance_result().getAttribute("value"))){
            t.log(Status.PASS,"Distance was entered correctly");

        }
        else {
            t.log(Status.FAIL,"Distance was not entered correctly");
        }
    }

    @Test
    public void signintest(){
        ExtentTest t = rep.startTest("Test 3");
        String email= "hello7@maildrop.cc";
        String pass = "ThisIsaPassword32";
        PSE p = new PSE();
        String s = "N22 5JD";
        wd.navigate().to("http://www.autotrader.co.uk/");
        t.log(Status.INFO,"Went to homepage");
        FW fl = new FW();
        fl.wt(wd,30,5);
        Home h = PageFactory.initElements(wd,Home.class);
        SignIn si = PageFactory.initElements(wd,SignIn.class);

        h.sign_in();
        si.sign_up();
        si.enter_email(email);
        si.enter_password(pass);
        t.log(Status.INFO,"Entered email and password");
        si.confirm_details();
        try {
            h.go_to_profile();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            t.log(Status.FAIL,"Sign up Failed");
        }

        assertEquals(email,si.getchkeml().getText());

        if (email.equals(si.getchkeml().getText())){
            t.log(Status.PASS,"Sign up Successful");
        }
        else {
            t.log(Status.FAIL,"Sign up Failed");
        }

    }

    @After
    public void sh(){
        wd.quit();
    }

    @AfterClass
    public static void en(){
        rep.getReport().flush();
    }




}
