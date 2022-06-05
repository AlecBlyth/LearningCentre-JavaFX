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

public class A6a_AdminStockMenuClass {

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

    public void viewStock(ActionEvent viewStock) throws IOException {

        getUsers(myUsers); //Gets data
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminStockList.fxml")); //Loads fxml from file path
        AnchorPane stockViewParent = loader.load();
        A6b_AdminStockListClass passUsers = (A6b_AdminStockListClass) loader.getController();
        A6b_AdminStockListClass passItems = (A6b_AdminStockListClass) loader.getController();
        A6b_AdminStockListClass passLoans = (A6b_AdminStockListClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends data to class
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene PaperViewScene = new Scene(stockViewParent); //Sets stock list fxml as new scene
        Stage window = (Stage) ((Node) viewStock.getSource()).getScene().getWindow(); //sets windows to stock list fxml
        window.setScene(PaperViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows stock list fxml
    } //Sends admin to view stock

    public void editStock(ActionEvent editStock) throws IOException {

        getUsers(myUsers); //Gets data
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminStockEdit.fxml")); //Loads fxml from file path
        AnchorPane editStockviewer = loader.load();
        A6c_AdminStockEditClass passUsers = (A6c_AdminStockEditClass) loader.getController();
        A6c_AdminStockEditClass passItems = (A6c_AdminStockEditClass) loader.getController();
        A6c_AdminStockEditClass passLoans = (A6c_AdminStockEditClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends data to class
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene viewUsersScene = new Scene(editStockviewer); //Sets stock editor fxml as new scene
        Stage window = (Stage) ((Node) editStock.getSource()).getScene().getWindow(); //sets windows to stock editor fxml
        window.setScene(viewUsersScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows stock editor fxml
    } //Sends admin to edit stock

    public void createStock(ActionEvent createStock) throws IOException {

        getUsers(myUsers); //Gets data
        getItems(myItems);
        getLoans(myLoans);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminStockCreator.fxml")); //Loads fxml from file path
        AnchorPane StockViewParent = loader.load();
        A6d_AdminStockCreatorClass passUsers = (A6d_AdminStockCreatorClass) loader.getController();
        A6d_AdminStockCreatorClass passItems = (A6d_AdminStockCreatorClass) loader.getController();
        A6d_AdminStockCreatorClass passLoans = (A6d_AdminStockCreatorClass) loader.getController();
        passUsers.getUsers(myUsers); //Sends data to class
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene StockViewScene = new Scene(StockViewParent); //Sets item creation fxml as new scene
        Stage window = (Stage) ((Node) createStock.getSource()).getScene().getWindow(); //sets windows to item creation fxml
        window.setScene(StockViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows item creation fxml
    } //Sends admin to create stock

    public void back(ActionEvent back) throws IOException {

        getUsers(myUsers);
        getLoans(myLoans);
        getItems(myItems);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminMenu.fxml")); //Loads fxml from file path
        AnchorPane BackViewParent = loader.load();
        A3_AdminMenuClass passUsers = (A3_AdminMenuClass) loader.getController();
        A3_AdminMenuClass passItems = (A3_AdminMenuClass) loader.getController();
        A3_AdminMenuClass passLoans = (A3_AdminMenuClass) loader.getController();
        passUsers.getUsers(myUsers);
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        Scene BackViewScene = new Scene(BackViewParent); //Sets Admin Menu fxml as new scene
        Stage window = (Stage) ((Node) back.getSource()).getScene().getWindow(); //sets windows to Admin Menu fxml
        window.setScene(BackViewScene); //sets scene as window
        window.setResizable(false);
        window.show(); //Shows Admin Menu fxml
    } //Sends admin back to menu
}
