package TSQLandAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class API {

	public static void main(String[] args) throws IOException {
//		String baseURL = "https://www.1secmail.com/api/v1/";
//		String email = getResponse(baseURL + "?action=genRandomMailbox&count=1");
//		email = email.substring(2, email.length() - 2);
//		System.out.println(email);
//		String message = getResponse(baseURL + "?action=getMessages&login=" + email.substring(0, email.indexOf('@'))
//				+ "&domain=" + email.substring(email.indexOf('@') + 1, email.length()));
		sentMessage();
//		System.out.println(message);
	}

	private static String getResponse(String apiURL) throws IOException {
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = bf.readLine()) != null) {
			sb.append(line);
		}
		System.out.println(sb.toString());
		bf.close();
		con.disconnect();
		return sb.toString();

	}
	public static void sentMessage() {
		        // Sender's email address and password
		        String senderEmail = "bigbasketfireflink2023@gmail.com";
		        String senderPassword = "Bigbasket@2023";

		        // Recipient's email address
		        String recipientEmail = "sanjeev@testyantra.com";

		        Properties properties = new Properties();
		        properties.put("mail.smtp.auth", "true");
		        properties.put("mail.smtp.starttls.enable", "true");
		        properties.put("mail.smtp.host", "smtp.gmail.com");
		        properties.put("mail.smtp.port", "587");

		        // Create a session with the email server
		        Session session = Session.getInstance(properties, new Authenticator() {
		            @Override
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(senderEmail, senderPassword);
		            }
		        });

		        try {
		            // Create a MimeMessage object
		            Message message = new MimeMessage(session);

		            // Set the sender and recipient addresses
		            message.setFrom(new InternetAddress(senderEmail));
		            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));

		            // Set the subject and content of the email
		            message.setSubject("Hello, This is a test email!");
		            message.setText("This is the message body.");

		            // Send the email
		            Transport.send(message);

		            System.out.println("Email sent successfully!");
		        } catch (MessagingException e) {
		            e.printStackTrace();
		        }
		    

	}

}
