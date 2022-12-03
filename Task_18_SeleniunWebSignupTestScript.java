import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniunWebSignupTest {

    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        driver = new ChromeDriver();
        //Test 1: Verify that user inputs the right url and is on the right page
        driver.get("https://selenium-blog.herokuapp.com");
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Incorrect Webpage");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void positiveSignup() throws InterruptedException {
        //Test 7:Verify that user can signup with valid details
        driver.findElement(By.id("user_username")).sendKeys("gmayrreeeew1");
        driver.findElement(By.id("user_email")).sendKeys("gmayreew4@mailinator.com");
        driver.findElement(By.id("user_password")).sendKeys("gmareereew@3");
        driver.findElement(By.id("submit")).click();
        System.out.println("Successful Signup");
        Thread.sleep(5000);
    }
    @Test (priority = 1)
    public void clickUser1Item() throws InterruptedException {
        //Test 2. Verify that when user clicks on the signup button, the user is directed to the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
                if(actualUrl.contains(expectedUrl))
                    //Pass
                    System.out.println("Correct Webpage");
                else
                    //Fail
                    System.out.println("Incorrect Webpage");
        Thread.sleep(5000);
    }
    @Test(priority = 2)
    public void verifyItem() throws InterruptedException {
        //Test 9: Verify that the item searched for on the User1 page is present
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //Pass
            System.out.println("Correct user1Page");
        else
            //Fail
            System.out.println("Incorrect user1Page");
        Thread.sleep(5000);
    }
        @Test (priority = 3)
        public void logoutSuccessfully() {

        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test 10: Verify that when the user logout, they are directed back to the home page
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedTitle))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Incorrect Webpage");
    }

    @Test (priority = 4)
    public void negativeSignup2() throws InterruptedException {
        //Test 6:Verify that user cannot signup with either/all of the fields empty
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("user_username")).sendKeys("madie");
        driver.findElement(By.id("user_email")).sendKeys("");
        driver.findElement(By.id("user_password")).sendKeys("");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void negativeSignup() throws InterruptedException {
        //Test 3:Verify that user cannot signup with username less than three characters
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("user_username")).sendKeys("mx");
        //Test 4: Verify that user cannot signup with invalid email address
        driver.findElement(By.id("user_email")).sendKeys("marx4@mailinator");
        //Test 5: Verify that user cannot signup with password less than or equal to one character
        driver.findElement(By.id("user_password")).sendKeys("mareed@3");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
    @AfterTest
    public void CloseBrowser() {
        driver.quit();

    }}

