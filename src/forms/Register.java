package forms;

import db.UserHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JDialog {
    private JButton cancelButton;
    private JPanel registerPanel;
    private JTextField textField1;
    private JPasswordField passwordField;
    private JButton registerButton;
    public boolean registerConfirm = false;


    public Register(JFrame parent) {
        super(parent);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Create a new account");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
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

    public boolean registerUser() {
        String username = textField1.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        if (username.length() <= 2) {
            JOptionPane.showMessageDialog(this, "Kullanıcı adı en az 3 karakter uzunluğunda olmalıdır.", "Hata", JOptionPane.ERROR_MESSAGE);
            return false; // İşlemi sonlandır
        }

        // Şifre kriterlerini kontrol et
        if (password.length() < 8) {
            JOptionPane.showMessageDialog(this, "Şifreniz en az 8 karakter uzunluğunda olmalıdır.", "Hata", JOptionPane.ERROR_MESSAGE);
            return false; // İşlemi sonlandır
        }




        UserHandler userHandler = new UserHandler(username,password);
        if (userHandler.registerUser()){
            JOptionPane.showMessageDialog(this, "Welcome", "Succesfull", JOptionPane.INFORMATION_MESSAGE);
            registerConfirm = true;
            dispose();
            return true;
        }else{
            JOptionPane.showMessageDialog(this, "Username is taken", "Error", JOptionPane.ERROR_MESSAGE);
            registerConfirm = false;
            return false;
        }
    }
}
