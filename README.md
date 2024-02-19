# 42_bank_system-spring_angular
proyecto realizado con java y angular para registrar transferencias entre usuarios
<hr>
 <p>We begin with the presentation of the pages. This project was developed with Java and JavaScript using the Spring and Angular frameworks. Before starting the project, a sketch of how the pages would look like was created with HTML. Angular works with the Single Page Application (SPA) model, so all pages are rendered as needed on the index.html page. The remaining pages are designed through the Angular engine.</p>

  <p>The first page of the application is where user data is entered, simulating access to their account. The dummy account details are:</p>
  <ul>
    <li>Account Number: 123456789012</li>
    <li>Key: 1234</li>
  </ul>

  <p>Immediately, a window is rendered that provides access to the user's transfers, where the following operations can be performed:</p>
  <ul>
    <li>List all transactions (search for a transfer by date or any filter can be added)</li>
    <li>Remove transactions (logical removal)</li>
    <li>Create a new transaction</li>
  </ul>

![a](https://github.com/josevflores911/42_bank_system-spring_angular/assets/59713685/1abc77df-6516-4d4b-bb27-766981bd9e80)

<p>In the backend, we perform the search for data using the account number and access key. If both do not match, we will not be able to access the user's data who will perform the transaction.</p>

![a](https://github.com/josevflores911/42_bank_system-spring_angular/assets/59713685/329926f9-b877-4692-b076-fcc48c31c186)

<p>For the dummy user, we have 3 scheduled transfers. The conditions for the transfer are that it cannot be the same account number, and the amount must be less than or equal to the sum of the transfer plus the fee.</p>

![a](https://github.com/josevflores911/42_bank_system-spring_angular/assets/59713685/94d0975b-5148-42c4-acdf-342c57f90d31)

<p>We have another dummy account to which the transfers will be made.</p>
<ul>
  <li>Account Number: 123456789013</li>
</ul>
<p>In the backend, we can perform the search by account number since both the ID and account numbers are unique. Here, we have a form where we must enter a future date and an amount available according to the money in the account (add sending user data such as available amount). Upon making the request, the list is rendered with the new element.</p>

![a](https://github.com/josevflores911/42_bank_system-spring_angular/assets/59713685/224ef937-440a-4229-8654-470ea3fc6ed3)

<p>When we delete an element, we are not actually removing it from the in-memory database (H2); instead, we hide it by performing a logical removal with a parameter that sets the visibility to false.</p>

![image](https://github.com/josevflores911/42_bank_system-spring_angular/assets/59713685/437bde84-63ec-4d8b-826c-1c2ec2655d0b)

<p>Within some additional features, we have a page where we can test the Swagger controllers, testing the controller for users and transfers.</p>

<p>For users, we have the following services:</p>
<ul>
  <li>Get user by ID</li>
  <li>Get user by account number and key</li>
  <li>Get all users (not used)</li>
  <li>Update a user (not used)</li>
  <li>Delete and add user (not used)</li>
</ul>

<p>For transfers:</p>
<ul>
  <li>Get all transfers by user ID</li>
  <li>Create a new transfer</li>
</ul>

<p>URLs used:</p>
<ul>
  <li>GET http://localhost:8080/users/get/fa8dbb11-8635-4a33-8957-cb7e0e30eeb7</li>
  <li>POST http://localhost:8080/users/account (with JSON body)</li>
  <li>GET http://localhost:8080/transactions/user/7ec92ada-9080-4958-af54-33b07edc3db1</li>
  <li>GET http://localhost:8080/users/get/fa8dbb11-8635-4a33-8957-cb7e0e30eeb7</li>
  <li>POST http://localhost:8080/transactions/ (with JSON body)</li>
</ul>

<p>The database with the initial elements was created within the backend with the name data.sql, where the Flyway framework takes care of executing the queries in the in-memory database.</p>

![a](https://github.com/josevflores911/42_bank_system-spring_angular/assets/59713685/1d66dc3a-c237-43d4-be89-b30cbfb067fe)

![a](https://github.com/josevflores911/42_bank_system-spring_angular/assets/59713685/feb11586-07a5-44ff-a261-73b48bacd71c)
swagger
![a](https://github.com/josevflores911/42_bank_system-spring_angular/assets/59713685/4e2ef461-4f0c-4c0d-97f6-7f3d5df64a5e)

![a](https://github.com/josevflores911/42_bank_system-spring_angular/assets/59713685/9c2cf3d6-48bc-4b8b-9284-bc0234b3f405)
postman
![image](https://github.com/josevflores911/42_bank_system-spring_angular/assets/59713685/dae8225b-c8ae-4420-82a2-20195a46ebfe)

folder
![a](https://github.com/josevflores911/42_bank_system-spring_angular/assets/59713685/0af8c825-7662-486f-8590-32ec75dd13d3)


