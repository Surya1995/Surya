Feature File: Sample API Request

Background:
* URL 'https://restful-booker.herokuapp.com'
* Headers {
      Authorization: 'Bearer Token',
      Accept: 'application/json',
      Content-Type: 'application/json',
      Cookie: 'token=<token_value>'
      }

Scenario: Verify GET request with headers
         Given path '/booking/1'
         When Method GET
         Then status 200
         And match response == { id: '#number'}
  
 Scenario: Verify POST request with headers
         Given path '/booking'
         And request{"firstname" : "Jim","lastname" : "Brown","totalprice" : 111,"depositpaid" : true,"bookingdates" : {"checkin" : "2018-01-01","checkout" : "2019-01-01"},"additionalneeds" : "Breakfast"}
         When Method POST
         Then status 201
         And match response == { Message: "Created"}
         
Scenario: Verify PUT request with headers
         Given path '/booking/1
         And request And request{"firstname" : "James","lastname" : "Brown","totalprice" : 111,"depositpaid" : true,"bookingdates" : {"checkin" : "2018-01-01","checkout" : "2019-01-01"},"additionalneeds" : "Breakfast"}
         When Method PUT
         Then status 200
         And match response == { Message: "Created"}
                  
 Scenario: Verify DELETE request with headers
         Given path '/booking/1'
         When Method DELETE
         Then status 200

 Scenario: Verify PATCH request with headers
         Given path '/booking/1'
         And request {"firstname" : "James","lastname" : "Brown"}
         When Method PATCH
         Then status 200         