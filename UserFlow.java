import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class UserFlow extends Thread implements Serializable {
	private static final long serialVersionUID = 1L;
	BootstrapServer bootstrap;

	public UserFlow(BootstrapServer bootstrap) {
		// TODO Auto-generated constructor stub
		this.bootstrap = bootstrap;
	}

	@Override
	public void run() {

		String input = "";
		Scanner s = new Scanner(System.in);
		do {
			System.out.print("Bootstrap>");
			input = s.nextLine();
			String[] commandAndValue = input.split(" ");

			switch (commandAndValue[0]) {

			case "lookup":
				try {
					System.out.println(bootstrap.lookup(Integer.parseInt(commandAndValue[1])));
				} catch (Exception e) {
					System.out.println("Key not found");
				}
				break;

			case "insert":
				try {
					bootstrap.insert(Integer.parseInt(commandAndValue[1]), commandAndValue[2]);
				} catch (NumberFormatException | ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
				break;

			case "delete":
				try {
					bootstrap.delete(Integer.parseInt(commandAndValue[1]));
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			default:
				System.out.println("Invalid Command");

			}

		} while (true);

	}

}
