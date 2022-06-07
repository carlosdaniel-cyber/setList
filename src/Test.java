import java.sql.*;
import java.util.List;

public class Test {
    public static Connection conn;

    /*public static void createTable() {
        String sql = "CREATE TABLE song( " +
                "title varchar(30), album varchar(30), " +
                "artist varchar(30) )";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    /*public static void insertSong() {
        String sql = "INSERT INTO song(title, album, artist) VALUES(?,?, ?)";

        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Esoteric Surgery");
            stmt.setString(2, "The Way ol All flesh");
            stmt.setString(3, "Gojira");
            stmt.execute();
            stmt.close();
            System.out.print("Entrada inserida com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    /*public static void printSong() {
        String sql = "select * from song";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Título:"+rs.getString("title"));
                System.out.println("Álbum:"+rs.getString("album"));
                System.out.println("Artista:"+rs.getString("artist"));
            }
            stmt.close();

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }*/

    public static void main(String[] args) {
        SongDAO dao = new SongDAO();
        dao.add(new Song("Isoteric Surgery", "The Way of All Flesh", "Gojira"));
        List<Song> musicas = dao.getSong();
        for (Song musica : musicas) {
            System.out.println(musica);
        }
    }
}