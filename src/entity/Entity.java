package entity;

import main.GamePanel;

import java.awt.*;

public class Entity {
    GamePanel gp;
    public int playerX, playerY;
    public int playerSpeed;
    public int enemyX, enemyY;
    public int enemySpeed;
    public String direction = "";
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public boolean collisionOn = false;
    public boolean onWin = false;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
}
