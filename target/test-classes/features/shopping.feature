Feature: Shopping Process
Scenario:  the shopping process till the end
Given User is on "http://automationpractice.com/"
Then User adds some products to cart
And proceeds to checkout
Then User continues to signin
And provides "random@test.com" and "random" to login
Then User checks address
Then User sets up shipping
Then proceeds to Payment
And User selects payment method to confirm order
Then page returns order confirmation