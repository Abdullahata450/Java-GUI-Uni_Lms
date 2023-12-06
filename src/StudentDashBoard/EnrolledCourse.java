package StudentDashBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class EnrolledCourse extends JFrame {

    public EnrolledCourse() {
        setTitle("Enrolled Course");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1, 10, 10)); // Set GridLayout to vertically arrange course panels
        setSize(600, 400);
        setLocationRelativeTo(null);

        retrieveCourseData(); // Call the method to retrieve course data from the database

        setVisible(true);
    }

    public void addCourseBox(int courseId, String courseName, int credithrs, String teacherName) {
        JPanel coursePanel = new JPanel();
        coursePanel.setBorder(BorderFactory.createTitledBorder(String.valueOf(courseId)));
        coursePanel.setLayout(new BorderLayout());

        JLabel courseLabel = new JLabel("<html><b>Course Teacher Name:</b>" + teacherName + " <b>Course Name:</b> " + courseName + "<br/><b>Credit Hours:</b> " + credithrs + "</html>");
        coursePanel.add(courseLabel, BorderLayout.CENTER);

        JButton enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality to enroll in the course
                JOptionPane.showMessageDialog(EnrolledCourse.this, "Enroll in " + courseName + " Button Clicked!");
            }
        });
        coursePanel.add(enrollButton, BorderLayout.SOUTH);

        add(coursePanel);
    }

    public void retrieveCourseData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "2000");

            String query = "SELECT c.Course_id, c.Course_name, c.Credit_hrs, t.Name, t.Subject " +
                    "FROM course c " +
                    "JOIN teacher t ON c.Course_name = t.Subject";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int courseId = resultSet.getInt("Course_id");
                String courseName = resultSet.getString("Course_name");
                int creditHours = resultSet.getInt("Credit_hrs");
                String teacherName = resultSet.getString("Name");

                addCourseBox(courseId, courseName, creditHours, teacherName);
            }

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new EnrolledCourse();
    }
}
