package BunnyCorp.Main_Classes;

import BunnyCorp.Classes.Items;
import BunnyCorp.Classes.Loans;
import BunnyCorp.Classes.Users;
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
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class A4a_AdminUserCreatorClass implements Initializable {

    public ArrayList<Users<String>> myUsers; //User object array list
    public ArrayList<Items> myItems; //Item object array list
    public ArrayList<Loans> myLoans; //Loan object array list

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    } //Gets user data from classes

    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    } //Gets item data from classes

    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    } //Gets loan data from classes

    //User Creator FXML components
    public TextField CreateUsername;
    public TextField CreateFirstname;
    public TextField CreateSurname;
    public TextField CreateAddress;
    public TextField CreateCity;
    public TextField CreatePostcode;
    public TextField CreatePhone;
    public DatePicker CreateDOB;
    public TextField CreatePassword;
    public ChoiceBox<String> CreateMember;

    public Label emptyUsername;
    public Label emptyFirstname;
    public Label emptySurname;
    public Label emptyAddress;
    public Label emptyCity;
    public Label emptyPostcode;
    public Label emptyPhone;
    public Label emptyBirth;
    public Label emptyPassword;

    //User data variables
    private String scannedName; //Used to validate taken username
    private String userName;
    private String firName;
    private String secName;
    private String userAddress;
    private String userTown;
    private String userPost;
    private String userNum;
    private String passWord;
    private int nextUsersID;
    private static final String fileName = "src\\BunnyCorp\\Data\\UserData.txt"; //Setting fileName to UserData.txt | Used for BufferedWriter
    private boolean found = false;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.UK); //Used to format date from XX-XX-XXXX to xx/XX/xxxx

    public void createUser() {
        getUsers(myUsers); //Gets data
        getItems(myItems);
        getLoans(myLoans);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) { //Appends textfile
            if (myUsers != null) {
                int i = 0;
                while (i < myUsers.toArray().length) { //Loops throughout registered users
                    if (myUsers.get(i) != null) {
                        for (Users<String> aGetUsers : myUsers) { //This replaces the scanner which was used to validate duplicate usernames, however for each new user, it wouldn't detect new additions to the text file, To fix this, replaced scanner with a for each loop.
                            if (aGetUsers != null) {
                                scannedName = (aGetUsers.getUser()); //scannedName = all current usernames
                                nextUsersID = (aGetUsers.getUserID()); //nextUserID = last user's ID
                                nextUsersID++; //Increments by 1
                                if (CreateUsername.getText().isEmpty()) { //If username isn't inputted, break program and inform user of missing data
                                    emptyUsername.setText("Empty!");
                                    emptyUsername.setVisible(true);
                                    found = false;
                                } else if (CreateUsername.getText().equals(scannedName)) { //If username is taken, break and inform user of matching data
                                    emptyUsername.setText("Taken!");
                                    emptyUsername.setVisible(true);
                                    found = true;
                                    break;
                                } else {
                                    userName = CreateUsername.getText(); //If username is unique and isn't empty, UserName = text in textfield
                                    emptyUsername.setVisible(false);
                                    found = false;
                                }
                            }
                        }
                        if (!found) {
                            out.println("Username validation has found no duplicates in memory"); //Informs developer is username is unique
                        }
                        if (CreateFirstname.getText().isEmpty()) { //Firstname validation
                            emptyFirstname.setVisible(true);
                        } else {
                            firName = CreateFirstname.getText();
                            emptyFirstname.setVisible(false);
                        }
                        if (CreateSurname.getText().isEmpty()) { //Surname validation
                            emptySurname.setVisible(true);
                        } else {
                            secName = CreateSurname.getText();
                            emptySurname.setVisible(false);
                        }
                        if (CreateAddress.getText().isEmpty()) { //Address validation
                            emptyAddress.setVisible(true);
                        } else {
                            userAddress = CreateAddress.getText();
                            emptyAddress.setVisible(false);
                        }
                        if (CreateCity.getText().isEmpty()) { //Town/City validation
                            emptyCity.setVisible(true);
                        } else {
                            userTown = CreateCity.getText();
                            emptyCity.setVisible(false);
                        }
                        if (CreatePostcode.getText().isEmpty()) { //Postcode validation
                            emptyPostcode.setVisible(true);
                        } else {
                            userPost = CreatePostcode.getText();
                            emptyPostcode.setVisible(false);
                        }
                        if (CreatePhone.getText().isEmpty()) { //Phone validation
                            emptyPhone.setVisible(true);
                        } else {
                            userNum = CreatePhone.getText();
                            emptyPhone.setVisible(false);
                        }
                        if (CreatePassword.getText().isEmpty()) { //Password validation
                            emptyPassword.setVisible(true);
                        } else {
                            passWord = CreatePassword.getText();
                            emptyPassword.setVisible(false);
                        }
                        String userDOB;
                        try {
                            String formattedDate = (CreateDOB.getValue()).format(formatter); //Date of birth validation
                            CreateDOB.setPromptText(formattedDate); //Sets input to format
                            userDOB = formattedDate; //Sets variable to formatted date
                        } catch (NullPointerException e) { //Breaks if no data is entered
                            out.println("User has failed to enter date");
                            CreateDOB.setPromptText("Invalid!");
                            break;
                        }
                        if ((CreateUsername.getText().isEmpty() || (CreateFirstname.getText().isEmpty() || (CreateSurname.getText().isEmpty() || (CreateAddress.getText().isEmpty() || (CreateCity.getText().isEmpty() || (CreatePostcode.getText().isEmpty() || (CreatePhone.getText().isEmpty() || CreatePassword.getText().isEmpty() || CreateUsername.getText().equals(scannedName))))))))) {
                            out.println("Unable to create new user"); //Prevents admin from creating empty user
                            break;
                        } else {
                            String userType = CreateMember.getValue(); //Sets choicebox string to userType
                            String memberID = Integer.toString(nextUsersID); //sets String to Integer
                            writer.write(memberID + "|" + userName + "|" + passWord + "|" + firName + "|" + secName + "|" + userAddress + "|" + userTown + "|" + userPost + "|" + userNum + "|" + userDOB + "|" + userType + "|");
                            writer.newLine(); //Writes new user to text file
                            out.println(nextUsersID); //Prints out new user's ID
                            Users<String> u = new Users<>(nextUsersID, userName, passWord, firName, secName, userAddress, userTown, userPost, userNum, userDOB, userType); //Adds new user data to array
                            myUsers.add(u);  //Adds new user object into array
                            serialiseUsers(); //Serialises new user
                        }
                        break; //stops loop
                    }
                    i++; //increments i
                }
            }
        } catch (IOException e) {
            out.println(e);
        }
    } //User creation method, called on button click

    private void serialiseUsers() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src\\BunnyCorp\\Data\\UserData.ser"); //Opens file
            ObjectOutputStream out = new ObjectOutputStream(fileOut); //creates new output stream
            out.writeObject(myUsers); //Writes to file
            out.close(); //closes output stream
            fileOut.close(); //closes file
            System.out.println("New Data has been saved in src\\BunnyCorp\\Data\\UserData.ser"); //informs user of new data
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //Serialises users when new user is created

    public void viewUsers(ActionEvent viewUsers) throws IOException {

        getUsers(myUsers); //Gets data
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminUserList.fxml")); //Loads fxml from file path
        AnchorPane viewUsersParent = loader.load();
        A4b_AdminUserListClass passUsers = (A4b_AdminUserListClass) loader.getController();
        A4b_AdminUserListClass passItems = (A4b_AdminUserListClass) loader.getController();
        A4b_AdminUserListClass passLoans = (A4b_AdminUserListClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends new data to class
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene viewUsersScene = new Scene(viewUsersParent); //Sets UserList fxml as new scene
        Stage window = (Stage) ((Node) viewUsers.getSource()).getScene().getWindow(); //sets windows to UserList fxml
        window.setScene(viewUsersScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows UserList fxml
    } //Sends admin to user list

    public void Back(ActionEvent back) throws IOException {

        getUsers(myUsers); //Gets new data
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminMenu.fxml")); //Loads fxml from file path
        AnchorPane backViewParent = loader.load();
        A3_AdminMenuClass passUsers = (A3_AdminMenuClass) loader.getController();
        A3_AdminMenuClass passItems = (A3_AdminMenuClass) loader.getController();
        A3_AdminMenuClass passLoans = (A3_AdminMenuClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends new data to class
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene backViewScene = new Scene(backViewParent); //Sets admin menu fxml as new scene
        Stage window = (Stage) ((Node) back.getSource()).getScene().getWindow(); //sets windows to admin menu fxml
        window.setScene(backViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows admin menu fxml
    } //Sends user back to menu

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CreateMember.getItems().addAll("STAFF", "MEMBER", "CASUAL");
        CreateMember.setValue("MEMBER"); //Sets default choice to MEMBER
    } //Loads strings into choice box when loaded.
}
