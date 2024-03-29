# Web_Testing_Fake_Store

Functional testing of web app: [https://www.saucedemo.com/](https://www.saucedemo.com/)

This project is build following Hybrid Driven Framework (Data Driven Testing and Keyword Driven Testing) and with Page Object Model as design pattern.

## Using
- Selenium
- Java 17
- TestNG
- Jenkins for CI
- Excel files as data providers
- Data Driven Testing (DDT)
- Keyword Driven Testing (KDT)
- Page Object Model (POM)

### Test Scenario
- Login Page with inputs username and password.

|    Test Cases    | Test Description                                 | Steps                     |               Expected Result                |
|:----------------:|:-------------------------------------------------|:--------------------------|:--------------------------------------------:|
| TC_LoginTest_001 | Verify if correct credentials work successfully. | User type username        |                                              |
|                  |                                                  | User type password        |                                              |
|                  |                                                  | User click button "Login" |                                              |
|                  |                                                  | User in page "Inventory"  | New Page must have title equal to "Products" |

### Test Scenario
- Login Page with inputs username and password, using multiples credential verify all with DDT.

|    Test Cases    | Test Description                                              | Steps                              |             Expected Result              |
|:----------------:|:--------------------------------------------------------------|:-----------------------------------|:----------------------------------------:|
| TC_LoginTest_002 | Verify if all credentials meet the expected result response.  | User login successfully            |                  Valid                   |
|                  |                                                               | Return to Login Page               |                                          |
|                  |                                                               | User login wrongly                 |                 Invalid                  |
|                  |                                                               | Clean inputs username and password |                                          |
|                  |                                                               | Again (all rows in Excel sheet)    | All credentials must respond as expected |

### Test Scenario
- Inventory Page add products and check in Cart Page if they were added.

|       Test Cases        | Test Description                                   | Steps                                                         |                                  Expected Result                                  |
|:-----------------------:|:---------------------------------------------------|:--------------------------------------------------------------|:---------------------------------------------------------------------------------:|
| TC_AddProductToCart_003 | Verify if products added in inventory are in cart. | User login successfully (TC_LoginTest_001)                    |                                                                                   |
|                         |                                                    | User click button "Add to cart" in every product in main page |                                                                                   |
|                         |                                                    | User click button "Cart link"                                 |                                                                                   |
|                         |                                                    | User in page "Cart"                                           | Verifies if the products in the cart page are the same as those previously added. |
|                         |                                                    | User click button "Checkout"                                  |                                                                                   |
|                         |                                                    | User in page "CheckoutFillOut"                                |                                 Verify title name                                 |

### Test Scenario
- CheckoutFillOut Page fill out the information multiple times using Data Driven provider (CheckoutFillOut.xlsx).

|          Test Cases           | Test Description                                             | Steps                                                            |                  Expected Result                   |
|:-----------------------------:|:-------------------------------------------------------------|:-----------------------------------------------------------------|:--------------------------------------------------:|
| TC_CheckoutFillOutInfoDDT_004 | Verify if fill out the information works with multiple data. | User login successfully (TC_LoginTest_001)                       |                                                    |
|                               |                                                              | User add product to cart (TC_AddProductToCart_003)               |                                                    |
|                               |                                                              | **Loop Data Provider**                                           |                                                    |
|                               |                                                              | User in page "Checkout: You Information"                         |                 Verify title name                  |
|                               |                                                              | User type "First Name"                                           |                                                    |
|                               |                                                              | User type "Last Name"                                            |                                                    |
|                               |                                                              | User type "Zip/Postal Code"                                      |                                                    |
|                               |                                                              | User click button "Continue"                                     |                                                    |
|                               |                                                              | If there's not error the user go back to "CheckoutFillOut"       |                                                    |
|                               |                                                              | If there's a error the user clean inputs and click error message |                 Verify title name                  |

### Test Scenario
- CheckoutFillOut Page fill out your information to continue the purchase.

|          Test Cases          | Test Description                          | Steps                                               |                  Expected Result                   |
|:----------------------------:|:------------------------------------------|:----------------------------------------------------|:--------------------------------------------------:|
|  TC_CheckoutFillOutInfo_005  | Verify if fill out the information works. | User login successfully (TC_LoginTest_001)          |                                                    |
|                              |                                           | User add product to cart (TC_AddProductToCart_003)  |                                                    |
|                              |                                           | User in page "Checkout: You Information"            |                 Verify title name                  |
|                              |                                           | User type "First Name"                              |                                                    |
|                              |                                           | User type "Last Name"                               |                                                    |
|                              |                                           | User type "Zip/Postal Code"                         |                                                    |
|                              |                                           | User click button "Continue"                        |                                                    |
|                              |                                           | User in page "Checkout: Overview"                   |                 Verify title name                  |

### Test Scenario
- Finish correctly the purchase.

|            Test Cases             | Test Description                                | Steps                                                         |                  Expected Result                  |
|:---------------------------------:|:------------------------------------------------|:--------------------------------------------------------------|:-------------------------------------------------:|
| TC_CheckoutFinishPurchaseTest_006 | Verify if the purchase is finished completely.  | User filled out info to purchase (TC_CheckoutFillOutInfo_005) |                                                   |
|                                   |                                                 | User in page "CheckoutOverview"                               |                 Verify title name                 |
|                                   |                                                 |                                                               |       Verify 2 list have the same products        |
|                                   |                                                 |                                                               | Verify if correct total is equal to previous list |
|                                   |                                                 |                                                               | Verify if item total displayed in page is correct |
|                                   |                                                 | User click button "Finish"                                    |                                                   |
|                                   |                                                 | User in page "CheckoutComplete"                               |                 Verify title page                 |
|                                   |                                                 | User check right description "Complete!"                      |              Verify header complete               |
|                                   |                                                 | User click button "Back Home"                                 |                                                   |
|                                   |                                                 | User in page "Inventory"                                      |                 Verify title page                 |


### Test Scenario
- Finish correctly the purchase.

|         Test Cases          | Test Description                                                      | Steps                                                |                             Expected Result                              |
|:---------------------------:|:----------------------------------------------------------------------|:-----------------------------------------------------|:------------------------------------------------------------------------:|
| TC_SelectFilterProducts_007 | Verify if filter works as expected when user choose a type of filter. | User click dropdown and choose "Name (A to Z)"       |    Verify if first placeholder in dropdown changed to "Name (A to Z)"    |
|                             |                                                                       | User click dropdown and choose "Name (Z to A)"       |    Verify if first placeholder in dropdown changed to "Name (Z to A)"    |
|                             |                                                                       | User click dropdown and choose "Price (low to high)" | Verify if first placeholder in dropdown changed to "Price (low to high)" |
|                             |                                                                       | User click dropdown and choose "Price (high to low)" | Verify if first placeholder in dropdown changed to "Price (high to low)" |

