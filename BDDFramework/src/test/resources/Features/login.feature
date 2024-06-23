Feature: Sauce App Automation
Scenario Outline: Checkin login is successful with correct credentials
Given User on login Page "<url>"
When User has valid "<Username>" and "<password>"
And User clicks on Login button
Then User navigates to home page
Then Select Sorting criteria by "<Sorting Criteria Type>"
And User clicks on cart
Then User goes to cart Page and see no items are added by default
And close browser

Examples:
    | Username | password |url|Sorting Criteria Type|
    |    standard_user | secret_sauce |https://www.saucedemo.com/|Price (low to high)|