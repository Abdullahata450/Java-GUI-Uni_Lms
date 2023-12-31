package StudentDashBoard;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EnrolledCourseDB {

    public void InsterIntoEnrolledCourse(String StdId, String Stdname,String Course_name, String Teacher_name, int crdhr) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "2000");
            PreparedStatement statement = con.prepareStatement("INSERT INTO enrolled_courses (Student_id, Student_name,Course_name, Teacher_name, Credit_hr) VALUES (?, ?, ?, ?,?)");

            statement.setString(1, StdId);
            statement.setString(2, Stdname);
            statement.setString(3, Course_name);
            statement.setString(4, Teacher_name);
            statement.setInt(5, crdhr);

            // Execute the update
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "You Have Enrolled in " + Course_name);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to enroll in " + Course_name);
            }

            // Close the connection and statement
            statement.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Enrolled Course DB: " + ex.getMessage());
            ex.printStackTrace(); // Print the stack trace for debugging
        }
    }
}
