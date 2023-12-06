package StudentDashBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class EnrolledCourse extends JFrame {

    private JPanel contentPanel;

    public EnrolledCourse() {
        setTitle("Enrolled Course");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(600, 600);
        setLocationRelativeTo(null);

        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBounds(10, 10, 560, 340);
        add(contentPanel);

        retrieveCourseData();

        setVisible(true);
    }

    public void addCourseBox(int courseId, String courseName, int creditHrs, String teacherName) {
        JPanel coursePanel = new JPanel();
        coursePanel.setBorder(BorderFactory.createTitledBorder(String.valueOf(courseId)));
        coursePanel.setLayout(new GridLayout(4, 4));

        JLabel nameLabel = new JLabel("Teacher Name: " + teacherName);
        coursePanel.add(nameLabel);

        JLabel courseLabel = new JLabel("Course Name: " + courseName);
        coursePanel.add(courseLabel);

        JLabel creditLabel = new JLabel("Credit Hours: " + creditHrs);
        coursePanel.add(creditLabel);

        JButton enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(EnrolledCourse.this, "Enroll in " + courseName + " Button Clicked!");
            }
        });
        coursePanel.add(enrollButton);

        coursePanel.setBounds(60, contentPanel.getComponentCount() * 110, 300, 100);

        contentPanel.add(coursePanel);


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
