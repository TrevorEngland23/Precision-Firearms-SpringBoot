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

File: *mainscreen.html*   
   **Line 14** -> linked new stylesheet to mainscreen.html (mainscreen.css)  
   **Line 16** -> Changed customer shop name to "Precision Firearms"  
   **Lines 19-33** -> Added BootStrap navigation bar for user experience (UX)  
   **Line 36** -> Changed default h1 to reflect the shop name (Precision Firearms)  
   **Line 37** -> Added svg for the company website  
   **Line 39** -> Replaced default parts with "Accessories"  
   **Line 71** -> Replaced default product with "Rifles"

File: *mainscreen.css*  
   **Lines 1-141** -> Added file [Full Code](src/main/resources/static/css/mainscreen.css)

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.  

File: *AboutController.java*  
   **Lines 1-13** -> Added file [Full Code](/src/main/java/com/example/demo/controllers/AboutController.java)  

File: *about.html*  
   **LINES 1-127** -> Added about page for customer software application. [Full Code](/src/main/resources/templates/about.html)  

File: *about.css*  
   **LINES 1-99** -> Added CSS file for the about page to match the theme of the application. [Full Code](/src/main/resources/static/css/about.css)  

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.  

File: *BootStrapData.java*  
   **Lines 43-126** -> Added functionality to add 5 parts and 5 products using constructor of part and product classes and putting the data into a HashSet. [Full Code](/src/main/java/com/example/demo/bootstrap/BootStrapData.java)  

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:  
•  The “Buy Now” button must be next to the buttons that update and delete products.  
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.  
•  Display a message that indicates the success or failure of a purchase.  

File *mainscreen.html*  
   **Line 101** -> Added buy now button for successful purchases  

File: *successfulpurchase.html*  
   **Lines 1-32** -> Added HTML page for successful purchases. [Full Code](/src/main/resources/templates/successfulpurchase.html)  

File: *unsuccessfulpurchase.html*  
   **Lines 1-16** -> Added HTML page for unsuccessful purchases. [Full Code](/src/main/resources/templates/unsuccessfulpurchase.html)  

File: *BuyNowController*  
   **Lines 1-31** -> Added a controller for the buyNow webpage. Ensures that a product out of stock cannot be purchased, and any product that is purchased is decremented in quantity by 1. [Full Code](/src/main/java/com/example/demo/controllers/BuyNowController.java)  

File: *successfulpurchase.css*  
   **Lines 1-34** -> Added a style sheet to match the theme of the application for successpurchase.html  

File: *unsuccessfulpurchase.html*  
   **Lines 1-34** -> Added a style sheet to match the theme of the application for unsuccessfulpurchase.html  

G.  Modify the parts to track maximum and minimum inventory by doing the following:  
•  Add additional fields to the part entity for maximum and minimum inventory.  
•  Modify the sample inventory to include the maximum and minimum fields.  
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.  
•  Rename the file the persistent storage is saved to.  
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

File: *Part.java*  
   **Lines 33-36** -> Added Integer values for min/max inventory. Also creates columns in the database.  
   **Lines 60-66** -> Created a new constructor to handle all entities.  
   **Lines 101-115** -> Created getters & setters for max/min inventory.  

File: *BootStrapData.java*   
   **Lines 72,73,80,81,88,89,97,98,106,107** -> Used Getter & Setter methods for each part.  

File: *InhousePartForm.html*  
   **Lines 24-28** -> Added text inputs for the in-house part inventory so users can set the minimum and maximum values for each part.  

File: *OutsourcedPartForm.html*  
   **Lines 25-29** -> Added text inputs for the outsourced part inventory so users can set the minimum and maximum values for each part.  

File: *spring-boot.h2.db102.mv.db*  
   Renamed file to *precision-firearms-db* and updated the url accordingly.  

File: *application.properties*  
   **Line 6** -> Updated the url to the database to *jdbc:h2:~/precision-firearms-db*.  

File: *Part.java*  
   **Lines 119-130** -> Added a method isValid() that enforces logical rules on the minimum and maximum values. Throws an exception in the event a rule is broken.  

File: *AddOutsourcedPartController.java*  
   **Lines 41-58** -> Changed the @PostMapping logic to enforce the use of the isValid() method defined in Part.java.  

File *AddInhousePartController.java*  
   **Lines 42-59** -> Changed the @PostMapping logic to enforce the use of the isValid() method in Part.java.  

Files *updateprod.css*, *productform.css*  
   **Lines 1-111**, **1-172** (respectively) -> Added stylesheets to fit the theme of the application.  

File: *mainscreen.html*  
   **Lines 56-57** -> Added the Min Inventory and Max Inventory table headings.  

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:  
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.  
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.  
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.  

File: *Part.java*  
   **Lines 121-134** -> Added multiple checks to enforce the minimum and maximum values are set, and inventory must fall within the range of minimum and maximum values.  

File: *AddPartController.java*  
   **Lines 59-75** -> Replaced logic for updatePart to save the part and update partService and display a confirmation page if no exceptions are thrown, otherwise return the form back.  

File: *AddProductController.java*  
   **Lines 32-35** -> Added private fields partService and partRepository
   **Lines 76-104** -> Added logic to the submitForm method that handles the logic for adding / updating products IF the associated parts inventory for that product allows for it. Added additional error messages for if a user requests an increase in the number of product that will cause the associated part to fall into the negative numbers. If the part inventory supports the request, the user should be allowed to update / add their product, which will decrement  
                        the part inventory by the amount of products requested.  

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.  

File: *PartTest.java*  
   **Lines 161-195** -> Added unit tests (assertEquals) on get/set max and min inventory.  

J.  Remove the class files for any unused validators in order to clean your code.  

*Will go through code to remove class files and clean up extra whitespace in code*  


K.  Demonstrate professional communication in the content and presentation of your submission.  

**Of Note:**  
Some files, such as the HTML and CSS files, I have modified throughout the development process. To keep things simple, the general changes for these files include adding a bootstrap navigation bar to each html file. Additionally, the "<a href="http://localhost:8080/mainscreen">Back to mainscreen</a>" element is either in the navigation bar at "Home" or included in the original place.  












