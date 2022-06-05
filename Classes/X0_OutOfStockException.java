package BunnyCorp.Classes;

public class X0_OutOfStockException extends Exception { //Custom Exception called when item is out of stock //Inherits from Exception
    public X0_OutOfStockException(String message) {
        super(message);
    } //Sends message
}