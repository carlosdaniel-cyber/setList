import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SongDAO implements AbstractDAO<Song> {
    public Connection conn;

    public SongDAO() {
        String url = "jdbc:derby:agenda;create=true";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conectado");

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void add(Song s) {
        String sql = "INSERT INTO Song(title, album, artist) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, s.getTitle());
            stmt.setString(2, s.getAlbum());
            stmt.setString(3, s.getArtist());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public List<Song> getSong() {
        List<Song> musicas = new LinkedList<>();

        String sql = "select * from song";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Song musica = new Song();
                musica.setTitle(rs.getString("title"));
                musica.setAlbum(rs.getString("album"));
                musica.setArtist(rs.getString("artist"));

                musicas.add(musica);
            }
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return musicas;
    }

    @Override
    public void create(Song obj) {

    }

    @Override
    public List<Song> retrieve() {
        List<Song> songs = Arrays.asList();
        return songs;
    }

    public void update(Song s) {
        String sql = "update Song set album=?, artist=? where title=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, s.getAlbum());
            stmt.setString(2, s.getArtist());
            stmt.setString(3, s.getTitle());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    @Override
    public void delete(Song obj) {

    }
}
