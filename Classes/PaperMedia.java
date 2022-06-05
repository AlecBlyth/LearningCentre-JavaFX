package BunnyCorp.Classes;

public class PaperMedia extends Items { //Inherits all from Items superclass - Is Parent class of Books and Journal Classes

    private String subjectArea;
    private int numberofPages;

    public PaperMedia(int ID, String itemPublisher, String itemTitle, double Cost, int StockLevel, String type, String subject, int numOfPages) {
        super(ID, itemTitle, itemPublisher, Cost, StockLevel, type); //Adds new attributes

        subjectArea = subject;
        numberofPages = numOfPages;
    }

    @Override //Sends attributes to superclass
    public String getSubjectArea() {
        return subjectArea;
    }

    @Override
    public int getNumberofPages() {
        return numberofPages;
    }

    public void setSubjectArea(String newSubject) {
        this.subjectArea = newSubject;
    }

    public void setNumberofPages(int newPages) {
        this.numberofPages = newPages;
    }
}