Overview-Find the Interest Amount for current year
----------------------------------------------------------

• This project aims to automate and test the EMI calculator website using TestNG and Cucumber Frameworks.

• It tests the EMI calculator site, Whether the site is giving the EMI values, monthly and yearly principal and interest table and verify User Interface.



Libraries and Dependencies
------------------------------------------------------------------------
• Maven Repository: Maven 3.12.1

• Apache POI: 5.2.5

• TestNG: 7.9.0

• Extent Report: 5.1.1

• Selenium WebDriver: 4.17.0

• Cucumber: 7.15.0

Plugins
---------------------------------------------------

• TestNG

• Cucumber

Automation Flow
----------------------------------------------------------------

1. Navigate to EMI calculator site.

2. Click on car loan and give values as Principal “1500000”, Interest “9.5”, Time “1 year”.

3. Display the interest amount & principal amount for one month.

4. Click Home Loan, fill relevant details & extract all the data from year-on-year table & store in excel.

5. Click Menu and pick Loan Calculator and then under EMI calculator, we need to do all UI checks for text box and scales.

6. Then Change the Loan Tenure for year and month &need to check the change in scale.

7. We need to Re-use the same validations for Loan Amount Calculator & Loan Tenure Calculator.




Challenges:
-------------------------------------------------------------

1. To retrieve the tables and store in excel.
2. While performing all UI Checks.

Benefits:
-------------------------------------------------------------

1. Increased Efficiency through automated UI Checks.
2. Reduced manual effort and minimized the chance of human errors.







