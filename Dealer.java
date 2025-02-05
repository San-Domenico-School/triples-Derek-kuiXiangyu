import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import greenfoot.*;

public class Dealer
{
    private Deck deck;  // The deck the dealer uses to deal cards
    private ArrayList<Card> cardsOnBoard;  // Cards that are currently on the board
    private ArrayList<Integer> selectedCardsIndex;  // Indices of the selected cards on the board
    private Card[] cardsSelected;  // Array of selected cards for a triple
    private int numCardsInDeck;  // Number of cards in the deck
    private int triplesRemaining;  // Number of triples remaining in the deck

    public Dealer(int numOfCardsInDeck)
    {
        this.numCardsInDeck = numOfCardsInDeck;
        this.triplesRemaining = numOfCardsInDeck / 3;  // Assuming triples = total cards / 3
        this.deck = new Deck(numOfCardsInDeck);  // Initialize the deck with the given number of cards
        this.cardsSelected = new Card[3];  // Initialize the selected cards array
        this.cardsOnBoard = new ArrayList<>();  // List to hold cards that are currently on the board
        this.selectedCardsIndex = new ArrayList<>();  // List for selected card indices
    }

    // Shuffle the deck
    public void shuffleDeck()
    {
        deck.createShuffledDeck();  // Shuffle the deck
    }

    // Draw a card from the deck
    public Card drawCard()
    {
        Card card = deck.getTopCard();  // Get the top card from the shuffled deck
        if (card != null)
        {
            cardsOnBoard.add(card);  // Add the drawn card to the cards on the board
        }
        return card;  // Return the drawn card
    }

    // Deal a certain number of cards to the board (5 rows of 3 columns)
    public void dealBoard()
    {
        Greenfoot.playSound("shuffle.mp3");  // Play shuffle sound

        for (int row = 0; row < 5; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                Card card = drawCard();  // Draw the next card
                if (card != null)
                {
                    int x = 100 + col * 100;  // X position for the column
                    int y = 100 + row * 100;  // Y position for the row
                    getWorld().addObject(card, x, y);  // Add the card to the world at the calculated position
                }
            }
        }
    }

    // Set the UI for the game (cards remaining, score, etc.)
    public void setUI()
    {
        // Update the UI with the current number of cards remaining
        Label remainingLabel = new Label("Cards Remaining: " + cardsLeftInDeck(), 30);
        getWorld().addObject(remainingLabel, 50, 50);  // Place the label in the top-left corner

        // Display the score (for now it's 0, this will be updated later)
        Label scoreLabel = new Label("Score: 0", 30);
        getWorld().addObject(scoreLabel, 50, 100);  // Place the score below the remaining cards
    }

    // Method to get the number of cards left in the deck
    public int cardsLeftInDeck()
    {
        return deck.getNumCardsInDeck();  // Return how many cards remain in the deck
    }

    // Method to check if a selected triple exists
    public void checkIfTriple()
    {
        // Check if the selected cards form a valid triple (this will depend on your game logic)
        if (cardsSelected[0] != null && cardsSelected[1] != null && cardsSelected[2] != null)
        {
            // Assuming the logic for a valid triple is implemented here
            if (isTriple(cardsSelected))
            {
                actionIfTriple();  // Take action if it's a valid triple (e.g., score points, remove cards, etc.)
            }
        }
    }

    // Helper method to check if the selected cards form a triple (game-specific logic)
    private boolean isTriple(Card[] selectedCards)
    {
        // Example logic for checking if 3 cards form a triple (you can modify this)
        return selectedCards[0].equals(selectedCards[1]) && selectedCards[1].equals(selectedCards[2]);
    }

    // Method to handle the action after finding a valid triple (e.g., remove cards from the board)
    public void actionIfTriple()
    {
        // Remove the selected cards from the board
        for (Card card : cardsSelected)
        {
            if (card != null)
            {
                getWorld().removeObject(card);  // Remove the card from the world
                cardsOnBoard.remove(card);  // Remove the card from the list of cards on the board
            }
        }

        // Update the number of triples remaining
        triplesRemaining--;

        // Update the UI (score, remaining cards, etc.)
        setUI();
    }

    // Set the selected cards for the current turn (called when player selects cards)
    public void setCardsSelected(ArrayList<Card> cards, ArrayList<Integer> indices, Card[] selectedCards)
    {
        // Update the selected cards and their indices
        for (int i = 0; i < 3; i++)
        {
            this.cardsSelected[i] = cards.get(i);  // Store the selected cards
            this.selectedCardsIndex.add(indices.get(i));  // Store the indices of the selected cards
        }
    }

    // Method to reset the deck and start a new game
    public void resetDeck(int numOfCardsInDeck)
    {
        deck = new Deck(numOfCardsInDeck);  // Recreate the deck with the given number of cards
        cardsOnBoard.clear();  // Clear the list of cards on the board
        dealtCards.clear();  // Clear the list of dealt cards
        triplesRemaining = numOfCardsInDeck / 3;  // Reset the number of triples remaining
        setUI();  // Reset the UI
    }

    // Method to add the Dealer to the world (called when the dealer is added to the world)
    public void addedToWorld(World world)
    {
        dealBoard();  // Deal the cards to the board
        setUI();  // Set up the UI
    }
}



