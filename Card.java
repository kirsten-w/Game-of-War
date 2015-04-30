/**
 Kirsten Wheeler
 CS 110
 Game of War
 
 Card Class
 This class represents a playing card from a standard 52 card deck.
 It keeps track of card suit and rank/value.
*/


public class Card 
{      
    // Suits
    private int suit;                           
    public final static int SPADES = 1;
    public final static int HEARTS = 2;
    public final static int DIAMONDS = 3;
    public final static int CLUBS = 4;
   
    // Ranks
    private int rank; 
    public final static int JACK = 11;       
    public final static int QUEEN = 12;       
    public final static int KING = 13;
    public final static int ACE = 14; 
   
    public String cardFilepath;                             
                             
    /**
     The constructor initializes the card's rank and suit.
     @param rank
     @param suit
    */
   
    public Card(int rank, int suit) 
    {
        this.rank = rank;
        this.suit = suit;     
        cardFilepath = "cardpics/" + getSuitAsCapsString() + rank + ".jpg";
    }
   
    /**
     The other constructor initializes the card's rank and suit.
     @param otherCard to be copied
    */ 
     
    public Card(Card otherCard) 
    {
        this.rank = otherCard.rank;
        this.suit = otherCard.suit;
        cardFilepath = "cardpics/" + getSuitAsCapsString() + rank + ".jpg";
    }
    
    /**
     The getRank method returns the int that represents the card's rank.
     @return card's rank
    */
  
    public int getSuit() 
    {
        return suit;
    }
   
    /**
     The getRank method returns the int that represents the card's rank.
     @return card's rank
    */

    public int getRank() 
    {
        return rank;
    }
   
    /**
     The toString method returns the card as a string.
    */

    public String toString() 
    {
        return getRankAsString() + " of " + getSuitAsString();
    }
    
    /**
     The getSuitString method returns the card's suit as a string. Used for game output.
     @return suitString
    */
   
    public String getSuitAsString() 
    {
       switch (suit)
       {
           case SPADES:   return "Spades";
           case HEARTS:   return "Hearts";
           case DIAMONDS: return "Diamonds";
           case CLUBS:    return "Clubs";
           default:       return "Invalid";
       }
    }
   
    /**
     The getSuitAsCapsString method returns the card's suit as a string in all caps. Used for image file retrieval. 
     @return suitString
    */
   
    public String getSuitAsCapsString() 
    {
       switch (suit)
       {
           case SPADES:   return "SPADES";
           case HEARTS:   return "HEARTS";
           case DIAMONDS: return "DIAMONDS";
           case CLUBS:    return "CLUBS";
           default:       return "?";
       }
    }
      
    /**
     The getRankString method returns the card's rank.
     @return rank
    */
   
    public String getRankAsString() 
    {
       switch (rank) 
       {
           case 2:    return "2";
           case 3:    return "3";
           case 4:    return "4";
           case 5:    return "5";
           case 6:    return "6";
           case 7:    return "7";
           case 8:    return "8";
           case 9:    return "9";
           case 10:   return "10";
           case 11:   return "Jack";
           case 12:   return "Queen";
           case 13:   return "King";
           case 14:   return "Ace";
           default:   return "?";
       }
    }
    
    /**
     The equals method compares the rank of the card to the rank of
     another card. If they are the same, the method returns true.
     @return boolean
    */
   
    public boolean equals(Card otherCard) 
    {
        return rank == otherCard.rank;
    }

    /**
     Returns the .jpg image of card
     @return path to image
    */
   
    public String getFilepath() 
    {
       return cardFilepath;
    }
}
    


