package Admin;

import javax.swing.*;
import java.awt.event.*;

public class AdminPanel implements ActionListener {
    public JButton addCourseBtn, addStudentBtn, addTeacherBtn, deleteBtn, updateBtn;
    JFrame frame;

    public AdminPanel() {
        frame = new JFrame("Admin Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeButtons(panel);
        frame.setVisible(true);
    }

    private void placeButtons(JPanel panel) {
        addCourseBtn = new JButton("Add New Course");
        addStudentBtn = new JButton("Add New Student");
        addTeacherBtn = new JButton("Add New Teacher");
        deleteBtn = new JButton("Delete");
        updateBtn = new JButton("Update");

        panel.add(addCourseBtn);
        panel.add(addStudentBtn);
        panel.add(addTeacherBtn);
        panel.add(deleteBtn);
        panel.add(updateBtn);

        addCourseBtn.addActionListener(this);
        addStudentBtn.addActionListener(this);
        addTeacherBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        updateBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCourseBtn) {
            // Add new course logic
            // Example: Opening the AddCourseModule window
            new AddCourseModule();
            frame.dispose();
        }
//        else if (e.getSource() == addStudentBtn) {
//            // Add new student logic
//            // You should add functionality here as needed
//        }
//        else if (e.getSource() == addTeacherBtn) {
//            // Add new teacher logic
//            // You should add functionality here as needed
//        }
//        else if (e.getSource() == deleteBtn) {
//            // Delete logic
//            // You should add functionality here as needed
//        }
//        else if (e.getSource() == updateBtn) {
//            // Update logic
//            // You should add functionality here as needed
//        }
    }

    public static void main(String[] args) {
         new AdminPanel();
    }
}
