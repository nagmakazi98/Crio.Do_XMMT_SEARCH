package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public void testCase01() {
        System.out.println("Start Test case: testCase01");

        driver.get("https://www.makemytrip.com/");

        // retrieve the current url
        String currentUrl = driver.getCurrentUrl();

        //validating current url
        if(currentUrl.contains("makemytrip")){
            System.out.println("url of the page contains makemytrip");
        }
        else{
            System.out.println("url of the page does not contain makemytrip");  
            
            endTest();
        }

        //Closing pop-ups
        WebElement closepopups = driver.findElement(By.xpath("//*[@id='SW']/div[1]/div[2]/div[2]/div/section/span"));
        closepopups.click();

        System.out.println("end Test case: testCase01");
    }
   
    public void testCase02() throws InterruptedException {

        System.out.println("Start Test case: testCase02");

        //click on fromInputBox
       WebElement fromInput = driver.findElement(By.xpath("//*[@id='fromCity']"));
       fromInput.click();

       //click on toInputBox
       WebElement fromSearchBox = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));
       fromSearchBox.click();

       // sending input as text
       fromSearchBox.sendKeys("blr");

       Thread.sleep(1000);

       //clicking on the list of cities
       WebElement selectFromCity = driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']"));
       selectFromCity.click();

       //Validation
       WebElement from_input_box_validate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/label/p/span"));

       //retrieve the value of from_input_box using getText();
       String from_input_value = from_input_box_validate.getText();

       //print the value of from_input_Box
       System.out.println(from_input_value);

       if(from_input_value.contains("BLR")){
           System.out.println("sending blr as departure location");
       }
       else{
           System.out.println("sending invalid state code as departure location");
       }

       //click on toInputBox
       WebElement toInput = driver.findElement(By.xpath("//*[@id='toCity']"));
       toInput.click();

       //click on toSearchBox
       WebElement toSearchBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div[1]/input"));
       toSearchBox.click();

       // sending input as text
       toSearchBox.sendKeys("del");

       Thread.sleep(1000);

       //clicking on the list of cities
       WebElement selectToCity =  driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']"));
       selectToCity.click();

       //Validation of to_input_box
       WebElement to_input_box_validate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[2]/label/p/span"));

       //retrieve the value of to_input_box using getText();
       String to_input_value = to_input_box_validate.getText();

       //print the value of to_input_Box
       System.out.println(to_input_value);

       if(to_input_value.contains("DEL")){
           System.out.println("sending del as departure location");
       }
       else{
           System.out.println("sending invalid state code as departure location");
       }

       // click on Departure Date
       WebElement clickDeparture = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/label/span"));
       clickDeparture.click();

       Thread.sleep(2000);

       // click to the next set of dates according to the date of travel specified
       WebElement changeCalendar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
       changeCalendar.click();

       Thread.sleep(2000);

       //Validation of Departure Date
      // WebElement month = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div"));
      WebElement month = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div"));

       String departure_month = month.getText();

   System.out.println(departure_month);

       if(departure_month.contains("January 2024")){
           System.out.println("selecting January 2024 in the month of travel");
       }
       else{
           System.out.println("selecting invalid date in the month of travel");
       }
       
       // click on the speified date of travel
       WebElement clickDepartureDate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[7]"));
       clickDepartureDate.click();

       Thread.sleep(2000);

       //Clicking on Search button
       WebElement clickSearchbtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/p/a"));
       clickSearchbtn.click();

       // close pop-ups
       WebElement close_poup = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/span"));
       close_poup.click(); 

    //    //retrieve price per adult using getText();
    //    WebElement pricePerAdult = driver.findElement(By.xpath("//*[@id='listing-id']/div/div[2]/div/div[3]/div[1]/div[2]/div[2]/div/div/div"));
       WebElement pricePerAdult = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/div/div"));
      
       String priceperadult = pricePerAdult.getText();
       System.out.println(priceperadult);
    //     List <WebElement> findValue = driver.findElements(By.xpath("//div[@class='textRight flexOne']/div[1]"));

    //     for (WebElement webElement : findValue) {
    //     String printValue = webElement.getText();
    //      System.out.println(printValue);
    //     } 


       System.out.println("end Test case: testCase02");
   }

   public void testCase03() throws InterruptedException {

       System.out.println("Start Test case: testCase03");

       //clicking on trains link
       WebElement clickonTrains = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div/div/div/nav/ul/li[5]/span/a"));
       clickonTrains.click();

       // // closing pop-ups
       // WebElement closeads = driver.findElement(By.xpath("//*[@id='SW']/div[1]/div[2]/div[2]/div/section/span"));
       //  closeads.click();

        //click on fromInput Box
       WebElement fromInput = driver.findElement(By.xpath("//*[@id='fromCity']"));
       fromInput.click();

       // click on fromSearchBox
       WebElement fromSearchBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/div[1]/div/div/div/input"));
       fromSearchBox.click();

       Thread.sleep(1000);

       // sending input as text
       fromSearchBox.sendKeys("ypr");

       Thread.sleep(1000);

       //clicking on the list of cities
       WebElement fromCitySelect = driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']"));
       fromCitySelect.click();

       //Validation of from_input_box
       WebElement from_input_box_validate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[1]/label/p"));

       //retrieve the value of from_input_box using getText();
       String from_input_value = from_input_box_validate.getText();

       //print the value of from_input_box
       System.out.println(from_input_value);

       if(from_input_value.contains("YPR")){
           System.out.println("sending ypr as departure location");
       }
       else{
           System.out.println("sending invalid state code as departure location");
       }

       Thread.sleep(2000);

       //click on toInput Box
       WebElement toInput = driver.findElement(By.xpath("//*[@id='toCity']"));

       //click on toInputSearchBox
        WebElement toInputSearchBox = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input"));
        toInputSearchBox.click();

        // sending input as text
        toInputSearchBox.sendKeys("ndls");

       Thread.sleep(1000);

       //clicking on the list of cities
       WebElement toCitySelect = driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']"));
       toCitySelect.click();

       //Validation of to_input_box
       WebElement to_input_box_validate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[2]/label/p"));

       //retrieve the value of to_input_box using getText();
       String to_input_value = to_input_box_validate.getText();

       //printing the text from to_input_value
       System.out.println(to_input_value);

       if(to_input_value.contains("NDLS")){
           System.out.println("sending ndls as departure location");
       }
       else{
           System.out.println("sending invalid state code as departure location");
       }    

       // clicking on Departure Date
       WebElement clickDepature = driver.findElement(By.xpath("//*[@id='travelDate']"));
       clickDepature.click();

       Thread.sleep(2000);

       // clicking to the next set of dates according to the date of travel specified
       WebElement changeCalendar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
       changeCalendar.click();

       Thread.sleep(2000);

       //Validation of Departure Date
       WebElement month = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div"));

       String departure_month = month.getText();

   System.out.println(departure_month);

       if(departure_month.contains("January 2024")){
           System.out.println("selecting January 2024 in the month of travel");
       }
       else{
           System.out.println("selecting invalid date in the month of travel");
       }

       // clicking on the speified date of travel
       WebElement clickDepartureDate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[7]"));
       clickDepartureDate.click();

       Thread.sleep(2000);

       //clicking on class type
       WebElement clickOnClass = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[4]/label/span"));
       clickOnClass.click();

       //selecting the class type
       WebElement classType = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div[2]/div/div[4]/ul/li[3]"));
       classType.click();

       Thread.sleep(2000);

       //click on Search Button
       WebElement clickSearchbtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div[2]/p/a"));
       clickSearchbtn.click();

    //    // retrieve the price of Class Type specified using getText();
    //    WebElement classTypePrice = driver.findElement(By.xpath("//*[@id='train_options_20-01-2024_0']/div[1]/div[2]"));
    //    String trainclassTypePrice = classTypePrice.getText();
    //    System.out.println(trainclassTypePrice);

     // retrieve the price of Class Type specified using getText();
     WebElement classTypePrice = driver.findElement(By.xpath("//*[@id='train_options_17-02-2024_0']/div[1]/div[2]"));
     String trainclassTypePrice = classTypePrice.getText();
     System.out.println(trainclassTypePrice);

       System.out.println("end Test case: testCase03");
   }

   public void testCase04() throws InterruptedException {

       System.out.println("Start Test case: testCase04");

       //click on buses link
      // WebElement clickonBuses = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/nav/ul/li[6]/span/a"));
         WebElement clickonBuses = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div[2]/div/div/nav/ul/li[6]/span/a"));
                                                                
       clickonBuses.click();

       //clicking on fromInput box
       WebElement fromInput = driver.findElement(By.xpath("//*[@id='fromCity']"));
       fromInput.click();

       //clicking on from search box
       WebElement fromSearchBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input"));
       fromSearchBox.click();
       
       // sending input as text
       fromSearchBox.sendKeys("bangl");

       Thread.sleep(1000);

       //clicking on the list of cities
       WebElement fromCitySelect = driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-0']"));
       fromCitySelect.click();

       Thread.sleep(2000);

       //Validation of from_input_box
       WebElement from_input_box_validate = driver.findElement(By.xpath("//*[@id=\"fromCity\"]"));

       //retrieve the value of from_input_box using getAttribute();
       String from_input_value = from_input_box_validate.getAttribute("value");

       //printing the text from from_input_box
       System.out.println(from_input_value);

       if(from_input_value.contains("Bangalore, Karnataka")){
           System.out.println("sending blr as departure location");
       }
       else{
           System.out.println("sending invalid state code as departure location");
       }

       //clicking on toInputBox
       WebElement toInputBox = driver.findElement(By.xpath("//*[@id='toCity']"));
       // Thread.sleep(2000);
       // toInputBox.click();

       //clicking on toInputSearchbox
       WebElement toInputSearchBox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div/div/div/input"));
       toInputSearchBox.click();

       // sending input as text
       toInputSearchBox.sendKeys("del");

       Thread.sleep(1000);

       //clicking on the list of cities
       WebElement toCitySelect = driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]"));
       toCitySelect.click();

       //Validation of to_input_box
       WebElement to_input_box_validate = driver.findElement(By.xpath("//*[@id=\"toCity\"]"));

       //retrieve the value of to_input_box using getAttribute();
       String to_input_value = to_input_box_validate.getAttribute("value");

       //print the value from to_input_Box
       System.out.println(to_input_value);

       if(to_input_value.contains("Delhi")){
           System.out.println("sending ndls as departure location");
       }
       else{
           System.out.println("sending invalid state code as departure location");
       }

       // clicking on Departure Date
       WebElement clickDepature = driver.findElement(By.xpath("//*[@id='travelDate']"));
       //clickDepature.click();

       Thread.sleep(2000);

       // clicking to the next set of dates according to the date of travel specified
       WebElement changeCalendar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
       changeCalendar.click();

       Thread.sleep(2000);

       //Validation of Departure Date
       WebElement month = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div"));

       String departure_month = month.getText();

   System.out.println(departure_month);

       if(departure_month.contains("January 2024")){
           System.out.println("selecting January 2024 in the month of travel");
       }
       else{
           System.out.println("selecting invalid date in the month of travel");
       }

       // clicking on the speified date of travel
       WebElement clickDepartureDate = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[3]/div[7]"));
       clickDepartureDate.click();

       Thread.sleep(2000);

   //click on Search Button
       WebElement clickSearchbtn = driver.findElement(By.xpath("//*[@id=\"search_button\"]"));
       clickSearchbtn.click();

       // Validating bus search results page
       WebElement busSearch = driver.findElement(By.xpath("//*[@id='root']/div[1]/div[3]/div[1]/span[1]"));

       //retrieve the value using getText();
       String busSearchResult = busSearch.getText();

       if(busSearchResult.contains("No buses found for 20 Jan")){
           System.out.println("No buses found for 20 Jan");
       }

     System.out.println("End Test case: testCase04");

   }
}
