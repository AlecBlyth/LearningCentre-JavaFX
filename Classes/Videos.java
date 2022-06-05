package BunnyCorp.Classes;

public class Videos extends DigitalMedia { //Inherits from Digital Media

    private String videoFormat;
    private String Genre;

    public Videos(int ID, String itemTitle, String itemPublisher, String videoGenre, String videoType, int runTime, double Cost, String storageType, int StockLevel, String type) {
        super(ID, itemTitle, itemPublisher, runTime, Cost, storageType, StockLevel, type);  //Adds new attributes

        videoFormat = videoType;
        Genre = videoGenre;
    }
    @Override
    public String getVideoFormat() {
        return videoFormat;
    } //Gets video format

    @Override
    public String getGenre() {
        return Genre;
    } //gets genre

    public void setVideoFormat(String newVideoFormat) {
        this.videoFormat = newVideoFormat;
    } //Sets video format - used for stock editor

    public void setGenre(String newGenre) {
        this.Genre = newGenre;
    } //Sets video genre - used for stock editor
}