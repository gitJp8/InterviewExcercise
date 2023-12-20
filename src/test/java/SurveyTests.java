import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SurveyTests {
    private WebDriver driver;
    SurveyPage surveyPage;

    SoftAssert softAssert;

    String firstName = "Bill";
    String lastName = "Gates";
    String email = "bill@microsoft.com";
    String streetAddress = "One Microsoft Way";
    String city = "Seattle";
    String zipCode = "98052";

    @BeforeTest
    public void preTest(){
        surveyPage = new SurveyPage(driver);
        surveyPage.setDriver();
        softAssert = new SoftAssert();

    }
    @Test(priority = 1)
    public void verifyNames(){
        surveyPage.get("https://surveyrc.taxcreditco.com/automation-challenge");
        surveyPage.fillBasicInformation(firstName, lastName, email, streetAddress, city, zipCode);
        System.out.println("Basic info filled");
        surveyPage.answerQuestions();
        System.out.println("Questions answered");
        surveyPage.setFullName();
        System.out.println("Will compare names");
        softAssert.assertEquals(firstName + " " + lastName, surveyPage.fullName, "Name entered in the form is the same as the autofilled");
    }
    @Test(priority = 2)
    public void verifyHomePageIsDisplayed(){
        surveyPage.scrollToEnd();
        surveyPage.submitForm();
        softAssert.assertTrue(surveyPage.isHomePageDisplayed(), "Home page has been displayed");
    }

    @AfterTest
    public void endTest(){
        surveyPage.quit();
    }
}
