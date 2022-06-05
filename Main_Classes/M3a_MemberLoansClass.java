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

public class M3a_MemberLoansClass {

    //FXML Component
    public TextArea txtAreaLoans;

    private Locale locale = new Locale("en", "GB"); //Sets localisation
    private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale); //Sets currency format
    private String newline = System.getProperty("line.separator"); //Line separator
    public ArrayList<Users<String>> myUsers; //user array list
    public ArrayList<Items> myItems; //Item array list
    public ArrayList<Loans> myLoans; //loan array list
    private int loggedUser; //Logged in user

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    } //Gets users from class

    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    } //Gets items from class

    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    } //Gets loans from class

    public void setLoggedUser(int loggedUser) {
        this.loggedUser = loggedUser;
    } //Gets logged in user

    public void getLoans() {
        for (Loans aGetLoans : myLoans) {
            for (Items aGetItems : myItems) {
                if (myLoans != null) {
                    int readStockID = aGetItems.getStockID();
                    if (loggedUser == aGetLoans.getWhoLoaned() && readStockID == aGetLoans.getWhatLoaned()) {
                        txtAreaLoans.appendText(
                                "Loan ID:  " + aGetLoans.getLoanID() + newline +
                                        "Loan Due: " + aGetLoans.getLoanDuration() + newline +
                                        "Loan Cost: " + currencyFormatter.format(aGetLoans.getLoanCost()) + newline +
                                        "Item: " + aGetLoans.getWhatLoaned() + " Title: " + aGetItems.getTitle() + newline);
                    }
                }
            }
        }
    } //Displays current loans called when button is clicked

    public void back(ActionEvent back) throws IOException {
        getItems(myItems); //Gets data
        getUsers(myUsers);
        getLoans(myLoans);
        setLoggedUser(loggedUser);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/MemberMenu.fxml")); //Loads fxml from file path
        AnchorPane backViewParent = loader.load();
        M1a_MemberMenuClass passUsers = (M1a_MemberMenuClass) loader.getController();
        M1a_MemberMenuClass passItems = (M1a_MemberMenuClass) loader.getController();
        M1a_MemberMenuClass passLoans = (M1a_MemberMenuClass) loader.getController();
        M1a_MemberMenuClass passLog = (M1a_MemberMenuClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends data to class
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        passLog.setLoggedUser(loggedUser);
        Scene backViewScene = new Scene(backViewParent); //Sets member menu fxml as new scene
        Stage window = (Stage) ((Node) back.getSource()).getScene().getWindow(); //sets windows to member menu  fxml
        window.setScene(backViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows member menu fxml
    } //Sends member back to menu
}
