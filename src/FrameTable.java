import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

public class FrameTable extends JFrame {
    public  FrameTable() {
        super("Músicas");
        SongDAO musica = new SongDAO();
        SongTableModel tableModel = new SongTableModel(musica);
        JTable table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(table);
        add(scroll);
        JButton newButton = new JButton("Adicionar");
        newButton.addActionListener( event -> {
            String title = JOptionPane.showInputDialog("Digite o tíulo da música");
            System.out.println(title);
            tableModel.addSong(title);
        });
        add(newButton, BorderLayout.SOUTH);
        setSize(400, 400);
    }
}
