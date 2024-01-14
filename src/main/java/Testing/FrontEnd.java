package Testing;

import UITestProperties.BaseTest;
import UITestProperties.Page;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;

public class FrontEnd  extends BaseTest {

    @Test
    public void testSearchSameFromTo() throws InterruptedException {
        Page page = new Page(driver);
        String selectedCity = "Istanbul";
        page.SendKeysFromAndTo(selectedCity);
    }
    @Test
    public void testSearchDifferentCities() throws InterruptedException {
        Page page = new Page(driver);
        String fromCity = "Istanbul";
        String toCity = "Los Angeles";
        page.SendKeysFromAndTo(fromCity, toCity);
    }
    @Test
    public void List() throws InterruptedException {
        Page page = new Page(driver);
        String fromCity = "Istanbul";
        String toCity = "Los Angeles";
        page.SendKeysFromAndTo(fromCity, toCity);
        page.Listing();
    }
}
