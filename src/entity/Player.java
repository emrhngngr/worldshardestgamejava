package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UI;
import tile.TileManager;

import java.awt.*;
import java.security.Key;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;
    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.gp = gp;
        this.keyH = keyH;

        solidArea = new Rectangle(0,0,gp.tileSize/2,gp.tileSize/2);

        setDefaultValues();
    }

    public void setDefaultValues(){
        playerX = 150;
        playerY = 250;
        playerSpeed = 4;
    }

    public void update(){
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true)
        {
            if (keyH.upPressed == true){
                direction = "up";
            }
            else if (keyH.downPressed == true){
                direction = "down";
            }
            else if (keyH.leftPressed == true){
                direction = "left";
            }
            else if (keyH.rightPressed == true){
                direction = "right";
            }
            if (collisionOn == false){
                switch (direction){
                    case "up": playerY -= playerSpeed; break;
                    case "down": playerY += playerSpeed; break;
                    case "left": playerX -= playerSpeed; break;
                    case "right": playerX += playerSpeed; break;
                }
            }
        }
        //TileManager tileManager = new TileManager(gp);




        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkEnemy(this,gp.enemy);

    }


    public void draw(Graphics2D g2) {
        g2.setColor(Color.red);
        g2.fillRect(playerX,playerY,gp.tileSize/2,gp.tileSize/2);
    }
}
