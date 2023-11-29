package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Admin.AddCourseModule;
import Admin.AdminPanel;

public class Main {

    public static void main(String[] args) {
        createAndShowGUI();
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Simple Course Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.darkGray);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(40, 70, 100, 20);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 70, 150, 20);
        usernameLabel.setForeground(Color.white);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 100, 100, 20);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 20);
        passwordLabel.setForeground(Color.white);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(40, 140, 120, 30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Tahoma",Font.BOLD,16));

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(180, 140, 120, 30);
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setFont(new Font("Tahoma",Font.BOLD,16));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 20, 200, 200);





        frame.add(image);
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("Admin") && password.equals("admin")) {
                    new AdminPanel();
                    frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials. Try again.");
                }
            }
        });

        frame.setVisible(true);
    }
}
