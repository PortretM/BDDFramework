Feature: SauceDemo Functionality
Background: User is logged in
Given User has valid credentials
And User clicks login
Then User is navigated to Home Page

Scenario: Able to Add items
And select items
Then user is able to see items in cart



Scenario: Able to see about page
When  select about section
Then user is able to see about section




