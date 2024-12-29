Feature: Web Application testing

Background: user is login with valid credentials
Given I navigate the home page
And I click on the login button
Then I Enter email as saisairam1616@gmail.com and Ssaisairam@1666
Then I click on signin button

Scenario Outline: Add a new employee to the user

Given I navigate to the the dashboard page
Then I click on the Users tab on left side menu
Then I click on the Add Employee button
Then I enter the user details <user Name> and <user Email> and <user Employee id> and <user type> and <user department> and <user designation>
Then I click on create button 

Examples:

user Name   | user Email         | user Employee id  | user type  | user department    |user designation   |
abcde       | abcde123@gmail.com | A123              | Admin      | QA                 | QA Engineer       |
fgh         |fgh123@gmail.com    | B123              | Non Admin  | Dev                | Software Developer|               
ram         |ram213@gmail.com    | C123              | Non Admin  | Devops             | Software Engineer |

Scenario: update the existing user

Then I click on the Users tab on left side menu
Then I click on the first record view icon
Then I update the phone number
Then I update the Designation
Then I click on Save Changes
Then I click on the Users tab on left side menu
Then I click on the first record view icon
Then I validate the phone number and Designation


Scenario: delete the existing user

Then I click on the tab on left side menu
Then I click on the first record view icon
Then I click on Delete User

Scenario: create Attendence log for users

Then I click on the Attendance Log tab on left side menu
Then I select the user as Sai Sairam

Scenario: verify the user is update the company settings

Then I click on the Company Settings tab on left side menu
Then I update the company name
And I update the Industry name
Then I update the new location
Then I save the changes


Scenario: user is downloading the attendence report

Then I click on the Attendance Report tab on left side menu
And I click on download button it will downloaded in excel sheet