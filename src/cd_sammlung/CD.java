package cd_sammlung;

public class CD {
    //  Attribute
    String artist;
    String title;
    int duration;

    //  Konstruktoren
    public CD(){
        this.artist = "artist 01";
        this.title = "title 01";
        this.duration = 0;
    }
    public CD(String artist, String title, int duration){
        this.artist = artist;
        this.title = title;
        this.duration = duration;
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

    //  toString
    @Override
    public String toString() {
        return "CD: {" + this.getArtist() + "; " + this.getTitle() + "; " + this.getDuration() + "}";
    }

    //  lexikalischer Vergleich
    public int compareTitle(CD a){
        return this.getTitle().compareTo(a.getTitle());
    }
}
