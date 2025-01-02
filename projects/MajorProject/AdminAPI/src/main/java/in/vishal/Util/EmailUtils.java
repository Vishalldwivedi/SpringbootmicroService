package in.vishal.Util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

// Marks this class as a Spring-managed component (bean) for dependency injection.
@Component
public class EmailUtils {

    // Injects the JavaMailSender bean provided by Spring Boot for sending emails.
    @Autowired
    private JavaMailSender mailSender; // Used to send email to the user.

    /**
     * Method to send an email.
     * @param to      - Recipient email address.
     * @param subject - Email subject.
     * @param body    - Email body content (can be HTML).
     * @return        - true if email is sent successfully, false otherwise.
     */
    public boolean sendEmail(String to, String subject, String body) {
        boolean isSent = false; // Flag to track if email was sent successfully.

        try {
            // Create a new email message using JavaMailSender.
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            // Helper class to simplify adding email content.
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            // Set recipient email address.
            helper.setTo(to);

            // Set email subject.
            helper.setSubject(subject);

            // Set email body (true enables HTML content).
            helper.setText(body, true);

            // Send the email using JavaMailSender.
            mailSender.send(mimeMessage);

            // If no exception occurs, mark email as sent.
            isSent = true;
        } catch (Exception e) {
            // Print error details if email fails to send.
            e.printStackTrace();
        }

        // Return the result of the email sending process.
        return isSent;
    }
}
