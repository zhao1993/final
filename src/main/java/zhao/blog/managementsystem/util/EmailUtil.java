package zhao.blog.managementsystem.util;

import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	 	private static String fromAccount = "zqdbyc@163.com";
	 	private static String toUser = "个人博客";
	 	private static String fromPassword = "zaq163996";
	 	private static String smtpHost = "smtp.163.com";
	 	private static String toAccount = "zqdbyc@163.com";
	 	private static String title = "来自博客的邮件";
	 	public static boolean sendEmail(String toUser,String toAccount,String title,String contenTitle,String cotent){
	 		EmailUtil.toUser = toUser;
	 		EmailUtil.toAccount = toAccount;
	 		EmailUtil.title = title;
	 		try {
				sendEMail(contenTitle,cotent);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
	 	}
	 	private static boolean sendEMail(String msg,String contact) throws Exception{
	 		Properties pros = new Properties();
	 		pros.setProperty("mail.transport.protocol", "smtp");
	 		pros.setProperty("mail.smtp.host",smtpHost);
	 		pros.setProperty("mail.smtp.auth", "true");
	 		Session session = Session.getDefaultInstance(pros);
	 		session.setDebug(true);
	 		MimeMessage message = createMessage(session, msg, contact);
	 		Transport transport = session.getTransport();
	 		transport.connect(fromAccount,fromPassword);
	 		transport.sendMessage(message,message.getAllRecipients()); 
	 		transport.close();
	 		return false;
	 	}
	 	private static MimeMessage createMessage(Session sessoin,String msg,String contact) throws Exception{
	 		MimeMessage message = new MimeMessage(sessoin);
	 		message.setFrom(new InternetAddress(fromAccount,contact,"UTF-8"));
	 		message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(toAccount,toUser,"UTF-8"));
	 		message.setSubject(title,"UTF-8");
	 		message.setContent(msg+"<hr/>"+contact,"text/html;charset=UTF-8");
	 		message.setSentDate(DateUtil.getTime4J());
	 		message.saveChanges();
	 		return message;
	 	}
	 	public static void main(String[] args) {
			for (int i = 0; i <100; i++) {
				System.out.println(yzCode());
			}
		}
	 	public static String yzCode(){
	 		return String.valueOf((int)(Math.random()*899999)+100001);
	 	}
}
