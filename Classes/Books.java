package BunnyCorp.Classes;

public class Books extends PaperMedia { //Inherits attributes from PaperMedia class

    private String ISBN;
    private String Author;
    public Books(int ID,  String bookISBN, String bookAuthor, String itemTitle, double Cost, String subject, String itemPublisher, int numOfPages, int StockLevel, String type) {
        super(ID, itemPublisher, itemTitle, Cost, StockLevel, type, subject, numOfPages); //Adds inherited attributes and adds new ones

        ISBN = bookISBN;
        Author = bookAuthor;
    }
    @Override
    public String getAuthor() {
        return Author;
    } //Overrides and sends data to superclass
    @Override
    public String getISBN() {
        return ISBN;
    }

    public void setAuthor(String newAuthor) {
        this.Author = newAuthor;
    }
    public void setISBN(String newISBN) {
        this.ISBN = newISBN;
    }
}