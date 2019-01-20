Feature: To verify API automation with Rest Assured -  Weather forecast

#Author: Rashmi AG


Background: 
Given user have the proper API key

Scenario Outline: To verify weather Rest service by postal code

When user initiate Rest service to get weather details with "<postalcode>"
#Then response status code should be "200"
And response should includes the "<contry_code>" and "<timezone>" and "<city_name>"

Examples:
|postalcode |contry_code|  timezone       |city_name|
|2140|      |AU         |Australia/Sydney |PARRAMATTA|



@Apitest
Scenario Outline: To verify hourly weather forecast Rest service by postal code
Given user initiate to Rest service get forecast weather details with "<postal code>"
Then response status code is "200"
And response should have the following attributes "<wind_cdir>" and "<wind_cdir_full>"
 
 Examples:
|postalcode |wind_cdir|  wind_cdir_full|     
|2143       |NW       |northwest       |














  
          