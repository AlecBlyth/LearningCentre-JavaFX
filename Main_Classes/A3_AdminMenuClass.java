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

public class A3_AdminMenuClass {

    public ArrayList<Users<String>> myUsers; //Array list of Users (populated with users from A1_Main controller
    public ArrayList<Items> myItems; //Array list of Items (populated with users from A1_Main controller
    public ArrayList<Loans> myLoans; //Array list of Loans (Populated from A1_Main controller and or A5a_AdminLoanCreatorClass

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    } //Populates local user array list

    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    } //Populates local item array list

    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    } //Populates local loan array list

    public void Users(ActionEvent Users) throws IOException {

        getUsers(myUsers); //Used to ensure data isn't lost when changing classes between program
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminUserCreation.fxml")); //Loads fxml from file path
        AnchorPane UsersViewParent = loader.load();
        A4a_AdminUserCreatorClass passUsers = (A4a_AdminUserCreatorClass) loader.getController();
        A4a_AdminUserCreatorClass passItems = (A4a_AdminUserCreatorClass) loader.getController();
        A4a_AdminUserCreatorClass passLoans = (A4a_AdminUserCreatorClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends user data to class
        passItems.getItems(myItems); //Sends item data to class
        passLoans.getLoans(myLoans); //Sends loan data to class
        Scene UsersViewScene = new Scene(UsersViewParent); //Sets User Creation fxml as new scene
        Stage window = (Stage) ((Node) Users.getSource()).getScene().getWindow(); //sets windows to User Creation fxml
        window.setScene(UsersViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows User Creation fxml
    } //Sends admin to User Menu (User Creator and User List)

    public void Loans(ActionEvent Loans) throws IOException {

        getUsers(myUsers); //Used to ensure data isn't lost when changing classes between program
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminLoans.fxml")); //Loads fxml from file path
        AnchorPane loansViewParent = loader.load();
        A5a_AdminLoanCreatorClass passUsers = (A5a_AdminLoanCreatorClass) loader.getController();
        A5a_AdminLoanCreatorClass passItems = (A5a_AdminLoanCreatorClass) loader.getController();
        A5a_AdminLoanCreatorClass passLoans = (A5a_AdminLoanCreatorClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends user data to class
        passItems.getItems(myItems); //Sends item data to class
        passLoans.getLoans(myLoans); //Sends loan data to class
        Scene loansViewScene = new Scene(loansViewParent); //Sets Admin Loans fxml as new scene
        Stage window = (Stage) ((Node) Loans.getSource()).getScene().getWindow(); //sets windows to Admin Loans fxml
        window.setScene(loansViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows Admin Loans fxml
    } //Sends admin to Loan Menu (Loan Creator and Loan Returns)

    public void Stock(ActionEvent Stock) throws IOException {

        getUsers(myUsers); //Used to ensure data isn't lost when changing classes between program
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminStockMenu.fxml")); //Loads fxml from file path
        AnchorPane StockViewParent = loader.load();
        A6a_AdminStockMenuClass passUsers = (A6a_AdminStockMenuClass) loader.getController();
        A6a_AdminStockMenuClass passItems = (A6a_AdminStockMenuClass) loader.getController();
        A6a_AdminStockMenuClass passLoans = (A6a_AdminStockMenuClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends user data to class
        passItems.getItems(myItems); //Sends item data to class
        passLoans.getLoans(myLoans); //Sends loan data to class
        Scene StockViewScene = new Scene(StockViewParent); //Sets AdminStock fxml as new scene
        Stage window = (Stage) ((Node) Stock.getSource()).getScene().getWindow(); //sets windows to AdminStock fxml
        window.setScene(StockViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows AdminStock fxml
    } //Sends admin Stock Menu(Stock Creator, Stock Editor and Stock List)

    public void Logout(ActionEvent Logout) throws IOException {

        getUsers(myUsers); //Used to ensure data isn't lost when changing classes between program
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/Login.fxml")); //Loads fxml from file path
        AnchorPane logoutViewParent = loader.load();
        A2_LoginClass passUsers = (A2_LoginClass) loader.getController();
        A2_LoginClass passItems = (A2_LoginClass) loader.getController();
        A2_LoginClass passLoans = (A2_LoginClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends user data to class
        passItems.getItems(myItems); //Sends item data to class
        passLoans.getLoans(myLoans); //Sends loan data to class
        Scene logoutViewScene = new Scene(logoutViewParent); //Sets login fxml as new scene
        Stage window = (Stage) ((Node) Logout.getSource()).getScene().getWindow(); //sets windows to login fxml
        window.setScene(logoutViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows login fxml
    } //Logs out admin
}
