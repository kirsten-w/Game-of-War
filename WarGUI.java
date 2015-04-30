/**
 Kirsten Wheeler
 CS 110
 Game of War
 
 WarGUI Class
 Plays a game of war with a GUI.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarGUI extends JFrame
{  
   private WarGUI guiGame;    
   private War game;                                                                         

   private JPanel rightPlayerPanel;           // Player                   
   private JPanel leftPlayerPanel;            // Computer
   private JPanel buttonPanel;                // Holds buttons                  
   private JPanel gamePanel;                  // Main game area
  
   private JButton playButton;     
   private JButton shuffleButton;  
   private JButton quitButton;
   
   private static JLabel backLabelLeft;       // Label for backside of card (computer)
   private static JLabel backLabelRight;      // Label for backside of card (player)              
   private static JLabel playerCardLabel;                          
   private static JLabel computerCardLabel; 
   
   private ImageIcon back;                    // Icon for backside of card
   private ImageIcon blank;                   // Place holder
   private static ImageIcon playerCard;       // Player's current card
   private static ImageIcon computerCard;     // Computer's current card
   
   private JTextField playerCardsLeft;        // Counter for player
   private JTextField computerCardsLeft;      // Counter for computer
   
   private Card playersCard;
   private Card computersCard;
   
   private String war = "n";  
   String imagePath = "cardPics/back.jpg";                              

   /**
    This constructor builds & adds panels to contentpane.
   */
   
   public WarGUI()
   {
      // Set contentPane
      setLayout(new BorderLayout());
      setTitle("Game of War");
      setSize(1100, 550);
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      
      // Build & add deck panel
      assembleGamePanel();
      add(gamePanel, BorderLayout.CENTER);      
      
      // Build & add player panels
      assembleDecksPanel();
      add(leftPlayerPanel, BorderLayout.WEST);
      add(rightPlayerPanel, BorderLayout.EAST);

      // Build & add button panel
      assembleButtonPanel();
      add(buttonPanel, BorderLayout.SOUTH);
       
      setVisible(true);
       
      // Prepare deck & Player hands
      game = new War();  
   }
   
   /**
    The PlayCardListener tracks clicks on Play Card button. Cards are 
    drawn, war status is checked, scores and images are adjusted.
   */
 
   private class PlayCardListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
            // Normal gameplay
            if (war.equals("n"))
            {
                // Play cards.
                Card playersCard = game.playerDraw();
                Card computersCard = game.computerDraw();

                // Update GUI - Player
                playerCard = new ImageIcon(playersCard.getFilepath());
                playerCardLabel.setIcon(playerCard);
                
                // Update GUI - Computer
                computerCard = new ImageIcon(computersCard.getFilepath());
                computerCardLabel.setIcon(computerCard);

                // Compare cards
                game.compareCards(playersCard, computersCard);

                // If cards are equal, set war to true
                if (playersCard.equals(computersCard))
                {
                    war = "y";
                }

                // Otherwise, update score
                if (!war.equals("y")){
                    playerCardsLeft.setText("Player's Cards: " + (game.getPlayerCardsLeft() - 1));
                    computerCardsLeft.setText("Computer's Cards: " + (game.getComputerCardsLeft() - 1));
                }
            }
            
            // First war click
            if (war.equals("y"))
            {
                // Cards played face down
                playerCard = new ImageIcon(imagePath);
                playerCardLabel.setIcon(playerCard);

                computerCard = new ImageIcon(imagePath);
                computerCardLabel.setIcon(computerCard);
                war = "midWar";
            }
            
            // Second war click
            if (war.equals("midWar"))
            {
                // Update GUI to reveal war cards
                playerCard = new ImageIcon(game.getPlayerCard());
                playerCardLabel.setIcon(playerCard);

                computerCard = new ImageIcon(game.getComputerCard());
                computerCardLabel.setIcon(computerCard);
                war = "endWar";
            }
      
            // End war, update scores
            if (war.equals("endWar"))
            {  
                playerCardsLeft.setText("Player's Cards: " + (game.getPlayerCardsLeft() - 1));
                computerCardsLeft.setText("Computer's Cards: " + (game.getComputerCardsLeft() - 1));           
                war = "n";
            }
        }
   }
   
   /**
    The shuffleListener tracks clicks on Shuffle button. Deck is 
    shuffled.
   */
 
   private class shuffleListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.out.println("Shuffling deck...");
      }
   }   
   
   /**
    The quitListener tracks clicks on Quit button. Results are 
    displayed and program quits.
   */
 
   private class quitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         game.endGame();
      }
   }    
   
   /**
    The assembleGamePanel builds the gamePanel - the main deck area, 
    where cards are displayed.
   */
     
   private void assembleGamePanel()
   {
      // Place holder for cards
      blank = new ImageIcon();
      playerCardLabel = new JLabel(blank);
      computerCardLabel = new JLabel(blank);
      
      // Add labels to cardPanel 
      gamePanel = new JPanel();
      gamePanel.add(computerCardLabel);
      gamePanel.add(playerCardLabel);
      gamePanel.setPreferredSize(new Dimension(545, 540));
      gamePanel.setBackground(new Color(0, 64, 0));
   }
   
   /**
    The assembleDecksPanel method builds the panel that displays the 
    players' cardpiles.
   */
     
   private void assembleDecksPanel()
   {
      // Icons of card backside
      back = new ImageIcon(imagePath);

      // Add icons
      backLabelLeft = new JLabel();
      backLabelLeft.setIcon(back);
      JLabel backLabelRight = new JLabel();
      backLabelRight.setIcon(back);

      // Add labels to panels
      // Right
      rightPlayerPanel = new JPanel();
      rightPlayerPanel.setPreferredSize(new Dimension(150,220));
      rightPlayerPanel.add(backLabelRight);
      rightPlayerPanel.setBackground(new Color(0, 64, 0));
      playerCardsLeft = new JTextField("Player's Cards: 26", 13);
      playerCardsLeft.setEditable(false);
      rightPlayerPanel.add(playerCardsLeft);
       
      // Left 
      leftPlayerPanel = new JPanel();
      leftPlayerPanel.setPreferredSize(new Dimension(150,220));
      leftPlayerPanel.add(backLabelLeft);
      leftPlayerPanel.setBackground(new Color(0, 64, 0));
      computerCardsLeft = new JTextField("Computer's Cards: 26", 13); 
      computerCardsLeft.setEditable(false);
      leftPlayerPanel.add(computerCardsLeft);
        
   }
   
   /**
    The assembleButtonPanel method adds buttons to button panel.
   */
      
   private void assembleButtonPanel()
   {
      // Create panel
      buttonPanel = new JPanel();
      buttonPanel.setBackground(new Color(0, 64, 0));
      
      // Create & add buttons
      // Play Button
      JButton playCardButton = new JButton("Play");
      playCardButton.setPreferredSize(new Dimension(150,80));
      buttonPanel.add(playCardButton);
      
      // Shuffle Button
      JButton shuffleButton = new JButton("Shuffle");
      shuffleButton.setPreferredSize(new Dimension(150, 80));
      buttonPanel.add(shuffleButton);
      
      // Quit Button
      JButton quitButton = new JButton("Quit");
      quitButton.setPreferredSize(new Dimension(150, 80));
      buttonPanel.add(quitButton);
      
      // Add event listeners for the buttons.
      playCardButton.addActionListener(new PlayCardListener());
      shuffleButton.addActionListener(new shuffleListener());
      quitButton.addActionListener(new quitListener());
   }     

   /**
    The main method begins the GUI deck.
   */
   
   public static void main(String[] args) 
   {
       WarGUI guiGame = new WarGUI();
   } 
}