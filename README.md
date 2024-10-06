# WebTable

Project 1: Static Table Manipulation
Objective:
In this exercise, you will interact with a static table on a webpage using Selenium WebDriver. You will learn how to extract specific data from the table, iterate through all the cells, apply filters, and perform calculations, such as summing up the prices of books.
Steps:
🌐 Launch Browser and Access the Website:
Open Chrome browser and go to the URL: https://testautomationpractice.blogspot.com/.
🔢 Retrieve the Total Number of Rows and Columns:
Count the total number of rows and columns in the table displayed on the page.
🔍 Read Data from a Specific Cell:
Extract data from the 5th row and 1st column (book name) in the table.
📋 Iterate Through All Rows and Columns:
Read and display the content of all the table cells in the console.
📖 Extract and Display Book Names with Author "Mukesh":
Identify and display the book names whose author is "Mukesh."
💰 Calculate the Total Price of All Books:
Calculate the total sum of the prices of all books in the table.
Test Cases:
Test 1: Connection to the Website
Step: Open the URL https://testautomationpractice.blogspot.com/.
Expected Result: The site loads correctly, and the table is visible.
Test 2: Retrieve the Total Number of Rows and Columns
Step: Count the number of rows and columns.
Expected Result: The total number of rows and columns is displayed in the console.
Test 3: Read Data from a Specific Cell
Step: Read the content from the cell in row 5, column 1.
Expected Result: The book name is displayed correctly in the console.
Test 4: Iterate Through the Entire Table
Step: Iterate and display all table cells.
Expected Result: Every row and column content is displayed in the console.
Test 5: Filter Books by Author "Mukesh"
Step: Identify and display the books by author "Mukesh."
Expected Result: The book names with "Mukesh" as the author are displayed.
Test 6: Calculate the Total Price of the Books
Step: Sum up the prices of all books.
Expected Result: The total price is correctly displayed in the console.

Project 2: Handling Dynamic Pagination Web Table
Objective:
Manipulate dynamic and paginated tables on a web interface using Selenium Java. The goal is to navigate through multiple pages of a table, extract data from each page, and display it.
Steps:
🌐 Launch Browser and Log In:
Open Chrome and navigate to the admin page URL.
Log in using the credentials provided (demo/demo).
Verify successful login and close any unexpected pop-up windows.
👥 Access the Customers Section:
Click on the "Customers" menu in the main navigation.
Access the subsection listing the customers.
📄 Calculate the Total Number of Pages:
Locate the element that displays the total number of pages in the customers table.
Store this value to iterate over the pages.
➡️ Navigate Through Each Page:
For each page:
Click the button to go to the next page (if needed).
Extract and store customer data: Name, Email, and Date Added.
✔️ Verify All Pages Have Been Visited:
Ensure that all pages have been navigated through.
Test Cases:
Test 1: Valid Login
Step: Log in using the credentials "demo/demo".
Expected Result: Login is successful, and the dashboard is displayed.
Test 2: Closing Pop-up Window
Step: Close the pop-up window after login (if present).
Expected Result: The pop-up window is closed successfully.
Test 3: Navigate to Customers Section
Step: Access the "Customers" menu and go to the customer management page.
Expected Result: The customers' management page is displayed.
Test 4: Pagination
Step: Iterate through all pages in the customer table.
Expected Result: Data from each page is extracted, and navigation works as expected.
Test 5: Data Retrieval
Step: Extract Name, Email, and Date Added for each customer on every page.
Expected Result: Customer data is correctly extracted and displayed.
Test 6: End of Pagination
Step: Display a message indicating the end of pagination after visiting all pages.
Expected Result: A message indicating the end of pagination is displayed in the console.

Project 3: Dynamic Table Handling (BlazeDemo)
Objective:
Interact with dynamic tables on the BlazeDemo web interface, select a flight based on the lowest price, and complete a booking.
Steps:
🌐 Launch Browser and Access the Website:
Open Chrome and navigate to https://blazedemo.com/.
✈️ Select Departure and Arrival Cities:
Select "Boston" as the departure city and "Rome" as the destination.
💸 Extract Flight Prices:
Iterate through the table containing flight information and extract prices for each row.
Compare the prices to identify the cheapest flight.
✔️ Select the Flight with the Lowest Price:
Select the flight with the lowest price from the table.
📝 Fill in Booking Information:
Fill in the required fields (name, credit card, etc.) to complete the booking.
🎉 Verify the Confirmation Message:
Verify that the confirmation message "Thank you for your purchase today!" is displayed after booking.
Test Cases:
Test 1: Connection to the Website
Step: Navigate to https://blazedemo.com/.
Expected Result: The site loads correctly, and the city selection fields are available.
Test 2: Select Cities
Step: Select "Boston" as the departure city and "Rome" as the destination.
Expected Result: The form displays available flights after submission.
Test 3: Select the Cheapest Flight
Step: Extract the prices of the flights and select the one with the lowest price.
Expected Result: The flight with the lowest price is selected.
Test 4: Fill in the Booking Form
Step: Fill in the booking details.
Expected Result: The form is correctly filled and submitted without errors.
Test 5: Reservation Confirmation
Step: Verify the confirmation message after submission.
Expected Result: The message "Thank you for your purchase today!" is displayed.
