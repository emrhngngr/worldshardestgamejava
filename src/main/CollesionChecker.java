package main;

import entity.Enemy;
import entity.Entity;

import java.awt.*;

public class CollesionChecker {
    GamePanel gp;

    public int gameStatus = 1; //0 = dead, 1 = play, 2 = pause, 3= next level
    public CollesionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public int getgameStatus() {
        return gameStatus;
    }

    public void setgameStatus(int status) {
        gameStatus = status;
    }

    // Function to detect walls with the user. Made to prevent passing through walls.
    public void checkTile(Entity entity){
        int entityLeftWorldX = entity.playerX + entity.solidArea.x;
        int entityRightWorldX = entity.playerX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.playerY + entity.solidArea.y;
        int entityBottomWorldY = entity.playerY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tileSize;
        int entityRightCol = entityRightWorldX/gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY/gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.playerSpeed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }else if (gp.tileManager.tile[tileNum1].win || gp.tileManager.tile[tileNum2].win) {
                    entity.onWin = true;
                }
                break;

            case "down":
                entityBottomRow = (entityBottomWorldY + entity.playerSpeed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }else if (gp.tileManager.tile[tileNum1].win || gp.tileManager.tile[tileNum2].win) {
                    entity.onWin = true;
                }
                break;

            case "left":
                entityLeftCol = (entityLeftWorldX - entity.playerSpeed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }else if (gp.tileManager.tile[tileNum1].win || gp.tileManager.tile[tileNum2].win) {
                    entity.onWin = true;
                }
                break;

            case "right":
                entityRightCol = (entityRightWorldX + entity.playerSpeed) / gp.tileSize;
                tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileManager.tile[tileNum1].collision || gp.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                } else if (gp.tileManager.tile[tileNum1].win || gp.tileManager.tile[tileNum2].win) {
                    entity.onWin = true;
                }
                break;
        }
    }
    // Function that detects collision between player and enemy
    public int checkEnemy(Entity entity, Enemy[] enemies) {
        for (Enemy enemy : enemies) {
            if (enemy != null) {
                Rectangle entityBounds = new Rectangle(entity.playerX, entity.playerY, entity.solidArea.width, entity.solidArea.height);
                Rectangle enemyBounds = new Rectangle(enemy.enemyX, enemy.enemyY, gp.tileSize / 2, gp.tileSize / 2);

                if (entityBounds.intersects(enemyBounds)) {
                    setgameStatus(0);
                    gp.levelHandler.setCurrentLevel(0);
                }
            }
        }
        return this.gameStatus;
    }


}
