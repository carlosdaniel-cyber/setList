public class Song {
    public Song() {

    }
    private String title;
    private String album;
    private String artist;
    public Song(String t, String alb, String art) {
        this.title = t;
        this.album = alb;
        this.artist = art;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Música [título = " + title + ", álbum = " + album + ", artista = " + artist + "]";
    }
}
