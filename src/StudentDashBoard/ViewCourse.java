package StudentDashBoard;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewCourse extends JFrame {

    JLabel nameLabel;
    JLabel courseLabel;
    JLabel teacherLabel;
    JLabel creditLabel;

    ViewCourse() {
        setTitle("View Course");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(null);
        setLocationRelativeTo(null);

        init();

        setVisible(true);
    }

    private void init() {
        nameLabel = new JLabel("Your id : ");
        courseLabel = new JLabel("Course Name: ");
        teacherLabel = new JLabel("Teacher Name: ");
        creditLabel = new JLabel("Credit Hours: ");

        nameLabel.setBounds(20, 10, 300, 25);
        courseLabel.setBounds(20, 35, 300, 25);
        teacherLabel.setBounds(20, 60, 300, 25);
        creditLabel.setBounds(20, 90, 300, 25);

        // Add labels to the frame
        add(nameLabel);
        add(courseLabel);
        add(teacherLabel);
        add(creditLabel);
    }

    public void FetchdataFromEnrolledCourse(int studentId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "2000");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM enrolled_courses WHERE Student_id = ?");
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nameLabel.setText("Your id: " + resultSet.getInt("Student_id"));
                courseLabel.setText("Course Name: " + resultSet.getString("Course_name"));
                teacherLabel.setText("Teacher Name: " + resultSet.getString("Teacher_name"));
                creditLabel.setText("Credit Hours: " + resultSet.getInt("Credit_hr"));
            } else {
                JOptionPane.showMessageDialog(null, "No data found for Student ID: " + studentId);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error fetching data: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ViewCourse();
    }
}
