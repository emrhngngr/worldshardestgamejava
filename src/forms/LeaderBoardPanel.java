package forms;

import db.Connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LeaderBoardPanel extends JDialog {
    private JPanel scoreboardPanel;
    private JLabel titleLabel;
    private JButton MAINMENUButton;
    private JTextArea scoreboardTextArea;

    public LeaderBoardPanel(JFrame parent) {
        super(parent);
        setTitle("Leaderboard");
        setContentPane(scoreboardPanel);
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        displayScoreboard();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        MAINMENUButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
    private void displayScoreboard() {
        Connect connection = new Connect();
        try {
            String query = "SELECT u.username, MIN(us.time) AS time " +
                    "FROM users u " +
                    "JOIN userstats us ON u.user_id = us.user_id " +
                    "GROUP BY u.username " +
                    "ORDER BY time ASC";  // ASC for ascending order
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder scoreboardText = new StringBuilder();
            int rank = 1;
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                double maxTime = resultSet.getDouble("time");

                // Sadece 4 ondalık basamak göstermek için
                String formattedMaxTime = String.format("%.4f", maxTime);

                scoreboardText.append(rank).append(".  ")
                        .append(username).append(" : ")
                        .append(formattedMaxTime).append("\n");
                rank++;
            }

            scoreboardTextArea.setText(scoreboardText.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }






}
