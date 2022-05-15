import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragNDropTest extends TestBase{

    String url = "https://seleniumui.moderntester.pl/droppable.php";
    private WebElement draggable;
    private WebElement dropZone;
    private Actions action;

    @BeforeMethod
    public void setupDragAndDrop(){
        driver.get(url);
        draggable = driver.findElement(By.id("draggable"));
        dropZone = driver.findElement(By.id("droppable"));
        action = new Actions(driver);
    }

    @Test
    public void dragAndDrop(){
        //teraz mozna robic d&d
        action.dragAndDrop(draggable,dropZone).perform();
        Assert.assertEquals(dropZone.getText(),"Dropped!");
    }

    @Test
    public void holdAndMoveOver(){
        //teraz mozna robic d&d
        action.clickAndHold(draggable).moveToElement(dropZone).release().perform();
        Assert.assertEquals(dropZone.getText(),"Dropped!");
    }


    @Test
    public void moveByOffset(){
        //teraz mozna robic d&d
        action.clickAndHold(draggable).moveByOffset(dropZone.getLocation().x - draggable.getLocation().x +5,10).release().perform();
        Assert.assertEquals(dropZone.getText(),"Dropped!");
    }



}
