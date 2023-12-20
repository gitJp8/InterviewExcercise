import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
public class SurveyPage extends Base{

    private WebDriver driver;
    By txtFieldFirstName = By.cssSelector("input[id*='SurveyControl_Question943']");
    By txtFieldLastName = By.cssSelector("input[id*='SurveyControl_Question946']");
    By txtFieldEmail = By.cssSelector("input[id*='SurveyControl_Question949']");
    By txtFieldStreet = By.cssSelector("input[id*='SurveyControl_Question950']");
    By txtFieldCity = By.cssSelector("input[id*='SurveyControl_Question951']");
    By txtFieldZip = By.cssSelector("input[id*='SurveyControl_Question952']");
    By btnNext = By.id("SurveyControl_SurveySubmit");
    By radioBtnFirstQuestion = By.xpath("//div[@id='SurveyControl_Question11396']/div/label[2]");
    By radioBtnSecondQuestion = By.xpath("//div[@id='SurveyControl_Question11397']/div/label[2]");
    By radioBtnThirdQuestion = By.xpath("//div[@id='SurveyControl_Question914']/div/label[2]");
    By radioBtnFourthQuestion = By.xpath("//div[@id='SurveyControl_Question11361']/div/label[2]");
    By radioBtnFifthQuestion = By.xpath("//div[@id='SurveyControl_Question915']/div/label[2]");
    By radioBtnSixthQuestion = By.xpath("//div[@id='SurveyControl_Question1244']/div/label[2]");

    By txtFieldAutoFullName = By.cssSelector("input[id*='SurveyControl_Question1137']");

    By btnSubmitForm = By.id("SurveyControl_SurveySubmit");
    By divLastPage = By.id("jurat");
    String fullName = "";

    String expectedTitle = "Experian Employer Services | Official Site";


    public SurveyPage(WebDriver driver){
        super(driver);
    }

    public void fillBasicInformation(String firstName, String lastName, String email, String streetAddress, String city, String zipCode){
        //fill in the basic information section of the survey
        sendKeys(txtFieldFirstName, firstName);
        sendKeys(txtFieldLastName, lastName);
        sendKeys(txtFieldEmail, email);
        sendKeys(txtFieldStreet, streetAddress);
        sendKeys(txtFieldCity, city);
        sendKeys(txtFieldZip, zipCode);
        //click on the next button
        System.out.println("Basic info filled, about to click on the next button");
        scrollToEnd();
        click(btnNext);
    }

    public void answerQuestions(){
        //send the answers for the section 2 of the survey
        //Question #1
        click(radioBtnFirstQuestion);
        scrollToEnd();
        //Question #2
        click(radioBtnSecondQuestion);
        //Question #3
        click(radioBtnThirdQuestion);
        //Question #4
        click(radioBtnFourthQuestion);
        //Question #5
        click(radioBtnFifthQuestion);
        //Question #6
        click(radioBtnSixthQuestion);
        //click on the next button
        click(btnNext);
    }

    public void setFullName(){
        wait(divLastPage);
        fullName = getText(txtFieldAutoFullName);
    }

    public void submitForm(){
        click(btnSubmitForm);
    }

    public boolean isHomePageDisplayed(){
        //checks if the homepage title is equal to the expected title
        return getTitle().equals(expectedTitle);
    }
}
