import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//51:28
public class KalkulatorTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("run once before all tests");
    }


    @Test
    public void verifyAddMethod() {
        //Kalkulator.add(2,3);
        //Assert.assertEquals(5,Kalkulator.add(2,3));
        Assert.assertEquals(Kalkulator.add(2,3),5);
    }


    @Test
    public void verifyMultiply() {
        //Assert.assertEquals(10,Kalkulator.multiply(2,3));
        Assert.assertEquals(Kalkulator.multiply(2,3),6);
    }



}
