package BunnyCorp.Classes;

public class CompactDiscs extends DigitalMedia { //Inherits attributes from DigitalMedia class

    private String CDFormat;
    private String CDArtist;
    private int numberOfTracks;

    public CompactDiscs(int ID,  String itemTitle, String Artist, String itemPublisher, int numOfTracks, int runTime, double Cost, String CDType, String storageType, int StockLevel, String type) {
        super(ID, itemTitle, itemPublisher,  runTime, Cost, storageType, StockLevel, type); //Adds new attributes

        CDArtist = Artist;
        CDFormat = CDType;
        numberOfTracks = numOfTracks;
    }

    @Override
    public String getCDArtist(){return CDArtist;} //Overrides and sends data to superclass
    @Override
    public String getCDFormat(){
        return CDFormat;
    }
    @Override
    public int getNumberOfTracks(){
        return numberOfTracks;
    }

    public void setCDFormat(String newCDFormat) {
        this.CDFormat = newCDFormat;
    }
    public void setNumberOfTracks(int newNumTracks) {
        this.numberOfTracks = newNumTracks;
    }
    public void setCDArtist(String newArtist) {
        this.CDArtist = newArtist;
    }
}