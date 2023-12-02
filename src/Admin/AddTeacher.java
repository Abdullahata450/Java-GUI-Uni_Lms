package Admin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class AddTeacher extends JFrame {
    private JTextField idField, TName, Subject, phoneField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JFormattedTextField dobField;

    private JButton addButton,cancelButton;

    public  AddTeacher(){
        setTitle("Add Teacher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(550, 450);
        setLocationRelativeTo(null);

        initComponents();
        addComponentsToFrame();

        setVisible(true);
    }

    private void initComponents() {

        idField = new JTextField();
        idField.setBounds(150, 20, 150, 20);

        TName = new JTextField();
        TName.setBounds(150, 60, 150, 20);


        phoneField = new JTextField();
        phoneField.setBounds(150, 140, 150, 20);

        Subject=new JTextField();
        Subject.setBounds(150, 100, 150, 20);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(150, 220, 80, 20);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(240, 220, 80, 20);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);


        addButton = new JButton("Add");
        addButton.setBounds(250, 290, 80, 30);

        cancelButton=new JButton("Go back");
        cancelButton.setBounds(150,290,80,30);
    }

    private void addComponentsToFrame(){
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 20, 80, 20);
        add(idLabel);
        add(idField);

        JLabel name=new JLabel("Name");
        name.setBounds(50,60,80,20);
        add(name);
        add(TName);

        JLabel Addsub = new JLabel("Subject:");
        Addsub.setBounds(50, 100, 80, 20);
        add(Addsub);
        add(Subject);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 140, 80, 20);
        add(phoneLabel);
        add(phoneField);


        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 220, 80, 20);
        add(genderLabel);
        add(maleRadioButton);
        add(femaleRadioButton);


        add(addButton);
        add(cancelButton);

      cancelButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              new AdminPanel();
              dispose();
          }
      });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    int id=Integer.parseInt(idField.getText());
                    String name =TName.getText();
                    String sub= Subject.getText();
                    String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                    String phone=phoneField.getText();

                    TeacherDB db=new TeacherDB();
                    db.insertupdateDeleteTeacher('i',id,name,sub,gender,phone);
                    JOptionPane.showMessageDialog(null, "Teacher added successfully!");

                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Please enter a valid ID.");
                }
            }
        });
    }



 public  static  void  main(String[] args){
       new AddTeacher();
 }

}
