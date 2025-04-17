package forms;

import db.UserHandler;
import main.GamePanel;
import main.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class WinPanel extends JDialog {
    private JPanel winPanel;
    private JButton RETRYButton;
    private JLabel currentTime;
    private JLabel recordTime;
    private JButton MAINMENUButton;
    private JLabel winMessage;


    public WinPanel(GamePanel parent) {
        if (!parent.userHandler.checkRecordOrNot(parent.username,parent.ui.playTime)){
            parent.userHandler.addToLeaderBoard(parent.userHandler.getUserID(parent.username),parent.ui.playTime);
        }
        String formattedTime = new DecimalFormat("#.####").format(parent.ui.playTime);
        if (parent.ui.playTime < parent.userHandler.getRecordTime(parent.username)){
            winMessage.setText("Congratulations new Record: " + parent.userHandler.getRecordTime(parent.username));
        }else{
            currentTime.setText(formattedTime);
            recordTime.setText(String.valueOf(parent.userHandler.getRecordTime(parent.username)));
        }
        setTitle("Congratulations");
        setMinimumSize(new Dimension(920, 598));
        setModal(true);
        setContentPane(winPanel);
        RETRYButton.addActionListener(e -> {
            // Yeniden başlatma işlemi
            dispose();
            parent.retry();
            // Pencereyi kapat
        });

        // MAINMENUButton için ActionListener
        MAINMENUButton.addActionListener(e -> {
            // Pencereyi kapat
            dispose();
            JFrame jFrame = new JFrame();
            jFrame.setLocationRelativeTo(parent);
            MainMenu mainMenu = new MainMenu(jFrame);
        });
        setVisible(true);
    }
}

