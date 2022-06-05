package BunnyCorp.Main_Classes;

import BunnyCorp.Classes.Items;
import BunnyCorp.Classes.Loans;
import BunnyCorp.Classes.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.out;

public class A6b_AdminStockListClass {

    public TextArea textAreaItems; //FXML component

    String newline = System.getProperty("line.separator"); //Line separator

    public ArrayList<Users<String>> myUsers; //User array list
    public ArrayList<Items> myItems; //Item array list
    public ArrayList<Loans> myLoans; //Loan array list

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    } //Gets users from class
    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    } //Gets items from class
    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    } //Gets loans from class

    public void listItems() {

        getUsers(myUsers); //Gets data
        getItems(myItems);
        getLoans(myLoans);

        textAreaItems.clear(); //Clears textarea
        if (myItems != null) {
            for (Items aGetItems : myItems) { //For each item in item array
                if (myItems != null) {
                    String scannedItem = aGetItems.getItemType(); //Scanned item = item type
                    if (scannedItem.equals("Book")) { //If type is a book, print out book details
                        textAreaItems.appendText(
                                newline+
                                "Item ID: " + aGetItems.getStockID() + " " +
                                "| ISBN: " + aGetItems.getISBN() + " " +
                                "| Author: " + aGetItems.getAuthor() + " " +
                                "| Title: " + aGetItems.getTitle() + " " +
                                "| Price: £" + aGetItems.getCostPrice() + " " +
                                "| Subject Area: " + aGetItems.getSubjectArea() + " " +
                                "| Publisher: " + aGetItems.getPublisher() + " " +
                                "| Pages: " + aGetItems.getNumberofPages() + " " +
                                "| Amount available: " + aGetItems.getItemStock() + " " +
                                "| Item Type: " + aGetItems.getItemType()+ newline);
                    }
                    if (scannedItem.equals("Journal")) { //If type is journal, print out journal details
                        textAreaItems.appendText(
                                newline+
                                "Item ID: " + aGetItems.getStockID() + " " +
                                "| Journal ISSN: " + aGetItems.getISSN() + " " +
                                "| Title: " + aGetItems.getTitle() + " " +
                                "| Price: £" + aGetItems.getCostPrice() + " " +
                                "| Subject Area: " + aGetItems.getSubjectArea() + " " +
                                "| Publisher: " + aGetItems.getPublisher() + " " +
                                "| Issue Number: " + aGetItems.getIssueNumber() + " " +
                                "| Issue Date: " + aGetItems.getIssueDate() + " " +
                                "| Pages: " + aGetItems.getNumberofPages() + " " +
                                "| Amount available: " + aGetItems.getItemStock() + " " +
                                "| Item Type: " + aGetItems.getItemType() + newline);
                    }
                    if (scannedItem.equals("Video")) { //If type is video, print out video details
                        textAreaItems.appendText(
                                newline+
                                "Item ID: " + aGetItems.getStockID() + " " +
                                "| Title: " + aGetItems.getTitle() + " " +
                                "| Publisher: " + aGetItems.getPublisher() + " " +
                                "| Genre: " + aGetItems.getGenre() + " " +
                                "| Format: " + aGetItems.getVideoFormat() + " " +
                                "| Runtime: " + aGetItems.getRunningTime() + " minutes" + " " +
                                "| Price: £" + aGetItems.getCostPrice() + " " +
                                "| Storage Type: " + aGetItems.getTypeOfStorage() + " " +
                                "| Amount available: " + aGetItems.getItemStock() + " " +
                                "| Item Type: " + aGetItems.getItemType()+ newline);
                    }
                    if (scannedItem.equals("Compact Disc")) { //If type is compact disc, print out CD details
                        textAreaItems.appendText(
                                newline +
                                "Item ID: " + aGetItems.getStockID() + " " +
                                "| Title: " + aGetItems.getTitle() + " " +
                                "| Artist: " + aGetItems.getCDArtist() + " " +
                                "| Publisher: " + aGetItems.getPublisher() + " " +
                                "| Tracks: " + aGetItems.getNumberOfTracks() + " " +
                                "| Runtime: " + aGetItems.getRunningTime() + " minutes" + " " +
                                "| Price: £" + aGetItems.getCostPrice() + " " +
                                "| Format: " + aGetItems.getCDFormat() + " " +
                                "| Storage Type: " + aGetItems.getTypeOfStorage() + " " +
                                "| Amount available: " + aGetItems.getItemStock() +  " " +
                                "| Item Type: " + aGetItems.getItemType()+ newline);
                    }
                }
            }
        }
    } //Lists all items stored in array when button is clicked

    public void backToMenu(ActionEvent back) throws IOException{
        out.println("Sending user to Stock Menu");
        getUsers(myUsers);
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminStockMenu.fxml")); //Loads fxml from file path
        AnchorPane BackEditor = loader.load();
        A6a_AdminStockMenuClass passUsers = (A6a_AdminStockMenuClass) loader.getController();
        A6a_AdminStockMenuClass passItems = (A6a_AdminStockMenuClass) loader.getController();
        A6a_AdminStockMenuClass passLoans = (A6a_AdminStockMenuClass) loader.getController();
        passUsers.getUsers(myUsers);
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene BackViewScene = new Scene(BackEditor); //Sets Admin Stock Menu fxml as new scene
        Stage window = (Stage) ((Node) back.getSource()).getScene().getWindow(); //sets windows to Admin Stock Menu fxml
        window.setScene(BackViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows Admin Stock Stock Menu fxml
    } //Sends admin back to menu
}