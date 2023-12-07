package StudentDashBoard;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewAssignment extends JFrame {

    private JPanel panel;

    public ViewAssignment() {
        setTitle("Display Files in Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 400);
        setLocationRelativeTo(null);

        panel = new JPanel(new GridLayout(1,1));
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(50, 50, 500, 300); // Set bounds for the scroll pane
        add(scrollPane);

        displayFiles();

        setVisible(true);
    }

    private void displayFiles() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "2000")) {
            String query = "SELECT Subject, Filename FROM upload_material";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String filename = resultSet.getString("Subject");
                    InputStream inputStream = resultSet.getBinaryStream("Filename");

                    File file = new File("retrieved_" + filename);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, bytesRead);
                    }

                    fileOutputStream.close();
                    inputStream.close();

                    JButton fileButton = new JButton(filename);
                    fileButton.addActionListener(e -> {
                        // Open the file here or perform any other action
                        // For example, open the file in default system application
                        try {
                            Desktop.getDesktop().open(file);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    });
                    panel.add(fileButton);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ViewAssignment::new);
    }
}
