package stepDefinations;

//Author: Rashmi AG

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import org.hamcrest.Matchers;
import org.junit.Assert;
import utilities.TestBase;
import utilities.Utils;
import io.restassured.path.json.JsonPath;

public class WeatherSteps extends TestBase{
	
	String apiKey;
	//private Response res;
	ValidatableResponse res;
	ValidatableResponse res1;
	String response;
	String response1;
	
			
	@Given("^user have the proper API key$")
	public void user_have_the_proper_API_key(){
		apiKey = prop.getProperty("Key");
	}
	
	
	@When("^user initiate Rest service to get weather details with \"([^\"]*)\"$")
	public void user_initiate_Rest_service_to_get_weather_details_with(String postalcode) throws Throwable {
		RestAssured.baseURI = "https://api.weatherbit.io/v2.0/current";
		 response = RestAssured.given().param("postal_code", postalcode)
			.param("key", apiKey).when().get().then().extract().asString();
		 System.out.println("Response is :- " + response);
		 
		 res = RestAssured.given().param("postal_code", postalcode)
			.param("key", apiKey).when().get().then();
		
		}

	@Then("^response status code should be \"([^\"]*)\"$")
	public void response_status_code_should_be(String arg1) throws Throwable {
		res.statusCode(200);
	}
	
	

	@When("^response should includes the \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void response_should_includes_the_and_and(String country_code, String timezone, String city_name) throws Throwable {
		
		Object cuntrycode = res1.extract().response().path("data.country_code");
		Object Timezone = res1.extract().response().path("data.timezone");
		Object cityName = res1.extract().response().path("data.city_name");
		System.out.println("Country code ***** Timezone*** city Name ****" + cuntrycode +Timezone +cityName  );
		Assert.assertEquals(cuntrycode,country_code);
		Assert.assertEquals(Timezone,timezone);
		Assert.assertEquals(cityName,city_name);
		
	}
	
	@Given("^user initiate to Rest service get forecast weather details with \"([^\"]*)\"$")
	public void user_initiate_to_Rest_service_get_forecast_weather_details_with(String postalcode) throws Throwable {
		RestAssured.baseURI = "https://api.weatherbit.io/v2.0/forecast/3hourly";
		 response1 = RestAssured.given().param("postal_code", postalcode)
			.param("key", apiKey).when().get().then().extract().asString();
		 System.out.println("Response is :- " + response);
		 
		 res1 = RestAssured.given().param("postal_code", postalcode)
			.param("key", apiKey).when().get().then();
		
		}
	

	@Then("^response status code is \"([^\"]*)\"$")
	public void response_status_code_is(String arg1) throws Throwable {
		res1.statusCode(200);
	}

	@Then("^response should have the following attributes \"([^\"]*)\" and \"([^\"]*)\"$")
	public void response_should_have_the_following_attributes_and(String wind_cdir, String wind_cdir_full) throws Throwable {
		
		Object windcdir = res1.extract().response().path("data.wind_cdir");
		Object windcdirfull = res1.extract().response().path("data.wind_cdir_full");
		System.out.println("windcdire ***** windcdirfull  is *** " + windcdir + windcdirfull);
		Assert.assertEquals(windcdir,wind_cdir);
		Assert.assertEquals(windcdirfull,wind_cdir_full);
	   
	}
}
	


