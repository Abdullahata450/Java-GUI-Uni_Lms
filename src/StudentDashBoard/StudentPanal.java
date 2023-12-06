package StudentDashBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentPanal extends JFrame {

    private JButton enrollCourseButton, viewCoursesButton, checkGradesButton;
    private JTextArea displayArea;

    public StudentPanal() {
        setTitle("Student Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400, 300);
        setLocationRelativeTo(null);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        enrollCourseButton = new JButton("Enroll in Course");
        enrollCourseButton.setBounds(50, 30, 150, 30);
        enrollCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality for enrolling in a course
                JOptionPane.showMessageDialog(StudentPanal.this, "Enroll in Course Button Clicked!");
            }
        });

        viewCoursesButton = new JButton("View Enrolled Courses");
        viewCoursesButton.setBounds(50, 80, 150, 30);
        viewCoursesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality for viewing enrolled courses
                JOptionPane.showMessageDialog(StudentPanal.this, "View Enrolled Courses Button Clicked!");
            }
        });

        checkGradesButton = new JButton("Check Grades");
        checkGradesButton.setBounds(50, 130, 150, 30);
        checkGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality for checking grades
                JOptionPane.showMessageDialog(StudentPanal.this, "Check Grades Button Clicked!");
            }
        });

        add(enrollCourseButton);
        add(viewCoursesButton);
        add(checkGradesButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBounds(220, 30, 150, 130);
        add(displayArea);
    }

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(StudentPanal::new);
        new StudentPanal();
    }
}
