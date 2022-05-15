import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*
driver.switchTo().alert().sendKeys("some text");
driver.switchTo().alert().accept();
driver.switchTo().alert().dismiss();
*/

public class AlertTest extends TestBase{

    String url = "https://seleniumui.moderntester.pl/alerts.php";

    @BeforeMethod                                 //ALBO TO (a1)
    public void setupAlert(){
        driver.get(url);
    }

    @Test
    public void shouldAcceptAlert(){
        //driver.get(url);                            //ALBO TO (a2)
        //klikamy button
        driver.findElement(By.id("simple-alert")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent(); //tak dla bezpieczenstwa
        //teraz asercja -- sprawdzamy czy po kliknieciu^^ bedzie spodziewany text
        Assert.assertEquals(driver.findElement(By.id("simple-alert-label")).getText(),"OK button pressed");
    }

    @Test
    public void shouldFillPromptAlert(){
        driver.findElement(By.id("prompt-alert")).click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        Assert.assertEquals(driver.findElement(By.id("prompt-label")).getText(),"Hello Harry Potter! How are you today?");
    }

    @Test
    public void shouldDismissAlert(){
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().dismiss();
        driver.switchTo().defaultContent();
        Assert.assertEquals(driver.findElement(By.id("confirm-label")).getText(),"You pressed Cancel!");
    }
}
