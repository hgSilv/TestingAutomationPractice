Feature: Sign up
Scenario: Creation of a new account
Given User is on "http://automationpractice.com/"
When User navigates to sign in
Then User provides "test@hs1.com" and clicks create account button
And User provides information to Register with
Then page shows success message

