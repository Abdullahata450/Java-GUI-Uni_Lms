package StudentDashBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewScore extends JFrame {
    private JLabel idField, courseField, ScoreField, DescriptionField;
    private JButton BackButton;

    public int id;
    public  JLabel slable=new JLabel("Welocme ");

    public ViewScore() {
        setTitle("Score Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(null);

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel inputPanel = new JPanel(null);

        JLabel idLabel = new JLabel("Your  ID:");
        idField = new JLabel();
        idLabel.setBounds(10, 10, 100, 25);
        idField.setBounds(120, 10, 150, 25);

        JLabel courseLabel = new JLabel("Course Name");
        courseField = new JLabel();
        courseLabel.setBounds(10, 40, 100, 25);
        courseField.setBounds(120, 40, 150, 25);

        JLabel scoreLabel = new JLabel("Your Score");
        ScoreField = new JLabel();
        scoreLabel.setBounds(10, 70, 100, 25);
        ScoreField.setBounds(120, 70, 150, 25);

        JLabel descriptionLabel = new JLabel("Description");
        DescriptionField = new JLabel();
        descriptionLabel.setBounds(10, 120, 100, 25);
        DescriptionField.setBounds(120, 120, 150, 25);

        BackButton = new JButton("Go Back");
        BackButton.setBounds(100, 180, 100, 30);

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(courseLabel);
        inputPanel.add(courseField);
        inputPanel.add(scoreLabel);
        inputPanel.add(ScoreField);
        inputPanel.add(descriptionLabel);
        inputPanel.add(DescriptionField);
        inputPanel.add(BackButton);

        add(inputPanel);

        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//               StudentPanel S= new StudentPanel();
//               S.StudentId=id;
//               S.SLable=slable;
                dispose();
            }
        });
    }

    public void retrieveScore(int id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "2000");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM score WHERE Student_id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int studentId = resultSet.getInt("Student_id");
                String courseName = resultSet.getString("Course_name");
                float score = resultSet.getFloat("Student_Score");
                String desc = resultSet.getString("description");

                idField.setText(String.valueOf(studentId));
                courseField.setText(courseName);
                ScoreField.setText(String.valueOf(score));
                DescriptionField.setText(desc);

            } else {
                JOptionPane.showMessageDialog(null, "No Data Found for ID: " + id);
            }

            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {

       new ViewScore();

    }
}
