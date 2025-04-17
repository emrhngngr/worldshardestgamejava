package main;

import entity.Enemy;


public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    // Function to set which coordinates all enemies will travel between
    public void setEnemy(GamePanel gp){
        switch (gp.levelHandler.getCurrentLevel()){
            case 0:
                gp.enemy[0] = new Enemy(this.gp);
                gp.enemy[0].enemyX = 6* gp.tileSize;
                gp.enemy[0].enemyY = 4*gp.tileSize+(gp.tileSize/4);
                gp.enemy[0].enemySpeed = 4;
                gp.enemy[0].minX = 6*gp.tileSize;
                gp.enemy[0].maxX = 14*gp.tileSize-(gp.tileSize/2);

                gp.enemy[1] = new Enemy(this.gp);
                gp.enemy[1].enemyX = 6* gp.tileSize;
                gp.enemy[1].enemyY = 6*gp.tileSize+(gp.tileSize/4);
                gp.enemy[1].enemySpeed = 4;
                gp.enemy[1].minX = 6*gp.tileSize;
                gp.enemy[1].maxX = 14*gp.tileSize-(gp.tileSize/2);

                gp.enemy[2] = new Enemy(this.gp);
                gp.enemy[2].enemyX = 6* gp.tileSize;
                gp.enemy[2].enemyY = 8*gp.tileSize+(gp.tileSize/4);
                gp.enemy[2].enemySpeed = 4;
                gp.enemy[2].minX = 6*gp.tileSize;
                gp.enemy[2].maxX = 14*gp.tileSize-(gp.tileSize/2);

                gp.enemy[3] = new Enemy(this.gp);
                gp.enemy[3].enemyX = 14*gp.tileSize-(gp.tileSize/2);
                gp.enemy[3].enemyY = 5*gp.tileSize+(gp.tileSize/4);
                gp.enemy[3].enemySpeed = 4;
                gp.enemy[3].minX = 6*gp.tileSize;
                gp.enemy[3].maxX = 14*gp.tileSize-(gp.tileSize/2);

                gp.enemy[4] = new Enemy(this.gp);
                gp.enemy[4].enemyX = 14*gp.tileSize-(gp.tileSize/2);
                gp.enemy[4].enemyY = 7*gp.tileSize+(gp.tileSize/4);
                gp.enemy[4].enemySpeed = 4;
                gp.enemy[4].minX = 6*gp.tileSize;
                gp.enemy[4].maxX = 14*gp.tileSize-(gp.tileSize/2);
                break;
            case 1:
                resetEnemies(gp,0,4);
                gp.enemy[5] = new Enemy(this.gp);
                gp.enemy[5].enemyX = 15*gp.tileSize-(gp.tileSize/2);
                gp.enemy[5].enemyY = 6*gp.tileSize+(gp.tileSize/4);
                gp.enemy[5].enemySpeed = 2;
                gp.enemy[5].minX = 14*gp.tileSize;
                gp.enemy[5].maxX = 17*gp.tileSize-(gp.tileSize/2);

                gp.enemy[6] = new Enemy(this.gp);
                gp.enemy[6].enemyX = 15*gp.tileSize-(gp.tileSize/2);
                gp.enemy[6].enemyY = 8*gp.tileSize+(gp.tileSize/4);
                gp.enemy[6].enemySpeed = 2;
                gp.enemy[6].minX = 14*gp.tileSize;
                gp.enemy[6].maxX = 17*gp.tileSize-(gp.tileSize/2);

                gp.enemy[7] = new Enemy(this.gp);
                gp.enemy[7].enemyX = 9*gp.tileSize+(gp.tileSize/4);
                gp.enemy[7].enemyY = 5*gp.tileSize+(gp.tileSize/4);
                gp.enemy[7].enemySpeed = 8;
                gp.enemy[7].minY = 1*gp.tileSize;
                gp.enemy[7].maxY = 12*gp.tileSize-(gp.tileSize/2);

                gp.enemy[8] = new Enemy(this.gp);
                gp.enemy[8].enemyX = 9*gp.tileSize-(gp.tileSize/2);
                gp.enemy[8].enemyY = 8*gp.tileSize+(gp.tileSize/4);
                gp.enemy[8].enemySpeed = 2;
                gp.enemy[8].minX = 8*gp.tileSize;
                gp.enemy[8].maxX = 11*gp.tileSize-(gp.tileSize/2);
                break;
            case 2:
                resetEnemies(gp,0,8);
                gp.enemy[9] = new Enemy(this.gp);
                gp.enemy[9].enemyX = 8*gp.tileSize-(gp.tileSize/2);
                gp.enemy[9].enemyY = 2*gp.tileSize+(gp.tileSize/4);
                gp.enemy[9].enemySpeed = 6;
                gp.enemy[9].minX = 7*gp.tileSize;
                gp.enemy[9].maxX = 16*gp.tileSize-(gp.tileSize/2);

                gp.enemy[10] = new Enemy(this.gp);
                gp.enemy[10].enemyX = 10*gp.tileSize-(gp.tileSize/2);
                gp.enemy[10].enemyY = 4*gp.tileSize+(gp.tileSize/4);
                gp.enemy[10].enemySpeed = 6;
                gp.enemy[10].minX = 6*gp.tileSize;
                gp.enemy[10].maxX = 16*gp.tileSize-(gp.tileSize/2);

                gp.enemy[11] = new Enemy(this.gp);
                gp.enemy[11].enemyX = 15*gp.tileSize+(gp.tileSize/4);
                gp.enemy[11].enemyY = 5*gp.tileSize+(gp.tileSize/4);
                gp.enemy[11].enemySpeed = 3;
                gp.enemy[11].minY = 3*gp.tileSize;
                gp.enemy[11].maxY = 12*gp.tileSize-(gp.tileSize/2);

                gp.enemy[12] = new Enemy(this.gp);
                gp.enemy[12].enemyX = 8*gp.tileSize-(gp.tileSize/2);
                gp.enemy[12].enemyY = 8*gp.tileSize+(gp.tileSize/4);
                gp.enemy[12].enemySpeed = 6;
                gp.enemy[12].minX = 5*gp.tileSize;
                gp.enemy[12].maxX = 11*gp.tileSize-(gp.tileSize/2);
                break;
            case 3:
                resetEnemies(gp,0,12);
                break;

        }

    }
    //Function to reset enemies every time the map is refreshed.
    public void resetEnemies(GamePanel gp, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            if (i >= 0 && i < gp.enemy.length && gp.enemy[i] != null) {
                gp.enemy[i] = null;
            }
        }
    }
}
