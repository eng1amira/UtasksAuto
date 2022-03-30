Feature: Sign up , sign in, and Create new project with new task and editing existing project


  @firstTest
  Scenario Outline: Sign up with existing account and assert in Error messages
    When user clicks on Sign up link
    Then user fills mandatory fields as <username>, <email>,<password>,and <passwordConfirmation>
    Then <errorMessage>message appeared


    Examples:
      | username | email               | password | passwordConfirmation | errorMessage                |  |  |  |  |
      | Amira    | amiraali4@gmail.com | admin123 | admin123             | Failed to create an account |  |  |  |  |

  @secondTest
  Scenario Outline: Sign up, sign in, create new project, and create new task
    When user clicks on Sign up link
    Then user fills mandatory fields as <username>, <email>,<password>,and <passwordConfirmation>
    When user redirected to login
    Then fill in <email> and <password>
    When user redirected to home page
    Then User click on add new project with <projectName> , add it, and selects it
    Then user add new task with <taskName> ,select <dueDate> from drop down menu ,and add Task

    Examples:
      | username | email               | password | passwordConfirmation | projectName | taskName   | dueDate   |  |  |
      | Amira    | amiraaliz@gmail.com | admin123 | admin123             | Vodafone1   | automation | Next week |  |  |


  @ThirdTest
  Scenario Outline: sign in and editing existing task
    When user redirected to login
    Then fill in <email> and <password>
    When user redirected to home page
    Then User selects an existing <projectName>
    Then user add new task with <taskName> ,select <dueDate> from drop down menu ,and add Task

    Examples:
      | email               | password | projectName | taskName   | dueDate |
      | amiraaliz@gmail.com | admin123 | Vodafone1   | automation | Today   |