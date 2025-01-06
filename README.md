# D287 Java Frameworks: Trevor England

### Scenario
You are working for a company that licenses and customizes a software application to keep track of inventory in stores. Your job as a software developer is to customize this application to meet a specific customer’s needs. You will choose any type of customer you would like, but it must sell a product composed of parts.

The customer I have chosen for this project is a firearm store. The products a firearm store would sell could be various different types of guns, with the parts being individual components that customers can buy (whether it be for customization or maintenance). DISCLAIMER: This is not an intention to promote violence; rather I chose type of customer because it fulfills the requirements of the project and is something I enjoy doing in my personal time.

---

## Table of Contents

- [Installation](#installation)
- [Features](#features)
- [Code Changes](#code-changes)

---

## Installation

Follow these steps to set up the project locally:

1. Clone the repository:
   ```bash
   git clone https://gitlab.com/wgu-gitlab-environment/student-repos/tengl93/d287-java-frameworks

2. Navigate to the project directory:
   ```bash
   cd d287-java-frameworks

3. Open with Intellij, run application.

4. Open a web browser and navigate to http://localhost:8080.

---

## Features

Not yet implemented, come back once further.

## Code Changes

C. Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

File: mainscreen.html  
   **Line 14** -> linked new stylesheet to mainscreen.html (mainscreen.css)  
   **Line 16** -> Changed customer shop name to "Precision Firearms"  
   **Lines 19-33** -> Added BootStrap navigation bar for user experience (UX)  
   **Line 36** -> Changed default h1 to reflect the shop name (Precision Firearms)  
   **Line 37** -> Added svg for the company website  
   **Line 39** -> Replaced default parts with "Accessories"  
   **Line 71** -> Replaced default product with "Rifles"

File: mainscreen.css  
   **Lines 1-141** -> Added file [Full Code](src/main/resources/static/css/mainscreen.css)

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.  

File: AboutController.java  
   **Lines 1-13** -> Added file [Full Code](/src/main/java/com/example/demo/controllers/AboutController.java)  

File: about.html  
   **LINES 1-127** -> Added about page for customer software application. [Full Code](/src/main/resources/templates/about.html)  

File: about.css  
   **LINES 1-99** -> Added CSS file for the about page to match the theme of the application. [Full Code](/src/main/resources/static/css/about.css)  

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.  

File: BootStrapData.java
   **Lines 43-126** -> Added functionality to add 5 parts and 5 products using constructor of part and product classes and putting the data into a HashSet. [Full Code](/src/main/java/com/example/demo/bootstrap/BootStrapData.java)  

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:  
•  The “Buy Now” button must be next to the buttons that update and delete products.  
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.  
•  Display a message that indicates the success or failure of a purchase.  

File: successfulpurchase.html
   **Lines 1-31** -> Added HTML page for successful purchases. [Full Code](/src/main/resources/templates/successfulpurchase.html)  

File: unsuccessfulpurchase.html
   **Lines 1-15** -> Added HTML page for unsuccessful purchases. [Full Code](/src/main/resources/templates/unsuccessfulpurchase.html)  

File mainscreen.html
   **Line 101** -> Added buy now button for products
