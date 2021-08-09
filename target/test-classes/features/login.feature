Feature: Login
Scenario: login of an existing account
Given User is on "http://automationpractice.com/"
When User navigates to sign in
And User provides "random@test.com" and "random" to login
Then page shows success message