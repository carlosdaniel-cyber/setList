public class Song {
    public Song() {

    }
    @ColunaAnnotation(name = "Título", pos = 0)
    private String title;
    @ColunaAnnotation(name = "Álbum", pos = 1)
    private String album;
    @ColunaAnnotation(name = "Artista", pos = 2)
    private String artist;

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
