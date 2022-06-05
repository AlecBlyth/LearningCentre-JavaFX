package BunnyCorp.Main_Classes;

        import BunnyCorp.Classes.Items;
        import BunnyCorp.Classes.Loans;
        import BunnyCorp.Classes.Users;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.AnchorPane;
        import javafx.stage.Stage;

        import static java.lang.System.*;

        import java.io.IOException;
        import java.util.ArrayList;

public class A2_LoginClass {
    public A2_LoginClass() { //Gets interface and displays total cost of items
        A1_Main c1 = new A1_Main();
        c1.getTotalCost();
    }

    public Label lblStatus; //Label used to inform user unsuccessful login
    public TextField txtUsername; //Textfield used to get username input
    public TextField txtPassword; //Textfield used to get password input
    public ArrayList<Users<String>> myUsers; //User object array
    public ArrayList<Items> myItems; //Item object array
    public ArrayList<Loans> myLoans; //Loan object array

    public void getUsers(ArrayList<Users<String>> myUsers) {
        this.myUsers = myUsers;
    } //Gets prepopulated/edited/new users from A1_Main

    public void getItems(ArrayList<Items> myItems) {
        this.myItems = myItems;
    } //Gets prepopulated/edited/new items from A1_Main

    public void getLoans(ArrayList<Loans> myLoans) {
        this.myLoans = myLoans;
    } //Gets placeholder and new loans

    public void login(ActionEvent event) throws IOException { //Open login button click program runs the code below
        getUsers(myUsers); //Gets users
        getItems(myItems); //Gets items
        getLoans(myLoans); //Gets loans
        if (myUsers != null) {
            for (Users aGetUsers : myUsers) { //Loops for each user object in user array
                String foundUser = (aGetUsers.getUser()); //Used to find matching username
                String foundPass = (aGetUsers.getPass()); //Used to find matching password
                String foundType = (String) aGetUsers.getType(); //Used to find matching user type
                out.println(foundUser + foundPass + foundType); //Displays all user details (Used for testing)
                if (txtUsername.getText().equals(foundUser) && (txtPassword.getText().equals(foundPass))) { //Login validation
                    out.println("Login successful"); //Inform developer of successful login
                    if (foundType.equals("ADMIN")) { //If the user logging in is ADMIN then load admin menu
                        out.println("Loading Admin Menu"); //Inform developer fxml is loading.
                        getUsers(myUsers);
                        getItems(myItems);
                        getLoans(myLoans);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/AdminMenu.fxml")); //Loads fxml from file path
                        AnchorPane adminViewParent = loader.load();
                        A3_AdminMenuClass passUsers = (A3_AdminMenuClass) loader.getController();
                        A3_AdminMenuClass passItems = (A3_AdminMenuClass) loader.getController();
                        A3_AdminMenuClass passLoans = (A3_AdminMenuClass) loader.getController();
                        passUsers.getUsers(myUsers); //Sends user array to user array found in next class
                        passItems.getItems(myItems); //Sends item array to item array found in next class
                        passLoans.getLoans(myLoans); //Sends loan array to loan array found in next class
                        Scene adminViewScene = new Scene(adminViewParent); //Sets admin fxml as new scene
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); //sets windows to admin fxml
                        window.setScene(adminViewScene); //sets scene as window
                        window.setResizable(false);
                        window.show(); //Shows Admin fxml
                    }
                    if ((foundType.equals("STAFF")) || (foundType.equals("MEMBER")) || (foundType.equals("CASUAL"))) { //If the user logging in others then load member menu
                        out.println("Loading Member Menu"); //Inform developer fxml is loading.
                        int loggedUser = aGetUsers.getUserID();
                        getUsers(myUsers);
                        getItems(myItems);
                        getLoans(myLoans);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/MemberMenu.fxml")); //Loads fxml from file path
                        AnchorPane memberViewParent = loader.load();
                        M1a_MemberMenuClass passUsers = (M1a_MemberMenuClass) loader.getController();
                        M1a_MemberMenuClass passItems = (M1a_MemberMenuClass) loader.getController();
                        M1a_MemberMenuClass passLoans = (M1a_MemberMenuClass) loader.getController();
                        M1a_MemberMenuClass passLog = (M1a_MemberMenuClass) loader.getController();
                        passUsers.getUsers(myUsers);  //Sends user array to user array found in next class
                        passItems.getItems(myItems); //Sends item array to item array found in next class
                        passLoans.getLoans(myLoans); //Sends loan array to loan array found in next class
                        passLog.setLoggedUser(loggedUser); //Sends user ID of specific member to the next class
                        Scene memberViewScene = new Scene(memberViewParent); //Sets member menu fxml as new scene
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow(); //sets windows to member menu fxml
                        window.setScene(memberViewScene); //sets scene as window
                        window.setResizable(false);
                        window.show(); //Shows member menu fxml
                    }
                } else {
                    lblStatus.setVisible(true); //If login is failed inform user via label.
                }
            }
        }
    } //Login method
}