package main;

public class LevelHandler {
    //Function to access the current level from other classes and to set the current level
    public int currentLevel = 0;

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void levelUp() {
        currentLevel++;
    }

}
