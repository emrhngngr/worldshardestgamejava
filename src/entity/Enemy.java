package entity;

import main.GamePanel;

import java.awt.*;

public class Enemy extends Entity{
    public int minX;
    public int maxX;
    public int minY;
    public int maxY;
    public int level;

    public Enemy(GamePanel gp) {
        super(gp);
    }
    // Function that makes the enemy move on an axis
    public void update(String direction) {
        if (direction.equals("x")) {
            enemyX += enemySpeed;
            if (enemyX > maxX || enemyX < minX) {
                enemySpeed = -enemySpeed;
            }
        } else if (direction.equals("y")) {
            enemyY += enemySpeed;
            if (enemyY > maxY || enemyY < minY) {
                enemySpeed = -enemySpeed;
            }
        }


        gp.repaint();
    }

    public int getX() {
        return enemyX;
    }

    public int getY() {
        return enemyY;
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.fillOval(enemyX, enemyY, gp.tileSize/2, gp.tileSize/2);
    }
    public void deleteEnemy(){

    }
}
