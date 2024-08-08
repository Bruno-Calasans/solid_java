package dependecy_inversion.after;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		var msg = new Message("This is a message again");
		var printer = new MessagePrinter();
		var formatter = new JSONFormatter();
		var writer = new PrintWriter(new FileWriter("test_msg.txt"));

		printer.writeMessage(msg, formatter, writer);
	}

}
