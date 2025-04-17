package main;

import db.UserHandler;
import entity.Enemy;
import entity.Player;
import forms.WinPanel;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //Determine the tilesize to 16x16 pixels and multiply it by 3. This is because the original tilesize can be changed in the future.
    final int originalTileSize = 16; //16x16
    final int scale = 3;

    public final int tileSize = originalTileSize * scale-2; //48x48
    //Split the screen into 20 columns and 13 rows.
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 13;
    public final int screenWidth = tileSize * maxScreenCol; //768 Pixels
    public final int screenHeight = tileSize * maxScreenRow; //576 Pixels
    public boolean isGameOverChecked = false; //Game over?

    public KeyHandler keyH = new KeyHandler(); // Key detection class for the game's WASD keys to work
    Thread gameThread = new Thread(); //A Thread was created to start the game
    Player player = new Player(this,keyH); //The player class was read and the detected key values were assigned to this class.
    public Enemy enemy[] = new Enemy[20]; //An array of enemy classes with a capacity of up to 20 enemies was created (Can be increased if desired)
    AssetSetter assetSetter = new AssetSetter(this); //Created assetSetter class to place enemies on the map
    public LevelHandler levelHandler = new LevelHandler(); // Created to handle level events such as level changes
    TileManager tileManager = new TileManager(this); // Created to draw 20 rows and 13 columns on the map.
    public UI ui = new UI(this); // Created for UI events
    public CollesionChecker cChecker = new CollesionChecker(this); // Created to detect any two objects colliding with each other.
    public UserHandler userHandler = new UserHandler(); //Created to manage user events.
    public String username;// Variable to share the login's username with other classes.

    public GamePanel(String username) {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground((Color.black));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.username = username;
    }

    public void setupGame(){ //Prepares the game
            assetSetter.setEnemy(this);  // Places enemies
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start(); //Starts the game.
    }
    int FPS = 60; //Variable to determine how many fps(frame per second) the game is

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS; // Draws every 0.01666 seconds
        double delta = 0;
        long lastTime = System.nanoTime(); // We set the final time equal to the system time.
        long currentTime; // Current time
        long timer = 0; // Counter
        int drawCount = 0;  //Drawing counter

        while (gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1){
                update(); // Update function is refreshed 60 times every second.
                repaint(); // Repaint function
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                //If you want to see FPS:
                //System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }

    }
    // Updates the game state
    public void update(){
        if (keyH.pausePressed != true){
            //PLAYER
            player.update();

            //ENEMIES
            if (cChecker.getgameStatus() == 1) {
                for (int i = 0; i < enemy.length; i++) {
                    if (enemy[i] != null) {
                        if (i == 7) {
                            enemy[i].update("y");
                        } else if (i == 11) {
                            enemy[i].update("y");
                        } else{
                            enemy[i].update("x");
                        }
                    }
                }
            }
        }




    }
    // Draws game components
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
        JFrame jf = new JFrame();

        if (player.onWin){
            if (this.levelHandler.getCurrentLevel() == 0){

                tileManager.loadMap("/maps/map02.txt");
                this.levelHandler.setCurrentLevel(1);
                setupGame();
                player.onWin = false;
            }else if (this.levelHandler.getCurrentLevel() == 1){
                tileManager.loadMap("/maps/map03.txt");
                this.levelHandler.setCurrentLevel(2);
                setupGame();
                player.onWin = false;
            }else if (this.levelHandler.getCurrentLevel() == 2){
                tileManager.loadMap("/maps/map04.txt");
                this.levelHandler.setCurrentLevel(3);
                setupGame();
                player.onWin = false;
            }else if (this.levelHandler.getCurrentLevel() == 3){
                closeWindow();
                WinPanel winPanel = new WinPanel(this);
                winPanel.setLocationRelativeTo(this);
                player.onWin = false;
            }
        }

        player.draw(g2);

        //Enemy
        for (int i = 0; i<enemy.length; i++){
            if (enemy[i]!=null){
                enemy[i].draw(g2);
            }
        }

        //UI
        ui.draw(g2);

        g2.dispose();
    }
    // Restarts the game
    public void retry(){
        closeWindow();
        JFrame newWindow = new JFrame();
        GamePanel newGamePanel = new GamePanel(username);
        newGamePanel.levelHandler.setCurrentLevel(0);
        newWindow.add(newGamePanel);
        newWindow.pack();
        newWindow.setLocationRelativeTo(null);
        newWindow.setVisible(true);

        newGamePanel.setupGame();
        newGamePanel.startGameThread();
    }
    //Function to close the window
    public void closeWindow(){
        JFrame currentWindow = (JFrame) SwingUtilities.getWindowAncestor(this);
        currentWindow.dispose();
    }
}
