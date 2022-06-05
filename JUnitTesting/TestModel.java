package BunnyCorp.JUnitTesting;

import BunnyCorp.Classes.*;

import java.util.ArrayList;

public class TestModel {
    private ArrayList<Books> testBooks = new ArrayList<>();
    private ArrayList<Journals> testJournals = new ArrayList<>();
    private ArrayList<Videos>testVideos = new ArrayList<>();
    private ArrayList<CompactDiscs>testCDs = new ArrayList<>();

    private ArrayList<Users>testUsers = new ArrayList<>();
    private ArrayList<Items>testItems = new ArrayList<>();

    public void addBook(Books book){
        testBooks.add(book);
    }
    public int getBookSize(){
        return testBooks.size();
    }
    public void resetBooks(){
        testBooks.clear();
    }
    public void addJournal(Journals journal){
        testJournals.add(journal);
    }
    public int getJournalSize(){
        return testJournals.size();
    }
    public void resetJournals(){
        testJournals.clear();
    }
    public void addVideo(Videos video){
        testVideos.add(video);
    }
    public int getVideoSize(){
        return testVideos.size();
    }
    public void resetVideos(){
        testVideos.clear();
    }
    public void addCD(CompactDiscs CD){
        testCDs.add(CD);
    }
    public int getCDSize(){
        return testCDs.size();
    }
    public void resetCDs(){
        testCDs.clear();
    }
    public void addUser(Users user){
        testUsers.add(user);
    }
    public int getUserSize(){
        return testUsers.size();
    }
    public void resetUsers(){
        testUsers.clear();
    }
    public void addItem(Items item){
        testItems.add(item);
    }
    public int getItemSize(){
        return testItems.size();
    }
    public void resetItems(){
        testItems.clear();
    }
}
