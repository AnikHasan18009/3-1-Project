
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties; 
public class sendMail {
	public static MimeMessage getmessage() {
		try {
	Properties properties= System.getProperties();
	properties.put("mail.smtp.host","smtp.gmail.com");
	properties.put("mail.smtp.port","465");
	properties.put("mail.smtp.ssl.enable","true");
	properties.put("mail.smtp.auth","true");
	
	Session session= Session.getInstance(properties,new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("mcq.exam.application@gmail.com","xkkgyvatsantmvws");
		}
	});
		MimeMessage message =new MimeMessage(session);
		return message;
	} 
	catch(Exception e)
	{
		return null;
	}
}
}
