package TeacherDashBoard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherModule {

    private JFrame frame;
    private JPanel topPanel, sidePanel, mainPanel;

    public TeacherModule() {
        frame = new JFrame();
        frame.setTitle("Professor Dashboard");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        initComponents();

        frame.setVisible(true);
    }

    private void initComponents() {
        topPanel = new JPanel();
        topPanel.setBounds(0, 0, frame.getWidth(), 50);
        topPanel.setBackground(Color.BLUE);
        frame.add(topPanel);

        sidePanel = new JPanel();
        sidePanel.setBounds(0, 50, 200, frame.getHeight() - 50);
        sidePanel.setBackground(Color.LIGHT_GRAY);
        frame.add(sidePanel);

        mainPanel = new JPanel();
        mainPanel.setBounds(200, 50, frame.getWidth() - 200, frame.getHeight() - 50);
        mainPanel.setBackground(Color.WHITE);
        frame.add(mainPanel);

        JButton viewCoursesButton = new JButton("View Courses");
        viewCoursesButton.setBounds(20, 20, 160, 30);
        sidePanel.add(viewCoursesButton);
        viewCoursesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality to view courses
                JOptionPane.showMessageDialog(frame, "View Courses Button Clicked!");
            }
        });

        JButton markAttendanceButton = new JButton("Mark Attendance");
        markAttendanceButton.setBounds(20, 70, 160, 30);
        sidePanel.add(markAttendanceButton);
        markAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality to mark attendance
                JOptionPane.showMessageDialog(frame, "Mark Attendance Button Clicked!");
            }
        });

        JButton uploadMaterialsButton = new JButton("Upload Materials");
        uploadMaterialsButton.setBounds(20, 120, 160, 30);
        sidePanel.add(uploadMaterialsButton);
        uploadMaterialsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality to upload materials
                JOptionPane.showMessageDialog(frame, "Upload Materials Button Clicked!");
            }
        });

        JButton inputGradesButton = new JButton("Input Grades");
        inputGradesButton.setBounds(20, 170, 160, 30);
        sidePanel.add(inputGradesButton);
        inputGradesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality to input grades
                JOptionPane.showMessageDialog(frame, "Input Grades Button Clicked!");
            }
        });
    }


    public static void main(String[] args) {
        new TeacherModule();
    }
}
