/**
 * Write a description of class Animations here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;  // Import Greenfoot packages

public class Animations {
    // Author: [Your Name]
    // Date: [Today's Date]

    // Method to play the wobble sound
    public static void wobble(Card[] cards) {
        Greenfoot.playSound("wobble.wav");
    }

    // Method to play the slide and turn sound
    public static void slideAndTurn(Card[] cards) {
        Greenfoot.playSound("swoosh.wav");
    }
}

