package Admin;
//
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class SendMailCourse {

    private JFrame frame;
    private JTextField emailField;

    public SendMailCourse() {
        frame = new JFrame("Send Enrollment Emails");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel emailLabel = new JLabel("Enter your email:");
        emailField = new JTextField();

        JButton sendButton = new JButton("Send Emails");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendEmails();
            }
        });

        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(sendButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void sendEmails() {
        // Email configuration
        String host = "your_smtp_server";
        String username = emailField.getText();
        String password = "your_password"; // Provide your email password here

        // Email properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Create a mail session
//        Session session = Session.getInstance(props, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//
//        try {
//            // Get all student emails from the database (replace this with your data retrieval logic)
//            String[] studentEmails = getAllStudentEmails();
//
//            // Email message configuration
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setSubject("Enrollment Reminder");
//            message.setText("Dear student,\n\nPlease enroll in your courses for the upcoming semester.\n\nBest regards,\nUniversity Administration");
//
//            // Send emails to all students
//            for (String email : studentEmails) {
//                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
//                Transport.send(message);
//                System.out.println("Email sent to: " + email);
//            }
//
//            JOptionPane.showMessageDialog(frame, "All emails sent successfully!");
//
//        } catch (MessagingException ex) {
//            JOptionPane.showMessageDialog(frame, "Failed to send emails. Check your email credentials and network settings.");
//            ex.printStackTrace();
//        }
//    }

        // Dummy method to get student emails (replace this with your data retrieval logic)
//    private String[] getAllStudentEmails() {
//        return new String[]{"student1@example.com", "student2@example.com", "student3@example.com"};
//    }


    }
    public static void main (String[]args){
        // Ensure the GUI is created in the Event Dispatch Thread (EDT)
          new SendMailCourse();
    }
}
