package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddCourseModule {

    JFrame frame = new JFrame();
    private JTextField CourseNametext, idText, CourseInstText;
    private JSpinner jSpinner_courseHours;
    private JButton button_AddCourses;
    private JButton button_Cancel;

    private JComboBox<String> instructorDropdown;

    public AddCourseModule() {
        initComponents();
    }

    private void initComponents() {
        frame.setSize(500, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel jLabel1 = new JLabel("Add Courses");
        jLabel1.setFont(new java.awt.Font("Courier New", 1, 30));
        jLabel1.setBounds(140, 40, 200, 40);
        frame.add(jLabel1);

        JLabel CourseName = new JLabel("Course id");
        CourseName.setFont(new java.awt.Font("Courier New", 1, 15));
        CourseName.setBounds(50, 120, 100, 30);
        frame.add(CourseName);

        JLabel Name = new JLabel("Course Name:");
        Name.setBounds(50, 190, 100, 30);
        frame.add(Name);

        JLabel Hours = new JLabel("Hours:");
        Hours.setFont(new java.awt.Font("Courier New", 1, 15));
        Hours.setBounds(50, 320, 100, 30);
        frame.add(Hours);

        JLabel instructorLabel = new JLabel("Instructor:");
        instructorLabel.setBounds(50, 250, 100, 30);
        frame.add(instructorLabel);

        instructorDropdown = new JComboBox<>();
        instructorDropdown.setBounds(150, 250, 200, 30);
        frame.add(instructorDropdown);

        List<String> instructors = fetchInstructorsFromDatabase();
        for (String instructor : instructors) {
            instructorDropdown.addItem(instructor);
        }

        idText = new JTextField();
        idText.setFont(new java.awt.Font("Comic Sans MS", 2, 18));
        idText.setBounds(150, 120, 200, 30);
        frame.add(idText);

        CourseNametext = new JTextField();
        CourseNametext.setFont(new java.awt.Font("Comic Sans MS", 2, 18));
        CourseNametext.setBounds(150, 190, 200, 30);
        frame.add(CourseNametext);

        jSpinner_courseHours = new JSpinner();
        jSpinner_courseHours.setFont(new java.awt.Font("Tahoma", 1, 14));
        jSpinner_courseHours.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        jSpinner_courseHours.setBounds(150, 320, 100, 30);
        frame.add(jSpinner_courseHours);

        button_AddCourses = new JButton("Add Course");
        button_AddCourses.setBackground(new java.awt.Color(102, 102, 102));
        button_AddCourses.setFont(new java.awt.Font("Calibri", 1, 16));
        button_AddCourses.setForeground(new java.awt.Color(255, 255, 255));
        button_AddCourses.setBounds(110, 450, 150, 36);
        button_AddCourses.addActionListener(this::button_AddCoursesActionPerformed);
        frame.add(button_AddCourses);

        button_Cancel = new JButton("Cancel");
        button_Cancel.setBackground(new java.awt.Color(102, 102, 102));
        button_Cancel.setFont(new java.awt.Font("Calibri", 1, 16));
        button_Cancel.setForeground(new java.awt.Color(255, 255, 255));
        button_Cancel.setBounds(280, 450, 100, 36);
        button_Cancel.addActionListener(this::button_CancelActionPerformed);
        frame.add(button_Cancel);

        frame.setLocationRelativeTo(null); // Center the frame on the screen
    }

    private List<String> fetchInstructorsFromDatabase() {
        List<String> instructors = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "2000");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from teacher");

            while (resultSet.next()) {
                String instructorName = resultSet.getString("Name");
                instructors.add(instructorName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return instructors;
    }

    private void button_AddCoursesActionPerformed(ActionEvent evt) {
        // Your logic for adding courses goes here
        // Use idText.getText(), CourseNametext.getText(), and jSpinner_courseHours.getValue() to get the entered values
        // Perform necessary operations
    }

    private void button_CancelActionPerformed(ActionEvent evt) {
        new AdminPanel();
        frame.dispose();

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new AddCourseModule();
        });
    }
}
