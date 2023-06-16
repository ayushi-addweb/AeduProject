package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks
{
    private WebDriver driver;

    @Before(order = 0)
    public void SetUp() throws InterruptedException
    {
        System.out.println("-------------------------");
        System.out.println("Starting Of The Scenario.");
        System.out.println("-------------------------");
        System.setProperty("web-driver.chrome.driver", "/Users/addweb/IdeaProjects/Aedu/src/chromedriver"); //Chromedriver path

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--headless"); // For Headless mode
        driver = new ChromeDriver(options);

        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://demo.aedu.co.in/admin/admin/dashboard"); //Aedu site
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/form[1]/div[1]/input")).sendKeys("addwebsolution@gmail.com"); //Username path
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/form[1]/div[2]/input")).sendKeys("addweb@123"); //Password
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div[2]/form[1]/button")).click(); //SignIn button
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[1]/div/h3")).getText(); //Get a Dashboard text
        Thread.sleep(1000);
    }

    @After(order = 1)
    public void TearDown() throws InterruptedException
    {
        System.out.println("-----------------------");
        System.out.println("Ending Of The Scenario.");
        System.out.println("-----------------------");
        driver.quit();
        Thread.sleep(2000);
    }
    public WebDriver getDriver()
    {
        return driver;
    }
}
