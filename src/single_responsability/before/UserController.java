package single_responsability.before;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Handles incoming JSON requests that work on User
// this class has two responsabilities:
// create user
// validate user
public class UserController {

	private UserPersistenceService persistenceService = new UserPersistenceService();

	// Create a new user
	public String createUser(String userJson) throws IOException {
		var user = new User();

		var valid = isValidUser(user);

		if (!valid) {
			return "ERROR";
		}

		persistenceService.saveUser(user);

		return "SUCCESS";
	}

	// Validates the user object
	private boolean isValidUser(User user) {
		if (!isPresent(user.getName())) {
			return false;
		}
		user.setName(user.getName().trim());

		if (!isValidAlphaNumeric(user.getName())) {
			return false;
		}
		if (user.getEmail() == null || user.getEmail().trim().length() == 0) {
			return false;
		}
		user.setEmail(user.getEmail().trim());
		if (!isValidEmail(user.getEmail())) {
			return false;
		}
		return true;
	}

	// Simply checks if value is null or empty..
	private boolean isPresent(String value) {
		return value != null && value.trim().length() > 0;
	}

	// check string for special characters
	private boolean isValidAlphaNumeric(String value) {
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
		Matcher matcher = pattern.matcher(value);
		return !matcher.find();
	}

	// check string for valid email address
	private boolean isValidEmail(String value) {
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(value);
		return matcher.find();
	}

}