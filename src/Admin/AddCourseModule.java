package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCourseModule {

    public AddCourseModule(){
            JFrame frame = new JFrame("Add New Course");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 300);
            frame.setLocation(500,250);


            JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JLabel nameLabel = new JLabel("Course Name:");
            JTextField nameField = new JTextField();

            JLabel codeLabel = new JLabel("Course Code:");
            JTextField codeField = new JTextField();

            JLabel instructorLabel = new JLabel("Instructor:");
            JTextField instructorField = new JTextField();

            JLabel creditsLabel = new JLabel("Credits:");
            JTextField creditsField = new JTextField();

            JButton addButton = new JButton("Add Course");

            panel.setBackground(Color.YELLOW);

        frame.add(panel);
        frame.setVisible(true);

            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(codeLabel);
            panel.add(codeField);
            panel.add(instructorLabel);
            panel.add(instructorField);
            panel.add(creditsLabel);
            panel.add(creditsField);
            panel.add(addButton);

            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String courseName = nameField.getText();
                    String courseCode = codeField.getText();
                    String instructor = instructorField.getText();
                    String credits = creditsField.getText();

                    // Displaying entered information (replace with database logic)
                    System.out.println("Course Name: " + courseName);
                    System.out.println("Course Code: " + courseCode);
                    System.out.println("Instructor: " + instructor);
                    System.out.println("Credits: " + credits);
                    // Add logic to save course details to the database
                }
            });


        }

    public static void main(String[] args) {
        new AddCourseModule();
    }
    }


