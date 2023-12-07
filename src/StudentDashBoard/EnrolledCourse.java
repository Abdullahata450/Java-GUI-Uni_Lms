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
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);

        retrieveCourseData();

        setVisible(true);
    }

    public void addCourseBox(int courseId, String courseName, int creditHrs, String teacherName, int index) {
        JPanel coursePanel = new JPanel(new GridLayout(4, 1));

        JLabel nameLabel = new JLabel("Teacher Name: " + teacherName);
        JLabel courseLabel = new JLabel("Course Name: " + courseName);
        JLabel creditLabel = new JLabel("Credit Hours: " + creditHrs);
        JButton enrollButton = new JButton("Enroll");

        nameLabel.setBounds(20, index * 110, 300, 25);
        courseLabel.setBounds(20, index * 110 + 25, 300, 25);
        creditLabel.setBounds(20, index * 110 + 50, 300, 25);
        enrollButton.setBounds(20, index * 110 + 75, 100, 25);

        enrollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(EnrolledCourse.this, "Enroll in " + courseName + " Button Clicked!");
            }
        });

        add(nameLabel);
        add(courseLabel);
        add(creditLabel);
        add(enrollButton);
    }

    public void retrieveCourseData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "2000");

            String query = "SELECT c.Course_id, c.Course_name, c.Credit_hrs, t.Name, t.Subject " +
                    "FROM course c " +
                    "JOIN teacher t ON c.Course_name = t.Subject";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int index = 0;
            while (resultSet.next()) {
                int courseId = resultSet.getInt("Course_id");
                String courseName = resultSet.getString("Course_name");
                int creditHours = resultSet.getInt("Credit_hrs");
                String teacherName = resultSet.getString("Name");

                addCourseBox(courseId, courseName, creditHours, teacherName, index++);
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
