package BunnyCorp.Classes;

public class Loans implements java.io.Serializable {

    private int loanID;
    private int whoLoaned;
    private int loanDuration;
    private double loanCost;
    private int whatLoaned;

    public Loans(int ID, int who, int duration, double cost, int what) { //Attributes
        loanID = ID;
        whoLoaned = who;
        loanDuration = duration;
        loanCost = cost;
        whatLoaned = what;

    }

    public int getLoanID() { //Gets Loan ID
        return loanID;
    }

    public int getWhoLoaned() { //Gets who loaned item
        return whoLoaned;
    }

    public int getLoanDuration() { //Gets the loan duration
        return loanDuration;
    }

    public double getLoanCost() { //Gets the total cost of loan
        return loanCost;
    }

    public int getWhatLoaned() {
        return whatLoaned;
    } //Gets what item is loaned
}