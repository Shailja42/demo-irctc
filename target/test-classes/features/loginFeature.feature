@login
Feature: User individual registraion

  @tc1
  Scenario: Register yourself first
    Given I launch the browser
    Then I register userid with "ShailjaGautam" and password "Android1234"
    Then I select security question as "Who was your Childhood hero?"
    Then I provide the security answer as "NoOne"
    Then I select preferred language as "English"
    And I enter user's first name as "Shailja" and last name as "Gautam"
    Then I provide user's date of birth as "August" month "1993" year and "02" day
    #Then I select country "India" 
    Then I write email "shailjagautam42@gmail.com"
    Then I give phone number "9041674650"
    Then I select nationality as "India"
    Then I provide residentional address deatils
    
    
    
    
    
    
    
    
    
    
    #Then  I book thw ticket from "PUNE" to "CHANDIGRAH"
