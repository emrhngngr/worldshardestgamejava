package main;

import db.UserHandler;
import forms.GameOver;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    CollesionChecker cChecker;
    DecimalFormat decimalFormat = new DecimalFormat("#0.0");

    public double playTime;

    public UI(GamePanel gp) {
        this.gp = gp;
    }


    public void draw(Graphics2D g2) {
        g2.setFont(new Font("Arial", Font.PLAIN, 40));
        g2.setColor(Color.RED);
        if (gp.keyH.pausePressed != true){
            playTime += (double) 1/60;
            drawCurrentLevel(g2);
        } else if (gp.isGameOverChecked == true) {
        } else{
            g2.drawString("PAUSED", gp.screenWidth/2, gp.screenHeight/2);
        }
        g2.drawString(String.valueOf(decimalFormat.format(playTime)), 0, 30);
        if (gp.cChecker.getgameStatus() == 0){
            gp.keyH.pausePressed = true;
            drawDEAD(g2);
        }
    }
    public void drawCurrentLevel(Graphics2D g2){
        g2.setFont(new Font("Arial", Font.PLAIN, 40));
        g2.setColor(Color.RED);
        g2.drawString("Level: "+ gp.levelHandler.getCurrentLevel(),gp.screenWidth-200,30);

    }
    public void drawDEAD(Graphics2D g2) {
        if (!gp.isGameOverChecked) {
            gp.isGameOverChecked = true;
            // Show Game Over screen
            SwingUtilities.invokeLater(() -> new GameOver(gp));
        }
    }
    public UI() {

    }

}
