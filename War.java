/**
 Kirsten Wheeler
 CS 110
 Game of War
 
 War Class
 Plays a game of war.
*/

import java.util.ArrayList;
import javax.swing.*;

public class War
{   
    private Card playerWarCard;
    private Card computerWarCard;
    private Card unseenPlayerCard;
    private Card unseenComputerCard;
    
    private Cardpile player = new Cardpile();
    private Cardpile computer = new Cardpile();
    
    private boolean war = false;

    /**
     Constructor prepares, shuffles deck then deals to players.
    */
   
    public War()
    {
        Deck deck = new Deck();
        deck.shuffle();
        dealPlayer(deck);
    }
    
   /**
    The compareCards method compares rank of card to 
    determine winner
    @param playerCard
    @param computerCard
   */
   
    public void compareCards(Card playerCard, Card computerCard)
    {
       if (playerCard.getRank() > computerCard.getRank())
       {
           player.addCard(playerCard);
           player.addCard(computerCard);

           System.out.println("Player's card: " + playerCard.toString() + "\nComputer's card: " + 
                                 computerCard.toString() + "\nYou win!");                  
       }
            
       else if (playerCard.getRank() < computerCard.getRank())
       {
           computer.addCard(playerCard);
           computer.addCard(computerCard);
              
           System.out.println("Your card: " + playerCard.toString() + "\nComputer's card: " + 
                                 computerCard.toString() + "\nYou lose.");
       }

       else // Cards are equal, war
       {
           war = true;
           System.out.println("Your card: " + playerCard.toString() + "\nComputer's card: " + computerCard.toString() + "\n\n\tWar!\n\n");
           beginWar(playerCard, computerCard);
       }
    }

    /**
     The beginWar method draws war cards, then compares to determine the winner of the war.
     @param playerCard
     @param computerCard
    */
   
    public void beginWar(Card playerCard, Card computerCard)
    {
       // Prize cards 
       unseenPlayerCard = player.playCard();
       unseenComputerCard = computer.playCard();
              
       // Determine winner
       playerWarCard = player.playCard();
       computerWarCard = computer.playCard();
       
       // If player wins...
       if (playerCard.getRank() > computerCard.getRank())
       {
           player.addCard(playerCard);
           player.addCard(computerCard);
           player.addCard(unseenPlayerCard);
           player.addCard(unseenComputerCard);
           
           //update counter!!

           System.out.println("Player's card: " + playerCard.toString() + "\nComputer's card: " +  computerCard.toString() + "\nPlayer wins!");
       }
     
       // If computer wins...
       else if (playerCard.getRank() < computerCard.getRank())
       {
         computer.addCard(playerCard);
         computer.addCard(computerCard);
         computer.addCard(unseenPlayerCard);
         computer.addCard(unseenComputerCard);
       
         System.out.println("Your card: " + playerCard.toString() + "\nComputer's card: " + computerCard.toString() + "\nPlayer loses.");

       }
   }


    /**
     The dealPlayer method assigns half of a 52 card deck to 
     each player.
     @param deck to be dealt
    */

    public void dealPlayer(Deck d)
    {
        for (int q = 0; q < 26; q++)
        {
            player.addCard(d.deal());
            computer.addCard(d.deal());
        }
    }
    
   /**
    The playerCardsLeft method returns the number of cards in
    the players's hand.
    @return player hand size
   */
   
   public int getPlayerCardsLeft()
   {
       return player.getSize();
   }

   /**
    The computerCardsLeft method returns the number of cards in
    the computer's hand.
    @return computer hand size
   */
   
   public int getComputerCardsLeft()
   {
       return computer.getSize();
   }

   
   /**
    The playerDraw method draws the next card in the player's pile.
    @return card
   */
   
   public Card playerDraw()
   {
       if (player.getSize() < 1)  
       {
          endGame();
       }
       
       return player.playCard(); 
   }

   /**
    The computerDraw method draws the next card in the computer's pile.
   */
   
   public Card computerDraw()
   {   
       if (computer.getSize() < 1)
       {
          endGame();
       }

       return computer.playCard();
   }

   /**
    The getPlayerCard method returns the image path of
    the computer's card for the GUI.
    @return filepath
   */
   
   public String getPlayerCard() 
   {
       return playerWarCard.getFilepath();  
   }
    
   /**
    The getComputerCard method returns the image path of
    the computer's card for the GUI.
    @return filepath
   */
   
   public String getComputerCard()
   {
       return computerWarCard.getFilepath();
   }

   /**
    The endGame method displays the results and quits the game.
   */
   
    public void endGame()
    {
       if (player.getSize() > computer.getSize())
       {
           System.out.println("Player wins the game!");
       }
       
       else if (computer.getSize() > player.getSize())
       {
           System.out.println("Computer wins the game.");
       }
       
       else
       {
           System.out.println("Tie game.");
       }
       
       System.exit(0);
    }
}
