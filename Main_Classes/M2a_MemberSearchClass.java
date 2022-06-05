package BunnyCorp.Main_Classes;

import BunnyCorp.Classes.Items;
import BunnyCorp.Classes.Loans;
import BunnyCorp.Classes.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class M2a_MemberSearchClass {

    //FXML Components
    public Label ItemLabel;
    public TextField textfieldTitle;
    public TextArea textareaSearch;

    public ArrayList<Users<String>> myUsers; //User array list
    public ArrayList<Items> myItems; //Item array list
    public ArrayList<Loans> myLoans; //Loan array list
    private int loggedUser; //Logged in user

    private String newline = System.getProperty("line.separator"); //Line separator

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
    } //Gets current logged in user

    public void allStock() {
        textareaSearch.clear(); //Clears textarea
        getItems(myItems); //gets data
        getUsers(myUsers);
        if (myItems != null) {
            for (Items aGetItems : myItems) { //For each item in array
                String scannedItem = aGetItems.getItemType();
                if (scannedItem.equals("Book")) { //matches item type then display item details
                    textareaSearch.appendText("Item ID: " + aGetItems.getStockID() + newline +
                            "ISBN: " + aGetItems.getISBN() + newline +
                            "Author: " + aGetItems.getAuthor() + newline +
                            "Title: " + aGetItems.getTitle() + newline +
                            "Subject Area: " + aGetItems.getSubjectArea() + newline +
                            "Publisher: " + aGetItems.getPublisher() + newline +
                            "Pages: " + aGetItems.getNumberofPages() + newline +
                            "Amount available: " + aGetItems.getItemStock() + newline +
                            "Price: £" + aGetItems.getCostPrice() + newline +
                            "Item Type: " + aGetItems.getItemType() +newline);
                }
                if (scannedItem.equals("Journal")) { //matches item type then display item details
                    textareaSearch.appendText("Item ID: " + aGetItems.getStockID() + newline +
                            "Journal ISSN: " + aGetItems.getISSN() + newline +
                            "Title: " + aGetItems.getTitle() + newline +
                            "Subject Area: " + aGetItems.getSubjectArea() + newline +
                            "Publisher: " + aGetItems.getPublisher() + newline +
                            "Issue Number: " + aGetItems.getIssueNumber() + newline +
                            "Issue Date: " + aGetItems.getIssueDate() + newline +
                            "Pages: " + aGetItems.getNumberofPages() + newline +
                            "Amount available: " + aGetItems.getItemStock() + newline +
                            "Price: £" + aGetItems.getCostPrice() + newline +
                            "Item Type: " + aGetItems.getItemType()+newline);

                }
                if (scannedItem.equals("Video")) { //matches item type then display item details
                    textareaSearch.appendText("Item ID: " + aGetItems.getStockID() + newline +
                            "Title: " + aGetItems.getTitle() + newline +
                            "Publisher: " + aGetItems.getPublisher() + newline +
                            "Genre: " + aGetItems.getGenre() + newline +
                            "Format: " + aGetItems.getVideoFormat() + newline +
                            "Runtime: " + aGetItems.getRunningTime() + " minutes" + newline +
                            "Storage Type: " + aGetItems.getTypeOfStorage() + newline +
                            "Amount available: " + aGetItems.getItemStock() + newline +
                            "Price: £" + aGetItems.getCostPrice() + newline +
                            "Item Type: " + aGetItems.getItemType()+newline);
                }
                if (scannedItem.equals("Compact Disc")) { //matches item type then display item details
                    textareaSearch.appendText("Item ID: " + aGetItems.getStockID() + newline +
                            "Title: " + aGetItems.getTitle() + newline +
                            "Artist: " + aGetItems.getCDArtist() + newline +
                            "Publisher: " + aGetItems.getPublisher() + newline +
                            "Tracks: " + aGetItems.getNumberOfTracks() + newline +
                            "Runtime: " + aGetItems.getRunningTime() + " minutes" + newline +
                            "Format: " + aGetItems.getCDFormat() + newline +
                            "Storage Type: " + aGetItems.getTypeOfStorage() + newline +
                            "Amount available: " + aGetItems.getItemStock() + newline +
                            "Price: £" + aGetItems.getCostPrice() + newline +
                            "Item Type: " + aGetItems.getItemType()+newline);
                }
            }
        }
    } //Shows all items when clicked


    public void searchStock() {
        textareaSearch.clear(); //Clears textarea
        getItems(myItems); //gets data
        getUsers(myUsers);
        if (myItems != null) {
            for (Items aGetItems : myItems) { //For each item in array
                String scannedTitle = aGetItems.getTitle();
                String scannedItem = aGetItems.getItemType();
                if (textfieldTitle.getText().equals(scannedTitle) && scannedItem.equals("Book")) { //If text is found and matches then display item details
                    textareaSearch.appendText("Item ID: " + aGetItems.getStockID() + newline +
                            "ISBN: " + aGetItems.getISBN() + newline +
                            "Author: " + aGetItems.getAuthor() + newline +
                            "Title: " + aGetItems.getTitle() + newline +
                            "Subject Area: " + aGetItems.getSubjectArea() + newline +
                            "Publisher: " + aGetItems.getPublisher() + newline +
                            "Pages: " + aGetItems.getNumberofPages() + newline +
                            "Amount available: " + aGetItems.getItemStock() + newline +
                            "Price: £" + aGetItems.getCostPrice() + newline +
                            "Item Type: " + aGetItems.getItemType());
                }
                if (textfieldTitle.getText().equals(scannedTitle) && scannedItem.equals("Journal")) { //If text is found and matches then display item details
                    textareaSearch.appendText("Item ID: " + aGetItems.getStockID() + newline +
                            "Journal ISSN: " + aGetItems.getISSN() + newline +
                            "Title: " + aGetItems.getTitle() + newline +
                            "Subject Area: " + aGetItems.getSubjectArea() + newline +
                            "Publisher: " + aGetItems.getPublisher() + newline +
                            "Issue Number: " + aGetItems.getIssueNumber() + newline +
                            "Issue Date: " + aGetItems.getIssueDate() + newline +
                            "Pages: " + aGetItems.getNumberofPages() + newline +
                            "Amount available: " + aGetItems.getItemStock() + newline +
                            "Price: £" + aGetItems.getCostPrice() + newline +
                            "Item Type: " + aGetItems.getItemType());

                }
                if (textfieldTitle.getText().equals(scannedTitle) && scannedItem.equals("Video")) { //If text is found and matches then display item details
                    textareaSearch.appendText("Item ID: " + aGetItems.getStockID() + newline +
                            "Title: " + aGetItems.getTitle() + newline +
                            "Publisher: " + aGetItems.getPublisher() + newline +
                            "Genre: " + aGetItems.getGenre() + newline +
                            "Format: " + aGetItems.getVideoFormat() + newline +
                            "Runtime: " + aGetItems.getRunningTime() + " minutes" + newline +
                            "Storage Type: " + aGetItems.getTypeOfStorage() + newline +
                            "Amount available: " + aGetItems.getItemStock() + newline +
                            "Price: £" + aGetItems.getCostPrice() + newline +
                            "Item Type: " + aGetItems.getItemType());
                }
                if (textfieldTitle.getText().equals(scannedTitle) && scannedItem.equals("Compact Disc")) { //If text is found and matches then display item details
                    textareaSearch.appendText("Item ID: " + aGetItems.getStockID() + newline +
                            "Title: " + aGetItems.getTitle() + newline +
                            "Artist: " + aGetItems.getCDArtist() + newline +
                            "Publisher: " + aGetItems.getPublisher() + newline +
                            "Tracks: " + aGetItems.getNumberOfTracks() + newline +
                            "Runtime: " + aGetItems.getRunningTime() + " minutes" + newline +
                            "Format: " + aGetItems.getCDFormat() + newline +
                            "Storage Type: " + aGetItems.getTypeOfStorage() + newline +
                            "Amount available: " + aGetItems.getItemStock() + newline +
                            "Price: £" + aGetItems.getCostPrice() + newline +
                            "Item Type: " + aGetItems.getItemType());
                }
            }
        }
    } //Search method, called when button clicked

    public void back(ActionEvent back) throws IOException {
        setLoggedUser(loggedUser); //Gets data
        getItems(myItems);
        getUsers(myUsers);
        getLoans(myLoans);
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
        Stage window = (Stage) ((Node) back.getSource()).getScene().getWindow(); //sets windows to member menu fxml
        window.setScene(backViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows member menu fxml
    } //Sends member back to menu

}
