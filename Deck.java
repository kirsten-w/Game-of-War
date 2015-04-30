/**
 Kirsten Wheeler
 CS 110
 Game of War
 
 Deck Class
 This class contains an array of 52 Card objects. It holds the numbers of cards in
 the deck, and also has shuffle, deal and getSize methods.
*/

import java.util.*;
import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    // Create ArrayList of cards
    int numCards = 52;
    private ArrayList<Card> deck = new ArrayList<Card>(numCards);

    /**
     The constructor creates a deck of 52 cards.
    */
    
    public Deck()
    {
        fillDeck();
        shuffle();
    }
    
    /**
     The shuffle method shuffles the deck.
    */
   
    public void shuffle()
    {
        ArrayList<Card> temp = new ArrayList<Card>();
        while(!deck.isEmpty()) 
        {
            int loc = (int)(Math.random() * deck.size());
            temp.add(deck.get(loc));
            deck.remove(loc);   
        }
        deck = temp;
    }

    /**
     Adds cards (in order) to a deck.
    */
    
    public void fillDeck()
    {
        for (int q = 2; q <= 14;q++)      // 14 cards in each suit
        {
            for (int n = 1;n <= 4;n++)
            {
                deck.add(new Card(q,n));
            }
        }
    }

    /**
     The deal method deals to the players.
     @return updated deck
    */
   
    public Card deal()
    {
        if(numCards == 0)
        {
           return null;
        }
        Card c = deck.remove(0); 
        return c;
    }

    /**
     The getSize method returns the size of the deck
     @return numCards in deck
    */
   
    public int getSize()
    {
        return numCards;
    }


    /**
     Checks if the deck still has cards
     @return boolean
    */
    
    public boolean isEmpty()
    {
        return (deck.size() == 0);
    }
}