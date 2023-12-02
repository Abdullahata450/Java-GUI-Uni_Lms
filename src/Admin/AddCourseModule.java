package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCourseModule {

    public JFrame frame;
    public JPanel panel;
    private JTextField numCoursesField;

    public AddCourseModule() {
        frame = new JFrame("Add New Course");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        panel = new JPanel();

        JLabel label = new JLabel("Enter the number of courses:");
        numCoursesField = new JTextField(10);
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = numCoursesField.getText();
                int numCourses = 0;
                try {
                    numCourses = Integer.parseInt(input);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
                    return;
                }
                addCoursePanels(numCourses);
            }
        });

        panel.add(label);
        panel.add(numCoursesField);
        panel.add(submitButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void addCoursePanels(int numCourses) {
        panel.removeAll(); // Clear existing components
        for (int i = 0; i < numCourses; i++) {
            CourseDetailsPanel coursePanel = new CourseDetailsPanel();
            panel.add(coursePanel.panel);
        }
        frame.revalidate();
        frame.repaint();
    }

    private static class CourseDetailsPanel {
        private JTextField nameField;
        private JTextField codeField;
        private JComboBox<String> instructorDropdown;
        private JTextField creditsField;
        public JPanel panel;

        public JFrame frame;


        public CourseDetailsPanel() {
            panel = new JPanel();
            panel.setLayout(new GridLayout(6, 2, 15, 10));

            JLabel nameLabel = new JLabel("Course Name:");
            nameField = new JTextField();

            JLabel codeLabel = new JLabel("Course Code:");
            codeField = new JTextField();

            JLabel instructorLabel = new JLabel("Instructor:");
            instructorDropdown = new JComboBox<>();
            // Replace this with actual logic to fetch instructors from the database
            instructorDropdown.addItem("Instructor 1");
            instructorDropdown.addItem("Instructor 2");
            instructorDropdown.addItem("Instructor 3");

            JLabel creditsLabel = new JLabel("Credits:");
            creditsField = new JTextField();

            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(codeLabel);
            panel.add(codeField);
            panel.add(instructorLabel);
            panel.add(instructorDropdown);
            panel.add(creditsLabel);
            panel.add(creditsField);
        }
    }


    public static void main(String[] args) {
        new AddCourseModule();
    }
}
