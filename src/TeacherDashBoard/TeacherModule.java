package TeacherDashBoard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherModule {

    private JFrame frame;
    private JPanel topPanel, sidePanel;
    public JLabel TLable;

    public TeacherModule() {
        frame = new JFrame();
        frame.setTitle("Professor Dashboard");
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        initComponents();

        frame.setVisible(true);
    }

    private void initComponents() {
        topPanel = new JPanel();
        topPanel.setBounds(0, 0, 200, 50);
        topPanel.setBackground(Color.BLUE);
        frame.add(topPanel);

        JLabel label=new JLabel("Teacher Panal");
        label.setBounds(400 ,0,200,100);
        label.setForeground(Color.BLACK);
        frame.add(label);

        sidePanel = new JPanel();
        sidePanel.setBounds(0, 50, 200, 550);
        sidePanel.setBackground(Color.LIGHT_GRAY);
        frame.add(sidePanel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/TeacherBackGround.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(200, 50, frame.getWidth() - 200, frame.getHeight() - 50);
        frame.add(image);

        sidePanel.setLayout(new GridLayout(0, 1,50,4));

        TLable=new JLabel("Welcome");
        TLable.setFont(new java.awt.Font("Courier New", 1, 20));
        TLable.setBounds(50, 120, 100, 30);
        frame.add(TLable);
        sidePanel.add(TLable);



        JButton viewCoursesButton = new JButton("View Alloted Courses");
//        viewCoursesButton.setBounds(20, 20, 160, 30);
        sidePanel.add(viewCoursesButton);

        viewCoursesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              ViewAlocatedCourse v = new ViewAlocatedCourse();
                new ViewAlocatedCourse();

            }
        });

        JButton markAttendanceButton = new JButton("Mark Attendance");
        markAttendanceButton.setBounds(20, 70, 160, 20);
        sidePanel.add(markAttendanceButton);
        markAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality to mark attendance
                JOptionPane.showMessageDialog(frame, "Mark Attendance Button Clicked!");
            }
        });

        JButton uploadMaterialsButton = new JButton("Upload Materials");
        uploadMaterialsButton.setBounds(20, 110, 160, 20);
        sidePanel.add(uploadMaterialsButton);
        uploadMaterialsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add functionality to upload materials
                JOptionPane.showMessageDialog(frame, "Upload Materials Button Clicked!");
            }
        });

        JButton inputGradesButton = new JButton("Input Grades");
        inputGradesButton.setBounds(20, 200, 100, 20);
        inputGradesButton.setBackground(new java.awt.Color(102, 102, 102));
        inputGradesButton.setFont(new java.awt.Font("Calibri", 1, 16));
        inputGradesButton.setForeground(new java.awt.Color(255, 255, 255));
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