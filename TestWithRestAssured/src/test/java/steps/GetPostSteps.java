package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetPostSteps {
	
	private static ResponseOptions<Response> response;
	
	@Given("I perform GET operation for {string}")
	public void i_perform_get_operation_for(String url) {
		response= RestAssuredExtension.getOps(url);
	}

	@Then("I should see the author name as {string}")
	public void i_should_see_the_author_name_as(String authorName) {
		assertThat("author not found",response.getBody().jsonPath().get("author").equals(authorName));
	}

	@Then("I should see the author names")
	public void i_should_see_the_author_names() {
	    
	}

	@Then("I should see verify GET Parameter")
	public void i_should_see_verify_get_parameter() {
	   
	}

	@Given("I perform authentication operation for {string} with body")
	public void i_perform_authentication_operation_for_with_body(String string, io.cucumber.datatable.DataTable dataTable) {
	   
	}

	@Then("I should see the author name as {string} with json validation")
	public void i_should_see_the_author_name_as_with_json_validation(String string) {
	   
	}
}
