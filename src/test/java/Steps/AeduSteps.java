package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class AeduSteps
{
    WebDriver driver;

    public AeduSteps(Hooks hooks)
    {
        this.driver = hooks.getDriver();
    }
    private static String ExpectedName = "Riddhi"; //Given an Expected name which takes dynamically on CRUD operation

    public class SharedContext //This class is made for takes dynamically updated values
    {
        public static String UpdatedTitle;
    }
    @Given("User is on dashboard page")
    public void user_is_on_dashboard_page()
    {
       System.out.println("User is on dashboard page");
    }
    @When("User clicks on Homework Menu")
    public void user_clicks_on_homework_menu() throws InterruptedException
    {
        WebElement DashboardMenu = driver.findElement(By.linkText("Homework")); //link text of Homework menu
        DashboardMenu.click();
        System.out.println("User is on Homework page");
        Thread.sleep(1000);
    }
    @Then("User is redirect on Homework page")
    public void user_is_redirect_on_homework_page() throws InterruptedException, IOException
    {
        System.out.println("User is redirected on Homework page");

        // Screenshot of Clicked on Attendance module
        TakesScreenshot HomeworkModuleScreenshot = (TakesScreenshot) driver;
        Thread.sleep(1000); //Saving the screenshot in desired location
        File HomeworkModuleFile = HomeworkModuleScreenshot.getScreenshotAs(OutputType.FILE);
        Thread.sleep(1000); //Path to the location to save screenshot
        FileHandler.copy(HomeworkModuleFile, new File("/Users/addweb/IdeaProjects/Aedu/Screenshot/HomeworkModule.png"));
        Thread.sleep(1000);
        System.out.println("Homework module Screenshot is captured");
    }
    @Given("User is on Homework page")
    public void userIsOnHomeworkPage()
    {
        System.out.println("User is on Homework page");
    }
    @When("User clicks on Add Homework button")
    public void userClicksOnAddHomeworkButton() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/div/a")).click(); //Add Homework Button
        Thread.sleep(1000);
    }
    @And("User fills up all the required fields")
    public void userFillsUpAllTheRequiredFields() throws InterruptedException, AWTException
    {
        driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/form/div/div[2]/div/div[1]/div[1]/input")).sendKeys(ExpectedName); //Add a Title of Homework
        Thread.sleep(1000);

        WebElement DatePicker = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/form/div/div[2]/div/div[2]/div/div[1]/input")); // Click on the DatePicker
        DatePicker.click();
        String DesiredDate = "06/22/2023"; // Specify the date
        DatePicker.sendKeys(DesiredDate); // Enter the date into the DatePicker using the sendKeys() method
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        WebElement MessageField = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/form/div/div[2]/div/div[1]/div[2]")); //xpath of whole message field
        actions.moveToElement(MessageField);

        WebElement Toolbar = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/form/div/div[2]/div/div[1]/div[2]/ul")); //xpath of toolbar
        actions.moveToElement(Toolbar);

        WebElement Textarea = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/form/div/div[2]/div/div[1]/div[2]/iframe")); //xpath of textarea and send a message
        actions.moveToElement(Textarea);
        Textarea.click();
        Textarea.sendKeys("This is for test Message");
        Thread.sleep(1500);

        WebElement browse = driver.findElement(By.id("files")); //click on ‘Choose file’ to upload the file
        browse.sendKeys("/Users/addweb/Downloads/dummyPdf.pdf"); //Uploading the file using sendKeys or path of the pdf
        System.out.println("File is Uploaded Successfully");
        Thread.sleep(1500);

        driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/form/div/div[2]/div/div[1]/div[3]/div/select")).sendKeys("ENGLISH (Theory) "); //Select a value of Subject
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/form/div/div[2]/div/div[1]/div[4]/div/select")).sendKeys("SBN-Nursery"); //Select a value of Class
        Thread.sleep(2000);

        JavascriptExecutor JS = (JavascriptExecutor) driver; // Scroll down the page
        JS.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement Checkbox = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/form/div/div[2]/div/div[1]/div[5]/div/div/label[2]/div/input")); //Select a checkbox of section
        Checkbox.click();
        Thread.sleep(2000);

        System.out.println("User filled all the required fields");
    }
    @And("User clicks on Submit button")
    public void userClicksOnSubmitButton() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/form/div/div[3]")).click(); //xpath of Submit button
        Thread.sleep(1500);
    }
    @Then("Added details are display")
    public void addedDetailsAreDisplay()
    {
        System.out.println("Added details are display");
    }
    @Given("User is on the Homework page")
    public void userIsOnTheHomeworkPage()
    {
        System.out.println("User is on the Homework page");
    }
    @When("User clicks on the Edit button")
    public void userClicksOnTheEditButton() throws InterruptedException
    {
        WebElement Searchbar = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div/div/div/div[2]/label/input")); //xpath of Searchbar
        Searchbar.sendKeys(ExpectedName); //In Search bar expected value will enter
        Thread.sleep(2500);

        Actions MatchTitle = new Actions(driver);
        WebElement HomeworkTable = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]")); //xpath of whole homework table
        MatchTitle.moveToElement(HomeworkTable);
        List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div/div/div/table/tbody/tr")); //common xpath of Homework's row
        System.out.println("Matched a Title");

        int Size = rows.size();
        System.out.println("Total Rows are : " + Size);  //Total row will display
        for (int j = 1; j <= Size; j++)
        {
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div/div/div/table/tbody/tr[" + j + "]/td[4]/a[2]")).click(); //common xpath of Edit button [When Title will match then it will click on edit button]
            System.out.println("clicked");
            Thread.sleep(2000);
            break;
        }
    }
    @And("User update the data")
    public void userUpdateTheData() throws InterruptedException
    {
        Thread.sleep(1000);
        WebElement TitleElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/form/div/div[2]/div[1]/div[1]/input")); //xpath of Title
        String UpdatedTitleValue = "New Updated  "; //Updated Title Name
        TitleElement.sendKeys(UpdatedTitleValue); //In the above given xpath of title above updated title will send
        SharedContext.UpdatedTitle = UpdatedTitleValue; //Public class which made at the starting of script is equivalent by updated method
        Thread.sleep(5000);

        JavascriptExecutor JSE = (JavascriptExecutor) driver; // Scroll down the page
        JSE.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement SectionCheckbox = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/form/div/div[2]/div[1]/div[5]/div/div/div")); //Select a checkbox of section
        SectionCheckbox.click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/form/div/div[3]/div/button")).click(); //xpath of Save button
        Thread.sleep(3000);

        System.out.println("Updating the Homework");
        Thread.sleep(3000);
    }

    @Then("Updated data is display")
    public void updatedDataIsDisplay()
    {
        System.out.println("Updated the Homework");
    }

    @Given("User is on to the homework page")
    public void userIsOnToTheHomeworkPage()
    {
        WebElement SearchbarField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div/div/div/div[2]/label/input")); //xpath of Searchbar
        SearchbarField.clear(); // Clear any existing value in the search bar
        SearchbarField.sendKeys(SharedContext.UpdatedTitle +ExpectedName); //In Search bar first it adds updated values, and then it adds expected value which was adds at the time of creation
        SearchbarField.sendKeys(Keys.ENTER); //Click on the Searchbar
    }
    @When("User click on view menu")
    public void userClickOnViewMenu() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div/div/div/table/tbody/tr/td[4]/a[1]")).click(); //xpath of View button
        Thread.sleep(4000);
        System.out.println("Viewing the Homework");
    }
    @Then("Homework page is display")
    public void homeworkPageIsDisplay()
    {
        System.out.println("Viewed the Homework");
    }
    @Given("user is on to homework page")
    public void userIsOnToHomeworkPage() throws InterruptedException
    {
        WebElement HomeworkMenu = driver.findElement(By.linkText("Homework")); //link text of Homework menu
        HomeworkMenu.click();
        System.out.println("User clicks on Homework menu");

        WebElement SearchbarField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div/div/div/div[2]/label/input")); //xpath of Search bar
        SearchbarField.clear(); // Clear any existing value in the search bar
        SearchbarField.sendKeys(SharedContext.UpdatedTitle + ExpectedName); //In Search bar first it adds updated values, and then it adds expected value which was adds at the time of creation
        Thread.sleep(5000);
        SearchbarField.sendKeys(Keys.ENTER); //CLick on Search bar
    }
    @When("User clicks on Delete menu")
    public void userClicksOnDeleteMenu() throws InterruptedException
    {
        Thread.sleep(1500);
        WebElement Delete = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div/div/div/table/tbody/tr[1]/td[4]/form/button")); //xpath of Delete Button
        Thread.sleep(3000);
        Delete.click(); //xpath of Delete menu
    }
    @Then("Homework is deleted")
    public void homeworkIsDeleted() throws InterruptedException
    {
        System.out.println("Homework Deleted Successfully");

        WebElement HomeWorkMenu = driver.findElement(By.linkText("Homework")); //link text of Homework menu
        HomeWorkMenu.click();
        System.out.println("User clicks on Homework menu");
        Thread.sleep(1000);

        WebElement SearchBarFields = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[2]/div/div/div/div[2]/label/input")); //xpath of Searchbar
        SearchBarFields.sendKeys(SharedContext.UpdatedTitle +ExpectedName); //In Search bar first it adds updated values, and then it adds expected value which was adds at the time of creation
        SearchBarFields.click(); //Click on the Searchbar
        Thread.sleep(5000);
        System.out.println("User view the deleted data is display or not");
    }
    @Given("User is in the Homework page")
    public void userIsInTheHomeworkPage()
    {
        WebElement HomeworkMenu = driver.findElement(By.linkText("Homework")); //link text of Homework menu
        HomeworkMenu.click();
        System.out.println("User clicks on Homework menu");
    }
    @When("User clicks on the Add Homework button")
    public void userClicksOnTheAddHomeworkButton() throws InterruptedException
    {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div[1]/div[1]/div/a")).click(); //Add Homework Button
        Thread.sleep(1500);
    }
    @And("User clicks on the Submit button")
    public void userClicksOnTheSubmitButton() throws InterruptedException, IOException
    {
        JavascriptExecutor Submit = (JavascriptExecutor) driver; // Scroll down the page
        Submit.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/form/div/div[3]")).click(); //xpath of Submit button
        Thread.sleep(5000);

        // Screenshot of Clicked on Attendance module
        TakesScreenshot ValidationScreenshot = (TakesScreenshot) driver;
        Thread.sleep(1000); //Saving the screenshot in desired location
        File HomeworkModuleFile = ValidationScreenshot.getScreenshotAs(OutputType.FILE);
        Thread.sleep(1000); //Path to the location to save screenshot
        FileHandler.copy(HomeworkModuleFile, new File("/Users/addweb/IdeaProjects/Aedu/Screenshot/Validation.png"));
        Thread.sleep(1000);
        System.out.println("Validation Screenshot is captured");
        System.out.println("Get a Message");
    }
    @Then("Validation is display")
    public void validationIsDisplay()
    {
        System.out.println("Validation is displayed");
    }
}

