package BunnyCorp.Main_Classes;

import BunnyCorp.Classes.Items;
import BunnyCorp.Classes.Loans;
import BunnyCorp.Classes.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class A5c_AdminLoanViewerClass {

    public ArrayList<Users<String>> myUsers; //User array list
    public ArrayList<Items> myItems; //Item array list
    public ArrayList<Loans> myLoans; //Loan arraylist
    public TextArea txtAreaLoans;

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    } //Gets users from class

    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    } //Gets items from class

    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    } //Sends and gets loans from and to classes

    private Locale locale = new Locale("en", "GB"); //Gets British localisation
    private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale); //Sets currency to Pound Stirling
    private String newLine = System.getProperty("line.separator"); //Seperates new lines

    public void viewLoans() {
        txtAreaLoans.clear(); //Clears textarea

        getUsers(myUsers); //Gets data
        getItems(myItems);
        getLoans(myLoans);

        for (Users aGetUsers : myUsers) { //For each user in user array
            for (Items aGetItems : myItems) { //For each item in item array
                for (Loans aGetLoans : myLoans) { //For each loan in loan array
                    if (myLoans != null) {
                        int readUserID = aGetUsers.getUserID();
                        int readStockID = aGetItems.getStockID();
                        if (readUserID == aGetLoans.getWhoLoaned() && readStockID == aGetLoans.getWhatLoaned()) { //If everything matches do this
                            txtAreaLoans.appendText( //Display loan details
                                            "Loan ID:  " + aGetLoans.getLoanID() + newLine +
                                            "Loan Due: " + aGetLoans.getLoanDuration() + newLine +
                                            "Loan Cost: " + currencyFormatter.format(aGetLoans.getLoanCost()) + newLine +
                                            "User ID: " + aGetLoans.getWhoLoaned() + " Username: " + aGetUsers.getUser() + " Full Name: " + aGetUsers.getFullName() + newLine +
                                            "Item: " + aGetLoans.getWhatLoaned() + " Title: " + aGetItems.getTitle() + newLine + newLine);
                        }
                    }
                }
            }
        }
    }

    public void back(ActionEvent backLoan) throws IOException {
        getUsers(myUsers);
        getItems(myItems);
        getLoans(myLoans);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminLoans.fxml")); //Loads fxml from file path
        AnchorPane backLoansViewParent = loader.load();
        A5a_AdminLoanCreatorClass passItems = (A5a_AdminLoanCreatorClass) loader.getController();
        A5a_AdminLoanCreatorClass passLoans = (A5a_AdminLoanCreatorClass) loader.getController();
        A5a_AdminLoanCreatorClass passUsers = (A5a_AdminLoanCreatorClass) loader.getController();
        passLoans.getLoans(myLoans);
        passUsers.getUsers(myUsers);
        passItems.getItems(myItems);
        Scene backViewScene = new Scene(backLoansViewParent); //Sets loan creator fxml as new scene
        Stage window = (Stage) ((Node) backLoan.getSource()).getScene().getWindow(); //sets windows to loan creator fxml
        window.setScene(backViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows loan creator fxml
    } //Sends admin to loan creator
}
