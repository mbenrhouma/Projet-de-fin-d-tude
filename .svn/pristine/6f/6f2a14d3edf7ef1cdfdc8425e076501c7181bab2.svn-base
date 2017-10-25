package com.cynapsys.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.faces.context.FacesContext;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.cynapsys.utils.ConfigUtils;
import com.cynapsys.utils.Constants;

public class EnvoyerMail {
	public static boolean envoieMessageFacturePayer() {
		// Sender's email ID needs to be mentioned
		final String username = ResourceBundle.getBundle(Constants.bundle_smtp)
				.getString("adress.send");
		final String password = ResourceBundle.getBundle(Constants.bundle_smtp)
				.getString("adress.send.password");
		Properties props = new Properties();
		props.setProperty(
				"mail.host",
				ResourceBundle.getBundle(Constants.bundle_smtp).getString(
						"smtp.mail.host"));
		props.setProperty(
				"mail.smtp.port",
				ResourceBundle.getBundle(Constants.bundle_smtp).getString(
						"smtp.mail.smtp.port"));
		props.setProperty(
				"mail.smtp.auth",
				ResourceBundle.getBundle(Constants.bundle_smtp).getString(
						"mail.smtp.auth"));
		props.setProperty(
				"mail.smtp.starttls.enable",
				ResourceBundle.getBundle(Constants.bundle_smtp).getString(
						"mail.smtp.starttls.enable"));
		props.put(
				"mail.smtp.ssl.trust",
				ResourceBundle.getBundle(Constants.bundle_smtp).getString(
						"mail.smtp.ssl.trust"));
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(ResourceBundle.getBundle(
					Constants.bundle_smtp).getString("adress.send")));
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(ResourceBundle.getBundle(
							Constants.bundle_smtp).getString(
							"adress.recipients")));

			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
					+ "\n\n No spam to my email, please!");
			File file = new File(FacesContext.getCurrentInstance()
					.getExternalContext().getRealPath("/")
					+ "resources/images/deconnexion.png");
			FileDataSource datasource1 = new FileDataSource(file);
			DataHandler handler1 = new DataHandler(datasource1);
			MimeBodyPart autruche = new MimeBodyPart();
			try {
				autruche.setDataHandler(handler1);
				autruche.setFileName(datasource1.getName());
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			MimeMultipart mimeMultipart = new MimeMultipart();
			try {
				mimeMultipart.addBodyPart(autruche);
				message.setContent(mimeMultipart);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			Transport.send(message);

			System.out.println("Done");
			return true;

		} catch (MessagingException e) {
			return false;
		}
	}

	public static boolean EnvoyerEmail(String fromAddress, List toAddressList,
			List ccAddressList, List bccAddressList, String emailSubject,
			String htmlText, String textEmailContent, String host, String port,
			String login, String password, boolean withAttachement, String attachedFileName)
			throws Exception {
		Iterator toAddressIt, ccAddressIt, bccAddressIt = null;
		String toAddress, ccAddress, bccAddress = null;
		boolean mailOkSend = false;

		String from = fromAddress;

		try {
			// Get system properties
			Properties props = System.getProperties();

			// server mail
			Session sessionMail;
			props.put("mail.smtp.host", host);
			if (port != null)
				props.put("mail.smtp.port", port);

			if ((login != null && !login.equals(""))
					&& (password != null && !password.equals(""))) {

				props.put("mail.smtp.auth", "true");
				Authenticator auth = new SMTPAuthenticator(login, password);
				sessionMail = Session.getDefaultInstance(props, auth);

			} else
				sessionMail = Session.getDefaultInstance(props, null);
			// Define messag

			MimeMessage monEmail = new MimeMessage(sessionMail);

			System.out.println("---from------>" + from);
			monEmail.setFrom(new InternetAddress(from));

			toAddressIt = toAddressList.iterator();
			while (toAddressIt.hasNext()) {
				toAddress = (String) toAddressIt.next();

				monEmail.addRecipient(Message.RecipientType.TO,
						new InternetAddress(toAddress));
			}

			if (ccAddressList != null && ccAddressList.size() > 0) {
				ccAddressIt = ccAddressList.iterator();

				while (ccAddressIt.hasNext()) {
					ccAddress = (String) ccAddressIt.next();
					monEmail.addRecipient(Message.RecipientType.CC,
							new InternetAddress(ccAddress));
				}
			}

			if (bccAddressList != null && bccAddressList.size() > 0) {
				bccAddressIt = bccAddressList.iterator();
				while (bccAddressIt.hasNext()) {
					bccAddress = (String) bccAddressIt.next();
					monEmail.addRecipient(Message.RecipientType.BCC,
							new InternetAddress(bccAddress));
				}
			}
			monEmail.setSubject(emailSubject);

			// Create a multi-part to combine the parts
			MimeMultipart multipart = new MimeMultipart("mixed");

			// Create html part
			MimeBodyPart htmlPart = new MimeBodyPart();
			// htmlPart.setText(htmlText, "iso-8859-1", "html");
			htmlPart.setText(htmlText, "UTF-8", "html");
			
			multipart.addBodyPart(htmlPart);

//			 check for attachement
			 if (withAttachement) {
			 MimeBodyPart attachedFilePart = new MimeBodyPart();
			 FileDataSource fds = new FileDataSource(new
			 File(attachedFileName));
			 attachedFilePart.setDataHandler(new DataHandler(fds));
			 attachedFilePart.setFileName(fds.getName());
			 multipart.addBodyPart(attachedFilePart);
			 }

			// monEmail.setContent(multipart, "text/plain");
			
			monEmail.setContent(multipart, "text/html; charset=utf-8");
			monEmail.saveChanges();

			System.out.println("--------before send ");
			/*
			 * Transport transport = sessionMail.getTransport();
			 * transport.connect(); transport.send(monEmail);
			 */
			Transport.send(monEmail);
			mailOkSend = true;
			System.out.println("Mail Sent Successfully");
			// transport.close();

		} catch (Exception e) {
			mailOkSend = false;
			System.out.println("mail manager error mail----" + e);
			e.printStackTrace();
		}
		return mailOkSend;
	}

	public static boolean envoyerMailAdminGestionUser(String mailTo, String objet,
			String htmlText) {
		try {
			ConfigUtils confUtils = ConfigUtils.getInstance();
			String host = confUtils.loadPropretiesConfigMailValue("smtp.mail.host");
			String port = confUtils.loadPropretiesConfigMailValue("smtp.mail.port");
			String login = confUtils
					.loadPropretiesConfigMailValue("smtp.mail.login");
			String motPasse = confUtils
					.loadPropretiesConfigMailValue("smtp.mail.password");
			String from = confUtils.loadPropretiesConfigMailValue("smtp.mail.from");

			List<String> toAddressList = new ArrayList<String>();
			toAddressList.add(mailTo);
	
			return EnvoyerEmail(from, toAddressList, null, null, objet, htmlText,
					null, host, port, login, motPasse, false, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean envoyerMailDetailDemade(String mailTo, String objet,
			String htmlText, String attachementFile) {
		try {
			ConfigUtils confUtils = ConfigUtils.getInstance();
			String host = confUtils.loadPropretiesConfigMailOPValue("smtp.mail.host");
			String port = confUtils.loadPropretiesConfigMailOPValue("smtp.mail.port");
			String login = confUtils
					.loadPropretiesConfigMailOPValue("smtp.mail.login");
			String motPasse = confUtils
					.loadPropretiesConfigMailOPValue("smtp.mail.password");
			String from = confUtils.loadPropretiesConfigMailOPValue("smtp.mail.from");

			List<String> toAddressList = new ArrayList<String>();
			toAddressList.add(mailTo);
	
			return EnvoyerEmail(from, toAddressList, null, null, objet, htmlText,
					null, host, port, login, motPasse,attachementFile==null?false:true, attachementFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static boolean envoyerMailFactureTemp(String mailTo, String objet,
			String htmlText, String attachementFile) {
		try {
			ConfigUtils confUtils = ConfigUtils.getInstance();
			String host = confUtils.loadPropretiesConfigMailTempFactureValue("smtp.mail.host");
			String port = confUtils.loadPropretiesConfigMailTempFactureValue("smtp.mail.port");
			String login = confUtils
					.loadPropretiesConfigMailTempFactureValue("smtp.mail.login");
			String motPasse = confUtils
					.loadPropretiesConfigMailTempFactureValue("smtp.mail.password");
			String from = confUtils.loadPropretiesConfigMailTempFactureValue("smtp.mail.from");

			List<String> toAddressList = new ArrayList<String>();
			toAddressList.add(mailTo);
	
			return EnvoyerEmail(from, toAddressList, null, null, objet, htmlText,
					null, host, port, login, motPasse,attachementFile==null?false:true, attachementFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean envoyerMailOrdrePaiement(String mailTo, String objet,
			String htmlText, String attachementFile) {
		try {
			ConfigUtils confUtils = ConfigUtils.getInstance();
			String host = confUtils.loadPropretiesConfigMailOPValue("smtp.mail.host");
			String port = confUtils.loadPropretiesConfigMailOPValue("smtp.mail.port");
			String login = confUtils
					.loadPropretiesConfigMailOPValue("smtp.mail.login");
			String motPasse = confUtils
					.loadPropretiesConfigMailOPValue("smtp.mail.password");
			String from = confUtils.loadPropretiesConfigMailOPValue("smtp.mail.from");

			List<String> toAddressList = new ArrayList<String>();
			toAddressList.add(mailTo);
	
			return EnvoyerEmail(from, toAddressList, null, null, objet, htmlText,
					null, host, port, login, motPasse,attachementFile==null?false:true, attachementFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public String getHtml(String htmlFile, String plainText, String htmlHeader,
			String htmlFooter) {
		String htmlText = null;
		try {
			Parser parser = new Parser(htmlFile);
			Parser parHed = new Parser(htmlHeader);
			Parser parFoot = new Parser(htmlFooter);

			NodeList xml = parser.parse(null);
			NodeList html = xml.elementAt(2).getChildren();

			// System.out.println(xml);
			// System.out.println(html);
			if (html != null && html.elementAt(3) != null) {
				NodeList body = html.elementAt(3).getChildren();

				NodeList tableTag = body.elementAt(3).getChildren();
				// 7System.out.println("-----tableTag--0--"+tableTag.elementAt(0));
				// System.out.println("-----tableTag-1--"+tableTag.elementAt(1));
				// System.out.println("-----tableTag-2--"+tableTag.elementAt(2));
				NodeList tableRow = tableTag.elementAt(1).getChildren();
				// System.out.println("----tableRow---"+tableRow.elementAt(1));
				NodeList tableColumn = tableRow.elementAt(1).getChildren();
				// System.out.println("----------tableColumn-----"+tableColumn.elementAt(1));
				Node divColumn = tableColumn.elementAt(1);
				// Node head=tableTag.elementAt(0);
				NodeList header = parHed.parse(null);
				// Node foot = tableTag.elementAt(2);
				NodeList footer = parFoot.parse(null);

				// head.setChildren(new NodeList(new
				// TextNode(header.toHtml())));

				divColumn.setChildren(new NodeList(new TextNode(header.toHtml()
						+ formatHTML(plainText) + footer.toHtml())));
			}

			// foot.setChildren(new NodeList(new TextNode(footer.toHtml())));

			htmlText = xml.toHtml();
		} catch (ParserException pe) {
			pe.printStackTrace();
		}
		return htmlText;
	}
	public String getHtmlWithouTemplate(String htmlFile) {
		String htmlText = null;
		try {
			Parser parser = new Parser(htmlFile);
			NodeList xml = parser.parse(null);
			htmlText = xml.toHtml();
		} catch (ParserException pe) {
			pe.printStackTrace();
		}
		return htmlText;
	}
	private String formatHTML(String input) {

		String outPut = "";

		outPut = input;

		return outPut;
	}

}
