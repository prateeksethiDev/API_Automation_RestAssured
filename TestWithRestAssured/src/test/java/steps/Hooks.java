package steps;

import io.cucumber.java.Before;
import utilities.RestAssuredExtension;

public class Hooks {
	
	@Before
	public void testSetup() {
		RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
		
	}

}
