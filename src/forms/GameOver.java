package forms;

import main.GamePanel;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JDialog{
    private JButton RESTARTButton;
    private JButton MAINMENUButton;
    private JPanel gameOver;

    public GameOver(GamePanel parent) {
        setTitle("DEAD");
        setLocationRelativeTo(parent);
        setMinimumSize(new Dimension(225, 180));
        setUndecorated(true);
        setModal(true);
        setContentPane(gameOver);

        RESTARTButton.addActionListener(e -> {
            // Restart process
            parent.retry();
            // Close the window
            dispose();
        });

        // MAINMENUButton için ActionListener
        MAINMENUButton.addActionListener(e -> {
            // Returning to the main menu

            // Close the window
            parent.closeWindow();
            JFrame jFrame = new JFrame();
            MainMenu mainMenu = new MainMenu(jFrame);
            dispose();
        });
        setVisible(true);
    }
}
