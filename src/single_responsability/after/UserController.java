package solid.single_responsability.after;

import java.io.IOException;

//Handles incoming JSON requests that work on User
//this class has one responsabbility:
// create user
// validate user (it's work for UserValidator class)
public class UserController {

	private UserPersistenceService persistenceService = new UserPersistenceService();

	// Create a new user
	public String createUser(String userJson) throws IOException {
		var user = new User();

		UserValidator validator = new UserValidator();
		boolean valid = validator.validateUser(user);

		if (!valid) {
			return "ERROR";
		}

		persistenceService.saveUser(user);

		return "SUCCESS";
	}

}