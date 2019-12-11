package carddeck.service.classes;
/*Task 2: Import necessary user defined classes*/ 
import carddeck.service.classes.CardSign;
import carddeck.service.classes.CardValue;
public class Card {
   private CardSign sign;
   private CardValue value;
   
public Card(CardSign sign, CardValue value) {   // constructor
      this.sign = sign;
      this.value = value;
   }
   
   public CardSign getSign() { return this.sign; }
   
   public CardValue getValue() { return this.value; }
   
   public String toString() { return "Card: " + this.value + " of " + this.sign; }   
   
}