import java.time.Duration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Pobeda {
    private WebDriver driver;
    private WebDriverWait wait;

    public Pobeda() {
    }

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/IKHalizov/Desktop/AT-Cource/UI/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30L));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30L));
        this.driver.get("https://google.com/");
    }

    @Test
    public void PobedaTesting() {
        this.driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).click();
        this.driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).sendKeys(new CharSequence[]{"Сайт компании Победа"});
        this.driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).sendKeys(new CharSequence[]{Keys.ENTER});
        this.driver.findElement(By.cssSelector("h3")).click();

        this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.xpath("//div[contains(@class, 'dp-14a08ke-root') and text()='Полетели в Абу-Даби!']"))));
        String text = this.driver.findElement(By.xpath("//div[contains(@class, 'dp-14a08ke-root') and text()='Полетели в Абу-Даби!']")).getText();
        Assert.assertEquals(text, "Полетели в Абу-Даби!");

        this.driver.findElement(By.cssSelector(".dp-4d364c-root-root .dp-1c04wlv-root-root")).click();
        this.driver.findElement(By.cssSelector(".dp-fhjt6f-root .dp-5l8iqa-root")).click();

        String text1 = this.driver.findElement(By.xpath("//div[contains(@class, 'dp-YpbSQV-textVisible-ref') and contains(@class, 'dp-1glhebn-root-textVisible') and text()='Ticket search']")).getText();
        Assert.assertEquals(text1, "Ticket search");

        String text2 = this.driver.findElement(By.xpath("//div[contains(@class, 'dp-YpbSQV-textVisible-ref') and contains(@class, 'dp-1glhebn-root-textVisible') and text()='Online check-in']")).getText();
        Assert.assertEquals(text2, "Online check-in");

        String text3 = this.driver.findElement(By.xpath("//div[contains(@class, 'dp-YpbSQV-textVisible-ref') and contains(@class, 'dp-1glhebn-root-textVisible') and text()='Manage my booking']")).getText();
        Assert.assertEquals(text3, "Manage my booking");
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }
}
