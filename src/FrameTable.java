import javax.swing.*;
import javax.swing.JFrame;

public class FrameTable extends JFrame {
    public  FrameTable() {
        super("Músicas");
        SongDAO musica = new SongDAO();
        SongTableModel tableModel = new SongTableModel(musica);
        JTable table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(table);
        add(scroll);
        setSize(400, 400);
    }
}
