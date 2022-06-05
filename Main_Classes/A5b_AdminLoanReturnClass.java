package BunnyCorp.Main_Classes;

import BunnyCorp.Classes.Items;
import BunnyCorp.Classes.Loans;
import BunnyCorp.Classes.Users;
import BunnyCorp.Classes.X2_AdminException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import static java.lang.System.out;

public class A5b_AdminLoanReturnClass {

    //FXML Components

    public TextField txtID;
    public TextField txtCost;
    public TextField txtDays;
    public TextArea txtAreaLoans;
    public Label lblEmpty;
    public Label lblOverdue;

    public ArrayList<Users<String>> myUsers; //User array
    public ArrayList<Items> myItems; //Item array
    public ArrayList<Loans> myLoans; //Loan array

    private Locale locale = new Locale("en", "GB"); //Sets localisation
    private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale); //Sets currency to Pound Stirling
    private String newLine = System.getProperty("line.separator"); //Creates new line

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    } //Gets users from class

    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    } //Gets items from class

    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    } //Gets loan from class

    //Return loan variables
    private int readStockID;
    private int readLoanID;
    private int loanDays;
    private double loanCost;
    private int currentLoanID;
    private int currentStockID;

    public void selectLoans() throws X2_AdminException {

        txtAreaLoans.clear(); //Clears textarea

        getUsers(myUsers); //Gets data
        getItems(myItems);
        getLoans(myLoans);

        for (Loans aGetLoans : myLoans) { //For each loan in loan array
            for (Users aGetUsers : myUsers) { //For each user in user array
                for (Items aGetItems : myItems) { //For each item in item array
                    if (myLoans != null) {
                        readLoanID = aGetLoans.getLoanID();
                        int readUserID = aGetUsers.getUserID();
                        readStockID = aGetItems.getStockID();
                        loanDays = aGetLoans.getLoanDuration();
                        loanCost = aGetLoans.getLoanCost();
                        if (txtID.getText().equals(String.valueOf(aGetLoans.getLoanID())) && readUserID == aGetLoans.getWhoLoaned() && readStockID == aGetLoans.getWhatLoaned()) { //If everything matches do this
                            currentLoanID = readLoanID;
                            currentStockID = readStockID;
                            if (currentLoanID == 999) { //If loan selected is placeholder, throw exception
                                throw new X2_AdminException("THIS ITEM CANNOT BE RETURNED!");
                            }
                            txtAreaLoans.appendText( //Display loan details
                                    "Loan ID:  " + aGetLoans.getLoanID() + newLine +
                                            "Loan Due: " + aGetLoans.getLoanDuration() + newLine +
                                            "Loan Cost: " + currencyFormatter.format(aGetLoans.getLoanCost()) + newLine +
                                            "User ID: " + aGetLoans.getWhoLoaned() + " Username: " + aGetUsers.getUser() + " Full Name: " + aGetUsers.getFullName() + newLine +
                                            "Item: " + aGetLoans.getWhatLoaned() + " Title: " + aGetItems.getTitle() + newLine);
                        }
                    }
                }
            }
        }
    } //Gets loan from loan ID (Custom exception, prevents from returning placeholder loan)

    public void returnLoan() {

        getUsers(myUsers); //Gets data
        getItems(myItems);
        getLoans(myLoans);

        try {
            Iterator<Loans> it = myLoans.iterator(); //Iterates from each loan
            while (it.hasNext()) { //While there is a loan object do this
                Loans aGetLoans = it.next(); //Sets all loans
                readLoanID = aGetLoans.getLoanID(); //Reads loanID
                for (Items aGetItems : myItems) { //For each item in item array
                    if (myItems != null) {
                        readStockID = aGetItems.getStockID(); //Read stock ID
                        int currentStockLevel = aGetItems.getItemStock(); //gets current stock level
                        if (currentLoanID == aGetLoans.getLoanID() && currentStockID == readStockID) { //If current loan is found do this.
                            currentStockLevel++; //Increment stock level
                            out.println(currentLoanID); //print out loan ID
                            out.println(currentStockLevel); //print out stock level
                            int returnDays = Integer.parseInt(txtDays.getText()); //gets days from textfield
                            if (returnDays > loanDays) { //If returned after days due, generate fee
                                out.println(returnDays);
                                lblOverdue.setVisible(true);
                                double fine = 0.50; //Fee is 50p per day
                                fine = fine * returnDays;
                                loanCost = loanCost + fine;
                                txtCost.setText("" + currencyFormatter.format(loanCost)); //Sets output to format
                            } else {
                                lblOverdue.setVisible(false);
                                txtCost.setText("" + currencyFormatter.format(loanCost)); //Sets output to format
                            }
                            it.remove(); //Removes loan from array
                            aGetItems.setItemStock(currentStockLevel); //increases stock level of loaned item
                            txtAreaLoans.clear(); //clears text area
                            txtAreaLoans.appendText("This loan has been returned and the stock item is now +1 "); //informs user loan has been returned
                            serialiseLoans(); //remove/modify loan file
                            break;
                        }
                    }
                }
            }
        } catch (
                NumberFormatException e)

        { //Validates for numerical values and
            out.println("Invalid input");
        }

    } //Return loan method, called when return is clicked

    private void serialiseLoans() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src\\BunnyCorp\\Data\\Loans.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myLoans);
            out.close();
            fileOut.close();
            System.out.println("Removed Data has been saved in src\\BunnyCorp\\Data\\Loans.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

    } //Removes loan from file

    public void back(ActionEvent backLoan) throws IOException {

        getUsers(myUsers);
        getItems(myItems);
        getLoans(myLoans);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminLoans.fxml")); //Loads fxml from file path
        AnchorPane backLoansViewParent = loader.load();
        A5a_AdminLoanCreatorClass passUsers = (A5a_AdminLoanCreatorClass) loader.getController();
        A5a_AdminLoanCreatorClass passItems = (A5a_AdminLoanCreatorClass) loader.getController();
        A5a_AdminLoanCreatorClass passLoans = (A5a_AdminLoanCreatorClass) loader.getController();
        passUsers.getUsers(myUsers);
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene backViewScene = new Scene(backLoansViewParent); //Sets AdminLoans  fxml as new scene
        Stage window = (Stage) ((Node) backLoan.getSource()).getScene().getWindow(); //sets windows to AdminLoans fxml
        window.setScene(backViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows AdminLoans fxml
    } //Sends admin to loan creator
}
