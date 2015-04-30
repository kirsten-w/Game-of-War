/**
 Kirsten Wheeler
 CS 110
 Game of War
 
 Node Class
 This node class is designed especially for Card objects.
*/


public class Node 
{
   private Card card;
   private Node next;

   /**
    Constructor handles incoming card
    @param incoming card
   */ 
   
   public Node(Card c) 
   {
      card = c;
      next = null;
   }
   
   /**
    Alternate constructor handles incoming card and position
    @param incoming card
    @param position
   */ 

   public Node(Card c, Node n) 
   {
      card = c;
      next = n;
   } 
   
   /**
    The setNext method sets the next node
    @param nextNode
   */ 

   public void setNext(Node n) 
   {
      next = n;
   } 
   
   /**
    The setCard method sets the incoming card.
    @param incoming card
   */ 
   
   public void setCard(Card c) 
   {
      card = c;
   } 
   
   /**
    The getNext method returns the next node.
   */ 

   public Node getNext() 
   {
      return next;
   }  
   
   /**
    The getCard method returns a card.
    @return card
   */ 

   public Card getCard() 
   {
      return card;
   }
}