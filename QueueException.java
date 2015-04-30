/**
 Kirsten Wheeler
 CS110
 Game of War
 
 QueueException
 Exception thrown if queue of cards is empty. 
*/

public class QueueException extends RuntimeException 
{
   public QueueException(String s) 
   {
      super(s);
   } 
}  