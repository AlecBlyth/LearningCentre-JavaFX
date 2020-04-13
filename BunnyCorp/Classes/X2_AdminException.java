package BunnyCorp.Classes;

public class X2_AdminException extends Exception { //Custom exception called when trying to return placeholder loan //Inherits from Exception
    public X2_AdminException(String message) {
        super(message);
    } //Displays a message
}