/**
 Kirsten Wheeler
 CS 110
 Game of War
 
 Cardpile Class
 Represents a queue based cardpile.
*/

public class Cardpile 
{
   private Node lastNode;

   public Cardpile() 
   {
      lastNode = null;
   }  
  
   /** 
    Determines whether or not a queue is empty.
    @return boolean
   */
  
   public boolean isEmpty() 
   {
      return lastNode == null;
   }  
  
   /**
    The addCard method adds a card to the pile.
   */
  
   public void addCard(Card c) 
   {
      Node temp = new Node(c);
      if (isEmpty()) 
      {
         temp.setNext(temp);
      }
      else 
      {
         temp.setNext(lastNode.getNext());
         lastNode.setNext(temp);
      }  

      lastNode = temp;
   

   } 
   
   /**
    The playCard method returns the card at the front of the pile.
    @return c
   */ 
  
   public Card playCard() throws QueueException 
   {
      if (!isEmpty()) 
      {
         Node firstNode = lastNode.getNext();
         if (firstNode == lastNode)
         { 
           lastNode = null; 
         }
      
         else 
         {
           lastNode.setNext(firstNode.getNext());
         } 
       
         return firstNode.getCard();
      }
   
      else 
      {
         throw new QueueException("Queue is empty.");
      } 
   }  

   /**
    The getSize method returns the size of the pile.
    @return size
   */
     
   public int getSize()
   {
      int size = 1;
     
      if (isEmpty())
      {
          return size;
      }
      
      else
      {
          size = 2;
          Node firstNode = lastNode;
          Node nextNode = firstNode.getNext();
    
          while (nextNode!= null && nextNode != firstNode)
          {
              size += 1;
              nextNode = nextNode.getNext();
          }
      }

      return size;
   }
} 
