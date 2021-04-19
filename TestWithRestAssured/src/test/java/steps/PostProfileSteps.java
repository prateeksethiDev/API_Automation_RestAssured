package steps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostProfileSteps {
	
	public static ResponseOptions<Response> response;
	
	@Given("I Perform POST operation for {string} with body")
	public void i_perform_post_operation_for_with_body(String url, io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> cells = dataTable.cells();
		
		//set body	
		Map<String,String> body= new HashMap<>();
		body.put("name", cells.get(1).get(0));
		//set path params
		Map<String,String> pathParams= new HashMap<>();
		pathParams.put("profileNo", cells.get(1).get(1));
		//Perform post operation
		response=RestAssuredExtension.postOpsWithBodyAndPathParam(url, pathParams, body);		
	}

	@Then("I should see the body has name as {string}")
	public void i_should_see_the_body_has_name_as(String name) {
		assertThat("name not found",response.getBody().jsonPath().get("name").equals(name));
	}
}