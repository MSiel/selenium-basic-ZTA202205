import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest extends TestBase {

    String url = "https://seleniumui.moderntester.pl/iframes.php";

    @BeforeMethod
    public void setupIFrame() {
        driver.get(url);
    }

    @Test
    public void iFrameTest(){
        driver.switchTo().frame("iframe1");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Mariusz");
        driver.switchTo().defaultContent(); //tak dla bezpieczenstwa

        driver.switchTo().frame("iframe2");
        driver.findElement(By.id("inputLogin")).sendKeys("dupa");
        driver.switchTo().defaultContent(); //tak dla bezpieczenstwa

    }
}