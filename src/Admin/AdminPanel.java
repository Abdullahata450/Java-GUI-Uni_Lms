package Admin;

import javax.swing.*;
import java.awt.event.*;

public class AdminPanel implements ActionListener {
    public JButton addCourseBtn, addStudentBtn, addTeacherBtn, ManageBtn, ManageBtn2;
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
        addStudentBtn = new JButton("Add Student");
        addTeacherBtn = new JButton("Add New Teacher");
        ManageBtn = new JButton("Manage Student");
        ManageBtn2 = new JButton("Manage Teacher");

        panel.add(addCourseBtn);
        panel.add(addStudentBtn);
        panel.add(addTeacherBtn);
        panel.add(ManageBtn);
        panel.add(ManageBtn2);

        addCourseBtn.addActionListener(this);
        addStudentBtn.addActionListener(this);
        addTeacherBtn.addActionListener(this);
        ManageBtn.addActionListener(this);
        ManageBtn2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCourseBtn) {

            new AddCourseModule();
            frame.dispose();
        }
        else if (e.getSource() == addStudentBtn) {
            new AddStudent();
            frame.dispose();

        }
        else if (e.getSource() == addTeacherBtn) {
           new AddTeacher();
           frame.dispose();
        }
        else if (e.getSource() == ManageBtn) {

            new ManageStudent();
            frame.dispose();
        }

        else if (e.getSource() == ManageBtn2) {
            new ManageTeacher();
            frame.dispose();
        }
    }

    public static void main(String[] args) {
         new AdminPanel();
    }
}
