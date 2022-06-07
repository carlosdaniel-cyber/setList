import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SongDAO {
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

    public void add(Song c) {
        String sql = "INSERT INTO Song(title, album, artist) VALUES(?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getTitle());
            stmt.setString(2, c.getAlbum());
            stmt.setString(3, c.getArtist());
            stmt.execute();
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public List<Song> getSong() {
        List<Song> musicas = new LinkedList<Song>();

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
}
