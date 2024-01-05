package TeacherDashBoard;//package testing;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkStdAttendenc extends JFrame {
    private JPanel panel;

    public void RetriveStd(int Teacherid) {
        setTitle("Mark Attendance");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(0, 1)); // Use a grid layout for checkboxes

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root", "2000");
//            String query = "SELECT * FROM student";
            String sqlQuery = "SELECT ec.Student_id, ec.Student_name " +
                    "FROM enrolled_courses ec " +
                    "JOIN teacher tt ON ec.Course_name = tt.Subject " + // Added space before WHERE
                    "WHERE tt.Teacher_id=?";


            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            pstmt.setInt(1,Teacherid);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String Firstname = rs.getString("Student_name");
//                String lastname = rs.getString("Last_name");

//                String studentName=Firstname +lastname;

                JCheckBox checkBox = new JCheckBox(Firstname);
                panel.add(checkBox);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submitAttendance());

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void submitAttendance() {
        Component[] components = panel.getComponents();

        // Logic to process attendance
        for (Component component : components) {
            if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                String studentName = checkBox.getText();
                boolean present = checkBox.isSelected();

                // Here, you can implement logic to update attendance in the database
                // For demonstration, let's print attendance status
                String status = present ? "Present" : "Absent";
                System.out.println(studentName + " - " + status);
            }
        }
    }

    public static void main(String[] args) {
        new MarkStdAttendenc();
    }
}
