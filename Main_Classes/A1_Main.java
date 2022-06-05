package BunnyCorp.Main_Classes;

        import BunnyCorp.Classes.*;
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.layout.AnchorPane;
        import javafx.stage.Stage;

        import java.io.*;
        import java.util.ArrayList;

        import static java.lang.System.out;

public class A1_Main extends Application implements Analyzable {
    private final ArrayList<Users<String>> myUsers = new ArrayList<>(); //Arraylist of all users
    private final ArrayList<Items> myItems = new ArrayList<>(); //Arraylist of Items (Videos, CDs, Books and Journals)
    private final ArrayList<Loans> myLoans = new ArrayList<>(); //Arraylist of loans
    private final Loans myLoans0 = new Loans(999, 1000, 1, 1, 1000); //Placeholder
    private File userFile = new File("src\\BunnyCorp\\Data\\UserData.txt"); //Gets file from packages
    private File compactDiscs = new File("src\\BunnyCorp\\Data\\CompactDiscs.txt");  //Gets file from packages
    private File videos = new File("src\\BunnyCorp\\Data\\Videos.txt");  //Gets file from packages
    private File books = new File("src\\BunnyCorp\\Data\\Books.txt"); //Gets file from packages
    private File journals = new File("src\\BunnyCorp\\Data\\Journals.txt");  //Gets file from packages

    @Override
    public void start(Stage primaryStage) throws Exception {
        myLoans.add(myLoans0); //Adds placeholder loan
        prepopulateUsers(); //prepopulates users
        prepopulateItems();  //prepopulates items
        serialiseItems(); //serialises items
        serialiseUsers(); //serialises users
        deSerialiseUsers(); //reads users
        deSerialiseItems(); //reads items

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BunnyCorp/FXMLs/Login.fxml"));  //Loads Login FXML from package .
        AnchorPane root = loader.load();
        A2_LoginClass passUsers = (A2_LoginClass) loader.getController(); //Passes data to next controller
        A2_LoginClass passItems = (A2_LoginClass) loader.getController();
        A2_LoginClass passLoans = (A2_LoginClass) loader.getController();
        passUsers.getUsers(myUsers);
        passItems.getItems(myItems);
        passLoans.getLoans(myLoans);
        primaryStage.setScene(new Scene(root)); //Sets Login FMXL as first scene
        primaryStage.setTitle("Glencaldy Learning Centre");
        primaryStage.setResizable(false);
        primaryStage.show(); //Displays Login FXML
    } //Beginning of the program

    public void getTotalCost() {
        double total = 0; //Initialises total to 0
        prepopulateItems(); //Prepopulates items
        for (Items aMyItems : myItems) { //For each item price in item array add all to get total cost
            total = total + aMyItems.getCostPrice();
        }
        System.out.println("Total cost of items is " + total);
    } //Gets total cost of all items

    private void prepopulateUsers() {
        Users<String> myUsers0 = new Users<>(1000, "admin", "password", "N/A", " N/A", " N/A", "N/A", "N/A", "N/A", "N/A", "ADMIN");
        Users<String> myUsers1 = new Users<>(1001, "lecturer", "capitalism", "Adam", "Smith", "127 High St", "Kirkcaldy", "KY5D8F", "03069990552", "16/06/1723", "STAFF");
        Users<String> myUsers2 = new Users<>(1002, "president", "economics", "Ronald", "Reagan", "56 Bel-Air", "Los Caldy", "KY8BD2", "80865390552", "06/02/1911", "STAFF");
        Users<String> myUsers3 = new Users<>(1003, "engineer", "memeword", "Tim", "Berners-Lee", "15 Westwood Place", "London", "KY9WWW", "07700900262", "08/06/1955", "STAFF");
        Users<String> myUsers4 = new Users<>(1004, "polymath", "monalisa", "Leonardo", "da Vinci", "23 Via Mozza", "Florence", "FL9MLA", "07700900466", "15/04/1452", "MEMBER");
        Users<String> myUsers5 = new Users<>(1005, "theoryman", "sexyphysics", "Richard", "Feynman", "Trump Tower", "New York", "NY5JEA", "03069990552", "11/05/1918", "MEMBER");
        Users<String> myUsers6 = new Users<>(1006, "destroyerofworlds", "nuclearwar", "Julius Robert", "Oppenheimer", "20 Trinity Site", "New Mexico", "NKW194", "03069990828", "22/04/1904", "MEMBER");
        Users<String> myUsers7 = new Users<>(1007, "crashtest", "dummy", "Samuel", "Alderson", "11 Marina Dey Rey", "California", "MDR238", "03069990011", "21/10/1914", "CASUAL");
        Users<String> myUsers8 = new Users<>(1008, "Zucc", "dadada", "Mark", "Zuckerberg", "1456 Edgewood Drive", "California", "EWD238", "06505434800", "14/05/1984", "CASUAL");
        Users<String> myUsers9 = new Users<>(1009, "bigmoney", "money", "Bill", "Gates", "1835 73rd Ave", "Washington", "WSA039", "2067093140", "28/10/1955", "CASUAL");

        myUsers.add(myUsers0);
        myUsers.add(myUsers1);
        myUsers.add(myUsers2);
        myUsers.add(myUsers3);
        myUsers.add(myUsers4);
        myUsers.add(myUsers5);
        myUsers.add(myUsers6);
        myUsers.add(myUsers7);
        myUsers.add(myUsers8);
        myUsers.add(myUsers9);

        try (BufferedWriter preloader = new BufferedWriter(new FileWriter(userFile, false))) {

            preloader.write("1001|lecturer|capitalism|Adam|Smith|127 High St|Kirkcaldy|KY5D8F|03069990552|16/06/1723|STAFF|");
            preloader.newLine();
            preloader.write("1002|president|economics|Ronald|Reagan|56 Bel-Air|Los Caldy|KY8BD2|80865390552|06/02/1911|STAFF|");
            preloader.newLine();
            preloader.write("1003|engineer|memeword|Tim|Berners-Lee|15 Westwood Place|London|KY9WWW|07700900262|08/06/1955|STAFF|");
            preloader.newLine();
            preloader.write("1004|polymath|monalisa|Leonardo|da Vinci|23 Via Mozza|Florence|FL9MLA|07700900466|15/04/1452|MEMBER|");
            preloader.newLine();
            preloader.write("1005|theoryman|sexyphysics|Richard|Feynman|Trump Tower|New York|NY5JEA|03069990552|11/05/1918|MEMBER|");
            preloader.newLine();
            preloader.write("1006|destroyerofworlds|nuclearwar|Julius Robert|Oppenheimer|20 Trinity Site|New Mexico|NKW194|03069990828|22/04/1904|MEMBER|");
            preloader.newLine();
            preloader.write("1007|crashtest|dummy|Samuel|Alderson|11 Marina Dey Rey|California|MDR238|03069990011|21/10/1914|CASUAL|");
            preloader.newLine();
            preloader.write("1008|Zucc|dadada|Mark|Zuckerberg|1456 Edgewood Drive|California|EWD238|06505434800|14/05/1984|CASUAL|");
            preloader.newLine();
            preloader.write("1009|bigmoney|money|Bill|Gates|1835 73rd Ave|Washington|WSA039|2067093140|28/10/1955|CASUAL|");
            preloader.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    } //Creates users

    private void prepopulateItems() {
        Items aBook1 = new Books(1000, "9781542995030", "Carl Sagan", "Cosmos: A Personal Voyage", 10.99, "Multi-Science", "Random House", 365, 5, "Book");
        Items aBook2 = new Books(1001, "9786074533989", "Charles Darwin", "On the Origins of Species", 98.00, "Evolutionary Biology", "John Murray", 502, 5, "Book");
        Items aBook3 = new Books(1002, "9781236699800", "Issac Newton", "Philosophi Naturalis Principia Mathematica", 27.99, "Physics", "Benjamin Motte", 616, 5, "Book");

        Items aVideo1 = new Videos(1003, "Carl Sagan's Cosmos", "PBS", "Science", "Blu-Ray", 780, 14.99, "Blu-Ray Case", 5, "Video");
        Items aVideo2 = new Videos(1004, "The First World War", "Channel 4", "History", "DVD", 500, 8.99, "DVD Case", 5, "Video");
        Items aVideo3 = new Videos(1005, "The Standard Deviants: Biology", "Cerebellum Corp", "Biology", "VHS", 135, 5.99, "VHS Case", 5, "Video");

        Items aCompactDisc1 = new CompactDiscs(1006, "Best of Bowie", "David Bowie", "EMI", 39, 157, 10.50, "Audio CD", "CD Jewel Case", 5, "Compact Disc");
        Items aCompactDisc2 = new CompactDiscs(1007, "The Last Stand", "Sabaton", "Nuclear Blast", 15, 45, 12.99, "DVD Audio", "SJB Plus", 5, "Compact Disc");
        Items aCompactDisc3 = new CompactDiscs(1008, "Beethoven Symphony No 7", "Ludwig van Beethoven", "Orfeo D'or", 5, 40, 14.00, "Super Audio CD", "SJB Standard", 5, "Compact Disc");

        Items aJournal1 = new Journals(1009, "0010-4620", "The Computer Journal", 1050.00, "Computer Science", "Oxford University Press", 12, "01/12/2017", 1750, 5, "Journal");
        Items aJournal2 = new Journals(1010, "0967-0742", "Medical Law Review", 620.00, "Law", "Oxford University Press", 4, "01/11/2017", 670, 5, "Journal");
        Items aJournal3 = new Journals(1011, "0004-6256", "The Astronomical Journal", 550.00, "Astronomy", "OP Publishing", 6, "15/06/2017", 850, 5, "Journal");

        myItems.add(aBook1); //Adds new Book Object
        myItems.add(aBook2);
        myItems.add(aBook3);

        myItems.add(aVideo1); //Adds new Video Object
        myItems.add(aVideo2);
        myItems.add(aVideo3);

        myItems.add(aCompactDisc1); //Adds new CD object
        myItems.add(aCompactDisc2);
        myItems.add(aCompactDisc3);

        myItems.add(aJournal1); //Adds new Journal Object
        myItems.add(aJournal2);
        myItems.add(aJournal3);

        try (BufferedWriter preloader = new BufferedWriter(new FileWriter(compactDiscs, false))) {
            preloader.write("1006|Best of Bowie|David Bowie|EMI|39|157|10.50|Audio CD|CD Jewel Case|5|Compact Disc|");
            preloader.newLine();
            preloader.write("1007|The Last Stand|Sabaton|Nuclear Blast|15|45|12.99|DVD Audio|SJB Plus|5|Compact Disc|");
            preloader.newLine();
            preloader.write("1008|Beethoven Symphony No 7|Ludwig van Beethoven|Orfeo D'or|5|40|14.00|Super Audio CD|SJB Standard|5|Compact Disc|");
            preloader.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter preloader = new BufferedWriter(new FileWriter(videos, false))) {
            preloader.write("1003|Carl Sagan's Cosmos|PBS|Science|Blu-Ray|780|14.99|Blu-Ray Case|5|Video|");
            preloader.newLine();
            preloader.write("1004|The First World War|Channel 4|History|DVD|500|8.99|DVD Case|5|Video|");
            preloader.newLine();
            preloader.write("1005|The Standard Deviants: Biology|Cerebellum Corp|Biology|VHS|135|5.99|VHS Case|5|Video|");
            preloader.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter preloader = new BufferedWriter(new FileWriter(books, false))) {
            preloader.write("1000|9781542995030|Carl Sagan|Cosmos: A Personal Voyage|10.99|Multi-Science|Random House|396|5|Book|");
            preloader.newLine();
            preloader.write("1001|9786074533989|Charles Darwin|On the Origins of Species|98.00|Evolutionary Biology|John Murray|502|5|Book|");
            preloader.newLine();
            preloader.write("1002|9781236699800|Issac Newton|Philosophi Naturalis Principia Mathematica|27.99|Physics|Benjamin Motte|616|5|Book|");
            preloader.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter preloader = new BufferedWriter(new FileWriter(journals, false))) {
            preloader.write("1009|0010-4620|The Computer Journal|1050.00|Computer Science|Oxford University Press|12|01/12/2017|1750|5|Journal|");
            preloader.newLine();
            preloader.write("1010|0967-0742|Medical Law Review|620.00|Law|Oxford University Press|4|01/11/2017|670|5|Journal|");
            preloader.newLine();
            preloader.write("1011|0004-6256|The Astronomical Journal|550.00|Astronomy|IOP Publishing|6|15/06/2017|850|5|Journal|");
            preloader.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } //Writes to text file
    } //Creates items

    private void serialiseUsers() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src\\BunnyCorp\\Data\\UserData.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myUsers);
            out.close();
            fileOut.close();
            System.out.println("Data has been saved in src\\BunnyCorp\\Data\\UserData.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //Writes users to ser file

    private void serialiseItems() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src\\BunnyCorp\\Data\\Items.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myItems);
            out.close();
            fileOut.close();
            System.out.println("Data has been saved in src\\BunnyCorp\\Data\\Items.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

    } //Writes items to file

    private void deSerialiseUsers() {

        ArrayList<Users> myNewUsers = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("src\\BunnyCorp\\Data\\UserData.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            myNewUsers = (ArrayList<Users>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            out.println("Class not found");
            c.printStackTrace();
        }

        out.println("UserData.ser");
        for (Users users : myNewUsers) {
            out.println(users.getUserID() + "|" + users.getUser() + "|" + users.getPass() + "|" + users.getFirstName() + "|" + users.getSecondName() + "|" + users.getAddress() + "|" + users.getTown() + "|" + users.getPostCode() + "|" + users.getPhoneNum() + "|" + users.getDOB() + "|" + users.getType() + "|");
            out.println();
        }
    } //Reads file on start up

    private void deSerialiseItems() {
        ArrayList<Items> myNewItems = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("src\\BunnyCorp\\Data\\Items.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            myNewItems = (ArrayList<Items>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            out.println("Class not found");
            c.printStackTrace();
        }

        out.println("Items.ser");
        for (Items items : myNewItems) {
            if (items.getItemType().equals("Book")) {
                out.println(items.getStockID() + "|" + items.getISBN() + "|" + items.getAuthor() + "|" + items.getTitle() + "|" + items.getCostPrice() + items.getSubjectArea() + "|" + items.getPublisher() + "|" + items.getNumberofPages() + "|" + items.getItemStock() + "|" + items.getItemType());
                out.println();
            }
            if (items.getItemType().equals("Journal")) {
                out.println(items.getStockID() + "|" + items.getISSN() + "|" + items.getTitle() + items.getCostPrice() + "|" + items.getSubjectArea() + "|" + items.getPublisher() + "|" + items.getIssueDate() + "|" + items.getNumberofPages() + "|" + items.getItemStock() + "|" + items.getItemType());
                out.println();
            }
            if (items.getItemType().equals("Video")) {
                out.println(items.getStockID() + "|" + items.getTitle() + "|" + items.getPublisher() + "|" + items.getSubjectArea() + "|" + items.getVideoFormat() + "|" + items.getRunningTime() + "|" + items.getCostPrice() + "|" + items.getTypeOfStorage() + "|" + items.getItemStock() + "|" + items.getItemType());
                out.println();
            }
            if (items.getItemType().equals("Compact Disc")) {
                out.println(items.getStockID() + "|" + items.getTitle() + "|" + items.getCDArtist() + "|" + items.getPublisher() + "|" + items.getNumberOfTracks() + "|" + items.getRunningTime() + "|" + items.getCostPrice() + "|" + items.getCDFormat() + "|" + items.getTypeOfStorage() + "|" + items.getItemStock() + "|" + items.getItemType());
                out.println();
            }
        }
    } //Reads file on start up

    public static void main(String[] args) {
        launch(args);
    } //Runs program
}