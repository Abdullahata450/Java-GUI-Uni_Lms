package TeacherDashBoard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddScore {
    private JFrame frame;
    private JComboBox<String> CourseDropdown;

    private JButton Add,Goback;
    private JTable ScoreTable;
    private DefaultTableModel model;
    private JScrollPane scrollPane;



    AddScore(){
        frame = new JFrame("Manage Teacher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700); // Set your desired size here
        frame.setLayout(null);

        initComponents();
        fillTable();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private  void initComponents(){

        JLabel jLabel1 = new JLabel("Add Score Of Student");
        jLabel1.setFont(new java.awt.Font("Courier", 2, 20));
        jLabel1.setBounds(300, 40, 200, 40);
        frame.add(jLabel1);

        JLabel id=new JLabel("Student id");
        id.setFont(new java.awt.Font("Courier", 2, 20));
        id.setBounds(50, 120, 200, 40);
        frame.add(id);
        JTextField Sid=new JTextField();
        Sid.setFont(new java.awt.Font("Courier", 2, 20));
        Sid.setBounds(197, 120, 200, 40);
        frame.add(Sid);

        JLabel Courseid=new JLabel("Course Name");
        Courseid.setFont(new java.awt.Font("Courier", 2, 20));
        Courseid.setBounds(50, 180, 200, 40);
        frame.add(Courseid);

        CourseDropdown = new JComboBox<>();
        CourseDropdown.setBounds(197, 180, 200, 40);
        frame.add(CourseDropdown);
        List<String> course=fetchCourseFromDatabase();
        for(String Course:course){
            CourseDropdown.addItem(Course);
        }

        JLabel Score =new JLabel("Add Score");
        Score.setFont(new java.awt.Font("Courier", 2, 20));
        Score.setBounds(50, 250, 200, 40);
        frame.add(Score);
        JTextField Sscore=new JTextField();
        Sscore.setFont(new java.awt.Font("Courier", 2, 20));
        Sscore.setBounds(197, 250, 200, 40);
        frame.add(Sscore);

        JLabel Description =new JLabel("Add Description");
        Description.setFont(new java.awt.Font("Courier", 2, 20));
        Description.setBounds(45, 320, 200, 40);
        frame.add(Description);
        JTextField Adddec=new JTextField();
        Adddec.setFont(new java.awt.Font("Courier", 2, 20));
        Adddec.setBounds(197, 320, 200, 40);
        frame.add(Adddec);

        // Adding table

        model = new DefaultTableModel();
        ScoreTable = new JTable(model);
        scrollPane = new JScrollPane(ScoreTable);
        scrollPane.setBounds(500, 150, 300, 300);
        frame.add(scrollPane);



        Add =new JButton("Add Score");
        Add.setBounds(50,390,100,40);
        frame.add(Add);

        Goback =new JButton("Go Back");
        Goback.setBounds(180,390,100,40);
        frame.add(Goback);

        Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            /// Next task jo student database ma unka hi data Score add ho !!
                int id=Integer.parseInt(Sid.getText());
                String Cname=(String)CourseDropdown.getSelectedItem();
                Float Score=Float.parseFloat(Sscore.getText());
                String Dec=Adddec.getText();
                ScoreDB db =new ScoreDB();
                db.InstertUpdateScore('i',id,Cname,Score,Dec);
                JOptionPane.showMessageDialog(null,"Score Added SuccessFully");
            }
        });
        Goback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new TeacherModule();
                frame.dispose();
            }
        });


    }
    public List <String> fetchCourseFromDatabase(){
        List<String> Course = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "2000");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT  * FROM course");

            while (resultSet.next()){
                String CourseName=resultSet.getString("Course_name");
                Course.add(CourseName);
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return Course;

    }

    public  void fillTable(){
        model.addColumn("Student id ");
        model.addColumn("First Name");
        model.addColumn("Last Name");

        try {
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root", "2000");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM student");

            while (resultSet.next()){
                Object [] obj=new Object[4];
                obj[0]=resultSet.getInt("Student_id");
                obj[1]=resultSet.getString("First_name");
                obj[2]=resultSet.getString("Last_name");
                model.addRow(obj);

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }




    public static void main(String[] args){
        new AddScore();
    }

}
