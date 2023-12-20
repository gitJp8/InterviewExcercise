# InterviewExcercise
Selenium exercise for Experian Interview.
It uses a POM pattern, where we have the following classes (in the folder test/java):
- **Base**: Base class that initializes the WebDriver instance and includes common methods that can be shared in the page classes
- **SurveyPage**: Page class that contains all the relevant methods for the survey page (https://surveyrc.taxcreditco.com/automation-challenge). Includes methods to fill the user basic information, answer the questions and compare the final autofill field.
- **SurveyTests**:Tests scripts that will verify what was requested:
  1) verifyNames: Verifies the name in the final survey page text field matches with the one entered in the initial form.
  2) verifyHomePageIsDisplayed: Verifies that user gets redirected to “https://www.experian.com/employer-services” after submitting the form.

## Getting Started
- Download the project folder and open it in your IDE of preference.
- Build the project
- Run the SurveyTests script in the SurveyTests.java file
