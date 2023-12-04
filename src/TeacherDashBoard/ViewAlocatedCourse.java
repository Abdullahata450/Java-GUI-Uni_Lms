package TeacherDashBoard;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewAlocatedCourse extends JFrame {

    private JTextField idField, courseField, nameField; // Fixed variable name 'NameField' to 'nameField'
    private JButton submitButton;

    public ViewAlocatedCourse() { // Constructor name corrected to match the class name
        setTitle("Teacher Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400, 200);
        setLocationRelativeTo(null);

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel idLabel = new JLabel("Teacher ID:");
        idField = new JTextField(10);

        JLabel nameLabel = new JLabel("Teacher Name:");
        nameField = new JTextField(10);

        JLabel courseLabel = new JLabel("Allocated Course:");
        courseField = new JTextField(10);

        submitButton = new JButton("Submit");

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(courseLabel);
        inputPanel.add(courseField);
        inputPanel.add(submitButton);

        add(inputPanel, BorderLayout.CENTER);
    }

    public void retrieveTeacherData(String id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "2000");
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM teacher WHERE Teacher_id = ?")) {

            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int teacherID = resultSet.getInt("Teacher_id");
                    String teacherName = resultSet.getString("Name");
                    String subject = resultSet.getString("Subject");

//                    idField.setText(String.valueOf(teacherID));
                    idField.setText(String.valueOf(teacherID));
                    nameField.setText(teacherName);
                    courseField.setText(subject);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ViewAlocatedCourse v = new ViewAlocatedCourse();
//        v.retrieveTeacherData(1); // You can pass the teacher ID here
    }
}
