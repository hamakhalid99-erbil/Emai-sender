package emailClient;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			EmailSender sender = new EmailSender("smtp.utb.cz", 25);
			sender.send("a_al_doori@utb.cz", "m_jamal@utb.cz", "Email from Java", "Does this work?\nSnad...");
			sender.close();
			System.out.println("Status Code 200");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}