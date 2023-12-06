import java.sql.*;

public class test {
    public static void main(String[] args) {
        try {

//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root", "2000");

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
                String subject = resultSet.getString("Subject");

                // Do something with the retrieved data
                System.out.println("Course Name: " + courseName);
                System.out.println("Course ID: " + courseId);
                System.out.println("Credit Hours: " + creditHours);
                System.out.println("Teacher Name: " + teacherName);
                System.out.println("Subject: " + subject);
                System.out.println("-----------------------");
            }

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
