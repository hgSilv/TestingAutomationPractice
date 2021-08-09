Feature: Logout
Scenario: Sign off from an existing session
Given User is on "http://automationpractice.com/"
When User navigates to sign in
And User provides "random@test.com" and "random" to login
Then page shows success message
Then User clicks sign out button
And page ends session