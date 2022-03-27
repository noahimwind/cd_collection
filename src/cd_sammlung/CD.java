package cd_sammlung;

public class CD {
    //  Attribute
    String artist;
    String title;
    int duration;
    int number_tracks;

    //  Konstruktoren
    public CD(){
        this.artist = "artist 01";
        this.title = "title 01";
        this.duration = 0;
        this.number_tracks = 0;
    }
    public CD(String artist, String title, int duration, int number_tracks){
        this.artist = artist;
        this.title = title;
        this.duration = duration;
        this.number_tracks = number_tracks;
    }

    //  Getter und Setter
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNumber_tracks() {
        return number_tracks;
    }

    public void setNumber_tracks(int number_tracks) {
        this.number_tracks = number_tracks;
    }

    //  toString
    @Override
    public String toString() {
        return this.getArtist() + "; " + this.getTitle() + "; " + this.getDuration() + "; " + this.getNumber_tracks();
    }

    //  lexikalischer Vergleich
    public int compareTitle(CD a){
        return this.getTitle().compareTo(a.getTitle());
    }
    public int compareArtist(CD a){
        return this.getArtist().compareTo(a.getArtist());
    }

}
