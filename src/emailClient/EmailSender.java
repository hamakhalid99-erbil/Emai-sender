package emailClient;
import java.net.*;
import java.io.*;

public class EmailSender {
	/*
	 * Constructor opens Socket to host/port. If the Socket throws an exception during opening, 
	 * the exception is not handled in the constructor. 
	 */
	Socket s ;
	InputStream is;
	OutputStream os;
	public EmailSender(String host, int port) throws UnknownHostException, IOException {
		s = new Socket(host,port);
		is = s.getInputStream();
		os = s.getOutputStream();
		
	}
	/*
	 * sends email from an email address to an email address with some subject and text. 
	 * If the Socket throws an exception during sending, the exception is not handled by this method.
	 */
	public void send(String from, String to, String subject, String text) throws IOException {
		byte status[] = new byte[2000];
		int statusInt ;
		
		os.write("HELO ahmed\r\n".getBytes());
		os.flush();
		statusInt = is.read(status);
		System.out.write(status,0,statusInt);
		
		
		os.write(("MAIL FROM:"+ from+"\r\n").getBytes());
		os.flush();
		statusInt = is.read(status);
		System.out.write(status,0,statusInt);
		
		os.write(("RCPT TO:"+to+"\r\n").getBytes());
		os.flush();
		statusInt = is.read(status);
		System.out.write(status,0,statusInt);
		
		os.write(("DATA\r\n").getBytes());
		os.flush();
		statusInt = is.read(status);
		System.out.write(status,0,statusInt);
		
		os.write(("Subject: "+subject+"\r\n").getBytes());
		os.flush();
		statusInt = is.read(status);
		System.out.write(status,0,statusInt);
		
		os.write((text+"\r\n.\r\n").getBytes());
		os.flush();
		statusInt = is.read(status);
		System.out.write(status,0,statusInt);
		
		
	}
	
	/* 
	 * sends QUIT and closes the socket 
	 */
	public void close() {
		try {
			byte status[] = new byte[2000];
			int statusInt ;
			os.write(("QUIT\r\n").getBytes());
			os.flush();
			statusInt = is.read(status);
			System.out.write(status,0,statusInt);
			
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}