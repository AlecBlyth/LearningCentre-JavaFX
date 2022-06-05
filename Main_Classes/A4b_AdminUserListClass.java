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

import java.io.FileInputStream;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.util.ArrayList;

import static java.lang.System.out;


public class A4b_AdminUserListClass {

    //FXML Component
    public TextArea textAreaUsers;

    //newLine creates new line when printing out data
    private String newLine = System.getProperty("line.separator");

    public ArrayList<Users<String>> myUsers; //User array list
    public ArrayList<Items> myItems; //Item array list
    public ArrayList<Loans> myLoans; //Loan array list

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    } //Gets user data from previous class

    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    } //Gets items from previous class

    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    } //Gets loans from previous class

    public void listUsers() {
        deSerialiseUsers(); //Lists current users found in file
        getUsers(myUsers); //Gets users
        if (myUsers != null) {
            textAreaUsers.clear(); //Clears textarea on click (Used to prevent it keep appending textarea
            for (Users aGetUsers : myUsers) { //For each user in user array
                if (myUsers != null) {
                    textAreaUsers.appendText( //List all user's data line by line
                            newLine
                                    + "ID: " + aGetUsers.getUserID() + " | " + "USERNAME: " + aGetUsers.getUser() + " | "
                                    + "FULL NAME: " + aGetUsers.getFullName() + " | " + "ADDRESS: " + aGetUsers.getAddress() + " | " + "TOWN/CITY: "
                                    + aGetUsers.getTown() + " | " + "POSTAL CODE: " + aGetUsers.getPostCode() + " | " + "PHONE NUM: " + aGetUsers.getPhoneNum()
                                    + " | " + "DATE OF BIRTH: " + aGetUsers.getDOB() + " | " + "MEMBERSHIP TYPE: " + aGetUsers.getType() + " | " + "PASSWORD: " + aGetUsers.getPass() + newLine);
                }
            }
        }
    } //List user method / Called when button is clicked

    private void deSerialiseUsers() {

        ArrayList<Users> myNewUsers = new ArrayList<>();
        try {
            out.println("Placeholder Text #1"); //Used to get rid of duplicate code
            FileInputStream fileIn = new FileInputStream("src\\BunnyCorp\\Data\\UserData.ser"); //Gets file
            ObjectInputStream in = new ObjectInputStream(fileIn); //Opens new input stream
            myNewUsers = (ArrayList<Users>) in.readObject(); //Array list of users
            in.close(); //closes input stream
            fileIn.close(); //closes file
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            out.println("Class not found");
            c.printStackTrace();
        }
        out.println("UserData.ser");
        for (Users users : myNewUsers) { //Displays current users on file
            out.println(users.getUserID() + "|" + users.getUser() + "|" + users.getPass() + "|" + users.getFirstName() + "|" + users.getSecondName() + "|" + users.getAddress() + "|" + users.getTown() + "|" + users.getPostCode() + "|" + users.getPhoneNum() + "|" + users.getDOB() + "|" + users.getType() + "|");
            out.println();
        }
    } //Writes users to console

    public void backUserCreation(ActionEvent back) throws IOException {

        getItems(myItems);
        getUsers(myUsers);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminUserCreation.fxml")); //Loads fxml from file path
        AnchorPane backViewParent = loader.load();
        A4a_AdminUserCreatorClass passUsers = (A4a_AdminUserCreatorClass) loader.getController();
        A4a_AdminUserCreatorClass passItems = (A4a_AdminUserCreatorClass) loader.getController();
        A4a_AdminUserCreatorClass passLoans = (A4a_AdminUserCreatorClass) loader.getController();
        passUsers.getUsers(myUsers);
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene backViewScene = new Scene(backViewParent); //Sets UserCreation fxml as new scene
        Stage window = (Stage) ((Node) back.getSource()).getScene().getWindow(); //sets windows to UserCreation fxml
        window.setScene(backViewScene); //sets scene as window
        window.show(); //Shows UserCreation fxml
    } //Sends admin back to user creator
}
