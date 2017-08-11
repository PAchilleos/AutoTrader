import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.List;

/** Courtesy of Ashley**/
public class TestReport {

    private ExtentReports report;
    private ExtentTest test;
    private String reportFilePath = "report.html";
    private List<ExtentTest> testList;

    @BeforeClass
    public static void init(){

    }

    @Before
    public void setUp(String a){
        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("ReportName");
        extentHtmlReporter.config().setDocumentTitle("DocumentTitle");
        report.attachReporter(extentHtmlReporter);


    }

    public ExtentTest startTest(String name){
        testList = new ArrayList<>() ;
        ExtentTest t = report.createTest(name);
        testList.add(t);
        return t;
    }

    public ExtentReports getReport() {

        return report;
    }





}
