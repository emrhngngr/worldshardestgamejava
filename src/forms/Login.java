package forms;

import db.Connect;
import db.UserHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends JDialog{
    private JButton loginButton;
    private JButton registerButton;
    private JButton cancelButton;
    private JTextField textField1;
    private JPasswordField passwordField;
    private JPanel loginPanel;
    public boolean loginConfirm = false;
    public String username;




    public Login(JFrame parent) {
        super(parent);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkLogin();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegister();
            }
            private void openRegister() {
                Register register = new Register(parent);
            }

        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    /*
    If you want to use Database you should uncomment here.
    public boolean checkLogin() {
        this.username = textField1.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        UserHandler userHandler = new UserHandler(username,password);
        password = userHandler.hashPassword(password);
        // Check username and password from database
        Connect connection = new Connect();
        try {
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful", "Successful", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Close the window if login is successful
                loginConfirm = true;
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed", "Failed", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }*/
    //Login without database, only for have game experience
    public boolean checkLogin() {
        this.username = textField1.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        if (username.equals("admin") && password.equals("123")) {
            JOptionPane.showMessageDialog(this, "Login Successful", "Successful", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Close the window if login is successful
            loginConfirm = true;
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Login Failed", "Failed", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }




}
