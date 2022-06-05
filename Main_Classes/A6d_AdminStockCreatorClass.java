package BunnyCorp.Main_Classes;

import BunnyCorp.Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class A6d_AdminStockCreatorClass implements Initializable {

    //Default FXML Properties
    public TextField txtStock;
    public TextField txtCost;
    public ChoiceBox itemType;
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
    public Label lblVideoTitle;
    public Label lblVideoPublisher;
    public Label lblVideoRuntime;
    public Label lblVideoGenre;

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
    public Label lblCDTitle;
    public Label lblCDPublisher;
    public Label lblCDRuntime;
    public Label lblArtist;
    public Label lblTracks;

    //Book FXML Properties
    public VBox BookBox;
    public VBox BookLabels;
    public TextField txtBookTitle;
    public TextField txtBookPublisher;
    public TextField txtBookSubject;
    public TextField txtBookPages;
    public TextField txtBookISBN;
    public TextField txtBookAuthor;
    public Label lblBookTitle;
    public Label lblBookPublisher;
    public Label lblBookSubject;
    public Label lblBookPages;
    public Label lblBookISBN;
    public Label lblBookAuthor;

    //Journal FXML Properties
    public VBox JournalBox;
    public VBox JournalLabels;
    public TextField txtJournalTitle;
    public TextField txtJournalPublisher;
    public TextField txtJournalSubject;
    public TextField txtJournalPages;
    public TextField txtJournalISSN;
    public TextField txtIssueNum;
    public DatePicker datePicker;
    public Label lblJournalTitle;
    public Label lblJournalPublisher;
    public Label lblJournalSubject;
    public Label lblJournalPages;
    public Label lblJournalISSN;
    public Label lblJournalIssueNum;
    public Label lblIssueDate;

    //Arraylist and Getters
    public ArrayList<Users<String>> myUsers;
    public ArrayList<Items> myItems;
    public ArrayList<Loans> myLoans;

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    } //Get Users from class

    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    } //Gets Items from class

    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    } //Gets loans from class

    //Default Variables
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.UK); //Sets date format
    private boolean found = false;
    private String ScannedTitle;
    private String itemTitle;
    private String itemPublisher;
    private int StockLevel;
    private int newID;
    private double Cost;

    //Paper Media Variables
    private File books = new File("src\\BunnyCorp\\Data\\Books.txt");
    private File journals = new File("src\\BunnyCorp\\Data\\Journals.txt");
    private boolean bookSelected = false;
    private boolean journalSelected = false;
    private String subject;
    private String bookAuthor;
    private String bookISBN;
    private String DateOfIssue;
    private int IssueNum;
    private int numOfPages;

    //Digital Variables
    private File compactDiscs = new File("src\\BunnyCorp\\Data\\CompactDiscs.txt");
    private File videos = new File("src\\BunnyCorp\\Data\\Videos.txt");
    private boolean videoSelected = false;
    private boolean CDSelected = false;
    private String videoGenre;
    private String storageType;
    private String Artist;
    private int runTime;

    public void changeItemType() {
        if (itemType.getValue().equals("Compact Disc")) { //If item type is CD then show and enable CD controls and disable/hide non CD controls

            CDSelected = true;
            videoSelected = false;
            bookSelected = false;
            journalSelected = false;

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

        }
        if (itemType.getValue().equals("Video")) { //If item type is Video then show and enable Video controls and disable/hide non Video controls

            videoSelected = true;
            CDSelected = false;
            bookSelected = false;
            journalSelected = false;

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

        }
        if (itemType.getValue().equals("Book")) { //If item type is Book then show and enable Book controls and disable/hide non Book controls

            bookSelected = true;
            videoSelected = false;
            CDSelected = false;
            journalSelected = false;

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

        }
        if (itemType.getValue().equals("Journal")) { //If item type is Journal then show and enable Journal controls and disable/hide non Journal controls

            journalSelected = true;
            bookSelected = false;
            videoSelected = false;
            CDSelected = false;

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
        }
    } //Changes Item Type

    public void createItem() {

        getItems(myItems); //Gets data
        getUsers(myUsers);
        getLoans(myLoans);

        if (videoSelected) {
            createVideo();
        }
        if (CDSelected) {
            createCD();
        }
        if (bookSelected) {
            createBook();
        }
        if (journalSelected) {
            createJournal();
        }
    } //Create item called when Create button is clicked

    private void createVideo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(videos, true))) { //Opens a new Buffered Writer and replaces text in file with new text inputted by user
            for (int i = 0; i < myItems.toArray().length; i++) { //Loops for each item within item array's length
                if (myItems.get(i) != null) {
                    for (Items aMyItems : myItems) { //Loops for each item within item array, used to scan duplicate titles
                        if (aMyItems != null) {
                            newID = (aMyItems.getStockID());
                            newID++;
                            out.println(newID);
                            ScannedTitle = (aMyItems.getTitle()); //Every title within item class title becomes ScannedTitle
                            if (txtVideoTitle.getText().isEmpty()) { //If the user doesn't enter anything, program doesn't collect empty string
                                lblVideoTitle.setStyle("-fx-text-fill: red");
                                lblVideoTitle.setText("Empty!"); //Informs user of empty textfield
                            } else if (txtVideoTitle.getText().equals(ScannedTitle)) { //If input matches title found in memory, user is informed.
                                lblVideoTitle.setStyle("-fx-text-fill: red");
                                lblVideoTitle.setText("Taken!"); //Like this
                                found = true; //Found boolean becomes true
                                break;
                            } else {
                                itemTitle = txtVideoTitle.getText(); //If textfield has text and isn't taken input is accepted
                                lblVideoTitle.setStyle("-fx-text-fill: white");
                                lblVideoTitle.setText("Title:"); //Hides to inform user input is accepted
                            }
                        }
                    }
                    if (!found) {
                        out.println("Item validation has found no duplicates in memory"); //Informs developer no duplicates have been found
                    }
                    if (txtVideoPublisher.getText().isEmpty()) { //Gets publisher from textfield
                        lblVideoPublisher.setStyle("-fx-text-fill: red");
                        lblVideoPublisher.setText("Empty!");
                    } else {
                        itemPublisher = txtVideoPublisher.getText();
                        lblVideoPublisher.setStyle("-fx-text-fill: white");
                        lblVideoPublisher.setText("Publisher:");
                    }
                    try {
                        runTime = Integer.parseInt(txtVideoRuntime.getText());
                        lblVideoRuntime.setStyle("-fx-text-fill: white");
                        lblVideoRuntime.setText("Runtime:");
                    } catch (NumberFormatException e) { //Validates for numerical values only
                        out.println("User has entered invalid input for video");
                        lblVideoRuntime.setStyle("-fx-text-fill: red");
                        lblVideoRuntime.setText("Enter valid input!");
                        break; //Stops program unless numerical value is entered.
                    }
                    if (txtGenre.getText().isEmpty()) { //Gets Genre information from textfield
                        lblVideoGenre.setStyle("-fx-text-fill: red");
                        lblVideoGenre.setText("Empty!");
                    } else {
                        videoGenre = txtGenre.getText();
                        lblVideoGenre.setStyle("-fx-text-fill: white");
                        lblVideoGenre.setText("Genre:");
                    }
                    try {
                        StockLevel = Integer.parseInt(txtStock.getText()); //Gets stock amount from user
                        txtStock.setPromptText("Enter Stock");
                    } catch (NumberFormatException e) {
                        out.println("User has entered invalid video input");
                        txtStock.setPromptText("Invalid!");
                        break;
                    }
                    try {
                        Cost = Double.parseDouble(txtCost.getText()); //Gets cost amount from user
                        txtCost.setPromptText("Enter Cost");
                    } catch (NumberFormatException e) {
                        out.println("User has entered invalid video input");
                        txtCost.setPromptText("Invalid!");
                    }

                    if ((txtVideoTitle.getText().isEmpty() || (txtVideoPublisher.getText().isEmpty() || (txtGenre.getText().isEmpty() || txtVideoTitle.getText().equals(ScannedTitle)))) || txtStock.getText().isEmpty() || txtCost.getText().isEmpty()) { //Stops program from creating video object in memory unless all inputs are entered.
                        out.println("Cannot create video item as required information is absent");
                        break;
                    } else {
                        String itemType = "Video";
                        String videoType = VideoFormat.getValue().toString();
                        storageType = VideoStorageType.getValue().toString();
                        if (storageType.equals("VHS Case") && (videoType.equals("DVD") || (videoType.equals("Blu-Ray")))) {
                            out.println("Why did you put a disc inside a box? It doesn't even have anything to hold it. It's just going to move around whenever you move the case.");
                        }
                        if (storageType.equals("DVD Case") || (storageType.equals("Blu-Ray Case") && (videoType.equals("VHS")))) {
                            out.println("A VHS cannot fit inside a disc case, but since you insist, we've taped the chosen case to the VHS using sellotape.");
                        }
                        writer.write(newID + "|" + itemTitle + "|" + itemPublisher + "|" + videoGenre + "|" + videoType + "|" + runTime + "|" + Cost + "|" + storageType + "|" + StockLevel + "|" + itemType + "|");
                        writer.newLine();
                        Items videos = new Videos(newID, itemTitle, itemPublisher, videoGenre, videoType, runTime, Cost, storageType, StockLevel, itemType); //Adds new video object
                        myItems.add(videos); //Adds new item to array
                        serialiseItems(); //Adds item to file
                        out.println("Video has been created and is stored in memory"); //Informs developer of successful creation of object in memory
                    }
                    break; //Ends loop
                }
            }
        } catch (IOException e) { //Catches IO Exception is file is altered/not found
            e.printStackTrace();
        }
    } //Creates Video

    private void createCD() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(compactDiscs, true))) {
            for (int i = 0; i < myItems.toArray().length; i++) {
                if (myItems.get(i) != null) {
                    for (Items aMyItems : myItems) {
                        newID = (aMyItems.getStockID()); //Increments new ID for each item created.
                        newID++;
                        ScannedTitle = (aMyItems.getTitle());
                        if (txtCDTitle.getText().isEmpty()) {
                            lblCDTitle.setStyle("-fx-text-fill: red");
                            lblCDTitle.setText("Empty!");
                        } else if (txtCDTitle.getText().equals(ScannedTitle)) {
                            lblCDTitle.setText("Taken!");
                            lblCDTitle.setStyle("-fx-text-fill: red");
                            found = true;
                            break;
                        } else {
                            itemTitle = txtCDTitle.getText();
                            lblCDTitle.setStyle("-fx-text-fill: white");
                            lblCDTitle.setText("Title:");
                        }
                    }
                    if (!found) {
                        out.println("Item validation has found no duplicates in memory");
                    }
                    if (txtCDPublisher.getText().isEmpty()) {
                        lblCDPublisher.setStyle("-fx-text-fill: red");
                        lblCDPublisher.setText("Empty!");
                    } else {
                        lblCDPublisher.setStyle("-fx-text-fill: white");
                        itemPublisher = txtCDPublisher.getText();
                        lblCDPublisher.setText("Publisher:");
                    }
                    try {
                        runTime = Integer.parseInt(txtCDRuntime.getText());
                        lblCDRuntime.setStyle("-fx-text-fill: white");
                        lblCDRuntime.setText("Runtime:");
                    } catch (NumberFormatException e) {
                        out.println("User has entered invalid CD input");
                        lblCDRuntime.setStyle("-fx-text-fill: red");
                        lblCDRuntime.setText("Enter valid input!");
                        break;
                    }
                    if (txtArtist.getText().isEmpty()) {
                        lblArtist.setStyle("-fx-text-fill: red");
                        lblArtist.setText("Empty!");
                    } else {
                        Artist = txtArtist.getText();
                        lblArtist.setStyle("-fx-text-fill: white");
                        lblArtist.setText("Artist:");
                    }
                    int numOfTracks;
                    try {
                        numOfTracks = Integer.parseInt(txtTracks.getText());
                        lblTracks.setStyle("-fx-text-fill: white");
                        lblTracks.setText("Tracks:");
                    } catch (NumberFormatException e) {
                        out.println("User has entered invalid CD input");
                        lblTracks.setStyle("-fx-text-fill: red");
                        lblTracks.setText("Enter valid input!");
                        break;
                    }
                    try {
                        StockLevel = Integer.parseInt(txtStock.getText()); //Gets stock amount from user
                        txtStock.setPromptText("Enter Stock");
                    } catch (NumberFormatException e) {
                        out.println("User has entered invalid CD input");
                        txtStock.setPromptText("Invalid!");
                        break;
                    }
                    try {
                        Cost = Double.parseDouble(txtCost.getText()); //Gets cost amount from user
                        txtCost.setPromptText("Enter Cost");
                    } catch (NumberFormatException e) {
                        out.println("User has entered invalid CD input");
                        txtCost.setPromptText("Invalid!");
                    }
                    if ((txtCDTitle.getText().isEmpty() || (txtCDPublisher.getText().isEmpty() || (txtArtist.getText().isEmpty() || txtCDTitle.getText().equals(ScannedTitle)))) || txtStock.getText().isEmpty() || txtCost.getText().isEmpty()) {
                        out.println("Cannot create CD item as required information is absent");
                        break;
                    } else {
                        String itemType = "Compact Disc";
                        String CDType = CDFormat.getValue().toString();
                        storageType = CDStorageType.getValue().toString();
                        writer.write(newID + "|" + itemTitle + "|" + Artist + "|" + itemPublisher + "|" + numOfTracks + "|" + runTime + "|" + "|" + Cost + "|" + CDType + "|" + storageType + "|" + StockLevel + "|" + itemType + "|");
                        writer.newLine();
                        Items CDs = new CompactDiscs(newID++, itemTitle, Artist, itemPublisher, numOfTracks, runTime, Cost, CDType, storageType, StockLevel, itemType); //Adds new CD object
                        myItems.add(CDs); //Adds CD to Array
                        serialiseItems(); //Adds item to file
                        out.println("CD has been created");
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //Creates CD

    private void createBook() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(books, true))) { //Opens a new Buffered Writer and replaces text in file with new text inputted by user
            for (int i = 0; i < myItems.toArray().length; i++) { //Loops for each item within item array's length
                if (myItems.get(i) != null) {
                    for (Items aMyItems : myItems) { //Loops for each item within item array, used to scan duplicate titles
                        newID = (aMyItems.getStockID()); //Increments new ID for Book Item
                        newID = newID + 1; //Creates ID for Book item
                        ScannedTitle = (aMyItems.getTitle()); //Every title within item class title becomes ScannedTitle
                        if (txtBookTitle.getText().isEmpty()) { //If the user doesn't enter anything, program doesn't collect empty string
                            lblBookTitle.setText("Empty!"); //Informs user of empty textfield
                            lblBookTitle.setStyle("-fx-text-fill: red");
                        } else if (txtBookTitle.getText().equals(ScannedTitle)) { //If input matches title found in memory, user is informed.
                            lblBookTitle.setText("Taken!"); //Like this
                            lblBookTitle.setStyle("-fx-text-fill: red");
                            found = true; //Found boolean becomes true
                            break; //Stops program
                        } else {
                            itemTitle = txtBookTitle.getText(); //If textfield has text and isn't taken input is accepted
                            lblBookTitle.setText("Title:");
                            lblBookTitle.setStyle("-fx-text-fill: white");
                        }
                    }
                    if (!found) {
                        out.println("Item validation has found no duplicates in memory"); //Informs developer no duplicates have been found
                    }
                    if (txtBookPublisher.getText().isEmpty()) {
                        lblBookPublisher.setText("Empty!");
                        lblBookPublisher.setStyle("-fx-text-fill: red");
                    } else {
                        itemPublisher = txtBookPublisher.getText();
                        lblBookPublisher.setText("Publisher:");
                        lblBookPublisher.setStyle("-fx-text-fill: white");
                    }
                    if (txtBookSubject.getText().isEmpty()) { //Gets subject from textfield
                        lblBookSubject.setText("Empty!");
                        lblBookSubject.setStyle("-fx-text-fill: red");
                    } else {
                        lblBookSubject.setText("Subject Area:");
                        subject = txtBookSubject.getText();
                        lblBookSubject.setStyle("-fx-text-fill: white");
                    }
                    try {
                        numOfPages = Integer.parseInt(txtBookPages.getText());
                        lblBookPages.setText("Pages"); //Like this
                        lblBookPages.setStyle("-fx-text-fill: white");
                    } catch (NumberFormatException e) { //Validates for numerical values only
                        out.println("User has entered invalid input for pages");
                        lblBookPages.setText("Enter valid input!");
                        lblBookPages.setStyle("-fx-text-fill: red");
                        break; //Stops program unless numerical value is entered.
                    }
                    if (txtBookISBN.getText().isEmpty()) { //Gets ISBN from textfield
                        lblBookISBN.setText("Empty!");
                        lblBookISBN.setStyle("-fx-text-fill: red");
                    } else {
                        bookISBN = txtBookISBN.getText();
                        lblBookISBN.setText("Subject Area:");
                        lblBookISBN.setStyle("-fx-text-fill: white");
                    }
                    if (txtBookAuthor.getText().isEmpty()) { //Gets Author information from textfield
                        lblBookAuthor.setText("Empty!");
                        lblBookAuthor.setStyle("-fx-text-fill: red");
                    } else {
                        bookAuthor = txtBookAuthor.getText();
                        lblBookAuthor.setText("Author:");
                        lblBookAuthor.setStyle("-fx-text-fill: white");
                    }
                    try {
                        StockLevel = Integer.parseInt(txtStock.getText()); //Gets stock amount from user
                        txtStock.setPromptText("Enter Stock");
                    } catch (NumberFormatException e) {
                        out.println("User has entered invalid Book input");
                        txtStock.setPromptText("Invalid!");
                        break;
                    }
                    try {
                        Cost = Double.parseDouble(txtCost.getText()); //Gets cost amount from user
                        txtCost.setPromptText("Enter Cost");
                    } catch (NumberFormatException e) {
                        out.println("User has entered invalid Book input");
                        txtCost.setPromptText("Invalid!");
                    }
                    if ((txtBookTitle.getText().isEmpty() || (txtBookPublisher.getText().isEmpty() || (txtBookAuthor.getText().isEmpty() || txtBookTitle.getText().equals(ScannedTitle) || txtBookISBN.getText().isEmpty() || txtBookSubject.getText().isEmpty() || txtStock.getText().isEmpty() || txtCost.getText().isEmpty())))) { //Stops program from creating book object in memory unless all inputs are entered.
                        out.println("Cannot create book item as required information is absent");
                    } else {
                        String itemType = "Book";
                        writer.write(newID + "|" + bookISBN + "|" + bookAuthor + "|" + itemTitle + "|" + Cost + "|" + subject + "|" + itemPublisher + "|" + numOfPages + "|" + StockLevel + "|" + itemType + "|");
                        writer.newLine();
                        Items books = new Books(newID++, bookISBN, bookAuthor, itemTitle, Cost, subject, itemPublisher, numOfPages, StockLevel, itemType); //Adds new item object
                        myItems.add(books); //Adds new book to array
                        serialiseItems(); //Adds item to file
                        out.println("Book has been created and is stored in memory"); //Informs developer of successful creation of object in memory
                    }
                    break; //Ends loop
                }
            }
        } catch (IOException e) { //Catches IO Exception is file is altered/not found
            e.printStackTrace();
        }
    } //Creates book

    private void createJournal() {
        {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(journals, true))) { //Opens a new Buffered Writer and replaces text in file with new text inputted by user
                for (int i = 0; i < myItems.toArray().length; i++) { //Loops for each item within item array's length
                    if (myItems.get(i) != null) {
                        for (Items aMyItems : myItems) { //Loops for each item within item array, used to scan duplicate titles
                            newID = (aMyItems.getStockID()); //Increments new ID for Video Item
                            newID = newID + 1; //Creates ID for Journal item
                            ScannedTitle = (aMyItems.getTitle()); //Every title within item class title becomes ScannedTitle
                            if (txtJournalTitle.getText().isEmpty()) { //If the user doesn't enter anything, program doesn't collect empty string
                                lblJournalTitle.setStyle("-fx-text-fill: red");
                                lblJournalTitle.setText("Empty!"); //Informs user of empty textfield
                            } else if (txtJournalTitle.getText().equals(ScannedTitle)) { //If input matches title found in memory, user is informed.
                                lblJournalTitle.setStyle("-fx-text-fill: red");
                                lblJournalTitle.setText("Taken!"); //Like this
                                found = true; //Found boolean becomes true
                                break; //Stops program
                            } else {
                                itemTitle = txtJournalTitle.getText(); //If textfield has text and isn't taken input is accepted
                                lblJournalTitle.setText("Title:");
                                lblJournalTitle.setStyle("-fx-text-fill: white");
                            }
                        }
                        if (!found) {
                            out.println("Item validation has found no duplicates in memory"); //Informs developer no duplicates have been found
                        }
                        if (txtJournalPublisher.getText().isEmpty()) {
                            lblJournalPublisher.setText("Empty!");
                            lblJournalPublisher.setStyle("-fx-text-fill: red");
                        } else {
                            itemPublisher = txtJournalPublisher.getText();
                            lblJournalPublisher.setStyle("-fx-text-fill: white");
                            lblJournalPublisher.setText("Publisher:");

                        }
                        if (txtJournalSubject.getText().isEmpty()) { //Gets subject from textfield
                            lblJournalSubject.setText("Empty!");
                            lblJournalSubject.setStyle("-fx-text-fill: red");
                        } else {
                            lblJournalSubject.setText("Subject Area:");
                            lblJournalSubject.setStyle("-fx-text-fill: white");
                            subject = txtJournalSubject.getText();
                        }
                        try {
                            numOfPages = Integer.parseInt(txtJournalPages.getText());
                            lblJournalPages.setText("Pages");
                            lblJournalPages.setStyle("-fx-text-fill: white");
                        } catch (NumberFormatException e) { //Validates for numerical values only
                            out.println("User has entered invalid input for pages");
                            lblJournalPages.setStyle("-fx-text-fill: red");
                            lblJournalPages.setText("Enter valid input!");
                        }
                        if (txtJournalISSN.getText().isEmpty()) { //Gets ISSN from textfield
                            lblJournalISSN.setText("Empty!");
                            lblJournalISSN.setStyle("-fx-text-fill: red");
                        } else {
                            String journal_ISSN = txtJournalISSN.getText();
                            lblJournalISSN.setText("Enter ISSN:");
                            lblJournalISSN.setStyle("-fx-text-fill: white");
                            try {
                                IssueNum = Integer.parseInt(txtIssueNum.getText());
                                lblJournalIssueNum.setText("Issue Number:");
                                lblJournalIssueNum.setStyle("-fx-text-fill: white");
                            } catch (NumberFormatException e) { //Validates for numerical values only
                                out.println("User has entered invalid input for pages");
                                lblJournalIssueNum.setStyle("-fx-text-fill: red");
                                lblJournalIssueNum.setText("Enter valid input!");
                            }
                            try {
                                StockLevel = Integer.parseInt(txtStock.getText()); //Gets stock amount from user
                                txtStock.setPromptText("Enter Stock");
                            } catch (NumberFormatException e) {
                                out.println("User has entered invalid Journal input");
                                txtStock.setPromptText("Invalid!");
                            }
                            try {
                                Cost = Double.parseDouble(txtCost.getText()); //Gets cost amount from user
                                txtCost.setPromptText("Enter Cost");
                            } catch (NumberFormatException e) {
                                out.println("User has entered invalid Journal input");
                                txtCost.setPromptText("Invalid!");
                            }
                            try {
                                String formattedDate = (datePicker.getValue()).format(formatter);
                                datePicker.setPromptText(formattedDate);
                                DateOfIssue = formattedDate;
                            } catch (NullPointerException e) {
                                out.println("User has failed to enter date");
                                datePicker.setPromptText("Invalid!");
                            }
                            if ((txtJournalTitle.getText().isEmpty() || (txtJournalPublisher.getText().isEmpty() || (txtJournalISSN.getText().isEmpty() || txtJournalTitle.getText().equals(ScannedTitle) || txtJournalPages.getText().isEmpty() || txtJournalSubject.getText().isEmpty() || txtIssueNum.getText().isEmpty() || txtStock.getText().isEmpty() || txtCost.getText().isEmpty())))) { //Stops program from creating journal object in memory unless all inputs are entered.
                                out.println("Cannot create journal item as required information is absent");
                                break;
                            } else {
                                String itemType = "Journal";
                                writer.write(newID + "|" + journal_ISSN + "|" + itemTitle + "|" + Cost + "|" + subject + "|" + itemPublisher + "|" + IssueNum + "|" + DateOfIssue + "|" + numOfPages + "|" + StockLevel + "|" + itemType + "|");
                                writer.newLine();
                                Items journals = new Journals(newID, journal_ISSN, itemTitle, Cost, subject, itemPublisher, IssueNum, DateOfIssue, numOfPages, StockLevel, itemType); //Adds new journal object
                                myItems.add(journals); //Adds item to array
                                serialiseItems(); //Adds item to file
                                out.println("journal has been created and is stored in memory"); //Informs developer of successful creation of object in memory
                            }
                            break; //Ends loop
                        }
                    }
                }
            } catch (IOException e) { //Catches IO Exception is file is altered/not found
                e.printStackTrace();
            }
        }
    } //Creates journal

    private void serialiseItems() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src\\BunnyCorp\\Data\\Items.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myItems);
            out.close();
            fileOut.close();
            System.out.println("New Data has been saved in src\\BunnyCorp\\Data\\Items.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

    } //Adds new items to file

    public void back(ActionEvent back) throws IOException {

        getUsers(myUsers);
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminStockMenu.fxml")); //Loads fxml from file path
        AnchorPane backViewParent = loader.load();
        A6a_AdminStockMenuClass passUsers = (A6a_AdminStockMenuClass) loader.getController();
        A6a_AdminStockMenuClass passItems = (A6a_AdminStockMenuClass) loader.getController();
        A6a_AdminStockMenuClass passLoans = (A6a_AdminStockMenuClass) loader.getController();
        passUsers.getUsers(myUsers);
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene BackViewScene = new Scene(backViewParent); //Sets Admin Stock Menu  fxml as new scene
        Stage window = (Stage) ((Node) back.getSource()).getScene().getWindow(); //sets windows to Admin Stock Menu u fxml
        window.setScene(BackViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows Admin Stock Menu fxml
    } //Sends admin back to stock menu

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        itemType.getItems().addAll("Video", "Compact Disc", "Book", "Journal");
        itemType.setValue("Video");

        CDFormat.getItems().addAll("Audio CD", "DVD Audio", "Super Audio CD");
        CDFormat.setValue("Audio CD");

        CDStorageType.getItems().addAll("CD Jewel Case", "SJB Plus", "SJB Standard");
        CDStorageType.setValue("CD Jewel Case");

        VideoFormat.getItems().addAll("DVD", "VHS", "Blu-Ray");
        VideoFormat.setValue("DVD");

        VideoStorageType.getItems().addAll("DVD Case", "VHS Case", "Blu-Ray Case");
        VideoStorageType.setValue("DVD Case");
    } //Adds data to choice boxes
}
