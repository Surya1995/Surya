Feature File: Sample API Request

Background:
* URL 'https://restful-booker.herokuapp.com/booking'
* Headers {
      Authorization: 'Bearer Token',
      Accept: 'application/json',
      Content-Type: 'application/json',
      Cookie: 'token=<token_value>'
      }

Scenario: Verify GET request with headers
         Given path '/endpoint'
         When Method GET
         Then status 200
         And match response == { id: '#number'}
  
 Scenario: Verify POST request with headers
         Given path '/endpoint'
         And request {firstname" : "Jim", "lastname": "Brown", "totalprice": 111, "depositpaid": true}
         When Method POST
         Then status 201
         And match response == { Message: "Created"}
         
Scenario: Verify PUT request with headers
         Given path '/endpoint'
         And request {firstname" : "James", "lastname": "Brown", "totalprice": 111, "depositpaid": true}
         When Method PUT
         Then status 200
         And match response == { Message: "Created"}
                  
 Scenario: Verify DELETE request with headers
         Given path '/endpoint'
         When Method DELETE
         Then status 200

 Scenario: Verify PATCH request with headers
         Given path '/endpoint'
         When Method PATCH
         Then status 200         