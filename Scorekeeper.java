/**
 * Write a description of class Scorekeeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scorekeeper {
    // Author: [Your Name]
    // Date: [Today's Date]

    // Fields
    private static int deckSize;
    private static int score;
    private static long startTime;

    // Constructor
    static {
        startTime = System.currentTimeMillis();  // Initialize startTime
    }

    // Setter for deckSize
    public static void setDeckSize(int deckSize) {
        Scorekeeper.deckSize = deckSize;
    }

    // Setter for updating score
    public static void updateScore() {
        // Increase score based on some condition. For example:
        score += 15;  // Add 10 points each time updateScore is called.
    }

    // Getter for score
    public static int getScore() {
        return score;
    }
}
