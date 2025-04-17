package forms;

import main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JDialog {
    private JButton STARTButton;
    private JPanel mainMenu;
    private JButton EXITButton;
    private JButton leaderboard;

    public MainMenu(JFrame parent) {
        //Pencere için ayarlar
        setTitle("MainMenu");
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(920, 598));
        setLocationRelativeTo(null);
        setModal(true);
        setContentPane(mainMenu);

        STARTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login(parent);
                if (login.loginConfirm) {
                    dispose();
                    JFrame gameFrame = new JFrame();
                    String username = login.username;
                    GamePanel gamePanel = new GamePanel(username);
                    gameFrame.add(gamePanel);
                    gameFrame.pack();
                    gameFrame.setLocationRelativeTo(null);
                    gameFrame.setVisible(true);
                    gamePanel.setupGame();
                    gamePanel.startGameThread();
                }
            }
        });
        leaderboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeaderBoardPanel scoreboardExample = new LeaderBoardPanel(parent);
            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    public MainMenu(GamePanel parent) {
    }
}
