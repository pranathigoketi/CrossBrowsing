package crossbrowsing;

import org.apache.commons.mail.*;

public class sendReport {
    public static void main(String args[]) throws Exception {
//        Email email = new SimpleEmail();
//        email.setHostName("smtp.gmail.com");
//        email.setSmtpPort(465);
//        email.setAuthenticator(new DefaultAuthenticator("gpranu73@gmail.com", "oqif jxin xljl myqu"));
//        email.setSSLOnConnect(true);
//        email.setFrom("gpranu73@gmail.com");
//        email.setSubject("Selenium TestMail");
//        email.setMsg("Good Evening!.\n\n This is a test mail from pranathi where I am sending to all simultaneously for testing of my code.\n Kindly ignore. \n\n With Best Regards,\n Pranathi");
//        email.addTo("pgoketi@gmail.com");


        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("C:\\Users\\PranathiGoketi-Kairo\\Downloads\\CrossBrowsing\\test-output\\emailable-report.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription("html report");
        attachment.setName("Pranathi");
//
//        EmailAttachment attachment1 = new EmailAttachment();
//        attachment1.setPath("C:\\Users\\PranathiGoketi-Kairo\\OneDrive - Kairos Technologies Inc\\Pictures\\Screenshots\\Screenshot (1250).png");
//        attachment1.setDisposition(EmailAttachment.ATTACHMENT);
//        attachment1.setDescription("Report of the test execution");
//        attachment1.setName("TestNG Report of the website and the website is working fine");
//
//        EmailAttachment attachment2 = new EmailAttachment();
//        attachment2.setPath("C:\\Users\\PranathiGoketi-Kairo\\OneDrive - Kairos Technologies Inc\\Pictures\\Screenshots\\Screenshot (1249).png");
//        attachment2.setDisposition(EmailAttachment.ATTACHMENT);
//        attachment2.setDescription("Report of the website and the website is working fine");
//        attachment2.setName("Extent Report");
//
        Email email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("gpranu73@gmail.com", "oqif jxin xljl myqu"));
        email.setSSLOnConnect(true);
        email.setFrom("gpranu73@gmail.com");
        email.setSubject("Selenium TestMail");
        email.setMsg("Good Evening!.\n\n This is a test mail from pranathi where I am sending to all simultaneously for testing of my code.\n Kindly ignore. \n\n With Best Regards,\n Pranathi");
        email.addTo("pranathi.g@kairostech.com");
        ((MultiPartEmail) email).attach(attachment);
//        ((MultiPartEmail) email).attach(attachment1);
//        ((MultiPartEmail) email).attach(attachment2);

        email.send();
        System.out.println("mail sent");

    }
}