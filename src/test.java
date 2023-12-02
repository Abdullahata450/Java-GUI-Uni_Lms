import java.sql.*;

public class test {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/checkingdatabase","root", "2000");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from admin");

        while (resultSet.next()){
            System.out.println(resultSet.getString("UserName"));
            System.out.println(resultSet.getString("PassWord"));
        }

    }
}
