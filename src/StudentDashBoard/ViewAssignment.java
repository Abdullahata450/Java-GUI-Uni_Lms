package StudentDashBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        panel = new JPanel(null); // Use null layout for absolute positioning
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

                int yPosition = 20; // Initial y-position for buttons

                while (resultSet.next()) {
                    String filename = resultSet.getString("Subject");

                    InputStream inputStream = resultSet.getBinaryStream("Filename");

                    JButton fileButton = new JButton(filename);
                    fileButton.setBounds(50, yPosition, 200, 30); // Set bounds for the file buttons
                    fileButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            openFile(filename, inputStream);
                        }
                    });
                    panel.add(fileButton);

                    yPosition += 40; // Increase y-position for the next button
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void openFile(String filename, InputStream inputStream) {
        try {
            File file = new File("retrieved : " + filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }

            fileOutputStream.close();
            inputStream.close();
            Desktop.getDesktop().open(file);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ViewAssignment::new);
    }
}
