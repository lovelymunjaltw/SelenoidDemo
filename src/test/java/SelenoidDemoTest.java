import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SelenoidDemoTest {

    WebDriver driver;

    @BeforeClass
    public void setUp () {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC",true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.addArguments("--window-size=1920,1080");
//        options.addArguments("-video-output-dir=/opt/selenoid/video");
//        options.addArguments("--video-output-dir=/opt/selenoid/video");
//        options.addArguments("vnc=true");

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1 (){
        int i = 0;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://spree-vapasi.herokuapp.com");
        System.out.println("i is: " + i++);
        driver.findElement(By.linkText("Login")).click();
        System.out.println("i is: " + i++);
        Assert.assertEquals(1,1);
        driver.quit();
    }
}