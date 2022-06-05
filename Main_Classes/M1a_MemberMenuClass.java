package BunnyCorp.Main_Classes;

import BunnyCorp.Classes.Items;
import BunnyCorp.Classes.Loans;
import BunnyCorp.Classes.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class M1a_MemberMenuClass {

    public ArrayList<Users<String>> myUsers; //User Array
    public ArrayList<Items> myItems; //Item Array
    public ArrayList<Loans> myLoans; //Loan Array
    private int loggedUser; //Current logged in user

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    } //Gets users from class

    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    } //Gets items from class

    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    } //Gets loan from class

    public void setLoggedUser(int loggedUser) {
        this.loggedUser = loggedUser;
    } //Gets current logged in user from class

    public void viewItems(ActionEvent viewItems) throws IOException {
        getItems(myItems); //Get data
        getUsers(myUsers);
        getLoans(myLoans);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/MemberSearch.fxml")); //Loads fxml from file path
        AnchorPane itemViewParent = loader.load();
        M2a_MemberSearchClass passUsers = (M2a_MemberSearchClass) loader.getController();
        M2a_MemberSearchClass passItems = (M2a_MemberSearchClass) loader.getController();
        M2a_MemberSearchClass passLoans = (M2a_MemberSearchClass) loader.getController();
        M2a_MemberSearchClass passLog = (M2a_MemberSearchClass) loader.getController();
        passItems.getItems(myItems); //Sends data to class
        passUsers.getUsers(myUsers);
        passLoans.getLoans(myLoans);
        passLog.setLoggedUser(loggedUser);
        Scene backViewScene = new Scene(itemViewParent); //Sets MemberSearch fxml as new scene
        Stage window = (Stage) ((Node) viewItems.getSource()).getScene().getWindow(); //sets windows to MemberSearch fxml
        window.setScene(backViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows MemberSearch fxml
    } //Sends member to item search

    public void viewLoans(ActionEvent viewLoans) throws IOException {
        getItems(myItems); //Gets data
        getUsers(myUsers);
        getLoans(myLoans);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/MemberLoans.fxml")); //Loads fxml from file path
        AnchorPane loanViewParent = loader.load();
        M3a_MemberLoansClass passUsers = (M3a_MemberLoansClass) loader.getController();
        M3a_MemberLoansClass passItems = (M3a_MemberLoansClass) loader.getController();
        M3a_MemberLoansClass passLoans = (M3a_MemberLoansClass) loader.getController();
        M3a_MemberLoansClass passLog = (M3a_MemberLoansClass) loader.getController();
        passItems.getItems(myItems); //Sends data to class
        passUsers.getUsers(myUsers);
        passLoans.getLoans(myLoans);
        passLog.setLoggedUser(loggedUser);
        Scene backViewScene = new Scene(loanViewParent); //Sets Member loans fxml as new scene
        Stage window = (Stage) ((Node) viewLoans.getSource()).getScene().getWindow(); //sets windows to Member loans fxml
        window.setScene(backViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows Member loans  fxml
    } //Sends member to Member loans  viewer

    public void editProfile(ActionEvent editProfile) throws IOException {
        getItems(myItems); //Gets data
        getUsers(myUsers);
        getLoans(myLoans);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/MemberProfile.fxml")); //Loads fxml from file path
        AnchorPane profileViewParent = loader.load();
        M4a_MemberProfileClass passUsers = (M4a_MemberProfileClass) loader.getController();
        M4a_MemberProfileClass passItems = (M4a_MemberProfileClass) loader.getController();
        M4a_MemberProfileClass passLoans = (M4a_MemberProfileClass) loader.getController();
        M4a_MemberProfileClass passLog = (M4a_MemberProfileClass) loader.getController();
        passItems.getItems(myItems); //Sends data to class
        passUsers.getUsers(myUsers);
        passLoans.getLoans(myLoans);
        passLog.setLoggedUser(loggedUser);
        Scene backViewScene = new Scene(profileViewParent); //Sets Member profile fxml as new scene
        Stage window = (Stage) ((Node) editProfile.getSource()).getScene().getWindow(); //sets windows to Member profile fxml
        window.setScene(backViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows Member profile fxml
    } //Sends member to profile editor

    public void logout(ActionEvent logout) throws IOException {
        getItems(myItems); //Gets data
        getUsers(myUsers);
        getLoans(myLoans);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/Login.fxml")); //Loads fxml from file path
        AnchorPane logoutViewParent = loader.load();
        A2_LoginClass passUsers = (A2_LoginClass) loader.getController();
        A2_LoginClass passItems = (A2_LoginClass) loader.getController();
        A2_LoginClass passLoans = (A2_LoginClass) loader.getController();
        passItems.getItems(myItems); //Sends data to class
        passUsers.getUsers(myUsers);
        passLoans.getLoans(myLoans);
        Scene backViewScene = new Scene(logoutViewParent); //Sets login fxml as new scene
        Stage window = (Stage) ((Node) logout.getSource()).getScene().getWindow(); //sets windows to login fxml
        window.setScene(backViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows login fxml
    } //Logs out non admin member f
}
