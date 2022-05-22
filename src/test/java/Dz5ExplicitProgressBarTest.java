import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dz5ExplicitProgressBarTest extends TestBase {

    String url = "https://seleniumui.moderntester.pl/progressbar.php";

    @BeforeMethod
    public void setupAlert(){
        driver.get(url);
    }

    @Test
    public void shouldContainCompleteClass(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.cssSelector("#progressbar>.ui-progressbar-complete"));

    }



    @Test
    public void progressBarShouldShowCompleted(){
        String text = "Complete!";
        WebElement label = driver.findElement(By.cssSelector("#progressbar>.progress-label"));
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.textToBePresentInElement(label,text));
        wait.until(c->label.getText().equals(text));
    }

    @Test
    public void progressBarShouldShowCompleted2(){
        String className = "ui-progressbar-complete";
        WebElement bar = driver.findElement(By.cssSelector("#progressbar>.ui-progressbar-value"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.attributeContains(bar,"class",className));
                //lambda:
        wait.until(c -> bar.getAttribute("class").contains(className));
    }

    @AfterMethod
    public void resetImplicitWaitTime(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIME_SEC));

    }
}
