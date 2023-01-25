Feature: Login
  Scenario Outline: Login berhasil
    Given Buka browser
    When User buka url "https://admin-demo.nopcommerce.com/login"
    And User masukin email "<email>" dan password "<password>"
    And Click login button
    Then Page tittle harusnya "Dashboard / nopCommerce administration"
    When Click logout button
    #Then page tittle harusnya "Your store. Login"
    And close browser
Examples:
    |email|password|
    |admin@yourstore.com|admin|
    |admin1@yourstore.com|123456|
