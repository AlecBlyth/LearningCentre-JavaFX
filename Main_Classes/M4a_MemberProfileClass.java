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
import java.time.format.DateTimeFormatter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class M4a_MemberProfileClass implements Initializable {

    //FXML components
    public TextField txtUsername;
    public TextField txtFirstname;
    public TextField txtSurname;
    public TextField txtAddress;
    public TextField txtCity;
    public TextField txtPostcode;
    public TextField txtNum;
    public TextField txtPassword;
    public DatePicker datePicker;
    public Label lblUsername;
    public Label lblFirstname;
    public Label lblSurname;
    public Label lblAddress;
    public Label lblTown;
    public Label lblPostcode;
    public Label lblNum;
    public Label lblPass;
    public Label lblBirth;
    public ChoiceBox userTypeBox;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.UK); //UK date format

    public ArrayList<Users<String>> myUsers; //User array list
    public ArrayList<Items> myItems; //Item array list
    public ArrayList<Loans> myLoans; //Loan array list
    private int loggedUser; //Current logged in user

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    }

    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    }

    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    }

    public void setLoggedUser(int loggedUser) {
        this.loggedUser = loggedUser;
    }

    public void loadProfile() {
        if (myItems != null) {
            for (Users<String> aGetUsers : myUsers) { //For each user in user array
                if (myUsers != null) {
                    if (loggedUser == aGetUsers.getUserID()) { //If logged in user is found in array, display their details
                        txtUsername.setText(aGetUsers.getUser());
                        txtFirstname.setText(aGetUsers.getFirstName());
                        txtSurname.setText(aGetUsers.getSecondName());
                        txtAddress.setText(aGetUsers.getAddress());
                        txtCity.setText(aGetUsers.getTown());
                        txtNum.setText(aGetUsers.getPhoneNum());
                        txtPostcode.setText(aGetUsers.getPostCode());
                        txtPassword.setText(aGetUsers.getPass());
                        Object currentUserType = aGetUsers.getType();
                        datePicker.setPromptText(aGetUsers.getDOB());
                        userTypeBox.setValue(currentUserType);
                    }
                }
            }
        }
    } //Fills user's profile will their details

    public void updateUser() {
        try {
            if (myUsers != null) {
                for (Users aGetUsers : myUsers) {
                    String scannedName = aGetUsers.getUser();
                    if (myUsers != null) {
                        if (txtUsername.getText().equals(scannedName)) { //Username validation, prevents user from changing their username to one that is taken.
                            out.println("Username has been found!");
                            break;
                        }
                        if (!txtUsername.getText().isEmpty()) { //If username isn't empty or taken then edit user
                            if (loggedUser == (aGetUsers.getUserID())) {
                                aGetUsers.setUser(txtUsername.getText());
                                serialiseUsers(); //Adds edited user to file
                            }
                        } else {
                            out.println("Data empty!");
                        }
                    }
                }
            }
        } catch (RuntimeException e) {
            out.println("Incorrect data-type Inputted");
        }
        try {
            if (myUsers != null) {
                for (Users aGetUsers : myUsers) { //For each user in user array
                    if (myUsers != null) {
                        if ((!txtFirstname.getText().isEmpty()) || (!txtSurname.getText().isEmpty()) || (!txtAddress.getText().isEmpty()) || (!txtCity.getText().isEmpty()) || (!txtPostcode.getText().isEmpty()) || (!txtNum.getText().isEmpty()) || (!txtPassword.getText().isEmpty())) { //Textfield validation
                            if (loggedUser == (aGetUsers.getUserID())) {
                                out.println("BEFORE: " + aGetUsers.getUser() + " " + aGetUsers.getFirstName() + " " + aGetUsers.getSecondName() + " " + aGetUsers.getAddress() + " " + aGetUsers.getTown() + " " + aGetUsers.getPostCode() + " " + aGetUsers.getPhoneNum() + " " + aGetUsers.getDOB() + " " + aGetUsers.getType() + " " + aGetUsers.getPass()); //Shows profile before edit
                                aGetUsers.setFirstName(txtFirstname.getText()); //Edits first name
                                aGetUsers.setSecondName(txtSurname.getText()); //Edits surname
                                aGetUsers.setAddress(txtAddress.getText()); //Edits address
                                aGetUsers.setTown(txtCity.getText()); //Edits town/city
                                aGetUsers.setPostCode(txtPostcode.getText()); //Edits post code
                                aGetUsers.setPhoneNum(txtNum.getText()); //Edits phone number
                                aGetUsers.setPass(txtPassword.getText()); //Edits password
                                try {
                                    String formattedDate = (datePicker.getValue()).format(formatter); //Sets date format
                                    datePicker.setPromptText(formattedDate); //sets datepicker prompt text to date format
                                    String Date = formattedDate; //Sets date to format
                                    aGetUsers.setDOB(String.valueOf(Date)); //edits date
                                } catch (NullPointerException e) {
                                    out.println("No Date entered or no change"); //Informs dev no change has been made
                                }
                                aGetUsers.setType(userTypeBox.getValue()); //edits membership
                                out.println("AFTER: " + aGetUsers.getUser() + " " + aGetUsers.getFirstName() + " " + aGetUsers.getSecondName() + " " + aGetUsers.getAddress() + " " + aGetUsers.getTown() + " " + aGetUsers.getPostCode() + " " + aGetUsers.getPhoneNum() + " " + aGetUsers.getDOB() + " " + aGetUsers.getType() + " " + aGetUsers.getPass()); //Shows profile after edit
                                serialiseUsers();
                            }
                        }
                    } else {
                        out.println("Data empty!");
                    }
                }
            }
        } catch (RuntimeException e) {
            out.println("Incorrect data-type Inputted");
        }
    } //Edits user's profile

    private void serialiseUsers() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src\\BunnyCorp\\Data\\UserData.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myUsers);
            out.close();
            fileOut.close();
            System.out.println("Updated Data has been saved in src\\BunnyCorp\\Data\\UserData.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //Adds edited profile to file

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
        passLog.setLoggedUser(loggedUser); //Sends data to class
        passUsers.getUsers(myUsers);
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene backViewScene = new Scene(backViewParent); //Sets member menu fxml as new scene
        Stage window = (Stage) ((Node) back.getSource()).getScene().getWindow(); //sets windows to member menu fxml
        window.setScene(backViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows member menu fxml
    } //Sends member back to menu

    public void initialize(URL url, ResourceBundle rb) {
        userTypeBox.getItems().addAll("STAFF", "MEMBER", "CASUAL");
    } //Adds data to choice box
}
