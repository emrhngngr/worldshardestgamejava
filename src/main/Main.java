package main;



import forms.MainMenu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Create window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("RedAlert");
        //Start Main Menu
        MainMenu mainMenu = new MainMenu(window);
    }
}
