package api.endpoints;

public class Routes {
	// base URL
	static public String baseUrl = "https://restful-booker.herokuapp.com";
	// Authenticate user
	static public String authUrl = baseUrl + "/auth";
	// GET, PUT, PATCH by User Id
	static public String urlById = baseUrl + "/booking/{id}";
	// GET, POST
	static public String cuUrl = baseUrl + "/booking";
	// Health Check
	static public String healthCheckUrl = baseUrl + "/ping";
	// DELETE by Id
	static public String deleteUrl = cuUrl + "/{id}";
	// GET
}
