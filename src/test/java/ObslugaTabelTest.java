import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
/*
Otwórz stronę https://seleniumui.moderntester.pl/table.php
Stwórz test, który wypisze do konsoli – przy pomocy System.out.println() - informacje o szczytach (nazwa, pasmo górskie, państwo, wysokość) ale tylko tych których wysokość jest większa niż 4000m
Do rozwiązania zadania użyj pętli for-each w celu przeiterowania po wszystkich wierszach w tabeli
 */
public class ObslugaTabelTest extends TestBase{
    String url = "https://seleniumui.moderntester.pl/table.php";

    @BeforeMethod
    public void setupObslugaTabel() {
        driver.get(url);
    }

    @Test
    public void obslugaTabelTest(){
        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        int count = 0;
        for(WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String nazwa = cells.get(0).getText();
            String pasmo = cells.get(1).getText();
            String panstwo = cells.get(2).getText();
            Integer wysokosc = Integer.valueOf(cells.get(3).getText());

            if (wysokosc >4000){
                System.out.println(nazwa+" "+pasmo+" "+panstwo+" "+wysokosc);
                count++;
            }
        }
        Assert.assertEquals(count,9);

    }

}
