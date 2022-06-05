package BunnyCorp.Main_Classes;

import BunnyCorp.Classes.Items;
import BunnyCorp.Classes.Loans;
import BunnyCorp.Classes.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class A6c_AdminStockEditClass implements Initializable {

    //Default FXML Properties
    public TextField txtID;
    public TextField txtStock;
    public TextField txtCost;
    public Label lblMins;

    //Video FXML Properties
    public VBox videoBox;
    public VBox videoLabels;

    public TextField txtVideoTitle;
    public TextField txtVideoPublisher;
    public TextField txtVideoRuntime;
    public ChoiceBox VideoStorageType;
    public ChoiceBox VideoFormat;
    public TextField txtGenre;

    //CD FXML Properties
    public VBox CDBox;
    public VBox CDLabels;

    public TextField txtCDTitle;
    public TextField txtCDPublisher;
    public TextField txtCDRuntime;
    public ChoiceBox CDStorageType;
    public ChoiceBox CDFormat;
    public TextField txtArtist;
    public TextField txtTracks;

    //Book FXML Properties
    public VBox BookBox;
    public VBox BookLabels;
    public TextField txtBookTitle;
    public TextField txtBookPublisher;
    public TextField txtBookSubject;
    public TextField txtBookPages;
    public TextField txtBookISBN;
    public TextField txtBookAuthor;

    //Journal FXML Properties
    public VBox JournalBox;
    public VBox JournalLabels;
    public TextField txtJournalTitle;
    public TextField txtJournalPublisher;
    public TextField txtJournalSubject;
    public TextField txtJournalPages;
    public TextField txtJournalISSN;
    public TextField txtIssueNum;
    public TextField txtDateOfIssue;

    public ArrayList<Users<String>> myUsers; //User array list
    public ArrayList<Items> myItems; //Item array list
    public ArrayList<Loans> myLoans; //Loan array list

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    } //Get users from class

    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    } //Get items from class

    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    } //Get loans from class

    public void selectItem() {
        try {
            Alert alert = new Alert(Alert.AlertType.WARNING); //Informs user that changing item will not save edited data
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Any unsaved changed details will be lost");
            alert.setContentText("Clicking OK will remove any edited data");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                if (myUsers != null) {
                    for (Items aGetItems : myItems) { //For each item in item array
                        if (myItems != null) {
                            int readID = aGetItems.getStockID(); //readID is stockID
                            String scannedType = aGetItems.getItemType(); //scannedType is item type
                            if (txtID.getText().equals(String.valueOf(readID))) { //If text from textfield is found in array
                                if (scannedType.equals("Video")) { //If the item type is a video then display and enable controls and disable and hide non video controls

                                    lblMins.setVisible(true);
                                    JournalBox.setVisible(false);
                                    JournalBox.disableProperty().setValue(true);
                                    JournalLabels.setVisible(false);
                                    JournalLabels.disableProperty().setValue(true);

                                    BookBox.setVisible(false);
                                    BookBox.disableProperty().setValue(true);
                                    BookLabels.setVisible(false);
                                    BookLabels.disableProperty().setValue(true);

                                    CDBox.setVisible(false);
                                    CDBox.disableProperty().setValue(true);
                                    CDLabels.setVisible(false);
                                    CDLabels.disableProperty().setValue(true);

                                    videoBox.setVisible(true);
                                    videoBox.disableProperty().setValue(false);
                                    videoLabels.setVisible(true);
                                    videoLabels.disableProperty().setValue(false);

                                    out.println(aGetItems.getTitle()); //Sets textfield text to current item selected info
                                    txtVideoTitle.setText(aGetItems.getTitle());
                                    txtVideoPublisher.setText(aGetItems.getPublisher());
                                    txtVideoRuntime.setText(String.valueOf(aGetItems.getRunningTime()));
                                    VideoFormat.setValue(aGetItems.getVideoFormat());
                                    VideoStorageType.setValue(aGetItems.getTypeOfStorage());
                                    txtGenre.setText(aGetItems.getGenre());
                                    txtCost.setText(String.valueOf(aGetItems.getCostPrice()));
                                    txtStock.setText(String.valueOf(aGetItems.getItemStock()));
                                }
                                if (scannedType.equals("Compact Disc")) { //If the item type is a CD then display and enable controls and disable and hide non CD controls

                                    lblMins.setVisible(true);

                                    JournalBox.setVisible(false);
                                    JournalBox.disableProperty().setValue(true);
                                    JournalLabels.setVisible(false);
                                    JournalLabels.disableProperty().setValue(true);

                                    BookBox.setVisible(false);
                                    BookBox.disableProperty().setValue(true);
                                    BookLabels.setVisible(false);
                                    BookLabels.disableProperty().setValue(true);

                                    videoBox.setVisible(false);
                                    videoBox.disableProperty().setValue(true);
                                    videoLabels.setVisible(false);
                                    videoLabels.disableProperty().setValue(true);

                                    CDBox.setVisible(true);
                                    CDBox.disableProperty().setValue(false);
                                    CDLabels.setVisible(true);
                                    CDLabels.disableProperty().setValue(false);

                                    out.println(aGetItems.getTitle()); //Sets text to item details
                                    txtCDTitle.setText(aGetItems.getTitle());
                                    txtCDPublisher.setText(aGetItems.getPublisher());
                                    txtCDRuntime.setText(String.valueOf(aGetItems.getRunningTime()));
                                    CDFormat.setValue(aGetItems.getCDFormat());
                                    CDStorageType.setValue(aGetItems.getTypeOfStorage());
                                    txtArtist.setText(aGetItems.getCDArtist());
                                    txtTracks.setText(String.valueOf(aGetItems.getNumberOfTracks()));
                                    txtCost.setText(String.valueOf(aGetItems.getCostPrice()));
                                    txtStock.setText(String.valueOf(aGetItems.getItemStock()));
                                }
                                if (scannedType.equals("Book")) { //If the item type is a book then display and enable controls and disable and hide non book controls

                                    lblMins.setVisible(false);

                                    videoBox.setVisible(false);
                                    videoBox.disableProperty().setValue(true);
                                    videoLabels.setVisible(false);
                                    videoLabels.disableProperty().setValue(true);

                                    CDBox.setVisible(false);
                                    CDBox.disableProperty().setValue(true);
                                    CDLabels.setVisible(false);
                                    CDLabels.disableProperty().setValue(true);

                                    JournalBox.setVisible(false);
                                    JournalBox.disableProperty().setValue(true);
                                    JournalLabels.setVisible(false);
                                    JournalLabels.disableProperty().setValue(true);

                                    BookBox.setVisible(true);
                                    BookBox.disableProperty().setValue(false);
                                    BookLabels.setVisible(true);
                                    BookLabels.disableProperty().setValue(false);

                                    out.println(aGetItems.getTitle()); //Sets text to item details
                                    txtBookTitle.setText(aGetItems.getTitle());
                                    txtBookPublisher.setText(aGetItems.getPublisher());
                                    txtBookSubject.setText(aGetItems.getSubjectArea());
                                    txtBookPages.setText(String.valueOf(aGetItems.getNumberofPages()));
                                    txtBookISBN.setText(aGetItems.getISBN());
                                    txtBookAuthor.setText(aGetItems.getAuthor());
                                    txtCost.setText(String.valueOf(aGetItems.getCostPrice()));
                                    txtStock.setText(String.valueOf(aGetItems.getItemStock()));
                                }
                                if (scannedType.equals("Journal")) { //If the item type is a journal then display and enable controls and disable and hide non journal controls

                                    lblMins.setVisible(false);

                                    videoBox.setVisible(false);
                                    videoBox.disableProperty().setValue(true);
                                    videoLabels.setVisible(false);
                                    videoLabels.disableProperty().setValue(true);

                                    CDBox.setVisible(false);
                                    CDBox.disableProperty().setValue(true);
                                    CDLabels.setVisible(false);
                                    CDLabels.disableProperty().setValue(true);

                                    BookBox.setVisible(false);
                                    BookBox.disableProperty().setValue(true);
                                    BookLabels.setVisible(false);
                                    BookLabels.disableProperty().setValue(true);

                                    JournalBox.setVisible(true);
                                    JournalBox.disableProperty().setValue(false);
                                    JournalLabels.setVisible(true);
                                    JournalLabels.disableProperty().setValue(false);

                                    out.println(aGetItems.getTitle()); //Sets text to item details
                                    txtJournalTitle.setText(aGetItems.getTitle());
                                    txtJournalPublisher.setText(aGetItems.getPublisher());
                                    txtJournalSubject.setText(aGetItems.getSubjectArea());
                                    txtJournalPages.setText(String.valueOf(aGetItems.getNumberofPages()));
                                    txtJournalISSN.setText(aGetItems.getISBN());
                                    txtIssueNum.setText(String.valueOf(aGetItems.getNumberofPages()));
                                    txtDateOfIssue.setText(aGetItems.getIssueDate());
                                    txtCost.setText(String.valueOf(aGetItems.getCostPrice()));
                                    txtStock.setText(String.valueOf(aGetItems.getItemStock()));
                                }
                            }
                        }
                    }
                }
            } else {
                out.println("Click create to save any edited data");
            }
        } catch (RuntimeException e) {
            out.println("Caught Exception");
        }
    } //Gets stock item from array

    public void changeItem() {

        try {
            if (myItems != null) {
                for (Items aGetItems : myItems) { //For each item in item array
                    if (myItems != null) {
                        int readID = aGetItems.getStockID();
                        String scannedType = aGetItems.getItemType();
                        if (txtID.getText().equals(String.valueOf(readID))) {
                            if (scannedType.equals("Video")) { //If item is video
                                if (txtVideoTitle.getText().isEmpty() || txtVideoPublisher.getText().isEmpty() || txtVideoRuntime.getText().isEmpty() || txtGenre.getText().isEmpty() || txtStock.getText().isEmpty() || txtCost.getText().isEmpty()) { //Video validation
                                    out.println("Data Missing!");
                                    break;
                                }
                                out.println("BEFORE: " + aGetItems.getTitle() + " " + aGetItems.getPublisher() + " " + aGetItems.getRunningTime() + " " + aGetItems.getTypeOfStorage() + " " + aGetItems.getVideoFormat() + " " + aGetItems.getGenre() + " " + aGetItems.getItemStock() + " " + aGetItems.getCostPrice()); //Shows items details before edited
                                aGetItems.setTitle(txtVideoTitle.getText()); //Edits video title
                                aGetItems.setPublisher(txtVideoPublisher.getText()); //Edits video publisher
                                aGetItems.setRunningTime(Integer.valueOf(txtVideoRuntime.getText())); //Edits video run time
                                aGetItems.setTypeOfStorage(VideoStorageType.getValue().toString()); //Edits video storage type
                                aGetItems.setVideoFormat(VideoFormat.getValue().toString()); //Edits video format
                                if (aGetItems.getTypeOfStorage().equals("VHS Case") && (aGetItems.getVideoFormat().equals("DVD") || (aGetItems.getVideoFormat().equals("Blu-Ray")))) {
                                    out.println("Why did you put a disc inside a box? It doesn't even have anything to hold it. It's just going to move around whenever you move the case.");
                                }
                                if (aGetItems.getTypeOfStorage().equals("DVD Case") || (aGetItems.getTypeOfStorage().equals("Blu-Ray Case") && (aGetItems.getVideoFormat().equals("VHS")))) {
                                    out.println("A VHS cannot fit inside a disc case, but since you insist, we've taped the chosen case to the VHS using sellotape.");
                                }
                                aGetItems.setGenre(txtGenre.getText()); //Edits genre
                                aGetItems.setItemStock(Integer.valueOf(txtStock.getText())); //Edits stock level
                                aGetItems.setCostPrice(Double.valueOf(txtCost.getText())); //Edits cost
                                out.println("AFTER: " + aGetItems.getTitle() + " " + aGetItems.getPublisher() + " " + aGetItems.getRunningTime() + " " + aGetItems.getTypeOfStorage() + " " + aGetItems.getVideoFormat() + " " + aGetItems.getGenre() + " " + aGetItems.getItemStock() + " " + aGetItems.getCostPrice()); //Shows item after edited
                                serialiseItems(); //Edits item in file
                            }
                            if (scannedType.equals("Compact Disc")) { //If item is CD
                                if (txtCDTitle.getText().isEmpty() || txtCDPublisher.getText().isEmpty() || txtCDRuntime.getText().isEmpty() || txtTracks.getText().isEmpty() || txtArtist.getText().isEmpty() || txtArtist.getText().isEmpty() || txtStock.getText().isEmpty() || txtCost.getText().isEmpty()) { //CD validation
                                    out.println("Data Missing!");
                                    break;
                                }
                                out.println("BEFORE: " + aGetItems.getTitle() + " " + aGetItems.getPublisher() + " " + aGetItems.getRunningTime() + " " + aGetItems.getTypeOfStorage() + " " + aGetItems.getCDFormat() + " " + aGetItems.getCDArtist() + " " + aGetItems.getNumberOfTracks() + " " + aGetItems.getItemStock() + " " + aGetItems.getCostPrice()); //Shows item details before edit
                                aGetItems.setTitle(txtCDTitle.getText()); //Edits CD title
                                aGetItems.setPublisher(txtCDPublisher.getText()); //Edits CD publisher
                                aGetItems.setRunningTime(Integer.valueOf(txtCDRuntime.getText())); //Edits CD RunTime
                                aGetItems.setTypeOfStorage(CDStorageType.getValue().toString()); //Edits CD Storage
                                aGetItems.setCDFormat((CDFormat.getValue().toString())); //Edit CD Format
                                aGetItems.setCDArtist(txtArtist.getText()); //Edit CD Artist
                                aGetItems.setNumberOfTracks(Integer.valueOf(txtTracks.getText())); //Edits Number of Tracks
                                aGetItems.setItemStock(Integer.valueOf(txtStock.getText())); //Edits Stock level
                                aGetItems.setCostPrice(Double.valueOf(txtCost.getText())); //Edit cost
                                out.println("AFTER: " + aGetItems.getTitle() + " " + aGetItems.getPublisher() + " " + aGetItems.getRunningTime() + " " + aGetItems.getTypeOfStorage() + " " + aGetItems.getCDFormat() + " " + aGetItems.getCDArtist() + " " + aGetItems.getNumberOfTracks() + " " + aGetItems.getItemStock() + " " + aGetItems.getCostPrice()); //Shows item details after edit
                                serialiseItems(); //Edits item in file
                            }
                            if (scannedType.equals("Book")) { //If item is book
                                if (txtBookTitle.getText().isEmpty() || txtBookPublisher.getText().isEmpty() || txtBookSubject.getText().isEmpty() || txtBookAuthor.getText().isEmpty() || txtBookPages.getText().isEmpty() || txtBookISBN.getText().isEmpty() || txtStock.getText().isEmpty() || txtCost.getText().isEmpty()) { //Validate book
                                    out.println("Data Missing!");
                                    break;
                                }
                                out.println("BEFORE: " + aGetItems.getTitle() + " " + aGetItems.getPublisher() + " " + aGetItems.getSubjectArea() + " " + aGetItems.getNumberofPages() + " " + aGetItems.getISBN() + " " + aGetItems.getAuthor() + " " + aGetItems.getItemStock() + " " + aGetItems.getCostPrice()); //Shows item details before edit
                                aGetItems.setTitle(txtBookTitle.getText()); //Edits book title
                                aGetItems.setPublisher(txtBookPublisher.getText()); //Edits book publisher
                                aGetItems.setSubjectArea(txtBookSubject.getText()); //Edits book subject
                                aGetItems.setNumberofPages(Integer.valueOf(txtBookPages.getText())); //Edit number of pages
                                aGetItems.setISBN(txtBookISBN.getText()); //Edits ISBN
                                aGetItems.setAuthor(txtBookAuthor.getText()); //Edits author
                                aGetItems.setItemStock(Integer.valueOf(txtStock.getText())); //Edits item stock
                                aGetItems.setCostPrice(Double.valueOf(txtCost.getText())); //Edits cost
                                out.println("AFTER: " + aGetItems.getTitle() + " " + aGetItems.getPublisher() + " " + aGetItems.getSubjectArea() + " " + aGetItems.getNumberofPages() + " " + aGetItems.getISBN() + " " + aGetItems.getAuthor() + " " + aGetItems.getItemStock() + " " + aGetItems.getCostPrice()); //Shows item details after edit
                                serialiseItems(); //Edit item in file
                            }
                            if (scannedType.equals("Journal")) { //If item is journal
                                if (txtJournalTitle.getText().isEmpty() || txtJournalPublisher.getText().isEmpty() || txtJournalSubject.getText().isEmpty() || txtJournalPages.getText().isEmpty() || txtDateOfIssue.getText().isEmpty() || txtJournalISSN.getText().isEmpty() || txtDateOfIssue.getText().isEmpty() || txtStock.getText().isEmpty() || txtCost.getText().isEmpty()) { //Journal validation
                                    out.println("Data Missing!");
                                    break;
                                }
                                out.println("BEFORE: " + aGetItems.getTitle() + " " + aGetItems.getPublisher() + " " + aGetItems.getSubjectArea() + " " + aGetItems.getNumberofPages() + " " + aGetItems.getISSN() + " " + aGetItems.getIssueNumber() + " " + aGetItems.getIssueDate() + " " + aGetItems.getItemStock() + " " + aGetItems.getCostPrice()); //Shows item details before edit
                                aGetItems.setTitle(txtJournalTitle.getText()); //Edits journal item
                                aGetItems.setPublisher(txtJournalPublisher.getText()); //Edits journal publisher
                                aGetItems.setSubjectArea(txtJournalSubject.getText()); //Edits journal subject
                                aGetItems.setNumberofPages(Integer.valueOf(txtJournalPages.getText())); //Edit number of pages
                                aGetItems.setISSN(txtJournalISSN.getText()); //Edits ISSN
                                aGetItems.setIssueNumber(Integer.valueOf(txtIssueNum.getText())); //Edits Issue Number
                                aGetItems.setIssueDate(txtDateOfIssue.getText()); //Edits IssueDate
                                aGetItems.setItemStock(Integer.valueOf(txtStock.getText())); //Edits item stock
                                aGetItems.setCostPrice(Double.valueOf(txtCost.getText())); //edits cost
                                out.println("AFTER: " + aGetItems.getTitle() + " " + aGetItems.getPublisher() + " " + aGetItems.getSubjectArea() + " " + aGetItems.getNumberofPages() + " " + aGetItems.getISSN() + " " + aGetItems.getIssueNumber() + aGetItems.getIssueDate() + " " + " " + aGetItems.getItemStock() + " " + aGetItems.getCostPrice()); //Shows item details after edit
                                serialiseItems(); //Edits item in file
                            }
                        }
                    }
                }
            }
        } catch (RuntimeException e) {
            out.println("Incorrect data-type Inputted");
        }
    } //Edits selected item

    private void serialiseItems() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src\\BunnyCorp\\Data\\Items.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myItems);
            out.close();
            fileOut.close();
            System.out.println("Edited Data has been saved in src\\BunnyCorp\\Data\\Items.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

    } //Modifies item in file

    public void back(ActionEvent back) throws IOException {
        getUsers(myUsers); //Gets data
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminStockMenu.fxml")); //Loads fxml from file path
        AnchorPane BackEditor = loader.load();
        A6a_AdminStockMenuClass passUsers = (A6a_AdminStockMenuClass) loader.getController();
        A6a_AdminStockMenuClass passItems = (A6a_AdminStockMenuClass) loader.getController();
        A6a_AdminStockMenuClass passLoans = (A6a_AdminStockMenuClass) loader.getController();
        passItems.getItems(myItems); //Sends data to class
        passUsers.getUsers(myUsers);
        passLoans.getLoans(myLoans);
        Scene BackViewScene = new Scene(BackEditor); //Sets Admin Stock Menu  fxml as new scene
        Stage window = (Stage) ((Node) back.getSource()).getScene().getWindow(); //sets windows to Admin Stock Menu fxml
        window.setScene(BackViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows Admin Stock Menu fxml
    } //Sends admin back to menu

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VideoFormat.getItems().addAll("DVD", "VHS", "Blu-Ray");
        VideoStorageType.getItems().addAll("DVD Case", "VHS Case", "Blu-Ray Case");

        CDFormat.getItems().addAll("Audio CD", "DVD Audio", "Super Audio CD");
        CDStorageType.getItems().addAll("CD Jewel Case", "SJB Plus", "SJB Standard");
    } //Adds strings to choice boxes
}
