package BunnyCorp.Main_Classes;

import BunnyCorp.Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import static java.lang.System.out;

public class A5a_AdminLoanCreatorClass {

    //FXML Components
    public TextField txtUsers;
    public TextField txtLoanDuration;
    public TextArea txtAreaUsers;
    public TextArea txtAreaItems;
    public TextField txtItems;
    public TextField txtLoanTotal;
    public Label lblUser;
    public Label lblItem;
    public Label lblLoanDuration;

    private Locale locale = new Locale("en", "GB"); //Gets British localisation
    private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale); //Sets currency to Pound Stirling
    private String newline = System.getProperty("line.separator"); //Seperates new lines
    private static final String fileName = "src\\BunnyCorp\\Data\\UserData.txt"; //Setting fileName to UserData.txt | Used for BufferedWriter

    //Loan data variables
    private int currentStock;
    private int currentItem;
    private int currentUser;
    private int loanDuration;
    private double finalPrice;
    private int nextLoanID;

    private String writeID;
    private String writeWho;
    private String writeDuration;
    private String writePrice;
    private String writeItem;

    public ArrayList<Users<String>> myUsers; //User array list
    public ArrayList<Items> myItems; //Item array list
    public ArrayList<Loans> myLoans; //Loan arraylist

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    } //Gets users from class

    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    } //Gets items from class

    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    } //Sends and gets loans from and to classes

    public void getItems() {

        getItems(myItems);
        getUsers(myUsers);
        getLoans(myLoans);

        if (myItems != null) {
            txtAreaItems.clear();
            for (Items aGetItems : myItems) {
                int scannedStockID = aGetItems.getStockID();
                String scannedTitle = aGetItems.getTitle();
                String scannedType = aGetItems.getItemType();
                if (txtItems.getText().equals(scannedTitle) || (txtItems.getText().equals(String.valueOf(scannedStockID)) && scannedType.equals("Book"))) {
                    txtAreaItems.appendText("Item ID: " + aGetItems.getStockID() + newline +
                            "ISBN: " + aGetItems.getISBN() + newline +
                            "Author: " + aGetItems.getAuthor() + newline +
                            "Title: " + aGetItems.getTitle() + newline +
                            "Subject Area: " + aGetItems.getSubjectArea() + newline +
                            "Publisher: " + aGetItems.getPublisher() + newline +
                            "Pages: " + aGetItems.getNumberofPages() + newline +
                            "Amount available: " + aGetItems.getItemStock() + newline +
                            "Price: £" + aGetItems.getCostPrice() + newline +
                            "Item Type: " + aGetItems.getItemType());
                    currentItem = aGetItems.getStockID();
                    currentStock = aGetItems.getItemStock();
                    writeItem = (String.valueOf(currentItem));
                    txtLoanDuration.clear();
                }
                if (txtItems.getText().equals(scannedTitle) || (txtItems.getText().equals(String.valueOf(scannedStockID)) && scannedType.equals("Journal"))) {
                    txtAreaItems.appendText("Item ID: " + aGetItems.getStockID() + newline +
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
                    currentItem = aGetItems.getStockID();
                    currentStock = aGetItems.getItemStock();
                    writeItem = (String.valueOf(currentItem));
                    txtLoanDuration.clear();
                }
                if (txtItems.getText().equals(scannedTitle) || (txtItems.getText().equals(String.valueOf(scannedStockID)) && scannedType.equals("Video"))) {
                    lblItem.setText("Users");
                    lblItem.setStyle("-fx-text-fill:  white");
                    txtAreaItems.appendText("Item ID: " + aGetItems.getStockID() + newline +
                            "Title: " + aGetItems.getTitle() + newline +
                            "Publisher: " + aGetItems.getPublisher() + newline +
                            "Genre: " + aGetItems.getGenre() + newline +
                            "Format: " + aGetItems.getVideoFormat() + newline +
                            "Runtime: " + aGetItems.getRunningTime() + " minutes" + newline +
                            "Storage Type: " + aGetItems.getTypeOfStorage() + newline +
                            "Amount available: " + aGetItems.getItemStock() + newline +
                            "Price: £" + aGetItems.getCostPrice() + newline +
                            "Item Type: " + aGetItems.getItemType());
                    currentItem = aGetItems.getStockID();
                    currentStock = aGetItems.getItemStock();
                    writeItem = (String.valueOf(currentItem));
                    txtLoanDuration.clear();
                }
                if (txtItems.getText().equals(scannedTitle) || (txtItems.getText().equals(String.valueOf(scannedStockID)) && scannedType.equals("Compact Disc"))) {
                    lblItem.setText("Users");
                    lblItem.setStyle("-fx-text-fill:  white");
                    txtAreaItems.appendText("Item ID: " + aGetItems.getStockID() + newline +
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
                    currentItem = aGetItems.getStockID();
                    currentStock = aGetItems.getItemStock();
                    writeItem = (String.valueOf(currentItem));
                    txtLoanDuration.clear();
                }
            }
        }
    } //Gets item from stock ID

    public void getUsers() {

        getItems(myItems);
        getUsers(myUsers);
        getLoans(myLoans);

        if (myUsers != null) {
            txtAreaUsers.clear();
            for (Users aGetUsers : myUsers) {
                int scannedUserID = aGetUsers.getUserID();
                String scannedUser = aGetUsers.getUser();
                if (txtUsers.getText().equals(scannedUser) || (txtUsers.getText().equals(String.valueOf(scannedUserID)))) {
                    txtAreaUsers.appendText(
                            "ID: " + aGetUsers.getUserID() + newline +
                                    "Firstname: " + aGetUsers.getFirstName() + newline +
                                    "Surname: " + aGetUsers.getSecondName() + newline +
                                    "Address: " + aGetUsers.getAddress() + newline +
                                    "Town/City: " + aGetUsers.getTown() + newline +
                                    "Postcode: " + aGetUsers.getPostCode() + newline +
                                    "Phone: " + aGetUsers.getPhoneNum() + newline +
                                    "Birthdate: " + aGetUsers.getDOB() + newline +
                                    "Membership: " + aGetUsers.getType());
                    currentUser = aGetUsers.getUserID();
                    writeWho = (String.valueOf(currentUser));
                    txtLoanDuration.clear();
                }
            }
        }
    } //Gets user from user ID

    public void calculatePrice() {

        getItems(myItems); //Gets data
        getUsers(myUsers);
        getLoans(myLoans);

        txtLoanTotal.clear(); //Clears textfield
        if (currentUser != 0 && currentItem != 0) { //If no item or user selected this will not run
            if (myItems != null) {
                for (Items aMyItems : myItems) { //For each item in item array
                    if (currentItem == aMyItems.getStockID() && (!txtLoanDuration.getText().isEmpty())) { //If currentItem is found and loan duration has been set try...
                        try {
                            loanDuration = Integer.parseInt(txtLoanDuration.getText()); //Gets loan amount from user //Only allows integers
                            txtLoanDuration.setPromptText("Enter Loan Duration");
                            out.println(aMyItems.getCostPrice());
                            finalPrice = 0.80 * aMyItems.getCostPrice(); //Generates price of loan (80% of cost to buy item)
                            writeDuration = (String.valueOf(loanDuration));
                            writePrice = (String.valueOf(finalPrice));
                        } catch (NumberFormatException e) {
                            out.println("User has entered invalid Loan input");
                            txtLoanDuration.setPromptText("Invalid!");
                            break;
                        }
                        try {
                            txtLoanTotal.appendText("£");
                            txtLoanTotal.appendText((String.valueOf(Math.floor(finalPrice))));  //Formats cost
                        } catch (NullPointerException e) {
                            out.println("No data found");
                            break;
                        }
                    }
                }
            }
        }
    } //Generates a price

    public void createLoan() throws IOException {
        getItems(myItems); //Gets data
        getUsers(myUsers);
        getLoans(myLoans);

        out.println(myLoans); //Prints loans
        {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) { //Writes to loan text file
                for (Items aGetItems : myItems) { //For each item in item array
                    if (myLoans != null) {
                        int i = 0;
                        while (i < myLoans.toArray().length) {
                            if (myLoans.get(i) != null) {
                                for (Loans aGetLoans : myLoans) {
                                    if (aGetLoans != null) {
                                        nextLoanID = (aGetLoans.getLoanID()); //Creates new loan ID
                                        nextLoanID++; //Increments ID by 1
                                        writeID = (String.valueOf(nextLoanID));
                                    }
                                }
                                if (currentStock <= 0) {
                                    throw new X0_OutOfStockException("ITEM IS OUT OF STOCK"); //Custom exception
                                }
                                if (currentItem == aGetItems.getStockID() && (!txtLoanDuration.getText().isEmpty())) { //If current item is found and loan duration isn't empty
                                    out.println(aGetItems.getStockID()); //Print out stock ID
                                    currentStock--; //Decrease stock level
                                    aGetItems.setItemStock(currentStock); //Sets new stock level of current item
                                    writer.write(writeID + " | " + writeWho + " | " + writeDuration + " | " + writePrice + " | " + writeItem); //Write loans to text file
                                    writer.newLine(); //writes new line
                                    Loans newLoan = new Loans(nextLoanID++, currentUser, loanDuration, finalPrice, currentItem); //Adds new loan data to newLoan
                                    out.println(nextLoanID++); //Prints out new loan ID - used for dev
                                    myLoans.add(newLoan); //Adds new loan to array list
                                    serialiseItems(); //Serialises edited data
                                    serialiseLoans(); //Serialises loans
                                    deSerialiseLoans(); //Lists out loans
                                    break; //Ends method
                                }
                                break; //Breaks out of loop
                            }
                            i++; //Increment i
                        }
                    }
                }
            } catch (X0_OutOfStockException e) { //Custom exception if item is out of stock, inform developer
                out.println("ITEM IS OUT OF STOCK");
            }
        }
    } //Creates a loan object and stores into loan array

    private void serialiseItems() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src\\BunnyCorp\\Data\\Items.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myItems);
            out.close();
            fileOut.close();
            System.out.println("Updated Data has been saved in src\\BunnyCorp\\Data\\Items.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

    } //Edits stock level in file

    private void serialiseLoans() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src\\BunnyCorp\\Data\\Loans.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myLoans);
            out.close();
            fileOut.close();
            System.out.println("Data has been saved in src\\BunnyCorp\\Data\\Loans.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

    } //Adds loan to file

    private void deSerialiseLoans() {

        ArrayList<Loans> myNewLoans = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("src\\BunnyCorp\\Data\\Loans.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            myNewLoans = (ArrayList<Loans>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            out.println("Class not found");
            c.printStackTrace();
        }

        out.println("Loans.ser");
        for (Loans loans : myNewLoans) {
            out.println(loans.getLoanID() + "|" + loans.getLoanDuration() + " Days |" + "£" + loans.getLoanCost() + "|" + loans.getWhoLoaned());
            out.println();
        }
    } //Reads loan from file

    public void viewloans(ActionEvent viewLoan) throws IOException {
        getUsers(myUsers); //Gets data
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminLoansView.fxml")); //Loads fxml from file path
        AnchorPane viewLoanViewParent = loader.load();
        A5c_AdminLoanViewerClass passUsers = (A5c_AdminLoanViewerClass) loader.getController();
        A5c_AdminLoanViewerClass passItems = (A5c_AdminLoanViewerClass) loader.getController();
        A5c_AdminLoanViewerClass passLoans = (A5c_AdminLoanViewerClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends data to classes
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene returnsViewScene = new Scene(viewLoanViewParent); //Sets loan view fxml as new scene
        Stage window = (Stage) ((Node) viewLoan.getSource()).getScene().getWindow(); //sets windows to loan view fxml
        window.setScene(returnsViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows loan view fxml
    }

    public void returns(ActionEvent returns) throws IOException {

        getUsers(myUsers); //Gets data
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminLoanReturn.fxml")); //Loads fxml from file path
        AnchorPane returnsViewParent = loader.load();
        A5b_AdminLoanReturnClass passUsers = (A5b_AdminLoanReturnClass) loader.getController();
        A5b_AdminLoanReturnClass passItems = (A5b_AdminLoanReturnClass) loader.getController();
        A5b_AdminLoanReturnClass passLoans = (A5b_AdminLoanReturnClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends data to classes
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene returnsViewScene = new Scene(returnsViewParent); //Sets return fxml as new scene
        Stage window = (Stage) ((Node) returns.getSource()).getScene().getWindow(); //sets windows to return fxml
        window.setScene(returnsViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows return fxml
    } //Sends admin to returns

    public void back(ActionEvent backToMenu) throws IOException {

        getLoans(myLoans); //Gets data
        getUsers(myUsers);
        getItems(myItems);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminMenu.fxml")); //Loads fxml from file path
        AnchorPane backViewParent = loader.load();
        A3_AdminMenuClass passUsers = (A3_AdminMenuClass) loader.getController();
        A3_AdminMenuClass passItems = (A3_AdminMenuClass) loader.getController();
        A3_AdminMenuClass passLoans = (A3_AdminMenuClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends data to classes
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene backViewScene = new Scene(backViewParent); //Sets menu fxml as new scene
        Stage window = (Stage) ((Node) backToMenu.getSource()).getScene().getWindow(); //sets windows to menu fxml
        window.setScene(backViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows menu fxml
    } //Send admin back to menu
}
