package BetterThanPaint;

import java.awt.*;


public class MainGUILoader {

    public static void main(String[] args) {

        //Replace with lambda
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Debug names
                MainJframe mainWindow = new MainJframe();

                // This way to change the title or pass it to the constructor
                mainWindow.setTitle("Better than Paint");

                mainWindow.setPreferredSize(new Dimension(1000,600));
                //Set Close Operation
                mainWindow.setDefaultCloseOperation(mainWindow.EXIT_ON_CLOSE);

            }

        });

        // jmenubar
        // buffered imaged
        // change font and size color
        // jsliders
    }
}
