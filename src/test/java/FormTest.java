import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FormTest extends TestBase {
    String url = "https://seleniumui.moderntester.pl/form.php";
    @Test
    public void shouldFillFormWithSuccess() {
        driver.get(url);

        //pola tekstowe
        WebElement fname = driver.findElement(By.id("inputFirstName3"));
        fname.sendKeys("Bugusław");

        WebElement fLastName = driver.findElement(By.id("inputLastName3"));
        fLastName.sendKeys("Łęcina");

        WebElement fEmail = driver.findElement(By.id("inputEmail3"));
        fEmail.sendKeys("jakotakoifajrant@onet.pl");

        //radio buttony
        List<WebElement> radioSex = driver.findElements(By.name("gridRadiosSex"));
        for(WebElement element : radioSex) {
            if(element.getAttribute("value").equals("other")){
                element.click();
                break;
            }
        }

        //pole tekstowe
        WebElement fAge = driver.findElement(By.id("inputAge3"));
        fAge.sendKeys("35");

        //radio buttony
        List<WebElement> radioYrsofExp = driver.findElements(By.name("gridRadiosExperience"));
        for(WebElement element : radioYrsofExp) {
            if(element.getAttribute("value").equals("1")){
                element.click();
                break;
            }
        }

        //checkboxy
      /*  List<WebElement> checkProfession = driver.findElements(By.name("gridCheckboxProfession"));

        for(WebElement element : checkProfession) {
            if(element.getAttribute("id").equals("gridCheckOther")){
                element.click();
                break;
            }
        }*/

        driver.findElement(By.id("gridCheckOther")).click();
        driver.findElement(By.id("gridCheckAutomationTester")).click();

        //dropdown jednokrotnego wyboru
        Select continent = new Select(driver.findElement(By.id("selectContinents")));
        continent.selectByValue("asia");           //wybieramy element po wartosci
        continent.selectByIndex(6);                  //wybieramy element po nr indeksu
        continent.selectByVisibleText("Europe");     //wybieramy element po tekście

        //pole wielokrotnego wyboru
        Select selCommds = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        selCommds.selectByValue("browser-commands");           //wybieramy element po wartosci
        selCommds.selectByIndex(1);                              //wybieramy element po nr indeksu
        selCommds.selectByVisibleText("Switch Commands");     //wybieramy element po tekście

        WebElement ffile = driver.findElement(By.id("chooseFile"));
        ffile.sendKeys("C:\\temp\\New folder\\plik.txt");

        driver.findElement(By.tagName("form")).submit();



       WebElement message = driver.findElement(By.id("validator-message"));
       Assert.assertEquals(message.getText(),"Form send with success");
    }
}
