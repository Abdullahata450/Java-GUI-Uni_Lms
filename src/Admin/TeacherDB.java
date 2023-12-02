package Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeacherDB {
    public void insertupdateDeleteTeacher(char operation, Integer id, String name, String subject, String gender,String phone) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "2000");

            if (operation == 'i') {
                String query = "INSERT INTO teacher (Teacher_id, Name, Subject, Gender, Phone) " +
                        "VALUES (?, ?, ?, ?, ?)";


                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, subject);
                preparedStatement.setString(4, gender);
                preparedStatement.setString(5, phone);

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new Teacher was inserted successfully!");
                }
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
