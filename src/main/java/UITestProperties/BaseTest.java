package UITestProperties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static ChromeOptions options;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        options=new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://flights-app.pages.dev/");
    }

    @AfterAll
    public static void tearDown() {
            driver.quit();
    }
}
