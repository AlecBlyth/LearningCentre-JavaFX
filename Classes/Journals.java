package BunnyCorp.Classes;

public class Journals extends PaperMedia { //Inherits from Paper Media

    private String IssueDate;
    private String ISSN;
    private int IssueNumber;

    public Journals(int ID, String journal_ISSN, String itemTitle, double Cost, String subject, String itemPublisher, int IssueNum, String DateOfIssue, int numOfPages, int StockLevel, String type) {
        super(ID, itemPublisher, itemTitle, Cost, StockLevel, type, subject, numOfPages); //Adds new attributes
        IssueDate = DateOfIssue;
        ISSN = journal_ISSN;
        IssueNumber = IssueNum;
    }

    @Override
    public String getIssueDate() {
        return IssueDate;
    } //Overrides and sends data to superclass

    @Override
    public String getISSN() {
        return ISSN;
    }

    @Override
    public int getIssueNumber() {
        return IssueNumber;
    }

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