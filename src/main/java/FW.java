import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class FW {
    private Wait<WebDriver> wait;

    public Wait<WebDriver> wt(WebDriver w,int to,int p){
        wait = new FluentWait<WebDriver>(w)
                .withTimeout(to, TimeUnit.SECONDS)
                .pollingEvery(p, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        return wait;
    }


    public void xpathcon(final WebDriver wd, final String xpath) {
        wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver webDriver) {
                return wd.findElement(By.xpath(xpath));
            }
        });
    }

    public void csscon(final WebDriver wd, final String css) {
        wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver webDriver) {
                return wd.findElement(By.cssSelector(css));
            }
        });
    }
}
