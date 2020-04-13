package BunnyCorp.Classes;

public class DigitalMedia extends Items { //Inherits attributes from Items  //Is Parent Class of Videos class and CompactDiscs class

    private int runningTime;
    private String TypeOfStorage;

    public DigitalMedia(int ID, String itemTitle, String itemPublisher, int runTime, double Cost, String storageType, int StockLevel, String type) {
        super(ID, itemTitle,itemPublisher, Cost, StockLevel, type); //Adds new attributes
        runningTime = runTime;
        TypeOfStorage = storageType;

    }
    //Overrides and sends data to superclass
    @Override
    public String getTypeOfStorage(){
        return TypeOfStorage;
    }
    @Override
    public int getRunningTime(){
        return runningTime;
    }

    public void setRunningTime(int newRuntime) {
        this.runningTime = newRuntime;
    }
    public void setTypeOfStorage(String newStorage) {
        this.TypeOfStorage = newStorage;
    }
}