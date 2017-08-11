import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;

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
        ExtentTest t = rep.startTest("Test 1");
        PSE p = new PSE();
        String s = "N22 5JD";

        wd.navigate().to("http://www.autotrader.co.uk/");
        t.log(Status.INFO,"Went to homepage");
        FW fl = new FW();
        fl.wt(wd,30,5);
        Home h = PageFactory.initElements(wd,Home.class);
        Results r = PageFactory.initElements(wd,Results.class);
        h.select_postcode(s);
        h.search_car();
        p.t(2);
        s=s.replaceAll("\\s+","");

        assertEquals(s.toLowerCase(),r.getPostcode_result().getAttribute("value"));


    }

    @Test
    public void distancetest(){  //NEED TO FIX
        ExtentTest t = rep.startTest("Test 2");
        PSE p = new PSE();
        String dist = "10";
        String s = "N22 5JD";
        wd.navigate().to("http://www.autotrader.co.uk/");
        FW fl = new FW();
        fl.wt(wd,30,5);
        Home h = PageFactory.initElements(wd,Home.class);
        Results r = PageFactory.initElements(wd,Results.class);

        h.select_postcode(s);
        h.click_nothing();
        h.select_distance(wd,dist);
        h.search_car();
        p.t(3);

        assertEquals(dist,r.getDistance_result().getAttribute("value"));
    }

    @Test
    public void signintest(){
        ExtentTest t = rep.startTest("Test 3");
        String email= "hello7@maildrop.cc";
        String pass = "ThisIsaPassword32";
        PSE p = new PSE();
        String s = "N22 5JD";
        wd.navigate().to("http://www.autotrader.co.uk/");
        FW fl = new FW();
        fl.wt(wd,30,5);
        Home h = PageFactory.initElements(wd,Home.class);
        SignIn si = PageFactory.initElements(wd,SignIn.class);

        h.sign_in();
        si.sign_up();
        si.enter_email(email);
        si.enter_password(pass);
        si.confirm_details();
        h.go_to_profile();
        assertEquals(email,si.getchkeml().getText());
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
