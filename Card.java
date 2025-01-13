import greenfoot.*; 

/**
 * Game Board for Triples
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.GreenfootImage;
import greenfoot.Actor;

import greenfoot.*;  // Import Greenfoot packages

public class Card extends Actor {
    // Enum for Shape
    public enum Shape {
        CIRCLE, SQUARE, TRIANGLE, NO_SHAPE
    }

    // Enum for Color
    public enum Color {
        RED, GREEN, BLUE, NO_COLOR
    }

    // Fields for the card
    private Shape shape;
    private Color color;
    private boolean isSelected;
    private GreenfootImage cardImage, selectedCardImage;
    private int numberOfShapes, shading;

    // Constructor
    public Card(Shape shape, Color color, int numberOfShapes, int shading, GreenfootImage cardImage, GreenfootImage selectedCardImage) {
        this.shape = shape;
        this.color = color;
        this.numberOfShapes = numberOfShapes;
        this.shading = shading;
        this.cardImage = cardImage;
        this.selectedCardImage = selectedCardImage;
        this.isSelected = false;  // Default value for isSelected
        setImage(cardImage);      // Set the initial image for the card
    }

    // Getter methods
    public Shape getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public int getNumberOfShapes() {
        return numberOfShapes;
    }

    public int getShading() {
        return shading;
    }

    public GreenfootImage getCardImage() {
        return cardImage;
    }

    public GreenfootImage getSelectedCardImage() {
        return selectedCardImage;
    }

    // Rename 'isSelected()' to 'getIsSelected()' to match the Tester
    public boolean getIsSelected() {
        return isSelected;
    }

    // Setter for isSelected
    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
        // Change image if the card is selected or not
        if (isSelected) {
            setImage(selectedCardImage); // Use selected image
        } else {
            setImage(cardImage); // Use the default image
        }
    }
}




