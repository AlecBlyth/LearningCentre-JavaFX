package BunnyCorp.JUnitTesting;

import BunnyCorp.Classes.*;
import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

public class jUnit_Testing_Class {
    @Test
    public void populateBookItemTestSuccess() {
        //Sets book objects
        Books book1 = new Books(1000, "1234567890", "Test Author 1", "Test Book 1", 1.99, "Testing One", "Test Publisher 1", 1, 1, "Book");
        Books book2 = new Books(1001, "2134567890", "Test Author 2", "Test Book 2", 1.99, "Testing Two", "Test Publisher 2", 2, 2, "Book");
        Books book3 = new Books(1002, "3214567890", "Test Author 3", "Test Book 3", 1.99, "Testing Three", "Test Publisher 3", 3, 3, "Book");
        Books book4 = new Books(1003, "4321567890", "Test Author 4", "Test Book 4", 1.99, "Testing Four", "Test Publisher 4", 4, 4, "Book");
        Books book5 = new Books(1004, "5432167890", "Test Author 5", "Test Book 5", 1.99, "Testing Five", "Test Publisher 5", 5, 5, "Book");

        TestModel model = TestController.getModel();
        //Add books to test book array
        model.addBook(book1);
        model.addBook(book2);
        model.addBook(book3);
        model.addBook(book4);
        model.addBook(book5);

        //Get number of books in test book array
        int currentSize = model.getBookSize();

        model.resetBooks();

        //5 Books have been added, testing to see if 5 books have been added. Test will need to pass
        assertEquals(5, currentSize);
        System.out.println(currentSize); //Should print 5
    }

    @Test
    public void TestPopulateBooksFail() {
        //Sets book objects
        Books book1 = new Books(1000, "1234567890", "Test Author 1", "Test Book 1", 1.99, "Testing One", "Test Publisher 1", 1, 1, "Book");
        Books book2 = new Books(1001, "2134567890", "Test Author 2", "Test Book 2", 1.99, "Testing Two", "Test Publisher 2", 2, 2, "Book");
        Books book3 = new Books(1002, "3214567890", "Test Author 3", "Test Book 3", 1.99, "Testing Three", "Test Publisher 3", 3, 3, "Book");
        Books book4 = new Books(1003, "4321567890", "Test Author 4", "Test Book 4", 1.99, "Testing Four", "Test Publisher 4", 4, 4, "Book");
        Books book5 = new Books(1004, "5432167890", "Test Author 5", "Test Book 5", 1.99, "Testing Five", "Test Publisher 5", 5, 5, "Book");

        TestModel model = TestController.getModel();
        //Adds only three books to test book array
        model.addBook(book1);
        model.addBook(book2);
        model.addBook(book5);

        //Get number of books in test book array
        int currentSize = model.getBookSize();
        model.resetBooks();

        //3 Books have only been added to the test array, this should fail and result in an exception
        assertEquals(5, currentSize);
    }

    @Test
    public void testGetBookTitlePass() {
        Books book1 = new Books(1000, "1234567890", "Test Author 1", "Test Book 1", 1.99, "Testing One", "Test Publisher 1", 1, 1, "Book");
        String testTitle = "Test Book 1";
        assertEquals(testTitle, book1.getTitle());
        out.println(book1.getTitle()); //Should print out book title if test passes
    }

    @Test
    public void testGetBookTitleFail() {
        Books book1 = new Books(1000, "1234567890", "Test Author 1", "Test Book 1", 1.99, "Testing One", "Test Publisher 1", 1, 1, "Book");
        String testTitle = "Die Hard";
        assertEquals(testTitle, book1.getTitle());
    }

    @Test
    public void populateJournalsTestSuccess() {
        //Sets Journal objects
        Journals testJournal1 = new Journals(1000, "1000-1000", "Test Title 1", 1, "Test Subject 1", "Test Publisher 1", 1, "10/10/1000", 1, 1, "Journal");
        Journals testJournal2 = new Journals(1001, "2000-1000", "Test Title 2", 2, "Test Subject 2", "Test Publisher 2", 2, "20/10/1000", 2, 2, "Journal");
        Journals testJournal3 = new Journals(1002, "3000-1000", "Test Title 3", 3, "Test Subject 3", "Test Publisher 3", 3, "30/10/1000", 3, 3, "Journal");
        Journals testJournal4 = new Journals(1003, "4000-1000", "Test Title 4", 4, "Test Subject 4", "Test Publisher 4", 4, "40/10/1000", 4, 4, "Journal");


        TestModel model = TestController.getModel();
        //Add Journals to test Journal array
        model.addJournal(testJournal1);
        model.addJournal(testJournal2);
        model.addJournal(testJournal3);
        model.addJournal(testJournal4);
        //Get number of Journals in test Journal array
        int currentSize = model.getJournalSize();

        model.resetJournals();

        //4 Journals have been added, testing to see if 4 Journals have been added. Test will need to pass
        assertEquals(4, currentSize);
        System.out.println(currentSize); //Should print 4
    }

    @Test
    public void TestPopulateJournalsFail() {
        //Sets Journal objects
        Journals testJournal1 = new Journals(1000, "1000-1000", "Test Title 1", 1, "Test Subject 1", "Test Publisher 1", 1, "10/10/1000", 1, 1, "Journal");
        Journals testJournal2 = new Journals(1001, "2000-1000", "Test Title 2", 2, "Test Subject 2", "Test Publisher 2", 2, "20/10/1000", 2, 2, "Journal");
        Journals testJournal3 = new Journals(1002, "3000-1000", "Test Title 3", 3, "Test Subject 3", "Test Publisher 3", 3, "30/10/1000", 3, 3, "Journal");
        Journals testJournal4 = new Journals(1003, "4000-1000", "Test Title 4", 4, "Test Subject 4", "Test Publisher 4", 4, "40/10/1000", 4, 4, "Journal");


        TestModel model = TestController.getModel();
        //Add Journals to test Journal array
        model.addJournal(testJournal1);
        model.addJournal(testJournal2);
        //model.addJournal(testJournal3);
        //model.addJournal(testJournal4);
        //Get number of Journals in test Journal array
        int currentSize = model.getJournalSize();

        model.resetJournals();

        //2 Journals have been added, testing to see if 4 Journals have been added. Test will fail
        assertEquals(4, currentSize);
    }

    @Test
    public void testGetJournalIssueNumPass() {
        Journals testJournal3 = new Journals(1002, "3000-1000", "Test Title 3", 3, "Test Subject 3", "Test Publisher 3", 3, "30/10/1000", 3, 3, "Journal");

        int testIssue = 3;

        assertEquals(testIssue, testJournal3.getIssueNumber());
        out.println(testJournal3.getIssueNumber()); //Should print out three is test has passed.

    }

    @Test
    public void testJournalIssueNumFalse() {
        Journals testJournal3 = new Journals(1002, "3000-1000", "Test Title 3", 3, "Test Subject 3", "Test Publisher 3", 3, "30/10/1000", 3, 3, "Journal");

        int testIssue = 1;

        assertEquals(testIssue, testJournal3.getIssueNumber());
    }

    @Test
    public void populateCDsTestSuccess() {
        //Sets CD objects
        CompactDiscs testDisc1 = new CompactDiscs(1000, "Test CD Title 1", "Test CD Artist 1", "Test Publisher 1", 1, 1, 1, "Audio CD", "CD Jewel Case", 1, "Compact Disc");
        CompactDiscs testDisc2 = new CompactDiscs(1001, "Test CD Title 2", "Test CD Artist 2", "Test Publisher 2", 2, 2, 2, "DVD Audio", "SJB Plus", 2, "Compact Disc");
        CompactDiscs testDisc3 = new CompactDiscs(1002, "Test CD Title 3", "Test CD Artist 3", "Test Publisher 3", 3, 3, 3, "Super Audio CD", "SJB Standard", 3, "Compact Disc");


        TestModel model = TestController.getModel();
        //Add CDs to test CD array
        model.addCD(testDisc1);
        model.addCD(testDisc2);
        model.addCD(testDisc3);

        //Get number of CDs in test CD array
        int currentSize = model.getCDSize();

        model.resetCDs();

        //3 CDs have been added, testing to see if 3 CDs have been added. Test will need to pass
        assertEquals(3, currentSize);
        System.out.println(currentSize); //Should print 3
    }

    @Test
    public void TestPopulateCDsFail() {
        //Sets CD objects
        CompactDiscs testDisc1 = new CompactDiscs(1000, "Test CD Title 1", "Test CD Artist 1", "Test Publisher 1", 1, 1, 1, "Audio CD", "CD Jewel Case", 1, "Compact Disc");
        CompactDiscs testDisc2 = new CompactDiscs(1001, "Test CD Title 2", "Test CD Artist 2", "Test Publisher 2", 2, 2, 2, "DVD Audio", "SJB Plus", 2, "Compact Disc");
        CompactDiscs testDisc3 = new CompactDiscs(1002, "Test CD Title 3", "Test CD Artist 3", "Test Publisher 3", 3, 3, 3, "Super Audio CD", "SJB Standard", 3, "Compact Disc");


        TestModel model = TestController.getModel();
        //Add CDs to test CD array
        model.addCD(testDisc1);
        model.addCD(testDisc2);
        //model.addCD(testDisc3);

        //Get number of CDs in test CD array
        int currentSize = model.getCDSize();

        model.resetCDs();

        //2 CDs have been added, testing to see if 5 CDs have been added. Test will fail
        assertEquals(5, currentSize);
    }

    @Test
    public void testGetCDStorageTypePass() {
        CompactDiscs testDisc1 = new CompactDiscs(1000, "Test CD Title 1", "Test CD Artist 1", "Test Publisher 1", 1, 1, 1, "Audio CD", "CD Jewel Case", 1, "Compact Disc");

        String testStorageType = "CD Jewel Case";

        assertEquals(testStorageType, testDisc1.getTypeOfStorage());
        out.println(testDisc1.getTypeOfStorage()); //Should print out CD Storage Type

    }

    @Test
    public void testGetCDStorageTypeFalse() {
        CompactDiscs testDisc1 = new CompactDiscs(1000, "Test CD Title 1", "Test CD Artist 1", "Test Publisher 1", 1, 1, 1, "Audio CD", "CD Jewel Case", 1, "Compact Disc");

        String testStorageType = "SJB Standard"; //Incorrect Storage Type

        assertEquals(testStorageType, testDisc1.getTypeOfStorage()); //Should fail

    }

    @Test
    public void populateVideoTestSuccess() {
        //Sets Video objects
        Videos testVideo1 = new Videos(1000, "Test Title 1", "Test Channel 1", "Test Genre 1", "Blu-Ray", 1, 1, "Blu-Ray Case", 1, "Video");
        Videos testVideo2 = new Videos(1001, "Test Title 2", "Test Channel 2", "Test Genre 2", "DVD", 2, 2, "DVD Case", 2, "Video");

        TestModel model = TestController.getModel();
        //Add Videos to test Video array
        model.addVideo(testVideo1);
        model.addVideo(testVideo2);


        //Get number of Videos in test Video array
        int currentSize = model.getVideoSize();

        model.resetVideos();

        //2 Videos have been added, testing to see if 2 Videos have been added. Test will need to pass
        assertEquals(2, currentSize);
        System.out.println(currentSize); //Should print 2
    }

    @Test
    public void TestPopulateVideosFail() {
        //Sets Video objects
        Videos testVideo1 = new Videos(1000, "Test Title 1", "Test Channel 1", "Test Genre 1", "Blu-Ray", 1, 1, "Blu-Ray Case", 1, "Video");
        Videos testVideo2 = new Videos(1001, "Test Title 2", "Test Channel 2", "Test Genre 2", "DVD", 2, 2, "DVD Case", 2, "Video");

        TestModel model = TestController.getModel();
        //Add Videos to test Video array
        model.addVideo(testVideo1);
        //model.addVideo(testVideo2);


        //Get number of Videos in test Video array
        int currentSize = model.getVideoSize();

        model.resetVideos();

        //1 Videos have been added, testing to see if 2 Videos have been added. Test will fail
        assertEquals(2, currentSize);
    }

    @Test
    public void testGetVideoStorageTypePass() {
        Videos testVideo1 = new Videos(1000, "Test Title 1", "Test Channel 1", "Test Genre 1", "Blu-Ray", 1, 1, "Blu-Ray Case", 1, "Video");

        String testStorageType = "Blu-Ray Case";

        assertEquals(testStorageType, testVideo1.getTypeOfStorage());
        out.println(testVideo1.getTypeOfStorage()); //Should print out Video Storage Type

    }

    @Test
    public void testGetVideoStorageTypeFalse() {
        Videos testVideo2 = new Videos(1001, "Test Title 2", "Test Channel 2", "Test Genre 2", "DVD", 2, 2, "DVD Case", 2, "Video");
        String testStorageType = "Blu-Ray Case"; //Incorrect Storage Type

        assertEquals(testStorageType, testVideo2.getTypeOfStorage()); //Should fail

    }

    @Test
    public void populateUsersTestSuccess() {
        //Sets User objects
        Users<String> testUsers1 = new Users<>(1001, "Test1", "test1", "Adam", "Smith", "127 High St", "Kirkcaldy", "KY5D8F", "03069990552", "16/06/1723", "ADMIN");
        Users<String> testUsers2 = new Users<>(1002, "Test2", "test2", "Ronald", "Reagan", "56 Bel-Air", "Los Caldy", "KY8BD2", "80865390552", "06/02/1911", "STAFF");
        Users<String> testUsers3 = new Users<>(1003, "Test3", "test3", "Tim", "Berners-Lee", "15 Westwood Place", "London", "KY9WWW", "07700900262", "08/06/1955", "STAFF");
        Users<String> testUsers4 = new Users<>(1004, "Test4", "test4", "Leonardo", "da Vinci", "23 Via Mozza", "Florence", "FL9MLA", "07700900466", "15/04/1452", "MEMBER");
        Users<String> testUsers5 = new Users<>(1005, "Test5", "test5", "Richard", "Feynman", "Trump Tower", "New York", "NY5JEA", "03069990552", "11/05/1918", "MEMBER");


        TestModel model = TestController.getModel();
        //Add User to test User array

        model.addUser(testUsers1);
        model.addUser(testUsers2);
        model.addUser(testUsers3);
        model.addUser(testUsers4);
        model.addUser(testUsers5);

        //Get number of Users in test User array
        int currentSize = model.getUserSize();

        model.resetUsers();

        //5 Users have been added, testing to see if 5 Users have been added. Test will need to pass
        assertEquals(5, currentSize);
        System.out.println(currentSize); //Should print 5
    }

    @Test
    public void TestPopulateUsersFail() {
        //Sets User objects
        Users<String> testUsers1 = new Users<>(1001, "Test1", "test1", "Adam", "Smith", "127 High St", "Kirkcaldy", "KY5D8F", "03069990552", "16/06/1723", "ADMIN");
        Users<String> testUsers2 = new Users<>(1002, "Test2", "test2", "Ronald", "Reagan", "56 Bel-Air", "Los Caldy", "KY8BD2", "80865390552", "06/02/1911", "STAFF");
        Users<String> testUsers3 = new Users<>(1003, "Test3", "test3", "Tim", "Berners-Lee", "15 Westwood Place", "London", "KY9WWW", "07700900262", "08/06/1955", "STAFF");
        Users<String> testUsers4 = new Users<>(1004, "Test4", "test4", "Leonardo", "da Vinci", "23 Via Mozza", "Florence", "FL9MLA", "07700900466", "15/04/1452", "MEMBER");
        Users<String> testUsers5 = new Users<>(1005, "Test5", "test5", "Richard", "Feynman", "Trump Tower", "New York", "NY5JEA", "03069990552", "11/05/1918", "MEMBER");


        TestModel model = TestController.getModel();
        //Add User to test User array

        model.addUser(testUsers1);
        model.addUser(testUsers2);
        //model.addUser(testUsers3);
        //model.addUser(testUsers4);
        //model.addUser(testUsers5);

        //Get number of Users in test User array
        int currentSize = model.getUserSize();

        model.resetUsers();

        //2 Users have been added, testing to see if 5 Users have been added. Test will fail
        assertEquals(5, currentSize);
    }

    @Test
    public void testGetUserTypePass() {
        Users<String> testUsers1 = new Users<>(1001, "Test1", "test1", "Adam", "Smith", "127 High St", "Kirkcaldy", "KY5D8F", "03069990552", "16/06/1723", "ADMIN");
        String testType = "ADMIN";
        assertEquals(testType, testUsers1.getType());
        out.println(testUsers1.getType()); //Tests to see if admin usertype exists //Will print out ADMIN if test passes
    }

    @Test
    public void testGetUserType2Pass() {
        Users<String> testUsers2 = new Users<>(1002, "Test2", "test2", "Ronald", "Reagan", "56 Bel-Air", "Los Caldy", "KY8BD2", "80865390552", "06/02/1911", "STAFF");
        String testType = "STAFF";
        assertEquals(testType, testUsers2.getType());
        out.println(testUsers2.getType()); //Tests to see if staff usertype exists //Will print out STAFF if test passes
    }

    @Test
    public void testGetUserType3Pass() {
        Users<String> testUsers4 = new Users<>(1004, "Test4", "test4", "Leonardo", "da Vinci", "23 Via Mozza", "Florence", "FL9MLA", "07700900466", "15/04/1452", "MEMBER");
        String testType = "MEMBER";
        assertEquals(testType, testUsers4.getType());
        out.println(testUsers4.getType()); //Tests to see if staff usertype exists //Will print out MEMBER if test passes
    }

    @Test
    public void testGetUserTypeFail() {
        Users<String> testUsers1 = new Users<>(1001, "Test1", "test1", "Adam", "Smith", "127 High St", "Kirkcaldy", "KY5D8F", "03069990552", "16/06/1723", "ADMIN");
        String testType = "STAFF";
        assertEquals(testType, testUsers1.getType()); //Will fail
    }

    @Test
    public void testGetUserType2Fail() {
        Users<String> testUsers2 = new Users<>(1002, "Test2", "test2", "Ronald", "Reagan", "56 Bel-Air", "Los Caldy", "KY8BD2", "80865390552", "06/02/1911", "STAFF");
        String testType = "MEMBER";
        assertEquals(testType, testUsers2.getType()); //Will Fail
    }

    @Test
    public void testGetUserType3Fail() {
        Users<String> testUsers4 = new Users<>(1004, "Test4", "test4", "Leonardo", "da Vinci", "23 Via Mozza", "Florence", "FL9MLA", "07700900466", "15/04/1452", "MEMBER");
        String testType = "ADMIN";
        assertEquals(testType, testUsers4.getType()); //Will Fail
    }

    @Test
    public void populateItemsTestSuccess() {
        //Sets Items objects
        Items testBook1 = new Books(1000, "1234567890", "Test Author 1", "Test Book 1", 1.99, "Testing One", "Test Publisher 1", 1, 1, "Book");
        Items testDisc1 = new CompactDiscs(1000, "Test CD Title 1", "Test CD Artist 1", "Test Publisher 1", 1, 1, 1, "Audio CD", "CD Jewel Case", 1, "Compact Disc");
        Items testJournal1 = new Journals(1000, "1000-1000", "Test Title 1", 1, "Test Subject 1", "Test Publisher 1", 1, "10/10/1000", 1, 1, "Journal");
        Items testVideo1 = new Videos(1000, "Test Title 1", "Test Channel 1", "Test Genre 1", "Blu-Ray", 1, 1, "Blu-Ray Case", 1, "Video");


        TestModel model = TestController.getModel();
        //Add Items to test Items array
        model.addItem(testBook1);
        model.addItem(testDisc1);
        model.addItem(testJournal1 );
        model.addItem(testVideo1);

        //Get number of Items in test Items array
        int currentSize = model.getItemSize();

        model.resetItems();

        //4  Items have been added, testing to see if 4 Items have been added. Test will need to pass
        assertEquals(4, currentSize);
        System.out.println(currentSize); //Should print 4
    }

    @Test
    public void TestPopulateItemsFail() {
        //Sets Items objects
        Items testBook1 = new Books(1000, "1234567890", "Test Author 1", "Test Book 1", 1.99, "Testing One", "Test Publisher 1", 1, 1, "Book");
        Items testDisc1 = new CompactDiscs(1000, "Test CD Title 1", "Test CD Artist 1", "Test Publisher 1", 1, 1, 1, "Audio CD", "CD Jewel Case", 1, "Compact Disc");
        Items testJournal1 = new Journals(1000, "1000-1000", "Test Title 1", 1, "Test Subject 1", "Test Publisher 1", 1, "10/10/1000", 1, 1, "Journal");
        Items testVideo1 = new Videos(1000, "Test Title 1", "Test Channel 1", "Test Genre 1", "Blu-Ray", 1, 1, "Blu-Ray Case", 1, "Video");


        TestModel model = TestController.getModel();
        //Add Items to test Items array
        model.addItem(testBook1);
        //model.addItem(testDisc1);
        //model.addItem(testJournal1 );
        model.addItem(testVideo1);

        //Get number of Items in test Items array
        int currentSize = model.getItemSize();

        model.resetItems();

        //2 Items have been added, testing to see if 4 Items have been added. Test will fail
        assertEquals(4, currentSize);
    }

    @Test
    public void testGetItemTypePass() {
        Items testBook1 = new Books(1000, "1234567890", "Test Author 1", "Test Book 1", 1.99, "Testing One", "Test Publisher 1", 1, 1, "Book");
        String testType = "Book";
        assertEquals(testType, testBook1.getItemType());
        out.println(testBook1.getItemType()); //Tests to see if Book item type exists //Will print out Book if test passes
    }

    @Test
    public void testGetItemType2Pass() {
        Items testDisc1 = new CompactDiscs(1000, "Test CD Title 1", "Test CD Artist 1", "Test Publisher 1", 1, 1, 1, "Audio CD", "CD Jewel Case", 1, "Compact Disc");
        String testType = "Compact Disc";
        assertEquals(testType, testDisc1.getItemType());
        out.println(testDisc1.getItemType()); //Tests to see if Compact Disc item type exists //Will print out Compact Disc if test passes
    }

    @Test
    public void testGetItemType3Pass() {
        Items testJournal1 = new Journals(1000, "1000-1000", "Test Title 1", 1, "Test Subject 1", "Test Publisher 1", 1, "10/10/1000", 1, 1, "Journal");
        String testType = "Journal";
        assertEquals(testType, testJournal1.getItemType());
        out.println(testJournal1.getItemType()); //Tests to see if Journal item type exists //Will print out Journal if test passes
    }

    @Test
    public void testGetItemType4Pass() {
        Items testVideo1 = new Videos(1000, "Test Title 1", "Test Channel 1", "Test Genre 1", "Blu-Ray", 1, 1, "Blu-Ray Case", 1, "Video");
        String testType = "Video";
        assertEquals(testType, testVideo1.getItemType());
        out.println(testVideo1.getItemType()); //Tests to see if Video item type exists //Will print out Video if test passes
    }

    @Test
    public void testGetItemTypeFail() {
        Items testBook1 = new Books(1000, "1234567890", "Test Author 1", "Test Book 1", 1.99, "Testing One", "Test Publisher 1", 1, 1, "Book");
        String testType = "Journal";
        assertEquals(testType, testBook1.getItemType()); //Will Fail
    }

    @Test
    public void testGetItemType2Fail() {
        Items testDisc1 = new CompactDiscs(1000, "Test CD Title 1", "Test CD Artist 1", "Test Publisher 1", 1, 1, 1, "Audio CD", "CD Jewel Case", 1, "Compact Disc");
        String testType = "Video";
        assertEquals(testType, testDisc1.getItemType()); //Will fail
    }

    @Test
    public void testGetItemType3Fail() {
        Items testJournal1 = new Journals(1000, "1000-1000", "Test Title 1", 1, "Test Subject 1", "Test Publisher 1", 1, "10/10/1000", 1, 1, "Journal");
        String testType = "Book";
        assertEquals(testType, testJournal1.getItemType()); //Will Fail
    }

    @Test
    public void testGetItemType4Fail() {
        Items testVideo1 = new Videos(1000, "Test Title 1", "Test Channel 1", "Test Genre 1", "Blu-Ray", 1, 1, "Blu-Ray Case", 1, "Video");
        String testType = "Compact Disc";
        assertEquals(testType, testVideo1.getItemType()); //Will Fail
    }
}
