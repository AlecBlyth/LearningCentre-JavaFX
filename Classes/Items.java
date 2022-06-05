package BunnyCorp.Classes;

abstract public class Items implements java.io.Serializable { //Superclass of Paper Media and Digital Media

    private int StockID;
    private int ItemStock;
    private double CostPrice;
    private String Publisher;
    private String Title;
    private String itemType;

    private int runningTime;
    private String TypeOfStorage;

    private String videoFormat;
    private String Genre;

    private String CDFormat;
    private String CDArtist;
    private int numberOfTracks;

    private String subjectArea;
    private int numberofPages;

    private String ISBN;
    private String Author;

    private String IssueDate;
    private String ISSN;
    private int IssueNumber;

    public Items(int ID, String itemTitle, String itemPublisher, double Cost, int StockLevel, String type) { //Attributes
        StockID = ID;
        Title = itemTitle;
        Publisher = itemPublisher;
        CostPrice = Cost;
        ItemStock = StockLevel;
        itemType = type;
    }

    //Default Object Getters
    public int getStockID() {
        return StockID;
    }
    public String getTitle() {
        return Title;
    }
    public String getPublisher() {
        return Publisher;
    }
    public double getCostPrice() {
        return CostPrice;
    }
    public int getItemStock() {
        return ItemStock;
    }
    public String getItemType() {
        return itemType;
    }

    //Digital Object Getters
    public int getRunningTime() {
        return runningTime;
    }
    public String getTypeOfStorage() {
        return TypeOfStorage;
    }

    //Video Object Getters
    public String getVideoFormat() {
        return videoFormat;
    }
    public String getGenre() {
        return Genre;
    }

    //CD Object Getters
    public String getCDFormat() {
        return CDFormat;
    }
    public int getNumberOfTracks() {
        return numberOfTracks;
    }
    public String getCDArtist() {
        return CDArtist;
    }

    //Paper Object Getters
    public String getSubjectArea() {
        return subjectArea;
    }
    public int getNumberofPages() {
        return numberofPages;
    }

    //Book Object Getters
    public String getAuthor() {
        return Author;
    }
    public String getISBN() {
        return ISBN;
    }

    //Journal Object Getters
    public String getISSN() {
        return ISSN;
    }
    public int getIssueNumber() {
        return IssueNumber;
    }
    public String getIssueDate() {
        return IssueDate;
    }

    //Default Object Setters
    public void setTitle(String newTitle) {
        this.Title = newTitle;
    }
    public void setPublisher(String newPublisher) {
        this.Publisher = newPublisher;
    }
    public void setCostPrice(Double newPrice) {
        this.CostPrice = newPrice;
    }
    public void setItemStock(int newStock) {
        this.ItemStock = newStock;
    }

    //Digital Object Setters
    public void setRunningTime(int newRuntime) {
        this.runningTime = newRuntime;
    }
    public void setTypeOfStorage(String newStorage) {
        this.TypeOfStorage = newStorage;
    }

    //Video Object Setters
    public void setVideoFormat(String newVideoFormat) {
        this.videoFormat = newVideoFormat;
    }
    public void setGenre(String newGenre) {
        this.Genre = newGenre;
    }

    //CD Object Setters
    public void setCDFormat(String newCDFormat) {
        this.CDFormat = newCDFormat;
    }
    public void setNumberOfTracks(int newNumTracks) {
        this.numberOfTracks = newNumTracks;
    }
    public void setCDArtist(String newArtist) {
        this.CDArtist = newArtist;
    }

    //Paper Object Setters
    public void setSubjectArea(String newSubject) {
        this.subjectArea = newSubject;
    }
    public void setNumberofPages(int newPages) {
        this.numberofPages = newPages;
    }

    //Book Object Setters
    public void setAuthor(String newAuthor) {
        this.Author = newAuthor;
    }
    public void setISBN(String newISBN) {
        this.ISBN = newISBN;
    }

    //Journal Object Setters
    public void setISSN(String newISSN) {
        this.ISSN = newISSN;
    }
    public void setIssueNumber(int newIssue) {
        this.IssueNumber = newIssue;
    }
    public void setIssueDate(String newIssueDate) {
        this.IssueDate = newIssueDate;
    }
}