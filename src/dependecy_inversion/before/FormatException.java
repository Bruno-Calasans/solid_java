package dependecy_inversion.before;

import java.io.IOException;

//Thrown by formatter
public class FormatException extends IOException {

	public FormatException(Exception cause) {
		super(cause);
	}
}
