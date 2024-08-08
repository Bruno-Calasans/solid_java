package dependecy_inversion.before;

//Formats Message to plain text
public class TextFormatter implements Formatter {

	public String format(Message message) {
		return message.getTimestamp() + ":" + message.getMsg();
	}
}
